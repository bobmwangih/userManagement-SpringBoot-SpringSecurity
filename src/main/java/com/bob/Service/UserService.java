package com.bob.Service;

import java.util.List;

import com.bob.model.AppUser;
import com.bob.model.Role;

public interface UserService {

	AppUser saveUser(AppUser appUser);
	Role saveRole(Role role);
	Boolean addRoleToUser(String userName,String roleName);
	AppUser getUser(String userName);
	List<AppUser> getUsers();
}
