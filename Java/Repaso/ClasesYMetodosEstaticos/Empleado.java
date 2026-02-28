package Java.Repaso.ClasesYMetodosEstaticos;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Empleado extends Persona implements Puesto {
    private String NUSS;
    private double salario;
    private LocalDate fechaDeContratacion;

    public Empleado(String dni, String nombre, int edad, String NUSS, double salario, LocalDate fechaDeContratacion) {
        super(dni, nombre, edad);
        this.NUSS = NUSS;
        this.salario = salario;
        this.fechaDeContratacion = fechaDeContratacion;
    }

    public Empleado() {
    }

    public String getNUSS() {
        return NUSS;
    }

    public void setNUSS(String NUSS) {
        this.NUSS = NUSS;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaDeContratacion() {
        return fechaDeContratacion;
    }

    public void setFechaDeContratacion(LocalDate fechaDeContratacion) {
        this.fechaDeContratacion = fechaDeContratacion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "NUSS='" + NUSS + '\'' +
                ", salario=" + salario +
                ", fechaDeContratacion=" + fechaDeContratacion +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", antiguedad=" + antiguedad() +" años"+
                '}';
    }

    long antiguedad(){
        return ChronoUnit.YEARS.between(fechaDeContratacion, LocalDate.now());
    }
}
