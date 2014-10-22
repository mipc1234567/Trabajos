/*
 * To change this template, choose Tools | Templates

 * and open the template in the editor.
 */
package Persistencia;

import javax.swing.JDialog;

import Interfaz.ParameterWindow;

/**
 *
 * @author AULA
 */
public class DataAppRam {
    
   public static final int MAIN_WINDOW=0;
   public static final int PARAMETER_WINDOW=1;
   public static final int PLAYER_ONE_WINDOW=2;
   private static DataAppRam instance=null;
   private int numberHmbuerguer;
   private String playerName;
   private int level;
   private int playerPoints;
   private JDialog[] windows;
   
   private DataAppRam(){
       this.numberHmbuerguer=0;
       this.playerName=null;
       this.level=0;
       this.playerPoints=0;
       this.windows=new JDialog[3];
       windows[PARAMETER_WINDOW]= new ParameterWindow();
   }
   
   public static DataAppRam getInstance(){
       if(instance==null){
           instance=new DataAppRam();
       }
       return instance;
   }

    public int getNumberHmbuerguer() {
        return numberHmbuerguer;
    }

    public void setNumberHmbuerguer(int numberHmbuerguer) {
        this.numberHmbuerguer = numberHmbuerguer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public JDialog[] getVentanas() {
        return windows;
    }

    public void setVentanas(JDialog[] ventanas) {
        this.windows = ventanas;
    }

    public JDialog[] getWindows() {
        return windows;
    }

    public void setWindows(JDialog[] windows) {
        this.windows = windows;
    }
    
   
   
   
}
