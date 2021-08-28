package com.bob.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bob.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByName( String name);
}
