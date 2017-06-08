package Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import TestUnit.CRUDAtendenteTeste;
import TestUnit.CRUDDoencaTeste;
import TestUnit.CRUDMedicamentoTeste;
import TestUnit.CRUDMedicoTeste;
import TestUnit.CRUDPacienteTest;

@RunWith(Suite.class)
@SuiteClasses({ 
CRUDAtendenteTeste.class,
CRUDPacienteTest.class,
CRUDMedicoTeste.class,
CRUDMedicamentoTeste.class,
CRUDDoencaTeste.class
})
public class TesteCRUD {

}
