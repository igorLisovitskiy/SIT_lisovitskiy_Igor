package com.lisovitskiy.hw12;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.*;

import static org.hamcrest.Matchers.equalTo;

public class HashTableTest {
	private HashTable<Integer, String> testTable;
	
	@Before
	public void setUpTable(){
		testTable = new HashTable<Integer, String>();
		testTable.add(1, "first");
		testTable.add(2, "second");
		testTable.add(3, "third");
	}
	@Test
	public void addsNewPair(){
		testTable.add(4, "forth");
		assertTrue(testTable.contains(4));
	}
	@Test
	public void doublesCapacity(){
		//how to test this?
	}
	@Test
	public void getsAddedValue(){
		assertThat(testTable.get(3),is(equalTo("third")));
	}
	@Test
	public void removesGivenValueByKey(){
		assertTrue(testTable.remove(2));
		assertFalse(testTable.contains(2));
	}
	@Test
	public void doesNotRemoveNonExistingValue(){
		assertFalse(testTable.remove(999));
	}
	@Test
	public void returnsSize(){
		assertThat(testTable.size(), is(equalTo(3)));
	}
	@Test
	public void notEmptyTable(){
		assertFalse(testTable.isEmpty());
	}
	@Test
	public void testToString(){
		testTable.remove(1);
		assertTrue(testTable.toString().equals("{2 = second}, {3 = third}"));
	}
	
}
