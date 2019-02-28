package kr.sujin.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.sujin.app.dto.SecurityUrlMatcher;

@Repository
public interface SecurityUrlMatcherRepository extends CrudRepository<SecurityUrlMatcher, String> {

	List<SecurityUrlMatcher> findAll();
	
	SecurityUrlMatcher findByUrl(String url);
}
