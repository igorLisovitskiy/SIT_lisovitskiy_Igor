package com.lisovitskiy.hw12;
import java.util.*;
import java.util.stream.*;

public class HashTable<K, V> {

	private ArrayList<HashNode<K, V>> bucketList; // used to store chains
	private int numberOfBuckets;
	private int size; // current size of bucket list

	public HashTable() {
		bucketList = new ArrayList<>();
		numberOfBuckets = 10;
		size = 0;

		// creating empty chains
		IntStream.range(0, numberOfBuckets).forEach(a -> {
			bucketList.add(null);
		});
	}

	private class HashNode<K, V> {
		K key;
		V value;
		HashNode<K, V> next;

		HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public int size() {
		return size;
	}
	private void doubleCapacity(ArrayList<HashNode<K, V>> bList){
		ArrayList<HashNode<K, V>> tempList = bList;
		bucketList = new ArrayList<HashNode<K, V>>();
		numberOfBuckets = numberOfBuckets * 2;
		size = 0;
		IntStream.range(0, numberOfBuckets).forEach(nbk -> {
			bucketList.add(null);
		});
		for (HashNode<K, V> headNode : tempList) {
			while (headNode != null) {
				add(headNode.key, headNode.value);
				headNode = headNode.next;
			}
		}
	}
	public boolean contains(K key){
		HashNode<K, V> head = bucketList.get(getBucketIndex(key));
		while(head != null){
			if(head.key.equals(key)){
				return true;
			}else{
				head = head.next;
			}
		}
		return false;
		
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	// find bucket index for a key, implements hash function
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		// ~4 billion different possible hash codes
		int index = hashCode % numberOfBuckets; // compressing the hash code to the number of buckets
		return index;
	}

	public boolean remove(K key) {
		int bucketIndex = getBucketIndex(key);
		// get the head of the chain of the nodes in the bucket
		HashNode<K, V> head = bucketList.get(bucketIndex);
		HashNode<K, V> previous = null;
		// find the key in the chain
		while (head != null) {
			if (head.key.equals(key)) {
				break;
			} else {
				previous = head;
				head = head.next;
			}
		}
		if (head == null) {
			return false;
		}
		size--;
		if (previous != null) {
			previous.next = head.next;
		} else {
			bucketList.set(bucketIndex, head.next);
		}
		return true;
	}

	// add a key value pair to hash
	public void add(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketList.get(bucketIndex);
		// check if the key already present
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			} else {
				head = head.next;
			}
		}
		size++;
		head = bucketList.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		bucketList.set(bucketIndex, newNode);
		if ((1.0 * size) / numberOfBuckets >= 0.7) { // when more than 7 elements out of default 10 is filled, double the size of the hash table
			doubleCapacity(bucketList);
		}
	}
	public V get(K key){
		HashNode<K,V> head = bucketList.get(getBucketIndex(key));
		while(head != null){
			if(head.key.equals(key)){
				return head.value;
			}else{
				head = head.next;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (HashNode<K, V> headNode : bucketList) {
			while (headNode != null) {
				sb.append("{" + headNode.key.toString());
				sb.append(" = ");
				sb.append(headNode.value.toString() + "}, ");
				headNode = headNode.next;
			}
		}

		return sb.toString().substring(0, sb.length() - 2);
	}
}
