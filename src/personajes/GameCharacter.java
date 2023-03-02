// Este es el objeto del personaje

package personajes;

import funcionesJuego.ImageFunctions;
import javax.swing.ImageIcon;

public class GameCharacter {
    
    private int positionX;
    private int positionY;
    private int width;
    private int height;
    private int life;
    private int stamina;
    private ImageIcon main_Image;
    private int sequence;
    private ImageFunctions image;
    private char direccion;
    private int sequenceJump;
    private String isAction;
    private final String type;
    
    public GameCharacter(int X, int Y, int width, int height, String type){
        image = new ImageFunctions();
        positionX = X;
        positionY = Y;
        this.height = height;
        this.width = width;
        life = 100;
        stamina = 100;
        sequence = 0;
        main_Image = image.characterImages(0, width, height,"",type);
        direccion = 'R';
        sequenceJump = 5;
        isAction = null;
        this.type = type;
    }
    
    //Sets y Gets de Atributos
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getLife(){
        return life;
    }
    public void setLife(int life){
        this.life += life;
    }
    public int getWidth(){
        return width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public String getisAction(){
        return isAction;
    }
    public void setisAction(String isAction){
        this.isAction = isAction;
    }
    public ImageIcon getIcon(){
        return main_Image;
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
    
    //Acciones de personaje
    public void moveRigth(){
        positionX += (isAction.equals("isJumping") ? 5 : 10);
        sequence = (sequence<17?sequence + 1:0);
        main_Image = image.characterImages(sequence, width, height,"Walking_Right",type);
        direccion = 'R';
    }
    public void moveLeft(){
        positionX -= (isAction.equals("isJumping") ? 5 : 10);
        sequence = (sequence<17?sequence + 1:0);
        main_Image = image.characterImages(sequence, width, height,"Walking_Left",type);
        direccion = 'L';
    }  
    public void jumping() {
        String action = Character.compare(direccion,'R')==0?"Jumping_Right":"Jumping_Left";
        if(sequenceJump < 1){
            main_Image = image.characterImages(sequenceJump, width, height,action,type);
            pause(120);
        }
        else{
            positionY -= 10;
            main_Image = image.characterImages(sequenceJump--, width, height,action,type);
            pause(120);
            jumping();
            main_Image = image.characterImages(sequenceJump++, width, height,action,type);
            positionY += 10;
            pause(120);
        }
        if(sequenceJump == 6){
            action = Character.compare(direccion,'R')==0?"Walking_Right":"Walking_Left";
            sequence = 0;
            main_Image = image.characterImages(sequence, width, height,action,type);
        }
    }
    public void attacking(){
        String action = (Character.compare(direccion, 'R')==0 ? "Attacking_Right" : "Attacking_Left");
        for(int i = 0; i < 12 ; i++){      
            main_Image = image.characterImages(i, width, height,action,type);
            pause(75);
        }

        
    }
    public void idle(){
        int i = 0;
        String action = (Character.compare(direccion, 'R')==0 ? "Idle_Right" : "Idle_Left");
        while(isAction.equals("Idle")){  
            main_Image = image.characterImages(i, width, height,action,type);
            pause(100);
            i = (i<11?i+1:0);
        }
    }
    
    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            
        }
    } // metodo de pausa
    
}
