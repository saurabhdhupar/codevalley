package maps;

public interface Maps<K,V> {
	int size();
	boolean isEmpty();
	void put(K key, V value);
	V get(K key);
	boolean containsKey(K key);
}
