package com.buffermanagement.main;

import com.buffermanagement.observer.ShareSubject;

public class AutoRunner {
	

	public static void main(String args[]) throws InterruptedException {
		int startval = 99;
		Producer p = new Producer(500, 12, startval);
		Consumer c = new Consumer(1000, 5, startval);
		
		ShareSubject sb = new ShareSubject();
		sb.attach(p);
		sb.attach(c);
	
		
		Thread t1 =new Thread(p);  
		sb.setStartVal(999);
		
		Thread t2 =new Thread(c); 
		
		t1.start(); 
		 
		//Thread.sleep(2000);
		
		t2.start();
		
	}
}
