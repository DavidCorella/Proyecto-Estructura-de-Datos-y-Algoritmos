
package personajes;

import funcionesJuego.ImageFunctions;
import javax.swing.ImageIcon;

public class MainCharacter {
    
    private int positionX;
    private int positionY;
    private int width;
    private int height;
    private int life;
    private int stamina;
    private ImageIcon main_Image;
    private int sequence;
    private ImageFunctions images;
    
    public MainCharacter(int X, int Y, int width, int height){
        images = new ImageFunctions();
        positionX = X;
        positionY = Y;
        this.height = height;
        this.width = width;
        life = 100;
        stamina = 100;
        sequence = 0;
        main_Image = images.mcWalking(0, width, height);
    }
    
    public ImageIcon getIcon(){
        return main_Image;
    }
    
    public int getPositionX(){
        return positionX;
    }
    
    public int getPositionY(){
        return positionY;
    }
    
    public void setPositionX(int X){
        positionX = X;
    }
    
    public void setPositionY(int Y){
        positionY = Y;
    }
    
    public void setSequence(int i){
        sequence = i;
    }
    
    public int getSequence(){
        return sequence;
    }
    
    public void moveRigth(){
        positionX += 10;
        sequence = (sequence<17?sequence + 1:0);
        main_Image = images.mcWalking(sequence, width, height);
    }
}
