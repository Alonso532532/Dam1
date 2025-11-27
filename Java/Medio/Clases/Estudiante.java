package Java.Medio.Clases;

public class Estudiante extends Personas{
    private Integer numExpediente;
    private Integer faltas;
    private Integer examenes;

    public Estudiante(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Estudiante(Double peso, Double altura, Integer edad, String dni, String nombre, Integer numExpediente, Integer faltas, Integer examenes) {
        super(peso, altura, edad, dni, nombre);
        this.numExpediente = numExpediente;
        this.faltas = faltas;
        this.examenes = examenes;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public Integer getExamenes() {
        return examenes;
    }

    public void setExamenes(Integer examenes) {
        this.examenes = examenes;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    @Override
    public String toString() {
        return super.toString() + "Estudiante{" +
                "numExpediente=" + numExpediente +
                ", faltas=" + faltas +
                ", examenes=" + examenes +
                '}';
    }

    @Override
    public String info() {
        return super.info() + " numExp: " + numExpediente;
    }
}

