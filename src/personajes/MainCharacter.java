
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
    private char direccion;
    private int sequenceJump;
    private boolean isJumping;
    private boolean isAttacking;
    
    public MainCharacter(){
        images = new ImageFunctions();
        positionX = 0;
        positionY = 0;
        this.height = 0;
        this.width = 0;
        life = 0;
        stamina = 0;
        sequence = 0;
        main_Image = null;
        direccion = ' ';
        sequenceJump = 0;
        isJumping = false;
        isAttacking = false;
    }
    public MainCharacter(int X, int Y, int width, int height){
        images = new ImageFunctions();
        positionX = X;
        positionY = Y;
        this.height = height;
        this.width = width;
        life = 100;
        stamina = 100;
        sequence = 0;
        main_Image = images.mcWalking(0, width, height,"");
        direccion = 'R';
        sequenceJump = 5;
    }
    
    public ImageIcon getIcon(){
        return main_Image;
    }
    
    public void setisAttacking(boolean isAttacking){
        this.isAttacking = isAttacking;
    }
    
    public boolean getisAttacking(){
        return isAttacking;
    }
    
    public void setSequenceJump(int sequence){
        this.sequenceJump = sequence;
    }
    
    public int getSequenceJump(){
        return sequenceJump;
    }
    
    public void setDirection(char direction){
        this.direccion = direction;
    }
    
    public char getDirection(){
        return direccion;
    }
    
    public void setIcon(ImageIcon imag){
        main_Image = imag;
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
        positionX += (isJumping ? 25 : 10);
        sequence = (sequence<17?sequence + 1:0);
        main_Image = images.mcWalking(sequence, width, height,"Walking_Right");
        direccion = 'R';
    }
    
    public void moveLeft(){
        positionX -= (isJumping ? 20 : 10);;
        sequence = (sequence<17?sequence + 1:0);
        main_Image = images.mcWalking(sequence, width, height,"Walking_Left");
        direccion = 'L';
    }
    
    public void jumping() {
        isJumping = true;
        String action = Character.compare(direccion,'R')==0?"Jumping_Right":"Jumping_Left";
        if(sequenceJump < 1){
            main_Image = images.mcWalking(sequenceJump, width, height,action);
        }
        else{
            positionY -= 10;
            main_Image = images.mcWalking(sequenceJump--, width, height,action);
            pause(120);
            jumping();
            main_Image = images.mcWalking(sequenceJump++, width, height,action);
            positionY += 10;
            pause(120);
        }
        isJumping = false;
        action = Character.compare(direccion,'R')==0?"Walking_Right":"Walking_Left";
        sequence = 0;
        main_Image = images.mcWalking(sequence, width, height,action);
    }
    
    public void attacking(){
        String action = (Character.compare(direccion, 'R')==0 ? "Attacking_Right" : "Attacking_Left");
        for(int i = 0; i < 12 ; i++){
            isAttacking = true;
            main_Image = images.mcWalking(i, width, height,action);
            pause(100);
            isAttacking = false;
        }
    }
    
    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
}
