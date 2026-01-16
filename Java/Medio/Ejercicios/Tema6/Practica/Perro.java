package Java.Medio.Ejercicios.Tema6.Practica;

public class Perro extends Animal{
    public Perro(String nombre, int edad) {
        super(nombre, edad);
        System.out.println("Se ha creado un perro");
    }

    @Override
    void hacerRuido() {
        super.hacerRuido();
        System.out.println("guau");
    }

    void darLaPata(){
        if (Math.random()*2 > 1){
            System.out.println("Te da la pata");
        } else {
            System.out.println("No te da la pata");
        }
    }
}
