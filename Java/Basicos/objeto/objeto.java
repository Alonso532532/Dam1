package Java.Basicos.objeto;

public class objeto {
    public static void main(String[] args) {
        // Crear un objeto de la clase Coche
        Coche miCoche = new Coche();

        // Dar valores a los atributos
        miCoche.color = "Rojo";
        miCoche.velocidad = 0;

        // Usar un metodo del objeto
        miCoche.acelerar();

        System.out.println("Color: " + miCoche.color);
        System.out.println("Velocidad: " + miCoche.velocidad);
    }
}