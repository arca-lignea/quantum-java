import java.lang.Math;

public class Quantum {

	public static void main(String[] argv) {
		System.out.println("hello");

		Complex a = new Complex(1/Math.sqrt(2), 0);
		System.out.println(a);
		Complex b = new Complex(0, 1/Math.sqrt(2));
		System.out.println(b);

		Qubit c = new Qubit(a,b);
	}

}

enum QState {
	ZERO,
	ONE 
}

class Qubit {
	// Note: |alpha|^2 + |beta|^2 = 1
	//
	Complex alpha; // |0>
	Complex beta; // |1>


	Qubit(Complex a, Complex b) {
		if (Math.abs(a.modSq() + b.modSq() - 1) > 0.01) {
			throw new RuntimeException("Squared modulii must add to 1");
		}
		alpha = a;
		beta = b;
	}
	
	// Returns ZERO with probability |alpha|^2,
	// or ONE with probability |beta|^2
	public QState measure() {
		return null;	
	}
}

class Complex {
	final double real;
	final double imaginary;

	Complex(double r, double i) {
		real = r;
		imaginary = i;
	}

	public double mod() {
		return Math.sqrt(modSq());
	}

	public double modSq() {
		return real*real + imaginary*imaginary;
	}

	public String toString() {
		return String.format("%f + %fi", real, imaginary);
	}
}
