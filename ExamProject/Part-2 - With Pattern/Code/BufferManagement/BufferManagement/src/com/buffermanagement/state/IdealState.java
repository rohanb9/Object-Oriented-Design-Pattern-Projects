package com.buffermanagement.state;

import com.buffermanagement.classes.BoundedBuffer;

public class IdealState implements State {

   public int doAction(BoundedBuffer context) {
      System.out.println("					(BoundedBuffer in ideal state)");
      context.setState(this);
      return 0;	
   }

   public String toString(){
      return "Ideal State";
   }
}