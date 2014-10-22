package Test;


import Interfaz.BaskedLabel;
import Interfaz.HamburgerLabel;
import Interfaz.PlayFrame;
import LogicHamburgesa.Basked;
import LogicHamburgesa.Hamburger;
import Persistencia.DataAppRam;


public class Demo {

	public static void main(String[]args){
		
            DataAppRam.getInstance();
		HamburgerLabel[] hamburger= new HamburgerLabel[5];
          // BaskedLabel basked= new BaskedLabel(new Basked(50));
	  	BaskedLabel basked= new BaskedLabel();
		
		
		
		for (int i = 0; i < hamburger.length; i++) {
			hamburger[i]= new HamburgerLabel(new Hamburger((byte)(10+Math.random()*80)));
		}
                PlayFrame play= new PlayFrame(hamburger, basked);
		play.setVisible(true);
		
                DataAppRam.getInstance().getWindows()[DataAppRam.PARAMETER_WINDOW].setVisible(true);
	}

}
