package kr.sujin.config.security;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
/**
 * @author sujin
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	public LoginSuccessHandler(String defaultTargetUrl) {
		setDefaultTargetUrl(defaultTargetUrl);
	}
}
