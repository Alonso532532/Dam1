package Java.Repaso.ClasesYMetodosEstaticos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Profesor eker = new Profesor("123123S", "Iker", 12, "31344131313", 200, LocalDate.parse("2003-02-21"), "2SMR");
        Estudiante alon = new Estudiante("3123123S", "Alons", 20, "3");
        Estudiante pasc = new Estudiante("3123123S", "Pascuals", 20, "3");
        System.out.println(eker);
        eker.indicarPuesto();
        Centro centro = new Centro(new ArrayList<>(Arrays.asList(eker, alon, pasc)));
        System.out.println(centro.empMasAntiguo().nombre);
        System.out.println(centro.sacarEstudiantes().size());
    }
}
