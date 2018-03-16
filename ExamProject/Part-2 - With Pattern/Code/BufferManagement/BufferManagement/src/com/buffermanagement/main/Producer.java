package com.buffermanagement.main;

import com.buffermanagement.exception.BBException;
import com.buffermanagement.impl.BoundedBufferImpl;
import com.buffermanagement.impl.MediatorBBInterface;
import com.buffermanagement.observer.Observer;

public class Producer extends Observer implements Runnable {
	
	private int startval = 0;
	
	private int sleepTime = 100;
	private int iterations = 1000;

	private MediatorBBInterface bbimpl;
	
	public Producer(int sleepTime, int iterations, int startval) {
		this.sleepTime = sleepTime;
		this.iterations = iterations;
		this.startval = startval;
		this.bbimpl = new BoundedBufferImpl();
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

		System.out.println(" PUT (val = "+ startval +") Request Generated. " + Thread.currentThread().getName());
		bbimpl.putRequest(startval);
		startval++;
	}

	@Override
	public void update(int startVal) {
		this.startval = startVal;
	}
	
}
