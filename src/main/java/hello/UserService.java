package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserService extends CrudRepository<User, String> {

	User findByUserId(String userId);
}
