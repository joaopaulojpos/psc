package rn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import basicas.EnumPerfil;
import basicas.EnumStatus;
import basicas.Receita;
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
	
	public void inserir(StatusReceita statusReceita) throws ValidacaoException{		
		inserirStatusReceita(statusReceita);	
	}
	
	private void inserirStatusReceita(StatusReceita statusReceita){		
		dao.getDAOStatusReceita().inserir(statusReceita);
	}
	
	public void despacharReceita(Receita receita) throws ValidacaoException{		
		validarDespacho(receita);		
		despachar(receita.getUltimoStatus());
	}

	private void despachar(StatusReceita statusReceita) throws ValidacaoException{
		dao.getDAOStatusReceita().inserir(statusReceita);
		
	}
	
	private void validarDespacho(Receita receita)throws ValidacaoException{
		try{
			
		
		VALIDA.checkId(receita.getIdReceita());
		VALIDA.checkNull(receita);
		VALIDA.checkNull(receita.getDataGeracao());
		VALIDA.checkNull(receita.getDoenca());		
		VALIDA.checkNull(receita.getListaMedicamentos());
		VALIDA.checkNull(receita.getListaStatusReceita());
		VALIDA.checkNull(receita.getMedico());
		VALIDA.checkNull(receita.getPaciente());
		VALIDA.checkNull(receita.getPrazo());
		VALIDA.checkNull(receita.getUltimoStatus());
		
		if(receita.getUltimoStatus().getStatus().equals(EnumStatus.ABERTA.toString())){					
			StatusReceita status = new StatusReceita();
			status.setDataAlteracao(Calendar.getInstance());
			status.setReceita(receita);
			status.setUsuarioAlteracao(new Usuario(2, "joao.silva", "joaoAtend123", EnumPerfil.ATENDENTE.toString(), null, null, null));
			status.setStatus(EnumStatus.FECHADA.toString());
			
			dao.getDAOStatusReceita().inserir(status);
		}else{
			throw new ValidacaoException("Não é possível Despachar uma receita Aberta");
		}
		
		}catch(ValidacaoException e){
			throw new ValidacaoException(e.getMessage());
		}
	}	
	
}
