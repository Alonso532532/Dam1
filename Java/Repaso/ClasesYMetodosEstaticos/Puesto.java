package Java.Repaso.ClasesYMetodosEstaticos;

public interface Puesto {
    default void indicarPuesto(){
        System.out.println("Trabajo en un centro educativo");
    }
}
