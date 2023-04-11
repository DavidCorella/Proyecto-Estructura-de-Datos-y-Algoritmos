//Clase del objeto de la lampara, almacena cual lampara ha sido encendida.

package LogicaObjetos;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Lamp {

    private String lampState1;
    private String lampState2;
    private String lampState3;
    private String lampState4;
    private String lampState5;
    private String lampState6;
    private String lampState0;
    private ImageIcon imag;

    public Lamp() {
        lampState0 = "On";
        lampState1 = "On";
        lampState2 = "Off";
        lampState3 = "Off";
        lampState4 = "Off";
        lampState5 = "Off";
        lampState6 = "Off";
    }

    public void setLampState1(String lampState1) {
        this.lampState1 = lampState1;
    }

    public void setLampState2(String lampState2) {
        this.lampState2 = lampState2;
    }

    public void setLampState3(String lampState3) {
        this.lampState3 = lampState3;
    }

    public void setLampState4(String lampState4) {
        this.lampState4 = lampState4;
    }

    public void setLampState5(String lampState5) {
        this.lampState5 = lampState5;
    }

    public void setLampState6(String lampState6) {
        this.lampState6 = lampState6;
    }

    public void setLampState0(String lampState0) {
        this.lampState0 = lampState0;
    }

    public String getLampState1() {
        return lampState1;
    }

    public String getLampState2() {
        return lampState2;
    }

    public String getLampState3() {
        return lampState3;
    }

    public String getLampState4() {
        return lampState4;
    }

    public String getLampState5() {
        return lampState5;
    }

    public String getLampState6() {
        return lampState6;
    }

    public String getLampState0() {
        return lampState0;
    }

    public ImageIcon getImag() {
        return imag;
    }

    public ImageIcon lampState(int mapa) {
        String lamp = "";
        switch (mapa) {
            case 0:
                lamp = lampState0;
                break;
            case 1:
                lamp = lampState1;
                break;
            case 2:
                lamp = lampState2;
                break;
            case 3:
                lamp = lampState3;
                break;
            case 4:
                lamp = lampState4;
                break;
            case 5:
                lamp = lampState5;
                break;
            case 6:
                lamp = lampState6;
                break;
        }
        Image preImag = null;
        if (lamp.compareTo("On") == 0) {
            preImag = new ImageIcon(".\\src\\Imagenes\\LamparaOn.png").getImage();
        } else {
            preImag = new ImageIcon(".\\src\\Imagenes\\LamparaOff.png").getImage();
        }
        imag = new ImageIcon(preImag.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        return imag;
    }

}
