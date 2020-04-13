package pepe.lmao;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import pepe.lmao.trapezoid.TrapezoidMethod;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int functionNumber;
        double lower;
        double upper;
        double eps;
        double answer = 0;
        int iterations = 0;
        double absoluteAccuracy = 0;
        boolean swapped = false;
        System.out.println("Pick a function:\n" +
                "1. (x^2-1)/6\n" +
                "2. x^3+x^2-1\n" +
                "3. 3x^3-4x^2+6x\n" +
                "4. -x^3-x^2+x+3");
        functionNumber = scanner.nextInt();
        System.out.println("Set upper bound:");
        upper = scanner.nextDouble();
        System.out.println("Set lower bound:");
        lower = scanner.nextDouble();
        System.out.println("Set precision:");
        eps = scanner.nextFloat();
        if (upper < lower) {
            upper = swap(lower, lower=upper);
            System.out.println("Bounds were swapped!");
            System.out.println("Upper bound: " + upper + "\nLower bound: " + lower);
            swapped = true;
        }
        if (upper - lower < eps) {
            System.out.println(answer);
        } else {

            TrapezoidMethod trapezoidMethod = new TrapezoidMethod(lower, upper, eps, swapped);
            UnivariateFunction univariateFunction;
            switch (functionNumber) {
                case 1:
                    univariateFunction = x -> (Math.pow(x, 2) - 1) / 6;
                    trapezoidMethod.setUnivariateFunction(univariateFunction);
                    trapezoidMethod.solve();
                    answer = trapezoidMethod.getAnswer();
                    iterations = trapezoidMethod.getIterations();
                    absoluteAccuracy = trapezoidMethod.getAbsoluteAccuracy();
                    break;
                case 2:
                    univariateFunction = x -> Math.pow(x, 3) + Math.pow(x, 2) - 1;
                    trapezoidMethod.setUnivariateFunction(univariateFunction);
                    trapezoidMethod.solve();
                    answer = trapezoidMethod.getAnswer();
                    iterations = trapezoidMethod.getIterations();
                    absoluteAccuracy = trapezoidMethod.getAbsoluteAccuracy();

                    break;
                case 3:
                    univariateFunction = x -> 3 * Math.pow(x, 3) - 4 * Math.pow(x, 2) + 6 * x;
                    trapezoidMethod.setUnivariateFunction(univariateFunction);
                    trapezoidMethod.solve();
                    answer = trapezoidMethod.getAnswer();
                    iterations = trapezoidMethod.getIterations();
                    absoluteAccuracy = trapezoidMethod.getAbsoluteAccuracy();

                    break;
                case 4:
                    univariateFunction = x -> -Math.pow(x, 3) - Math.pow(x, 2) + x + 3;
                    trapezoidMethod.setUnivariateFunction(univariateFunction);
                    trapezoidMethod.solve();
                    answer = trapezoidMethod.getAnswer();
                    iterations = trapezoidMethod.getIterations();
                    absoluteAccuracy = trapezoidMethod.getAbsoluteAccuracy();
                    break;
                default:
                    System.out.println("Illegal behavior");
                    break;
            }


        }

        System.out.println("Answer: " + answer + "\n" +
                "Number of iterations: " + iterations + "\n" +
                "Absolute accuracy: " + absoluteAccuracy);

    }

    public static double swap(double... args) {
        return args[0];
    }
}
