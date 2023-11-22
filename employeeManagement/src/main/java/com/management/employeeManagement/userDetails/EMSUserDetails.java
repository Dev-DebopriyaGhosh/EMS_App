package com.management.employeeManagement.userDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.management.employeeManagement.model.User;

@SuppressWarnings("serial")
public class EMSUserDetails implements UserDetails{
	
	private User user;
	
	
	public EMSUserDetails(User user) {
		this.user=user;
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authList = new ArrayList<>();
		SimpleGrantedAuthority auth = new SimpleGrantedAuthority(user.getRole());
		authList.add(auth);
		return authList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
