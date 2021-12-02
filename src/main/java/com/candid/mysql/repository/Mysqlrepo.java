package com.candid.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candid.mysql.entity.MyStudent;
import com.candid.mysql.service.User;
 
@Repository
public interface Mysqlrepo extends JpaRepository<MyStudent, Long> {

	MyStudent findByUsername(String username);

 
}
