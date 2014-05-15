package ch.leafit.trafficlight.auto;

public final class StateEngine {
	
	private State state=State.Red;
	
	public State nextState(){
		if(state==State.Red){
			state=State.Orange;
			return state;
		}
		if(state==State.Orange){
			state=State.Green;
			return state;
		}
		else{ // Green - Red
			state=State.Red;
			return state;
		}
	}
}
