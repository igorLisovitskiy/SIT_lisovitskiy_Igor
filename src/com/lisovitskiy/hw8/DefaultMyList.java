package com.lisovitskiy.hw8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultMyList implements MyList {
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	private Object[] data;

	public DefaultMyList(int initialCapacity) {
		if (initialCapacity > 0) {
			this.data = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.data = new Object[] {};
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
	}

	public DefaultMyList() {
		this.data = new Object[DEFAULT_CAPACITY];
	}

	private void ensureCapacity(int minCapacity) {
		if (minCapacity - data.length > 0) {
			grow(minCapacity);
		}

	}

	private void grow(int minCapacity) {
		int oldCapacity = data.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1); // 10 >> 1 == 5 increase to 50%; 5 >> 1 == 2;
		if (newCapacity > 0 && newCapacity > oldCapacity) {
		} else {
			newCapacity = minCapacity;
		}
		data = Arrays.copyOf(data, newCapacity);

	}

	public Object get(int index) {
		return data[index];
	}

	@Override
	public void add(Object e) {
		ensureCapacity(size + 1);
		data[size++] = e;
		// appends the specified element to the end of this list
	}

	@Override
	public void clear() {
		// removes all of the elements from this list

	}

	@Override
	public boolean remove(Object o) {
		// removes the first occurrence of the specified element from this list
		return false;
	}

	@Override
	public Object[] toArray() {
		// returns an array containing all of the elements in this list in
		// proper sequence
		return Arrays.copyOf(data, size);
	}

	@Override
	public int size() {
		// returns the number of elements in this list
		return this.size;
	}

	@Override
	public boolean contains(Object o) {
		// returns true if this list contains the specified element.
		return false;
	}

	@Override
	public boolean containsAll(MyList c) {
		// returns true if this list contains all of the elements of the
		// specified list
		return false;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		int length = data.length;
		if (length == 0) {
			return "{[]}";
		} else {
			sb.append("{");
			for (int i = 0; i < data.length; i++) {
				if (data[i] != null) {
					sb.append("[");
					sb.append(data[i]);
					sb.append("], ");
				}
			}
			String sList = sb.toString();
			return sList.substring(0, sList.length() - 2) + "}";
		}

	}

	public static void main(String[] args) {

		DefaultMyList dList = new DefaultMyList();
		dList.add(1);
		dList.add(2);
		System.out.println(dList.size());
		List<Integer> li = new ArrayList<>();

		System.out.println(dList);

	}

}
