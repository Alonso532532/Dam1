package Java.Repaso.Stream;

import java.util.ArrayList;
import java.util.Arrays;

public class Dados {
    public static void main(String[] args) {
        ArrayList<Jugador> partida = new ArrayList<>(Arrays.asList(new Jugador("Hecproll"), new Jugador("Eker"), new Jugador("Alons")));
        partida.forEach(Jugador::tirarDado);
        partida.forEach(System.out::println);
        System.out.println("<||========================================||>");

        if (partida.stream().filter(a -> a.getValor()==partida.stream().mapToInt(Jugador::getValor).max().getAsInt()).count()>1){

            System.out.println("Los puntajes más altos ("+partida.stream().mapToInt(Jugador::getValor).max().getAsInt()+") los tienen:");
            partida.stream().filter(a->a.getValor()==partida.stream().mapToInt(Jugador::getValor).max().getAsInt()).map(Jugador::getNombre).forEach(System.out::println);

        }else {

            System.out.print("El puntaje más alto lo tiene: ");
            partida.stream().filter(a->a.getValor()==partida.stream().mapToInt(Jugador::getValor).max().getAsInt()).map(Jugador::getNombre).forEach(System.out::print);
            System.out.println(" con un "+partida.stream().mapToInt(Jugador::getValor).max().getAsInt());

        }



    }
}
