package example.spring.mvc.model;

public class UserValidator {
	public static boolean isValid(User userObject) {
		boolean result=false;
		String currentUserId = userObject.getUsername();
		String currentPassword=userObject.getPassword();
		if(currentUserId.equals("admin")
				&&
				currentPassword.equals("phoenix123")
		)
		return true;
		return result;
		
	}
}
