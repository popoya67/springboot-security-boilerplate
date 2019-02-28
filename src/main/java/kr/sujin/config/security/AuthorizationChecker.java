package kr.sujin.config.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import kr.sujin.app.dto.SecurityUrlMatcher;
import kr.sujin.app.dto.User;
import kr.sujin.app.repository.SecurityUrlMatcherRepository;
import kr.sujin.app.repository.UserRepository;

@Component
public class AuthorizationChecker {
	@Autowired
	private SecurityUrlMatcherRepository urlMatcherRepository;

	@Autowired
	private UserRepository userRepository;

	public boolean check(HttpServletRequest request, Authentication authentication) {
		Object principalObj = authentication.getPrincipal();

		if (!(principalObj instanceof User)) {
			return false;
		}

		String authority = null;
		for (SecurityUrlMatcher matcher : urlMatcherRepository.findAll()) {
			if (new AntPathMatcher().match(matcher.getUrl(), request.getRequestURI())) {
				authority = matcher.getAuthority();
				break;
			}
		}

		String userId = ((User) authentication.getPrincipal()).getUserId();
		User loggedUser = userRepository.findByUserId(userId);

		List<String> authorities = loggedUser.getAuthority();

		if (authority == null || !authorities.contains(authority)) {
			return false;
		}
		return true;
	}
}
