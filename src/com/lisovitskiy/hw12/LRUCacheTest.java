package com.lisovitskiy.hw12;

import org.junit.Test;
import static org.junit.Assert.*;

public class LRUCacheTest {
	private LRUCache cache;

	public LRUCacheTest() {
		this.cache = new LRUCache(2);
	}

	@Test
	public void testEmpty() {
		assertEquals(cache.get(1), -1);
	}

	@Test
	public void testBelowCapacity() {
		cache.put(1, 1);
		assertEquals(cache.get(1), 1);
		assertEquals(cache.get(2), -1);
		cache.put(2, 4);
		assertEquals(cache.get(1), 1);
		assertEquals(cache.get(2), 4);
	}

	@Test
	public void testCapacityExceededEldestRemover() {
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		assertEquals(cache.get(1), - 1);
		assertEquals(cache.get(2), 2);
		assertEquals(cache.get(3), 3);
	}
}
