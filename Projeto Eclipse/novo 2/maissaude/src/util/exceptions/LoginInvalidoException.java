package util.exceptions;

public class LoginInvalidoException extends Exception{
	
	public LoginInvalidoException(){
		
	}
	
	public LoginInvalidoException(Exception e){
		super(e);
	}
	
	public LoginInvalidoException(String msg){
		super(msg);
	}	
}
