package util;

import util.exceptions.ValidacaoException;

public class Validacao {

	/**
	 * Verifica se o objeto é nulo.
	 * @param object 
	 * @throws ValidacaoException
	 */
	public void checkNull(Object object) throws ValidacaoException{
        if(object==null)
            throw new ValidacaoException("Registro inválido");
    }
	
	public void checkId(Integer id)throws ValidacaoException{
		if(id<=0 || id==null){
			throw new ValidacaoException("Identificador inválido");
		}
	}
	/**
	 * Verifica se um cpf está preenchido corretamente.
	 * @param cpf variável com o cpf.
	 * @throws ValidacaoException caso não esteja correto.
	 */
	public void cpf(String cpf)throws ValidacaoException{
		//variavel que contem a lógica da validacação do cpf.
		String regex = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$";
		
		if(cpf==null || cpf.toString().length()==0){
			throw new ValidacaoException("CPF inválido!");
		}
		
        if(!(cpf.matches(regex))){
            throw new ValidacaoException("Nome inválido");
        }
	}
	/**
	 * Verifica se o CRM está preenchido corretamente.
	 * @param crm
	 * @throws ValidacaoException
	 */
	public void crm(String crm)throws ValidacaoException{
		if(crm==null || crm.toString().length()==0){
			throw new ValidacaoException("Crm inválido!");
		}
	}
	
	/**
	 * Verifica se o fone está preenchido corretamente.
	 * @param fone
	 * @throws ValidacaoException
	 */
	public void fone(String fone)throws ValidacaoException{
		//variavel que contem a lógica de validacao do telefone. EX 9.9999-9999
		String regex = "^9.\\d{4}-\\d{4}$";
        
		if(fone!=null)
            if(!fone.matches(regex))
                throw new ValidacaoException("Preencha o campo telefone.");
	}
	
	/**
	 * Verifica se o email está preenchido corretamente.
	 * @param email
	 * @throws ValidacaoException
	 */
	public void email(String email)throws ValidacaoException{
		//variavel que contem a lógica de validacao do email.
		String regex = "^[a-zA-Z0-9][a-zA-Z0-9\\._-]+@([a-zA-Z0-9\\._-]+\\.)[a-zA-Z-0-9]{2,3}$";
        if(email!=null)
            if(!email.isEmpty())
                if(!email.matches(regex))
                    throw new ValidacaoException("Email inválido");
	}
	
	/**
	 * Verifica se o nome está preenchido corretamente.
	 * @param nome
	 * @throws ValidacaoException
	 */
	public void nome(String nome) throws ValidacaoException{
        if (nome==null) {
            throw new ValidacaoException("Nome inválido.");
        }
        if (nome.length()>200) {
            throw new ValidacaoException("Nome acima do limite de caracteres permitido.");
        }
        if (nome.length()< 3) {
            throw new ValidacaoException("Nome abaixo do limite de caracteres permitido.");
        }
        if (nome.isEmpty()) {
            throw new ValidacaoException("Nome inválido.");
        }
	}
}
