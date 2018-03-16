package com.buffermanagement.main;

import com.buffermanagement.exception.BBException;
import com.buffermanagement.impl.BBInterface;
import com.buffermanagement.impl.BoundedBufferImpl;

public class Producer implements Runnable {
	
	private int inc = 0;
	
	private int sleepTime = 100;
	private int iterations = 1000;

	private BBInterface bbimpl;
	
	public Producer(int sleepTime, int iterations, int inc) {
		this.sleepTime = sleepTime;
		this.iterations = iterations;
		this.inc = inc;
		bbimpl = new BoundedBufferImpl();
	}
	
	@Override
	public void run() {
		
		for(int i=0; i < iterations; i++) {
			try {

				putRequest();
				
				//System.out.println("--------------------------------------------------------------------\n");
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BBException e) {
				System.out.println(" 									*************************** Exception in "+ Thread.currentThread().getName() + " :  " + e.getMsg());
			} catch (Exception e) {
				System.out.println(" ERROR: " + e.getMessage());
			}
		}
		
	}
	
	public void putRequest() throws BBException {

		System.out.println(" PUT (val = "+ inc +") Request Generated. " + Thread.currentThread().getName());
		bbimpl.putRequest(inc);
		inc++;
	}
	
}
