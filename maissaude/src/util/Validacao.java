package util;

import util.exceptions.ValidacaoException;

public class Validacao {

	/**
	 * Verifica se o objeto � nulo.
	 * @param object 
	 * @throws ValidacaoException
	 */
	public void checkNull(Object object) throws ValidacaoException{
        if(object==null)
            throw new ValidacaoException("Registro inv�lido");
    }
	
	public void checkId(Integer id)throws ValidacaoException{
		if(id<=0 || id==null){
			throw new ValidacaoException("Identificador inv�lido");
		}
	}
	/**
	 * Verifica se um cpf est� preenchido corretamente.
	 * @param cpf vari�vel com o cpf.
	 * @throws ValidacaoException caso n�o esteja correto.
	 */
	public void cpf(String cpf)throws ValidacaoException{
		//variavel que contem a l�gica da validaca��o do cpf.
		String regex = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$";
		
		if(cpf==null || cpf.toString().length()==0){
			throw new ValidacaoException("CPF inv�lido!");
		}
		
        if(!(cpf.matches(regex))){
            throw new ValidacaoException("Nome inv�lido");
        }
	}
	/**
	 * Verifica se o CRM est� preenchido corretamente.
	 * @param crm
	 * @throws ValidacaoException
	 */
	public void crm(String crm)throws ValidacaoException{
		if(crm==null || crm.toString().length()==0){
			throw new ValidacaoException("Crm inv�lido!");
		}
	}
	
	/**
	 * Verifica se o fone est� preenchido corretamente.
	 * @param fone
	 * @throws ValidacaoException
	 */
	public void fone(String fone)throws ValidacaoException{
		//variavel que contem a l�gica de validacao do telefone. EX 9.9999-9999
		String regex = "^9.\\d{4}-\\d{4}$";
        
		if(fone!=null)
            if(!fone.matches(regex))
                throw new ValidacaoException("Preencha o campo telefone.");
	}
	
	/**
	 * Verifica se o email est� preenchido corretamente.
	 * @param email
	 * @throws ValidacaoException
	 */
	public void email(String email)throws ValidacaoException{
		//variavel que contem a l�gica de validacao do email.
		String regex = "^[a-zA-Z0-9][a-zA-Z0-9\\._-]+@([a-zA-Z0-9\\._-]+\\.)[a-zA-Z-0-9]{2,3}$";
        if(email!=null)
            if(!email.isEmpty())
                if(!email.matches(regex))
                    throw new ValidacaoException("Email inv�lido");
	}
	
	/**
	 * Verifica se o nome est� preenchido corretamente.
	 * @param nome
	 * @throws ValidacaoException
	 */
	public void nome(String nome) throws ValidacaoException{
        if (nome==null) {
            throw new ValidacaoException("Nome inv�lido.");
        }
        if (nome.length()>200) {
            throw new ValidacaoException("Nome acima do limite de caracteres permitido.");
        }
        if (nome.length()< 3) {
            throw new ValidacaoException("Nome abaixo do limite de caracteres permitido.");
        }
        if (nome.isEmpty()) {
            throw new ValidacaoException("Nome inv�lido.");
        }
	}
}
