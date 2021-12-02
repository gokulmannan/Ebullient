package com.candid.mysql.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.candid.mysql.entity.MyStudent;
import com.candid.mysql.repository.Mysqlrepo;

@Service
@Transactional
public class Usermysqlservice implements UserDetailsService,UserService {
	
	 
	@Autowired
	Mysqlrepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyStudent data=repo.findByUsername(username);
 		return new User(data);
	}
 

	@Override
	public MyStudent save(MyStudent s) {
		// TODO Auto-generated method stub
		return repo.save(s);
	}
 

}
