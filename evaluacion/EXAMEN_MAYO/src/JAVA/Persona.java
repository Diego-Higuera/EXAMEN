package JAVA;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Persona {
    //ATRIBUTOS

    private String idPersona;
    private String nombre;
    private int edad;
    private double estatura;
    private boolean casado;
    private String sexo;
    private Direccion direccion;
    private String[] hobbies;
    
    //CONSTRUCTORES

    public Persona() {
    }

    public Persona(String idPersona, String nombre, int edad, double estatura, boolean casado, String sexo, Direccion direccion, String[] hobbies) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.casado = casado;
        this.sexo = sexo;
        this.direccion = direccion;
        this.hobbies = hobbies;
    }

    public Persona(String idPersona, String nombre, int edad, double estatura, boolean casado, String sexo, Direccion direccion) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.casado = casado;
        this.sexo = sexo;
        this.direccion = direccion;
    }
    
    
    
    // SET Y GET

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public boolean getCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }


    public String toString1() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", edad=" + edad + ", estatura=" + estatura + ", casado=" + casado + ", sexo=" + sexo + ", direccion=" + direccion + ", hobbies=" + Arrays.toString(hobbies) + '}';
    }
  
        @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", edad=" + edad + ", estatura=" + estatura + ", casado=" + casado + ", sexo=" + sexo + ", direccion=" + direccion + '}';
    }
}
