package maissaude;

import org.junit.Assert;
import org.junit.Test;

import utilTestes.TswCalculadora;

public class TswTesteCalculadora {
    @Test
    public void testar10divididoPor1() {
        TswCalculadora c = new TswCalculadora();
         
        Double resultado = 
            c.dividir(new Double(10), new Double(1));
         
        Assert.assertEquals(10.0, resultado.doubleValue(), 0.1);
    }
     
    @Test
    public void testar1divididoPor10() {
        TswCalculadora c = new TswCalculadora();
         
        Double resultado = 
            c.dividir(new Double(1), new Double(10));
         
        Assert.assertEquals(0.1, resultado.doubleValue(), 0.1);
    }
     
    @Test
    public void testar1divididoPor0() {
        TswCalculadora c = new TswCalculadora();
         
        Double resultado = 
            c.dividir(new Double(1), new Double(0));
         
        Assert.assertEquals(Double.NaN, resultado.doubleValue(), 0.1);
    }
}
