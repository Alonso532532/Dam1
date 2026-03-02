package Java.Repaso.ClasesYMetodosEstaticos;

public abstract class Estudiar {
    int hDeEstudio = 0;
    abstract void estudiar();
    void mostrarEstudio(){
        System.out.println(hDeEstudio);
    }
}
