package com.lisovitskiy.hw11.mylist;

public interface MyList<E> extends Iterable<Object>{
		 void add(E e); // appends the specified element to the end of this list
		 void clear(); // removes all of the elements from this list
		 boolean remove(E o); // removes the first occurrence of the specified element from this list
		 Object[] toArray(); // returns an array containing all of the elements in this list in proper sequence
		 int size(); // returns the number of elements in this list
		 boolean contains(E o); // returns true if this list contains the specified element.
		 boolean containsAll(MyList<E> c); // returns true if this list contains all of the elements of the specified list
		

}
