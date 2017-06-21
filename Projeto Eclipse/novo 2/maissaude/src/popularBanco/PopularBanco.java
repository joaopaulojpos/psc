package popularBanco;

public class PopularBanco {
	public static void main(String args[]){
		try{
			TestaCriarBanco a = new TestaCriarBanco();			
			TestaInserirDoenca b = new TestaInserirDoenca();
			TestaInserirMedicamento c = new TestaInserirMedicamento();
			TestaInserirPaciente d = new TestaInserirPaciente();
			TestaInserirAtendente e = new TestaInserirAtendente();
			TestaInserirMedico f = new TestaInserirMedico();
			TestaInserirMinisterio g = new TestaInserirMinisterio(); 
			
			TestaInserirReceita h = new TestaInserirReceita(); 									
		}catch(Exception e){
			e.printStackTrace();
		}
		 
	}
}
