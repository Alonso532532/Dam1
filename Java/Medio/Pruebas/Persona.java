package Java.Medio.Pruebas;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
    }

    public static void main(String[] args) throws Exception {
// Crear una instancia de la clase Persona
        Persona persona = new Persona("Juan");

// Obtener el tipo de la clase Persona en tiempo de ejecución
        Class<?> tipo = persona.getClass();

// Invocar el método mostrarInfo mediante reflexión
        Method metodo = tipo.getMethod("mostrarInfo");
        metodo.invoke(persona);

// Obtener y mostrar los campos
        Field campo = tipo.getDeclaredField("nombre");
        campo.setAccessible(true); // Hacer el campo accesible
        System.out.println("Campo Nombre: " + campo.get(persona));
    }
}