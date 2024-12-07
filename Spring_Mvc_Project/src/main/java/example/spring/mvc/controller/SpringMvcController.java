package example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import example.spring.mvc.model.User;
import example.spring.mvc.model.UserValidator;

@Controller //Marks this class as controller of Spring MVC application
@SessionAttributes("loggedInUser")
public class SpringMvcController {

//	@RequestMapping("/doGreet")//Provide mapping between method->getIndexPage() and URL->/doGreet
	
	@GetMapping("/doGreet")
	public String getIndexPage() {
		System.out.println("Inside getIndexPage()");
		return "index";//Returning a view name
	}
//	@RequestMapping("/doLogin")
	@GetMapping("/doLogin")
	public String getLoginPage() {
		System.out.println("Inside get Login Page()");
		return "login";
	}
//	@RequestMapping(value="/doValidate",method=RequestMethod.POST)
	@PostMapping("/doValidate")
	public String getResultPage(
			@RequestParam("uid") String userName,
			@RequestParam("pwd") String password
			) {
		//This method returns one of the 2 possible result pages:
		//success and failure depends upon user's validity.
		String resultPage ="failure";
		//Building a model object: User based upon userName and password
		User userDataModel = new User(userName ,password);
		//Passing the Model object to UserValidation for validation
		boolean valid = UserValidator.isValid(userDataModel);
		if(valid)
			resultPage ="success";
		return resultPage;
				
	}
	//@RequestMapping(value="/doValidateAgain",method=RequestMethod.POST)
	@PostMapping("/doValidateAgain")
	public String getResultPageAgain(
			@RequestParam("uid") String userName,
			@RequestParam("pwd") String password,
			Model modelObject
			) {
		String resultPage="failurePage";
		User userDataModel = new User(userName ,password);
		boolean valid = UserValidator.isValid(userDataModel);
		if(valid) {
			resultPage ="successPage";
			//Adding userName in the modelObject ->ModelObject
			modelObject.addAttribute("loggedInUser",userName);
	}
		return resultPage;
		
	}
}
