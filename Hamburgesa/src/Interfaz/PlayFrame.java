package Interfaz;

import java.awt.Component;

import java.awt.Event;
import java.awt.GraphicsConfiguration;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Persistencia.DataAppRam;


public class PlayFrame<BaskedLabel> extends JFrame implements KeyListener {

	private HamburgerLabel[] arrayHambuerger; 
	private BaskedLabel baskedLabel;	
	private  Thread[] hilos;

	public PlayFrame(HamburgerLabel[] arrayHamburgerLabel, BaskedLabel baskedLabel) throws HeadlessException {
		setSize(500,500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.hilos= new Thread[arrayHamburgerLabel.length];
		this.arrayHambuerger=arrayHamburgerLabel;
		
		
		
		for (int i = 0; i < arrayHamburgerLabel.length; i++) {
			int size=(int)(arrayHamburgerLabel[i].getWidth());
			int limite=getWidth()-size;
			arrayHamburgerLabel[i].setLocation((int)(Math.random()*(limite)), 0);
			this.add(arrayHamburgerLabel[i]);
			hilos[i]= new Thread(arrayHambuerger[i]);
			
			
		}
		
		
		this.baskedLabel=baskedLabel;
		((Component) this.baskedLabel).setLocation(getWidth()/2-((Component) baskedLabel).getWidth()/2,getWidth()-((Component) baskedLabel).getWidth() );
			
		add((Component) baskedLabel);
		
//		add(arrayHamburgerLabel);
		setVisible(true);
		addKeyListener(this);
		
		
		
		
		
		
		 JMenuBar bar = new JMenuBar();
		    JMenu menu = new JMenu("File");
		    menu.setMnemonic('f');
		    bar.add(menu);

		    JMenuItem exit = new JMenuItem("Exit");
		    exit.setMnemonic('x');
		    exit.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        System.out.println("Exit performed");
		        PlayFrame.this.dispose();
		        System.exit(0);
		      }
		    });
		    menu.add(exit);

		    menu = new JMenu("Edit");
		    menu.setMnemonic('e');
		    bar.add(menu);

		    EditListener l = new EditListener();
		    JMenuItem mi;
		    mi = menu.add(new JMenuItem("Cut", 't'));
		    mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
		    mi.addActionListener(l);
		    mi = menu.add(new JMenuItem("Copy", 'c'));
		    mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
		    mi.addActionListener(l);
		    mi = menu.add(new JMenuItem("Paste", 'p'));
		    mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
		    mi.addActionListener(l);
		    
		    menu = new JMenu("Options");
		    menu.setMnemonic('e');
		    bar.add(menu);
		    
		    
		    menu = new JMenu("Help");
		    menu.setMnemonic('e');
		    bar.add(menu);


		    menu = new JMenu("Configurations");
		    menu.setMnemonic('e');
		    bar.add(menu);

		    setJMenuBar(bar);
		    getContentPane().add(new JLabel("A placeholder"));
	}
//	public PlayFrame(HamburgerLabel HamburgerLabel, BaskedLabel baskedLabel) throws HeadlessException {
//		HamburgerLabel= new HamburgerLabel();
//		HamburgerLabel.setLocation(0,0);
////		HamburgerLabel.setLocation(0,8);
////		HamburgerLabel.setLocation(0,16);
//		this.baskedLabel=baskedLabel;
//		setSize(500,500);
//		setLayout(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.baskedLabel.setLocation(getWidth()/2-baskedLabel.getWidth()/2,getWidth()-baskedLabel.getWidth() );
//		add(HamburgerLabel);
//		add(HamburgerLabel);
//		add(HamburgerLabel);
//		add(baskedLabel);
//		setVisible(true);
//		addKeyListener(this);
//	}
	

//-----------------------METODOS-------------------------------------------
	
	public void addHamburger(HamburgerLabel hamburgerLabel){

		HamburgerLabel[] auxProduct = new HamburgerLabel[arrayHambuerger.length];
		for (int i = 0; i < arrayHambuerger.length; i++) {
			auxProduct[i] = arrayHambuerger[i];
		}
		auxProduct[arrayHambuerger.length] = hamburgerLabel; 
		arrayHambuerger = auxProduct;
	}
	
	public void changePositionBasked(int value){
		int x= ((Component) baskedLabel).getX()+value;
		int y=getWidth()-((Component) baskedLabel).getWidth();
                ((Component) baskedLabel).setLocation(x, y);
	}
        public void baskedHome(){
            
            ((Component) baskedLabel).setLocation(0, getWidth()-((Component) baskedLabel).getWidth());
        }


	@Override
	public void keyPressed(KeyEvent key) {
		if(key.getKeyCode()==KeyEvent.VK_ENTER){
                   for(int i=0; i<hilos.length;i++){
                       arrayHambuerger[i].setPlayFrame(this);
                               hilos[i].start();
                                }
		}
		if(key.getKeyCode()==KeyEvent.VK_LEFT){
			changePositionBasked(-2);
		}
		if(key.getKeyCode()==KeyEvent.VK_RIGHT){
			changePositionBasked(2);
		}
                if(key.getKeyCode()==KeyEvent.VK_HOME){
			baskedHome();
		}
                if(key.getKeyCode()==KeyEvent.VK_ALT){
			DataAppRam.getInstance().getWindows()[DataAppRam.PARAMETER_WINDOW].setVisible(true);
		}
	}
	  private class EditListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      System.out.println(e.getActionCommand());
		    }
		  }

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
//-----------------------LOS GET Y LO SET---------------------------


	
	public PlayFrame(BaskedLabel baskedLabel) throws HeadlessException {
		super();
		this.baskedLabel = baskedLabel;
	}


	public BaskedLabel getBaskedLabel() {
		return baskedLabel;
	}



	public void setBaskedLabel(BaskedLabel baskedLabel) {
		this.baskedLabel = baskedLabel;
	}



	public HamburgerLabel[] getArrayHambuerger() {
		return arrayHambuerger;
	}

	public void setArrayHambuerger(HamburgerLabel[] arrayHambuerger) {
		this.arrayHambuerger = arrayHambuerger;
	}
	

}
