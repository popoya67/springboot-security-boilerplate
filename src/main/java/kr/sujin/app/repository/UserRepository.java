package kr.sujin.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.sujin.app.dto.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findByUserId(String userId);
}
