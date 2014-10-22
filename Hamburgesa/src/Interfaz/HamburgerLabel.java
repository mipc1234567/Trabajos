package Interfaz;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JLabel;

import LogicHamburgesa.Hamburger;
import Persistencia.DataAppRam;



public class HamburgerLabel extends JLabel implements Runnable{
	
	private Hamburger hamburger;
    private PlayFrame playFrame;
        
        
        

	public HamburgerLabel(Hamburger hambuerger) {    
		this.playFrame=null;
		this.hamburger=hambuerger;
		this.setSize(hamburger.getSize(),hamburger.getSize());
		
	}
	
	@Override
	public void run() {
		while(true){
                    int y= getY()+1;
                    ParameterWindow pw;
                    pw=(ParameterWindow)DataAppRam.getInstance().getWindows()[DataAppRam.PARAMETER_WINDOW];
                    pw.setPoints(y);
                    
                    if(getY()==playFrame.getHeight()){
                        y=0;
                    }
                     setLocation(getX(), y);
			
                        
			try {
				Thread.sleep((int) (10+Math.random()*50));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
        
	
	
//---------------------LOS GET Y LOS SET------------------------
	
	
    public PlayFrame getPlayFrame() {
        return playFrame;
    }

    public void setPlayFrame(PlayFrame playFrame) {
        this.playFrame = playFrame;
    }
	

	public Hamburger getHamburger() {
		return hamburger;
	}

	public void setHamburger(Hamburger hamburger) {
		this.hamburger = hamburger;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(0, 0,hamburger.getSize(), hamburger.getSize());
	//g.fill3DRect(0, 0,hamburger.getSize(), hamburger.getSize(), true);
	
	}
	
	
	



}
