package com.candid.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candid.mysql.entity.Student;

public interface Mysqlrepo extends JpaRepository<Student, Long> {

	Student findByUsername(String username);

}
