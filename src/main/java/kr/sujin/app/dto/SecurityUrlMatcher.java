package kr.sujin.app.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("SecurityUrlMatcher")
public class SecurityUrlMatcher {

	private String url;
	private String authority;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
