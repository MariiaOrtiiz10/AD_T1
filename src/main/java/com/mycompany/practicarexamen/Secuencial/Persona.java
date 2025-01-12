/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicarexamen.Secuencial;

import java.io.Serializable;

/**
 *
 * @author maria
 */
public class Persona implements Serializable{
    int Id;
    String nombre;
    int edad;
    private static int cont = 1;

    public Persona(String nombre, int edad) {
        this.Id = cont++;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "Id=" + Id + ", nombre=" + nombre + ", edad=" + edad + '}';
    }
    
}
