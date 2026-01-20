package Java.Medio.Practica.Cosas;

public class Padre {
    String hola = "hola pascual";
    public void saludar(){
        System.out.println(hola+"2");
    }

    interface saludos{
        void hola(String saludo);
        void adios(String saludo);
    }
}
