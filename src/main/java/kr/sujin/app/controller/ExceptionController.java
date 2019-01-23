package kr.sujin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "error/access_error";
	}
}
