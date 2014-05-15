package ch.leafit.startstop.sample1;

import java.util.Date;

public final class A extends Thread{
	
	private String name;
	private boolean stopTheThread=false;
	
	public A(String name){
		this.name=name;
		start();
	}
	
	public void run(){
		while(!stopTheThread){
			try{System.out.println("Hello I'm "+name);
				System.out.println("Current time is: "+new Date());
			    if (Thread.interrupted()) {
			        // We've been interrupted: no more working.
			    	System.out.println("Interruption ...");
					throw new InterruptedException();
			    }
				Thread.sleep(1000);}
			catch(InterruptedException e) {
			    // If the thread is interrupted while sleeping
				stopTheThread=true;
				System.out.println(name+" is ending - by interruption");
			}
		}
	}
}
