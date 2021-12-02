package com.candid.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.candid.mysql.entity.Student;
import com.candid.mysql.repository.Mysqlrepo;

public class Usermysqlservice implements UserDetailsService {
	Student data;
	@Autowired
	Mysqlrepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		data=repo.findByUsername(username);
 		return new User(data);
	}

}
