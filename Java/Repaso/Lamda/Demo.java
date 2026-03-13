package Java.Repaso.Lamda;

public class Demo {
    public static void main(String[] args) {
        Saludar hola =  a -> "Hola "+a;
        Operar suma = Double::sum;
        OperarCon3 muchaSuma = (a, b, c) -> a+b+c;
        System.out.println(hola.saludo("Hecproll"));
        System.out.println("Suma normal: "+suma.operacion(2,56.2));
        System.out.println("Suma triple: "+muchaSuma.operacion(5,2,6.32));


    }
}
