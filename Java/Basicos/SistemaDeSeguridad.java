package Java.Basicos;

import java.io.CharConversionException;
import java.util.*;
import java.math.*;

public class SistemaDeSeguridad {
    static void main() {
        Scanner sc = new Scanner(System.in);

        boolean valido;

        // -------------------------ENTERO----------------------
        // Aquí, cuando quiero que siga el código, válido tiene que ser false, entonces donde detecte un formato no válido lo pongo en true
        System.out.println("-------------------------ENTERO----------------------");
        int nume = 0;
        do {
            valido = false;
            System.out.print("Dame un entero\n> ");
            try {

                nume = Integer.parseInt(sc.nextLine());
                if (nume <= 0){
                    System.out.println("El numero es negativo, pero está ok");
                }else if (nume == 67){
                    System.out.println("En serio?? Ahora me das otro");
                    valido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Formato erroneo");
                valido = true;
            }
        } while (valido);
        System.out.println("El numerín: " + nume);

        // -------------------------DOBLE----------------------
        // Aquí, cuando quiero que siga el código, válido tiene que ser true, funciona al contrario que arriba y normalmente es más cómodo
        System.out.println("-------------------------DOBLE----------------------");
        double numd = 0;
        valido = false;

        do {
            System.out.print("Ahora un numero decimal, si quieres claro\n> ");
            try {
                numd = Double.parseDouble(sc.nextLine());
                if (numd <= 0){
                    System.out.println("Ahora por lo que sea no quiero negativos");
                }else if (numd == 67.67) {
                    System.out.println("Otra vez??, por listo me autodestruyo 👋");

                    Thread.sleep(3000);
                    for (int i = 0; i != 910000000; i++){
                        for (int j = 0; j != 991000000; j++){
                            System.out.printf("%.100f", Math.random() * 100000);
                        }
                    }
                    return;

                }else {
                    valido = true;
                }
                // InterruptedException se pone para que no pete al esperar
            } catch (NumberFormatException | InterruptedException e){
                System.out.println("Formato erroneo");
            }
        }while (!valido);
        System.out.println("El segundo numerín: " + numd);

        // -------------------------CARÁCTER----------------------
        // En caso de no querer nuinguna excepción habría que usar un booleano
        System.out.println("-------------------------CARÁCTER----------------------");
        char letra = 'e';
        String seguridad;
        do {
            System.out.print("Carácter\n> ");
            seguridad = sc.nextLine();
            if (seguridad.length() == 1) {
                letra = seguridad.charAt(0);
                if (letra == 'e'){
                    System.out.println("La -->e<-- no vale");
                }
            } else if (seguridad.length() > 1){
                System.out.println("Es más de un carácter");
            }else {
                System.out.println("No has metido nada");
            }
        } while (letra == 'e');
        System.out.println("El carácter es: " + letra);

        // -------------------------CADENA----------------------
        System.out.println("-------------------------CADENA----------------------");
        String cad = "";
        do {
            System.out.print("Ahora dame un texto\n> ");
            cad =  sc.nextLine();
            if (cad.length() == 0){
                System.out.println("La cadena está vacía");
            }
        }while (cad.length() == 0);
        System.out.println("La cadena es: " + cad);


    }
}
