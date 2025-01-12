/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicarexamen.Secuencial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javax.sound.midi.Soundbank;

/**
 *
 * @author maria
 */
public class escribirYleerSecuencialBinario {

    public static void main(String[] args) {
        File fileDirectorio = new File("Secuencial_Binario");
        if (!fileDirectorio.exists()) {
            if (fileDirectorio.mkdir()) {
                System.out.println("Directorio creado : " + fileDirectorio.getName());
            } else {
                System.out.println("Directorio ya existente : " + fileDirectorio.getName());
            }
        }
        File ficheroBinario = new File(fileDirectorio, "ficheroBinario");
        try {
            if (!ficheroBinario.exists()) {
                if (ficheroBinario.createNewFile()) {
                    System.out.println("Fichero creado: " + ficheroBinario.getName());
                } else {
                    System.out.println("Fichero ya existente");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en crear el fichero binario");
        }
        Persona persona1 = new Persona("Zule", 19);
        escribirBinario(persona1, ficheroBinario);
        leerBinario(persona1, ficheroBinario);
        System.out.println(persona1);
    }

    private static void escribirBinario(Persona persona, File file) {
        //Escribe flujos de bytes en el fichero 
        FileOutputStream fileOutputStream = null;
        try {
            //true en el append --> Para que no sobreescriba y escriba al final.
            fileOutputStream = new FileOutputStream(file, false);
        } catch (Exception ex) {
            System.out.println("Error en escribir el flujo de byte en el fichero");
        }
        //Creamos un objeto objectOutputStream para convertir el objeto en byte 
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (Exception e) {
            System.out.println("Error en convertir el objeto en byte");
        }

        //Por último para escribir el objeto en el fichero --> usamos el writeObject
        try {
            objectOutputStream.writeObject(persona);
        } catch (IOException E) {
            System.out.println("Error en escribir el obj");
        }
        try {
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException io) {
            System.err.println("No se han podido cerrar");
        }

    }

    private static void leerBinario(Persona persona, File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error en leer un fichero de byte");
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            System.out.println("Error en convertir byte en objetos");
        }
        try {
            persona = (Persona) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se ha podido leer el fichero");
        }

    }
}
