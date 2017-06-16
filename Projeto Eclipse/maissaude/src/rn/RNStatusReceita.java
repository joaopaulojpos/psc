package rn;

import basicas.Atendente;
import basicas.EnumPerfil;
import basicas.EnumStatus;
import basicas.StatusReceita;
import basicas.Usuario;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNStatusReceita {

	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNStatusReceita(){
		VALIDA = new Validacao();
	}	
	
	public void despachar(StatusReceita statusReceita) throws ValidacaoException{	
		validarNullidade(statusReceita);
		validarStatus(statusReceita);
		validarPerfil(statusReceita);	
		inserirStatusReceita(statusReceita);
		

	
	}
	
	public void validarStatus(StatusReceita statusReceita) throws ValidacaoException{
		if(statusReceita.getStatus().equals(EnumStatus.FECHADA.toString())){
			throw new ValidacaoException("N�o � poss�vel despachar uma Receita fechada.");
		}else
			if(statusReceita.getStatus().equals(EnumStatus.EXPIRADA.toString())){
				throw new ValidacaoException("N�o � poss�vel despachar uma Receita Expirada.");
			}else
				if(statusReceita.getStatus().equals(EnumStatus.ABERTA.toString())){
					//N�o faz nada pq � aqui qtem q entrar pra rosseguir sem throws
				}else{
					throw new ValidacaoException("N�o � poss�vel despachar uma Receita que n�o est� Aberta.");
				}
		
	}
	
	//M�todos Auxiliares
	
	private void validarNullidade(StatusReceita statusReceita)throws ValidacaoException{
		VALIDA.checkNull(statusReceita);
		if(statusReceita.getStatus() == null || statusReceita.getStatus() == ""){
			throw new ValidacaoException("Status do Status da Receita n�o pode ser vazio.");
		}
		if(statusReceita.getReceita() == null){
			throw new ValidacaoException("Status da Receita sem Receita relacionada.");
		}
		if(statusReceita.getUsuarioAlteracao() == null){
			throw new ValidacaoException("Status da Receita sem Usu�rio relacionado.");
		}
		if(statusReceita.getDataAlteracao() == null){
			throw new ValidacaoException("Status da Receita sem Data de Altera��o relacionada.");
		}		
	}		

	private void validarPerfil(StatusReceita statusReceita)throws ValidacaoException{		
		String perfil = statusReceita.getUsuarioAlteracao().getPerfil().toString();
		
		if(!perfil.equals(EnumPerfil.ATENDENTE.toString())){
			throw new ValidacaoException("� preciso ser um Atendente para poder Despachar Receitas.");
		}else{
		Atendente atendente = new Atendente();
		atendente = dao.getDAOAtendente().pesquisarUserId(statusReceita.getUsuarioAlteracao().getIdUsuario());
			if(atendente.isFarmaceutico()){
				
			}else
				if(statusReceita.getReceita().isControlada()){
					throw new ValidacaoException("Apenas Farmac�uticos podem Despachar Receitas com Medicamentos Controlados.");
				}	
		}
	}
	
	private void inserirStatusReceita(StatusReceita statusReceita){		
		dao.getDAOStatusReceita().inserir(statusReceita);
	}
	
}
