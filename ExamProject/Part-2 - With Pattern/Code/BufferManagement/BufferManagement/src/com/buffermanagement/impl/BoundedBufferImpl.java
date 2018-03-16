package com.buffermanagement.impl;

import java.util.LinkedList;
import java.util.Queue;

import com.buffermanagement.classes.BoundedBuffer;
import com.buffermanagement.classes.Request;
import com.buffermanagement.exception.BBException;
import com.buffermanagement.state.IdealState;
import com.buffermanagement.state.ReadState;
import com.buffermanagement.state.WriteState;

public class BoundedBufferImpl implements MediatorBBInterface {

	private BoundedBuffer bb = BoundedBuffer.getInstance();
	private static String READ = "READ";
	private static String WRITE = "WRITE";

	// Sequence queue
    Queue<String> q = new LinkedList<String>();
	// Read queue
    Queue<Request> readq = new LinkedList<Request>();
	// Write queue
    Queue<Request> writeq = new LinkedList<Request>();
    
    boolean inprocess = false;
    boolean lock = false;
    
	
	@Override
	public void putRequest(int val) throws BBException {
		q.add(WRITE);
		writeq.add(new Request(WRITE, Integer.toString(val)));
		if(!inprocess) {
			processExecutor(val);
		}
		
	}
	
	private int processExecutor(int v) throws BBException {
		String temp;
		inprocess = true;
		while(!q.isEmpty()) {
			
			if(!lock) {
				try {
					temp = q.remove();
					
					if(temp.equals(WRITE)) {
						WriteState writestate = new WriteState();
						
						
						lock = true;
						
						writestate.setValue(v);
						writestate.doAction(bb);
						writeq.remove();
						
						lock = false;
						
					} else if(temp.equals(READ)) {
						ReadState readstate = new ReadState();
						
						int getval = readstate.doAction(bb);
						System.out.println(" 									"+Thread.currentThread().getName()+" GET REQ OUTPUT =  " + getval);
						readq.remove();
					}
				} catch (BBException e) {
					lock = false;
					System.out.println(" 									*************************** Exception in "+ Thread.currentThread().getName() + " : " + e.getMsg());
				}
			}
		} 
		
		IdealState idealstate = new IdealState();
		idealstate.doAction(bb);
		
		inprocess = false;
		return 0;
	}

	@Override
	public int getRequest() throws BBException  {
		q.add(READ);

		readq.add(new Request(READ));
		if(!inprocess) {
			processExecutor(0);
		}
		return 0;
	}

	/*public static void main(String args[]) throws InterruptedException, BBException {
		bb.put(10);
		bb.put(11);
		bb.put(12);
		bb.put(13);
		bb.put(14);
		
		System.out.println("---  val " + bb.get());

		System.out.println("  val " + bb.get());

		System.out.println("  val " + bb.get());

		System.out.println("  val " + bb.get());

		System.out.println("  val " + bb.get());


		//System.out.println("  val " + bb.get());
		
		
	}*/
}
