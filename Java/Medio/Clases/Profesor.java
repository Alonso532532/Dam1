package Java.Medio.Clases;

public class Profesor extends Personas {
    private Double salario;
    private Boolean esCabron;

    public Profesor(Double salario) {
        this.salario = salario;
    }

    public Profesor(Double peso, Double altura, Integer edad, String dni, String nombre, Double salario, Boolean esCabron) {
        super(peso, altura, edad, dni, nombre);
        this.salario = salario;
        this.esCabron = esCabron;
    }

    public Double getSalario() {
        return salario;
    }

    public Boolean getEsCabron() {
        return esCabron;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setEsCabron(Boolean esCabron) {
        this.esCabron = esCabron;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesor{salario=" + salario + ", esCabron=" + esCabron + "}";
    }

    @Override
    public String info() {
        return super.info() + " esCabron: " + esCabron;
    }
}
