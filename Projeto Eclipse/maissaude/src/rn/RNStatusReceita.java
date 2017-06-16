package rn;

import java.util.Calendar;

import basicas.Atendente;
import basicas.EnumPerfil;
import basicas.EnumStatus;
import basicas.StatusReceita;
import dao.DAOFactory;
import util.Validacao;
import util.exceptions.ValidacaoException;

public class RNStatusReceita {

	private DAOFactory dao;
	private final Validacao VALIDA;
	
	public RNStatusReceita(){
		VALIDA = new Validacao();
	}	
	
	public void inserirStatusReceita(StatusReceita statusReceita) throws ValidacaoException{	
		validarNullidade(statusReceita);
		validarStatus(statusReceita);					
		inserir(statusReceita);			
	}
	
	public void validarStatus(StatusReceita statusReceita) throws ValidacaoException{
		if(!statusReceita.getStatus().equals(EnumStatus.FECHADA.toString()) &&
				!statusReceita.getStatus().equals(EnumStatus.ABERTA.toString()) &&
				!statusReceita.getStatus().equals(EnumStatus.EXPIRADA.toString())){
			throw new ValidacaoException("O Status a ser inserido n�o � v�lido.");
		}
		
		//Se for um Despacho...
		if(statusReceita.getStatus().equals(EnumStatus.FECHADA.toString())){
			validarDespachoPerfil(statusReceita);
		}
		//Se for uma Gera��o de Receita...
		if(statusReceita.getStatus().equals(EnumStatus.ABERTA.toString())){
			validarGeracaoPerfil(statusReceita);
		}
		//Se for uma Expira��o...
		if(statusReceita.getStatus().equals(EnumStatus.EXPIRADA.toString())){
			validarExpiracao(statusReceita);
		}		
	}	
	
	//M�todos Auxiliares
	
	private void validarExpiracao(StatusReceita statusReceita) throws ValidacaoException{
		Calendar diaAtual = Calendar.getInstance();
		Calendar prazo = statusReceita.getReceita().getPrazoCalendar();
		
		if(diaAtual.compareTo(prazo) < 0){
			throw new ValidacaoException("A Receita: " + statusReceita.getReceita().getIdReceita().toString() + " ainda est� dentro do prazo por isso n�o pode ser Expirada.");
		}
		
	}
	
	private void validarGeracaoPerfil(StatusReceita statusReceita) throws ValidacaoException{
		String perfil = statusReceita.getUsuarioAlteracao().getPerfil().toString();
		
		if(!perfil.equals(EnumPerfil.MEDICO.toString())){
			throw new ValidacaoException("� preciso ser um M�dico para poder Gerar Receitas.");
		}
	}
	
	
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

	private void validarDespachoPerfil(StatusReceita statusReceita)throws ValidacaoException{		
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
	
	private void inserir(StatusReceita statusReceita){		
		dao.getDAOStatusReceita().inserir(statusReceita);
	}
	
}
