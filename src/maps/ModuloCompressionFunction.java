package maps;

public class ModuloCompressionFunction implements CompressionFunction {

	@Override
	public int compressionCode(int k, int m) {
		return k % m;
	}

}
