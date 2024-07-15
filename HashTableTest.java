package assign09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the HashTable class. It covers various
 * scenarios including normal cases, edge cases, and collision handling.
 * 
 * @author Erin Parker and Phuc Do and Khang Nguyen
 * 
 * @version April 04, 2024
 */
class HashTableTest<K, V> {
	HashTable<String, Integer> hashTable;

	@BeforeEach
	void setUp() throws Exception {
		HashTable<String, Integer> hashTable = new HashTable<>();
		this.hashTable = hashTable;
		hashTable.put("apple", 10);
		hashTable.put("banana", 20);
		hashTable.put("orange", 30);
		hashTable.put("mango", 40);
		hashTable.put("berry", 50);

	}

	@Test
	void testClear() {
		hashTable.clear();
		assertTrue(hashTable.isEmpty());
	}

	@Test
	void testContainsKey() {
		assertTrue(hashTable.containsKey("apple"));
		assertTrue(hashTable.containsKey("banana"));
		assertTrue(hashTable.containsKey("orange"));
		assertTrue(hashTable.containsKey("mango"));
		assertTrue(hashTable.containsKey("berry"));

		assertFalse(hashTable.containsKey("blueberry"));
		assertFalse(hashTable.containsKey("watermelon"));
		assertFalse(hashTable.containsKey(null));

	}

	@Test
	void testContainsValue() {
		assertTrue(hashTable.containsValue(10));
		assertTrue(hashTable.containsValue(20));
		assertTrue(hashTable.containsValue(30));
		assertTrue(hashTable.containsValue(40));
		assertTrue(hashTable.containsValue(50));

		assertFalse(hashTable.containsValue(60));
		assertFalse(hashTable.containsValue(70));
		assertFalse(hashTable.containsValue(15));
		assertFalse(hashTable.containsValue(25));
		assertFalse(hashTable.containsValue(null));

	}

	@Test
	void testEntries() {
		List<MapEntry<String, Integer>> entries = hashTable.entries();
		assertTrue(entries.contains(new MapEntry<>("apple", 10)));
		assertTrue(entries.contains(new MapEntry<>("banana", 20)));
		assertTrue(entries.contains(new MapEntry<>("orange", 30)));
		assertTrue(entries.contains(new MapEntry<>("mango", 40)));
		assertTrue(entries.contains(new MapEntry<>("berry", 50)));

		assertFalse(entries.contains(new MapEntry<>("apple", 11)));
		assertFalse(entries.contains(new MapEntry<>("banana", 21)));
		assertFalse(entries.contains(new MapEntry<>("orange", 31)));
		assertFalse(entries.contains(new MapEntry<>("mango", 41)));
		assertFalse(entries.contains(new MapEntry<>("berry", 51)));

	}

	@Test
	void testGet() {
		assertEquals(10, hashTable.get("apple"));
		assertEquals(20, hashTable.get("banana"));
		assertEquals(30, hashTable.get("orange"));
		assertEquals(40, hashTable.get("mango"));
		assertEquals(50, hashTable.get("berry"));

		assertNull(hashTable.get("rasberry"));
		assertNull(hashTable.get("strawberry"));

	}

	@Test
	void testIsEmpty() {
		HashTable<String, Integer> emptyHashTable = new HashTable<>();
		assertTrue(emptyHashTable.isEmpty());
		assertFalse(hashTable.isEmpty());

	}

	@Test
	void testPut() {
		hashTable.put("kiwi", 12);
		hashTable.put("peach", 21);
		hashTable.put("coconut", 24);

		assertTrue(hashTable.containsKey("kiwi"));
		assertTrue(hashTable.containsKey("peach"));
		assertTrue(hashTable.containsKey("coconut"));

		assertTrue(hashTable.containsValue(12));
		assertTrue(hashTable.containsValue(20));
		assertTrue(hashTable.containsValue(24));

	}

	@Test
	void testRemove() {
		hashTable.remove("kiwi");
		hashTable.remove("peach");
		hashTable.remove("coconut");

		assertFalse(hashTable.containsValue(12));
		assertFalse(hashTable.containsValue(21));
		assertFalse(hashTable.containsValue(24));

		assertFalse(hashTable.containsKey("kiwi"));
		assertFalse(hashTable.containsKey("peach"));
		assertFalse(hashTable.containsKey("coconut"));
		assertNull(hashTable.remove(null));

		assertEquals(5, hashTable.size());
	}

	@Test
	void testSize() {
		assertEquals(5, hashTable.size());
	}

	@Test
	void testEmptyHashTable() {
		HashTable<String, Integer> hashTable = new HashTable<>();

		assertEquals(0, hashTable.size());
		hashTable.put("a", 6);
		hashTable.put("b", 7);
		hashTable.put("c", 6);

		hashTable.clear();
		assertTrue(hashTable.isEmpty());
	}

	@Test
	void testCollisionHandling() {
		HashTable<String, Integer> hashTable = new HashTable<>();
		hashTable.put("a", 6);
		hashTable.put("b", 7);
		hashTable.put("c", 6);
		hashTable.put("d", 7);
		hashTable.put("e", 8);

		assertEquals(6, hashTable.get("a"));
		assertEquals(7, hashTable.get("b"));
		assertEquals(6, hashTable.get("c"));
		assertEquals(7, hashTable.get("d"));
		assertEquals(8, hashTable.get("e"));

	}

	@Test
	void testDuplicateKeys() {
		hashTable.put("apple", 20);
		assertEquals(20, hashTable.get("apple"));
	}

	@Test
	void testIteratorRemoval() {

		Integer removedValue = hashTable.remove("banana");

		assertEquals(20, removedValue);
		assertFalse(hashTable.containsKey("banana"));
		assertNull(hashTable.get("banana"));
		assertEquals(4, hashTable.size());
	}

	@Test
	void testResize() {
		HashTable<String, Integer> hashTable = new HashTable<>();

		hashTable.put("apple", 1);
		hashTable.put("banana", 2);
		hashTable.put("orange", 3);
		hashTable.put("grape", 4);
		hashTable.put("pear", 5);
		hashTable.put("mango", 6);
		hashTable.put("pineapple", 7);
		hashTable.put("watermelon", 8);
		hashTable.put("kiwi", 9);
		hashTable.put("strawberry", 1);

		hashTable.put("blueberry", 11);
		hashTable.put("cherry", 12);
		hashTable.put("lemon", 13);
		hashTable.put("peach", 14);
		hashTable.put("lime", 15);
		hashTable.put("plum", 16);
		hashTable.put("apricot", 17);
		hashTable.put("blackberry", 18);
		hashTable.put("cantaloupe", 19);
		hashTable.put("pomegranate", 20);
		List<MapEntry<String, Integer>> entries = hashTable.entries();

		for (MapEntry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

	}
}
