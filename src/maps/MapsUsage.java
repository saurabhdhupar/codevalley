package maps;

public class MapsUsage {
	
	public static void main(String args[]) {
		ChainingMapImpl<Integer, Integer> map = new ChainingMapImpl<Integer, Integer>();
		map.put(5, 10);
		map.put(6, 12);
		System.out.println(map.get(5));
		System.out.println(map.get(6));
		System.out.println(map.get(7));
	}
}
