package maps;

import java.util.LinkedList;

public class ChainingMapImpl<K, V> implements Maps<K, V> {
	
	private int intialSize;
	private LinkedList<KeyValue<K, V>>[] hashAray;
	private int sizeDict;
	private CompressionFunction obj;
	
	@SuppressWarnings("unchecked")
	public ChainingMapImpl() {
		this.intialSize = 100;
		this.hashAray = (LinkedList<KeyValue<K,V>>[]) new LinkedList<?>[this.intialSize];
		this.sizeDict = 0;
		this.obj = new ModuloCompressionFunction();
	}

	@Override
	public int size() {
		return this.sizeDict;
	}

	@Override
	public boolean isEmpty() {
		return this.sizeDict > 0;
	}

	@Override
	public void put(K key, V value) {
		int hash = obj.compressionCode(key.hashCode(), this.intialSize);
		if(this.hashAray[hash] == null) {
			this.hashAray[hash] = new LinkedList<KeyValue<K, V>>();
		}
		this.hashAray[hash].add(new KeyValue<K,V>(key, value));
	}

	@Override
	public V get(K key) {
		int hash = obj.compressionCode(key.hashCode(), this.intialSize);
		LinkedList<KeyValue<K,V>> list = this.hashAray[hash];
		if(list != null) {
			for (KeyValue<K, V> keyValue : list) {
				if(keyValue.getKey().equals(key)) {
					return keyValue.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		return this.get(key) != null;
	}
}
