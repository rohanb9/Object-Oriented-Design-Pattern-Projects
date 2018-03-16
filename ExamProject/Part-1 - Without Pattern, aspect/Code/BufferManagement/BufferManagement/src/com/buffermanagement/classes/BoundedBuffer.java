package com.buffermanagement.classes;

import com.buffermanagement.exception.BBException;

public class BoundedBuffer {
	private int buff[];
	private int start=0;
	private int end=-1;
	private int currentSize = 0;
	private int buffSize;
	
	public BoundedBuffer(int size) {
		this.buff = new int[size];
		this.buffSize = size;
		this.currentSize = 0;
	}
	
	public synchronized void put(int val) throws BBException {
		
		if(!isFull()) {

			end = (end + 1) % buffSize;
			buff[end] = val;
			currentSize++;
			

			//System.out.println(" start " + start + "  end " + end + " curr " + currentSize);
			//printBuffer();
		} else {
			throw new BBException("Buffer is full.");
		}
	}
	
	public int get() throws BBException {
		if(!isEmpty()) {
			int element = buff[start];
			start = (start + 1) % buffSize;
			currentSize-- ;
			

			//System.out.println(" start " + start + "  end " + end + " curr " + currentSize);
			//printBuffer();

			return element; 
		} else {
			throw new BBException("Buffer is empty.");
		}
		
	}
	
	public boolean isEmpty() {
		if(currentSize <= 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(buffSize == currentSize) {
			return true;
		}
		return false;
	}
	
	public void printBuffer() {
		System.out.println("BUFFER -> " + toString());
		/*for(int i=0; i<=(buffSize) ; i++ ) {
	
			System.out.println(" i, " + buff[i] );
		}*/
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		int i = 0; 
		int j = start;
		while(i < currentSize) {
			str.append(Integer.toString(buff[j]) + " ");
			j = (j+1) % buffSize;
			i++;
		}
		return str.toString();
	}
}
