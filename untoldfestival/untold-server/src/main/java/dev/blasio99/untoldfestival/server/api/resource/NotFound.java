package dev.blasio99.untoldfestival.server.api.resource;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotFound implements ErrorController {

	public static final String PATH = "/error";

	@RequestMapping(value = PATH, method = RequestMethod.GET)
	public ModelAndView method() {
		return new ModelAndView("redirect:/#/notfound");
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}