package core.Auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthContext {
	private HttpSession session;
	
	public AuthContext(HttpServletRequest request) {
		session = request.getSession();
	}
	
	public boolean isAuthenticated() {
		ClaimPrincipal user = (ClaimPrincipal)session.getAttribute("USER");
		if (user != null) {
			return true;
		}
		return false;
	}
	
	public boolean isInRole(String value) {
		ClaimPrincipal user = (ClaimPrincipal)session.getAttribute("USER");
		if (user != null) {
			String role = user.getClaim("Role").getValue();
			if (role.equals(value)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean signIn(Claim[] claims) {
		ClaimPrincipal user = (ClaimPrincipal)session.getAttribute("USER");
		if (user == null) {
			session.setAttribute("USER", new ClaimPrincipal(claims));
			return true;
		}
		return false;
	}
	
	public Claim getClaim(String name) {
		ClaimPrincipal user = (ClaimPrincipal)session.getAttribute("USER");
		return user.getClaim(name);
	}
	
	public boolean signOut() {
		ClaimPrincipal user = (ClaimPrincipal)session.getAttribute("USER");
		if (user != null) {
			session.removeAttribute("USER");
			return true;
		}
		return false;
	}
}
