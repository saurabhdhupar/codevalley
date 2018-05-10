package maps;

public class FibonacciCompressionFunction implements CompressionFunction {
	
	private double goldenRatio = (Math.sqrt(5) - 1)/2;

	@Override
	public int compressionCode(int k, int m) {
		return (int) Math.floor(m* (k*goldenRatio % 1));
	}
}
