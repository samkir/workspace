package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Long>{

}
