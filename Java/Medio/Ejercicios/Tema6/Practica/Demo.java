package Java.Medio.Ejercicios.Tema6.Practica;

public class Demo {
    public static void main(String[] args) {
        Animal animal = new Animal("123", 3);
        Perro perro1 = new Perro("Lozano", 9);
        PastorAleman perro2 = new PastorAleman("Lozan", 9);
        Gato gato = new Gato("321", 3);
        perro1.hacerRuido();
        perro2.hacerRuido();
        System.out.println(perro2.toString());
        gato.hacerRuido();
        System.out.println(gato);
        System.out.println(comprobarAnimal(animal));
    }

    static String comprobarAnimal(Animal animal){
        if (animal instanceof Gato){
            return "gato";
        } else if (animal instanceof PastorAleman) {
            return "pastor alemán";
        } else if (animal instanceof Perro) {
            return "perro";
        }
        throw new IllegalArgumentException("Su tipo no está definido");
    }
}
