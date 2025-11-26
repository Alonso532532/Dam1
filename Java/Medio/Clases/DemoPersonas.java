package Java.Medio.Clases;

public class DemoPersonas {
    public static void main(String[] args) {
        Personas p1 = new Personas();
        Personas p2 = new Personas(80.0,40.5,50,"18461701S","Pascual");

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        p2.setPeso(2.0);
        p2.setEdad(40);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }
}
