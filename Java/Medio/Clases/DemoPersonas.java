package Java.Medio.Clases;

public class DemoPersonas {
    public static void main(String[] args) {
        Personas p1 = new Personas();
        Personas p2 = new Personas(80.0,40.5,50,"18461701S","Pascual");

        //Al meterlo en un sout buscará el metodo toString
        System.out.println(p1);
        System.out.println(p2);

        //apuntará al mismo sitio en memoria entonces se modificarán a la véz
        p1 = p2;

        p2.setPeso(2.0);
        p2.setEdad(40);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("---------------------");

        Estudiante e1 = new Estudiante(3.3,2.2,3,"18263242S","tete",3232323,8,2);
        Profesor pr1 = new Profesor(70.0,23.7,40,"542434T","Juanma",2.3,true);

        System.out.println(e1);;
        System.out.println(pr1);
    }
}
