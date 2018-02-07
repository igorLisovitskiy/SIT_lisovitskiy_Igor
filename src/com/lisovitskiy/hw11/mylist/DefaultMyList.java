package com.lisovitskiy.hw11.mylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class DefaultMyList<E> implements MyList<E>, ListIterable {
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	private Object[] data;
	private int cursor;
	private int lastElement = -1;

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

	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) data[index];
	}

	@Override
	public void add(E e) {
		ensureCapacity(size + 1);
		data[size++] = e;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean remove(E o) {
		int index = Arrays.asList(data).indexOf(o);
		if (index != -1) {
			int newLength = size - index - 1;
			System.arraycopy(data, index + 1, data, index, newLength);
			data[--size] = null;
			return true;
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(Object o) {
		int index = IntStream.range(0, size).filter(i -> o.equals(get(i))).findFirst().orElse(-1);
		return index > -1 ? true : false;
	}

	@Override
	public boolean containsAll(MyList<E> c) {
		boolean hasElement = false;
		if (size() == 0) {
			return false;
		} else {
			for (int i = 0; i < c.size(); i++) {
				DefaultMyList<E> dMl = (DefaultMyList<E>) c;
				hasElement = contains(dMl.get(i));
			}
		}
		return hasElement;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		if (size == 0) {
			return "{[]}";
		} else {
			sb.append("{");
			for (int i = 0; i < size; i++) {
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

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	@Override
	public ListIterator listIterator() {
		return new ListIteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object> {
		public boolean hasNext() {
			return cursor != size;
		}

		public Object next() {
			int i = cursor;
			if(i >= size){
				throw new NoSuchElementException();
			}
			Object[] dataIter = DefaultMyList.this.data;
			Object nextElement = dataIter[lastElement = i];
			cursor = i + 1;
			return nextElement;
		}

		@SuppressWarnings("unchecked")
		public void remove() {
			if (lastElement < 0) {
				throw new IllegalStateException();
			}
			DefaultMyList.this.remove((E) data[lastElement]);
			cursor = lastElement;
			lastElement = -1;
		}
	}

	private class ListIteratorImpl extends IteratorImpl implements ListIterator {
		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		@Override
		public Object previous() {
			Object previous = null;
			if (hasPrevious()) {
				int i = cursor - 1;
				lastElement = i;
				cursor = i;
				previous = get(i);
				previous = data[lastElement];
			} else {
				throw new NoSuchElementException();
			}
			return previous;
		}

		@Override
		public void set(Object e) {
			if (lastElement == -1) {
				throw new IllegalStateException();
			} else {
				data[lastElement] = e;
				lastElement = -1;
			}
		}
	}

	public static void main(String[] args) {

		DefaultMyList<Integer> intList = new DefaultMyList<>();

		for (int i = 0; i < 10; i++) {
			intList.add(i);
		}
		for (Object o : intList) {
			System.out.print(o + " ");
		}
		System.out.println();
		DefaultMyList<String> strList = new DefaultMyList<>();
		strList.add("I");
		strList.add(" tested");
		strList.add(" this!");
		System.out.println("IteratorImpl test:");
		Iterator<Object> it = strList.iterator();

		while (it.hasNext()) {
			System.out.print(it.next());
		}
		ListIterator it2 = strList.listIterator();
		System.out.println(it2.previous());
	}
}
