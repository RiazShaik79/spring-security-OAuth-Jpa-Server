package io.javabrains;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetail extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	public AuthUserDetail(User user) {
		super();
	}
	
	
	public AuthUserDetail() {
	
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		List<GrantedAuthority> grantedAuthority = new ArrayList<>();
		
		getRoles().forEach(role -> {
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission -> {
			grantedAuthority.add(new SimpleGrantedAuthority(permission.getName()));	
			});
		
		});
		
		return grantedAuthority;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return super.isAccount_expired();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.isAccount_locked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return super.isCredential_expired();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.isEnabled();
	}

}
