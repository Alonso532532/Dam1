package Java.InterfacesGraficas.Dia1;
import javax.swing.*;

public class Primero {
    public static void main(String[] args){
        //Crea y configura el frame
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        //Crea el botón
        JButton button = new JButton("Press");
        //Añade el botón al frame
        frame.getContentPane().add(button);
        //Finalmente lo muestra
        frame.setVisible(true);
    }
}
