package utilTestes;

public class TswCalculadora {
    private TswCalculadora aCalc;
    
    public Double dividir(Double pDividendo, Double pDivisor) {
        if ( pDivisor == 0 ) {
            throw new IllegalArgumentException("O Divisor nunca pode ser igual a 0.0!");
        }
        Double resultado = pDividendo / pDivisor;
        return resultado;
    }
}
