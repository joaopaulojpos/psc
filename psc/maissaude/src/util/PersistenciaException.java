package util;


public class PersistenciaException extends Exception{

	public PersistenciaException(){}
	
	public PersistenciaException(Exception e){
		super(e);
	}
	
	public PersistenciaException(String msg){
		super(msg);
	}
	
}
