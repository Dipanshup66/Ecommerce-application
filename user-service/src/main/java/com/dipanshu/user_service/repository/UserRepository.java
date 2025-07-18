package com.dipanshu.user_service.repository;

import com.dipanshu.common.controller.BaseRepository;
import com.dipanshu.user_service.model.User;

public interface UserRepository extends BaseRepository<User> {

	public boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
