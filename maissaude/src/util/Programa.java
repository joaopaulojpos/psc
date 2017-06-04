package util;

import java.util.Calendar;

import basicas.Receita;
import rn.Fachada;
import rn.RNReceita;
import util.exceptions.ValidacaoException;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RNReceita rnreceita = new RNReceita();
		
		Receita receita = new Receita();
		receita.setAtendente(Fachada.getInstance().listarAtendentesCRF("CR/PE 22266"));
		receita.setDataGeracao(Calendar.getInstance());
		receita.setDoenca(Fachada.getInstance().listarDoencaporCND("A03-B03"));
		receita.setListaMedicamentos(Fachada.getInstance().listarMedicamentos());
		receita.setListaStatusReceita(null);
		receita.setMedico(Fachada.getInstance().listarMedicoCRM("CRM/PE 22244"));
		receita.setPaciente(Fachada.getInstance().listarPacienteporCNS("222.3333.4444.5555"));
		receita.setPrazo(Calendar.getInstance());
		
		try {
			rnreceita.inserir(receita);
		} catch (ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
