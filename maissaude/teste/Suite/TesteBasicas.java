package Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TestUnit.CRUDAtendenteTeste;
import TestUnit.CRUDPacienteTest;
import TestUnit.RNAtendenteTeste;
import TestUnit.RNDoencaTeste;
import TestUnit.RNMedicamentoTeste;
import TestUnit.RNMedicoTeste;
import TestUnit.RNPacienteTeste;
import TestUnit.RNReceitaTestes;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	RNMedicoTeste.class,
	RNAtendenteTeste.class,
	RNPacienteTeste.class,
	RNDoencaTeste.class,
	RNMedicamentoTeste.class,
	RNReceitaTestes.class
})
public class TesteBasicas {

}
