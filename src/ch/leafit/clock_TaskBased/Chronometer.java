package ch.leafit.clock_TaskBased;

import javafx.concurrent.Task;

public final class Chronometer extends Task<Object> {
	
	private int hsec,seconds,minutes,hours;
	private String result;
	private boolean noDisplay=false;
	
	public void enableDisplay(){noDisplay=false;}
	public void disableDisplay(){noDisplay=true;}
	public boolean isDisplayOn(){return !noDisplay;}
	
	@Override
	protected Void call() throws Exception {
		while(true){
			if(isCancelled())break;
			increment();
			refreshDisplay();
			if(!noDisplay)updateMessage(result);
			Thread.sleep(10);
		}
		return null;
	}
	
	private void increment(){
		hsec++;
		if(hsec>=100){
			hsec=0;
			seconds++;
		}
		if(seconds>=60){
			seconds=0;
			minutes++;
		}
		if(minutes>=60){
			minutes=0;
			hours++;
		}
		if(hours>=24) hours=0;
	}
	
	private void refreshDisplay(){result=hours+":"+minutes+":"+seconds+":"+hsec;}
	
}
