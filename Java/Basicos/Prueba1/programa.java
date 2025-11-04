package Java.Basicos.Prueba1;
import java.util.*;

public class programa {
    //Esta función imprime la tabla con la pelota, primero descarto la primera y la ultima fila y luego pares e impares
    public static void impTabla(String[][] tabl){
        int c = 0;
        for (int i = 0; i <= 10; i++) {
            int b = -1;
            for (int j = 0; j <= 20; j++) {
                //Primera fila
                if (i == 0){
                    if (j == 0){
                        System.out.print("\n╔");
                    } else if (j == 20){
                        System.out.print("╗");
                    } else if (j%2 == 0){
                        System.out.print("╦");
                    } else {
                        for (int a = 0; a < 3; a++){
                            System.out.print("═");
                        }
                    }
                    //Ultima fila
                } else if (i == 10){
                    if (j == 0){
                        System.out.print("╚");
                    } else if (j == 20){
                        System.out.print("╝");
                    } else if (j%2 == 0){
                        System.out.print("╩");
                    } else {
                        for (int a = 0; a < 3; a++){
                            System.out.print("═");
                        }
                    }
                    //Pares
                } else if (i%2 == 0) {
                    if (j == 0){
                        System.out.print("╠");
                        c++;
                    } else if (j == 20){
                        System.out.print("╣");
                    } else if (j%2 == 0){
                        System.out.print("╬");
                    } else {
                        for (int a = 0; a < 3; a++){
                            System.out.print("═");
                        }
                    }
                    //Impares
                } else {
                    if (j%2 == 0){
                        System.out.print("║");
                    } else {
                        b++;
                        System.out.print(" " + tabl[c][b] + " ");
                    }
                }
            }
            if (i != 10) {
                System.out.println();
            }
        }
    }

    static void main() throws InterruptedException {
        pelota bola = new pelota();
        Scanner sc = new Scanner(System.in);
        String[][] tabla = {{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "}};
        String op;
        int cont = 0, pos = 0, tiempo;
        Double vel = 0.0;
        boolean valido = false;

        //Aquí imprimo la tabla con las posiciones, primero descarto la primera y la ultima fila y luego pares e impares
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 20; j++) {
                if (i == 0){
                    //Primera fila
                    if (j == 0){
                        System.out.print("╔");
                    } else if (j == 20){
                        System.out.print("╗");
                    } else if (j%2 == 0){
                        System.out.print("╦");
                    } else {
                        for (int a = 0; a < 3; a++){
                            System.out.print("═");
                        }
                    }
                    //Ultima fila
                } else if (i == 10){
                    if (j == 0){
                        System.out.print("╚");
                    } else if (j == 20){
                        System.out.print("╝");
                    } else if (j%2 == 0){
                        System.out.print("╩");
                    } else {
                        for (int a = 0; a < 3; a++){
                            System.out.print("═");
                        }
                    }
                    //Filas pares
                } else if (i%2 == 0) {
                    if (j == 0){
                        System.out.print("╠");
                    } else if (j == 20){
                        System.out.print("╣");
                    } else if (j%2 == 0){
                        System.out.print("╬");
                    } else {
                        for (int a = 0; a < 3; a++){
                            System.out.print("═");
                        }
                    }
                    //Filas impares
                } else {
                    if (j%2 == 0){
                        System.out.print("║");
                    } else {
                        cont++;
                        if (cont < 10) {
                            System.out.print(cont + "  ");
                        } else {
                            System.out.print(cont + " ");
                        }
                    }
                }
            }
            System.out.println();
        }

        //Pido los valores posición y dirección
        do {
            System.out.print("¿En que posición quieres que empiece la pelota?\n> ");
            try {
                pos = Integer.parseInt(sc.nextLine());
                if (pos > 50){
                    System.out.println("Te has pasado");
                } else if (pos <= 0){
                    System.out.println("Posición incorrecta");
                } else {valido = true;}
            } catch (NumberFormatException e){
                System.out.println("Formato invalido");
            }
        } while (!valido);

        //Calculo la posición en el array
        bola.posicionx = (pos-1) % 10 ;
        bola.posiciony = (pos-1) / 10;
        tabla[bola.posiciony][bola.posicionx] = "O";
        impTabla(tabla);

        //Determino hacia donde se va a mover la bola
        do {
            System.out.print("\n----------------------------\n¿Hacia donde quieres que se mueva la pelota?\n----------------------------\nArriba derecha\nArriba izquierda\nAbajo derecha\nAbajo izquierda\n----------------------------\n> ");
            op =  sc.nextLine();
            if (!op.equals("arriba derecha") && !op.equals("abajo derecha") && !op.equals("arriba izquierda") && !op.equals("abajo izquierda") && !op.equals("Arriba derecha") && !op.equals("Abajo derecha") && !op.equals("Arriba izquierda") && !op.equals("Abajo izquierda")){
                System.out.println("Dirección invalida");
            }
        }while (!op.equals("arriba derecha") && !op.equals("abajo derecha") && !op.equals("arriba izquierda") && !op.equals("abajo izquierda") && !op.equals("Arriba derecha") && !op.equals("Abajo derecha") && !op.equals("Arriba izquierda") && !op.equals("Abajo izquierda"));
        switch (op){
            case "arriba derecha", "Arriba derecha":
                bola.velocidad[0] = 1;
                bola.velocidad[1] = -1;
                break;
            case "arriba izquierda", "Arriba izquierda":
                bola.velocidad[0] = -1;
                bola.velocidad[1] = -1;
                break;

            case "abajo derecha", "Abajo derecha":
                bola.velocidad[0] = 1;
                bola.velocidad[1] = 1;
                break;
            case "abajo izquierda", "Abajo izquierda":
                bola.velocidad[0] = -1;
                bola.velocidad[1] = 1;
                break;
        }

        //Con que velocidad...
        valido = false;
        do {
            System.out.print("¿Con que velocidad quieres que se mueva? (5-Recomendado)\n> ");
            try {
                vel = Double.parseDouble(sc.nextLine());
                if (vel < 0){
                    System.out.println("Velocidad incorrecta");
                } else {valido = true;}
            } catch (NumberFormatException e){
                System.out.println("Formato invalido");
            }
        } while (!valido);
        System.out.println(vel);
        tiempo = (int) (3000 / vel);
        while (true){
            System.out.println("\n\n\n\n\n\n\n");
            impTabla(tabla);
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 10; j++){
                    if (tabla[i][j] == "."){
                        tabla[i][j] = " ";
                    }
                    if (tabla[i][j] == "o"){
                        tabla[i][j] = ".";
                    }

                }
            }
            tabla[bola.posiciony][bola.posicionx] = "o";
            bola.velocidad = bola.compVel(bola.posicionx, bola.posiciony, bola.velocidad);
            bola.posicionx = bola.moverx(bola.posicionx, bola.velocidad);
            bola.posiciony = bola.movery(bola.posiciony, bola.velocidad);
            tabla[bola.posiciony][bola.posicionx] = "O";
            Thread.sleep(tiempo);

        }
    }
}
