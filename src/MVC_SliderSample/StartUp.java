package MVC_SliderSample;

import javax.swing.JFrame;

public final class StartUp{
	
   private StartUp(){}
	
   public static void main(String[] args){
      SliderFrame frame = new SliderFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

