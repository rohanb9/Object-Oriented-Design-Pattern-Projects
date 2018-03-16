package com.buffermanagement.main;

import com.buffermanagement.exception.BBException;
import com.buffermanagement.impl.BoundedBufferImpl;
import com.buffermanagement.impl.MediatorBBInterface;
import com.buffermanagement.observer.Observer;

public class Consumer extends Observer implements Runnable{
	
	private int startval = 0;

	private int sleepTime = 100;
	private int iterations = 1000;
	
	private MediatorBBInterface bbimpl;
	
	public Consumer(int sleepTime, int iterations, int startval) {
		this.sleepTime = sleepTime;
		this.iterations = iterations;
		this.startval = startval;
		this.bbimpl = new BoundedBufferImpl();
	}

	@Override
	public void run() {
		for(int i=0; i < iterations; i++) {

			try {
				getRequest();

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

	public void getRequest() throws BBException {

		System.out.println(" GET Request Generated.  "+ Thread.currentThread().getName());

		bbimpl.getRequest();
	}

	@Override
	public void update(int startVal) {
		this.startval = startVal;
	}
}
