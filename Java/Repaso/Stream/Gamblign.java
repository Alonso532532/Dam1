package Java.Repaso.Stream;

import java.util.ArrayList;
import java.util.Arrays;

public class Gamblign {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Eker");
        Jugador j2 = new Jugador("Hecproll");
        Jugador j3 = new Jugador("Lozzan");
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(j1,j2,j3));

        while (true){
            jugadores.forEach(Jugador::tirarDado);

            if (jugadores.stream().filter(a->a.getValor()>3).count()>2){
                ArrayList<Jugador> resultado = new ArrayList<>(jugadores.stream().filter(a->a.getValor()>3).toList());
                for (Jugador i : resultado){
                    System.out.println(i.getNombre()+"-"+i.getValor());
                }
                System.out.println("Se han tirado "+resultado.getFirst().getTiradas()+" veces");
                return;
            }
        }


    }
}
