package com.buffermanagement.main;

import com.buffermanagement.exception.BBException;
import com.buffermanagement.impl.BBInterface;
import com.buffermanagement.impl.BoundedBufferImpl;

public class Consumer implements Runnable{
	
	private int sleepTime = 100;
	private int iterations = 1000;
	
	private BBInterface bbimpl;
	
	public Consumer(int sleepTime, int iterations) {
		this.sleepTime = sleepTime;
		this.iterations = iterations;
		bbimpl = new BoundedBufferImpl();
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
}
