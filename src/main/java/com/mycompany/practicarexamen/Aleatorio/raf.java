/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicarexamen.Aleatorio;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author maria
 */
public class raf {
    public static void main(String[] args) {
        File directorioAleatorio = new File("AccesoAleatorio");
        if(!directorioAleatorio.exists()){
            if(directorioAleatorio.mkdir()){
                System.out.println("Directorio creado con éxito");
            }else{
                System.out.println("Error al crear el directorio");
            }
        }else{
            System.out.println("Ya existe el dorectorio");
        }
        File ficheroAleatorio = new File(directorioAleatorio,"ficheroAleatorio.txt");
        try{
            if(!ficheroAleatorio.exists()){
                if(ficheroAleatorio.createNewFile()){
                    System.out.println("Fichero creado con éxito");
                }else{
                    System.out.println("Error en crear el archivo");
                }
            }else{
                System.out.println("Ya existe el fichero");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        RandomAccessFile raf= null;
        try{
            raf = new RandomAccessFile(ficheroAleatorio, "rw");
            //Para saber en que posición está.
            System.out.println("Posición: "+raf.getFilePointer());
            //Para escribir
            raf.writeBytes("Hola mundo"+ System.lineSeparator());
            System.out.println("Posición: "+raf.getFilePointer());
            raf.writeBytes("ID:2 Nombre: Maria"+ System.lineSeparator());
            System.out.println("Posición: "+raf.getFilePointer());   
            raf.seek(0);
            String linea;
            while((linea=raf.readLine()) != null){
                System.out.println(linea);
            }
            //Para escribir desde la posición 12, es decir destres de hola mundo.
            raf.seek(12);
            raf.writeBytes("ID:1 Nombre: Andrés"+ System.lineSeparator());
            System.out.println("Posición: "+raf.getFilePointer()); 
            raf.writeBytes("ID:2 Nombre: Maria"+ System.lineSeparator());
            System.out.println("Posición: "+raf.getFilePointer()); 
            // Para leer desde la posición 0
            raf.seek(0);
            while((linea=raf.readLine()) != null){
                System.out.println(linea);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
