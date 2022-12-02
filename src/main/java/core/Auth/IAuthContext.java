package core.Auth;

public interface IAuthContext {
	public boolean isAuthenticated();
	public boolean isInRole(String value);
	public boolean signIn(Claim[] claims);
	public Claim getClaim(String name);
	public boolean signOut();
}
