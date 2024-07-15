package assign09;

import java.util.*;

/**
 * A hash table implementation that utilizes separate chaining for collision
 * resolution. This class implements the Map interface and provides methods to
 * store, retrieve, and manipulate key-value pairs efficiently using hashing
 * techniques.
 *
 *
 * @param <K> The type of keys stored in the hash table.
 * @param <V> The type of values associated with the keys.
 * 
 * @author Phuc Do and Khang Nguyen
 * @version April 04, 2024
 */
public class HashTable<K, V> implements Map<K, V> {

	private static final double LOAD_FACTOR_THRESHOLD = 10.0;
	private int capacity = 10;
	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	private int size;
	private int collisions;

	/**
	 * Constructs a new HashTable instance with an initial capacity of 10.
	 * Initializes the internal array and sets the size to 0.
	 */
	public HashTable() {
		table = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			table.add(new LinkedList<>());
		}
		size = 0;
	}

	/**
	 * Calculates the hash value for a given key.
	 *
	 * @param key The key for which the hash value is calculated.
	 * @return The hash value computed for the key.
	 */
	private int hash(K key) {
		return Math.abs(key.hashCode() % table.size());
	}

	/**
	 * Resizes the internal array of the hash table when the load factor exceeds the
	 * predefined threshold.
	 */
	private void resizeTable() {
		double loadFactor = (double) size / capacity;
		if (loadFactor > LOAD_FACTOR_THRESHOLD) {
			int newCapacity = capacity * 2;
			ArrayList<LinkedList<MapEntry<K, V>>> newTable = new ArrayList<>(newCapacity);
			for (int i = 0; i < newCapacity; i++) {
				newTable.add(new LinkedList<>());
			}
			for (LinkedList<MapEntry<K, V>> bucket : table) {
				for (MapEntry<K, V> entry : bucket) {
					int index = Math.abs(entry.getKey().hashCode() % newCapacity);
					newTable.get(index).add(entry);
				}
			}
			table = newTable;
			capacity = newCapacity;
		}
	}

	/**
	 * Clears all key-value mappings from the hash table. The size of the table is
	 * reset to 0.
	 */

	@Override
	public void clear() {
		table.clear();
		for (int i = 0; i < capacity; i++) {
			table.add(new LinkedList<>());
		}
		size = 0;
	}

	/**
	 * Checks if the hash table contains a mapping for the specified key.
	 *
	 * @param key The key whose presence in the hash table is to be tested.
	 * @return true if the hash table contains a mapping for the specified key,
	 *         otherwise false.
	 */
	@Override
	public boolean containsKey(K key) {
		if (key == null)
			return false;
		int index = hash(key);
		for (MapEntry<K, V> entry : table.get(index)) {
			if (entry.getKey() != null && entry.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the hash table contains a mapping for the specified value.
	 *
	 * @param value The value whose presence in the hash table is to be tested.
	 * @return true if the hash table contains a mapping for the specified value,
	 *         otherwise.
	 */
	@Override
	public boolean containsValue(V value) {
		if (value == null)
			return false;
		for (LinkedList<MapEntry<K, V>> bucket : table) {
			for (MapEntry<K, V> entry : bucket) {
				if (entry != null && entry.getValue() != null && entry.getValue().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns a list containing all the key-value mappings in the hash table.
	 *
	 * @return A list containing all the key-value mappings in the hash table.
	 */
	@Override
	public List<MapEntry<K, V>> entries() {
		List<MapEntry<K, V>> entries = new LinkedList<>();
		for (LinkedList<MapEntry<K, V>> bucket : table) {
			entries.addAll(bucket);
		}
		return entries;
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this hash
	 * table contains no mapping for the key.
	 *
	 * @param key The key whose associated value is to be returned.
	 * @return The value to which the specified key is mapped, or null if this map
	 *         contains no mapping for the key.
	 */
	@Override
	public V get(K key) {
		int index = hash(key);
		for (MapEntry<K, V> entry : table.get(index)) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}

	/**
	 * Checks whether the hash table is empty.
	 *
	 * @return true if the hash table contains no key-value mappings, otherwise
	 *         false.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Associates the specified value with the specified key in this hash table. If
	 * the hash table previously contained a mapping for the key, the old value is
	 * replaced by the specified value.
	 *
	 * @param key   The key with which the specified value is to be associated.
	 * @param value The value to be associated with the specified key.
	 * @return The previous value associated with the specified key, or null if
	 *         there was no mapping for the key.
	 */
	@Override
	public V put(K key, V value) {
		resizeTable();
		int index = hash(key);
		if (table.get(index) == null) { // if null create a linked list
			table.set(index, new LinkedList<>());
		} else {
			for (MapEntry<K, V> entry : table.get(index)) {
				if (entry.getKey().equals(key)) {
					V oldValue = entry.getValue();
					entry.setValue(value);
					return oldValue;
				}
				collisions++; // Increment collision count
			}
		}

		table.get(index).add(new MapEntry<>(key, value));
		size++;
		return value;
	}

	/**
	 * Removes the mapping for a key from this hash table if it is present.
	 * 
	 */
	@Override
	public V remove(K key) {
		if (key == null) {
			return null;
		}
		int index = hash(key);
		Iterator<MapEntry<K, V>> iterator = table.get(index).iterator();
		while (iterator.hasNext()) {
			MapEntry<K, V> entry = iterator.next();
			if (key.equals(entry.getKey())) {
				iterator.remove();
				size--;
				return entry.getValue();
			}
		}
		return null;
	}

	/**
	 * Returns the number of key-value mappings in this hash table.
	 *
	 * @return The number of key-value mappings in this hash table.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the count of collisions encountered during operations on this hash
	 * table.
	 *
	 * @return The count of collisions encountered during operations.
	 */
	public int getCollisions() {
		return collisions;
	}

}
