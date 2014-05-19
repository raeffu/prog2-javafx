package MVC_SelfMade;

public final class ConsoleView implements View {

	private Model m;
	
	public ConsoleView(Model m){this.m=m;}

	@Override
	public void react() {System.out.println("" + m.getX());}
}