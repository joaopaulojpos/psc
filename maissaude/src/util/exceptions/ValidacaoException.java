package util.exceptions;


public class ValidacaoException extends Exception{

	public ValidacaoException(){}
	
	public ValidacaoException(Exception e){
		super(e);
	}
	
	public ValidacaoException(String msg){
		super(msg);
	}
	
}
