package hello;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		User user = userService.findByUserId(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		if (!matchPassword(password, user.getPassword())) {
			throw new BadCredentialsException(username);
		}

		if (!user.isEnabled()) {
			throw new BadCredentialsException(username);
		}
		
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	    auth.add(new SimpleGrantedAuthority(user.getAuthority()));
		return new UsernamePasswordAuthenticationToken(username, password, auth);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	private boolean matchPassword(String loginPwd, String password) {
		return loginPwd.equals(password);
	}

}
