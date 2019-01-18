package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.login.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}
