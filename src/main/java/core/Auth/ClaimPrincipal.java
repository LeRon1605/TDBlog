package core.Auth;

import java.util.Hashtable;
import java.util.Map;

public class ClaimPrincipal {
	private Map<String, String> _claims;
	
	public ClaimPrincipal(Claim claims[]) {
		_claims = new Hashtable<String, String>();
		for (Claim claim: claims) {
			_claims.put(claim.getName(), claim.getValue());
		}
	}
	
	public void setClaim(Claim claims[]) {
		_claims = new Hashtable<String, String>();
		for (Claim claim: claims) {
			_claims.put(claim.getName(), claim.getValue());
		}
	}
	
	public Claim getClaim(String name) {
		if (_claims.containsKey(name)) {
			return new Claim(name, _claims.get(name));
		}
		return null;
	}
	
	public boolean removeClaim(String name) {
		if (_claims.containsKey(name)) {
			_claims.remove(name);
			return true;
		}
		return false;
	}
	
	public void clear() {
		_claims.clear();
	}
}
