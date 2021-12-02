package com.candid.mysql.service;

 
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.candid.mysql.entity.MyStudent;

public class User implements UserDetails {
	@Autowired
	MyStudent s;

	public User(MyStudent s) {
		super();
		this.s = s;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
 		return s.getRole().stream().map(role->new SimpleGrantedAuthority("ROLE"+role.getName())).collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return s.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return s.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
