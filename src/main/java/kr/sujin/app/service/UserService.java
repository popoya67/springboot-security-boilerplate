package kr.sujin.app.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.sujin.app.dto.User;

@Repository
public interface UserService extends CrudRepository<User, String> {

	User findByUserId(String userId);
}
