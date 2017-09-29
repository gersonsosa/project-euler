package com.gersonsosa.projecteuler;

import java.util.Arrays;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
public class MaxHeap {
	private int capacity = 10;
	private int size = 0;

	private int[] elements = new int[capacity];

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return elements[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return elements[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return elements[getParentIndex(index)];
	}

	private void swap(int index1, int index2) {
		int index1Element = elements[index1];
		elements[index1] = elements[index2];
		elements[index2] = index1Element;
	}

	private void ensureCapacity() {
		if (size == capacity) {
			elements = Arrays.copyOf(elements, capacity * 2);
			capacity *= 2;
		}
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException("The heap is empty");
		}
		return elements[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalStateException("The heap is empty");
		}
		int element = elements[0];
		elements[0] = elements[size - 1];
		size--;
		heapifyDown();
		return element;
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int largestChildIndex = getLargestChildIndex(index);
			if (elements[index] < elements[largestChildIndex]) {
				swap(index, largestChildIndex);
				index = largestChildIndex;
			}else{
				break;
			}
		}
	}

	private int getLargestChildIndex(int index) {

		if (!hasRightChild(index)) {
			return getLeftChildIndex(index);
		}else if (leftChild(index) < rightChild(index)) {
			return getRightChildIndex(index);
		}else {
			return getLeftChildIndex(index);
		}
	}

	public void add(int element) {
		ensureCapacity();
		elements[size] = element;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) < elements[index]) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
}
