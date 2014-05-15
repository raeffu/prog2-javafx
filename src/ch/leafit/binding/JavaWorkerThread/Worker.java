package ch.leafit.binding.JavaWorkerThread;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;

public class Worker extends Thread{
	
	private IntegerProperty secProp, minProp, hourProp;
	private int secCounter=0, minCounter=0, hourCounter=0;
	
	public Worker(IntegerProperty secProp, IntegerProperty minProp, IntegerProperty hourProp){
		this.secProp=secProp;
		this.minProp=minProp;
		this.hourProp=hourProp;
		start();
	}
	
	public void run(){
		while(true){
			secCounter++;
			if(secCounter<60)
				Platform.runLater(new Runnable() {
					public void run() {secProp.set(secCounter);}
				});
			else{
				secCounter=0;
				minCounter++;
				if(minCounter < 60)
					Platform.runLater(new Runnable() {
						public void run() {minProp.set(minCounter);}
					});
				else{
					minCounter=0;
					hourCounter++;
					if(hourCounter>=24) hourCounter=0;
					Platform.runLater(new Runnable() {
						public void run(){hourProp.set(hourCounter);}
					});
				}
			}	
			try{Thread.sleep(1000);}
			catch (InterruptedException e) {}
		}
	}
}
