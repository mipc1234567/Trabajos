package LogicaGame;

import java.awt.Component;
import java.awt.HeadlessException;

import Interfaz.BaskedLabel;
import Interfaz.HamburgerLabel;

public class LogicaGame {
	

	private HamburgerLabel[] arrayHambuerger; 
	private BaskedLabel baskedLabel;	
	private  Thread[] hilos;

	public LogicaGame(HamburgerLabel[] arrayHamburgerLabel, BaskedLabel baskedLabel) throws HeadlessException {
	
		this.hilos= new Thread[arrayHamburgerLabel.length];
		this.arrayHambuerger=arrayHamburgerLabel;
		
		
		for (int i = 0; i < arrayHamburgerLabel.length; i++) {
			int size=(int)(arrayHamburgerLabel[i].getWidth());
			//int limite=getWidth()-size;
			//arrayHamburgerLabel[i].setLocation((int)(Math.random()*(limite)), 0);
			//this.add(arrayHamburgerLabel[i]);
			hilos[i]= new Thread(arrayHambuerger[i]);
			
			
		}
		
		
		this.baskedLabel=baskedLabel;
		//((Component) this.baskedLabel).setLocation(getWidth()/2-((Component) baskedLabel).getWidth()/2,getWidth()-((Component) baskedLabel).getWidth() );
			
		//add((Component) baskedLabel);
		

	}
	public int contWin(){
		return 0;
		
	}
	
	
	public void createGamer(){
		
	}
	
	public void CatchHamburger(){
		
	}
	
	
}
