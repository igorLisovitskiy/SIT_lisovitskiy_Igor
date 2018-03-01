package com.lisovitskiy.hw12;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {
	private int capacity;
	private LinkedHashMap<Integer, Integer> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new LinkedHashMap<>();
	}

	public int get(int key) {
		Integer value = map.get(key);
		if (value == null) {
			return -1;
		} else {
			put(key, value);
		}

		return value;

	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			map.remove(key);
		} else if (map.size() >= capacity) {
			Iterator<Integer> it = map.keySet().iterator();
			it.next();
			it.remove();
		}
		map.put(key, value);
	}

}