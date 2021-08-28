package com.bob.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bob.model.AppUser;
import com.bob.model.Role;
import com.bob.repo.RoleRepo;
import com.bob.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	
	@Override
	public AppUser saveUser(AppUser appUser) {
		log.info("Saving new appUser {} ",appUser.getName());
		return userRepo.save(appUser);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role {} ",role.getName());
		return roleRepo.save(role);
	}

	@Override
	public Boolean addRoleToUser(String userName, String roleName) {
		log.info("adding new role {}  to appUser {} ", roleName,userName);
		AppUser user = userRepo.findByUserName(userName);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
		return true;
	}

	@Override
	public AppUser getUser(String userName) {
		log.info("fetching appUser {} ", userName);
		return userRepo.findByUserName(userName);
	}

	@Override
	public List<AppUser> getUsers() {
		log.info("getting all Users {} ");
		return userRepo.findAll();
	}

}
