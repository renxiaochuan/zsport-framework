package com.zsport.platform.uaaservice.dao;


import com.zsport.platform.uaaservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
