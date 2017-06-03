package maissaude;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import basicas.Atendente;
import basicas.Doenca;
import basicas.Medicamento;
import basicas.Receita;

public class TesteAtendente {

	static Receita receita;
	static Atendente atendente;
	Medicamento medicamento;
	Doenca doenca;
	List<Medicamento> listaMedicamentos;
	
	
	@BeforeClass
	public static void gerarDadosParaTestes(){
		
		atendente = new Atendente();
		atendente.setCpf("999.999.999-61");
		atendente.setIdPessoa(1);
		atendente.setCrf("654321");
		atendente.setFarmaceutico(false);
		atendente.setLogin("waldir.pereira");
		atendente.setNome("Waldir Pereira");
		atendente.setRg("9.999.999");
		atendente.setSenha("123456");
		
		receita = null;
	}
	
	@Test
	public void testeDespacharReceitaNControladaNula(){
		
		Assert.assertNotNull(receita);
	}
}
