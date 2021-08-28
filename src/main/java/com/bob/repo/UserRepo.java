package com.bob.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bob.model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long> {

	AppUser findByUserName(String userName);
}
