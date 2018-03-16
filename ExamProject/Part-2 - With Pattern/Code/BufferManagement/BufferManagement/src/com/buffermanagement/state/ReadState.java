package com.buffermanagement.state;

import com.buffermanagement.classes.BoundedBuffer;
import com.buffermanagement.exception.BBException;

public class ReadState implements State {

   public int doAction(BoundedBuffer context) throws BBException {
      System.out.println("					(BoundedBuffer in Read state)");
      context.setState(this);

      if(!context.isEmpty()) {
    	  	int[] b = context.getBuff();
    	  	int start = context.getStart();
			int element = b[start];
			start = (start + 1) % context.getBuffSize();
			
			context.setStart(start);
			int currSize = context.getCurrentSize() - 1 ;
			context.setCurrentSize(currSize);
			
			

			//System.out.println(" start " + start + "  end " + end + " curr " + currentSize);
			//printBuffer();

			return element; 
		} else {
			throw new BBException("Buffer is empty.");
		}
   }

   
   public String toString(){
      return "Read State";
   }
}