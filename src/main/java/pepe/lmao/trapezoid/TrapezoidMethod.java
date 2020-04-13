package pepe.lmao.trapezoid;

import lombok.Data;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.TrapezoidIntegrator;

@Data
public class TrapezoidMethod {
    private UnivariateFunction univariateFunction;
    private TrapezoidIntegrator trapezoidIntegrator;
    private double lowerBound;
    private double upperBound;
    private double precision;
    private double answer;
    private int iterations;
    private double absoluteAccuracy;
    private boolean swapped;


    public TrapezoidMethod(double lowerBound, double upperBound, double precision, boolean swapped) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.precision = precision;
        this.swapped = swapped;
        trapezoidIntegrator = new TrapezoidIntegrator(precision, precision, 4, 64);
    }


    public void solve() {
        answer = trapezoidIntegrator.integrate(100000, univariateFunction, lowerBound, upperBound);
        if (swapped) answer = -answer;
        iterations = trapezoidIntegrator.getIterations();
        absoluteAccuracy = trapezoidIntegrator.getAbsoluteAccuracy();
    }
}
