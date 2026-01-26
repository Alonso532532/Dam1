package Java.Medio.Ejercicios.Tema10.Ej5;

public class Ej5 {
    public static void main(String[] args) {
        Usuario eker = new Usuario("iker", "1234Aasdada");
        System.out.println(eker.verificarContrasena("1234Aasdada"));
        eker.cambiarContrasena("asdfA2asd");
    }
}
