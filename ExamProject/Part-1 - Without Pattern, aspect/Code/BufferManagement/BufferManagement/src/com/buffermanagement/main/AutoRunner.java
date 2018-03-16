package com.buffermanagement.main;

public class AutoRunner {
	

	public static void main(String args[]) throws InterruptedException {
		Producer p = new Producer(500, 12, 99);
		Consumer c = new Consumer(1000, 5);
		
		Thread t1 =new Thread(p);  
		Thread t2 =new Thread(c); 
		
		t1.start(); 
		 
		//Thread.sleep(2000);
		
		t2.start();
		
	}
}
