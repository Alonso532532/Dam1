package Java.Medio.Pruebas.Prueba2;

public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica si son el mismo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica que sean de la misma clase
        Persona persona = (Persona) obj; // Convierte el objeto a Persona
        return edad == persona.edad && nombre.equals(persona.nombre); // Compara los campos de la clase
    }
}
