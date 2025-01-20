/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicarexamen.javaIO.claseFile;

import java.io.File;

/**
 *
 * @author maria
 */
public class ClaseFile {
    public static void main(String[] args) {
            //Primera forma File: Carpeta de directorio raíz
            File directorio = new File("Carpeta1");
            //Segunda forma File: 
            File carpetaFicherosPlanos = new File("C:\\Users\\maria\\ITP\\DAM\\AccesoDatos\\TEMA1\\practicarExamen\\Carpeta1","CarpetaFicherosPlanos");
            //tercera forma
            File carpeteaFicherosBinarios = new File(directorio,"carpetaFicherosBinarios");
            
            //CREAR CARPETA en directorio raíz
            if(!directorio.exists()){
                if(directorio.mkdir()){
                    System.out.println("Directorio carpeta1 creado con éxito");
                }else{
                    System.out.println("El directorio carpeta1 ya existe");
                }
            }
            //CREAR CARPETA para los ficheros planos DENTRO DE Carpeta1
            if(!carpetaFicherosPlanos.exists()){
                if(carpetaFicherosPlanos.mkdirs()){
                    System.out.println("Carpeta de los ficheros planos creado con éxito");
                }else{
                    System.out.println("La carpeta de los ficheros planos ya existe");
                }
            }
            //CREAR CARPETA para los ficheros binarios DENTRO DE Carpeta1
             if(!carpeteaFicherosBinarios.exists()){
                if(carpeteaFicherosBinarios.mkdirs()){
                    System.out.println("Carpeta de los ficheros binarios creado con éxito");
                }else{
                    System.out.println("La carpeta de los ficheros binarios ya existe");
                }
            }
            File ficheroPlano = new File(carpetaFicherosPlanos, "ficheroPlano.txt");
            try{
                ficheroPlano.createNewFile();
            }catch(Exception e){
                System.out.println("Error en crear el fichero plano");
            }
            File ficheroBinario = new File(carpeteaFicherosBinarios, "ficheroBinario");
            try{
                ficheroBinario.createNewFile();
            }catch(Exception e){
                System.out.println("Error en crear el fichero Binario");
            }
            //LISTADO DE LOS FICHEROS Y DIRECTORIOS
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Listado de los directorios, dentro de carpeta");
                String [] list = directorio.list();
                if(list != null){
                    for(String lista: list){
                        System.out.println(lista);
                    }
            }
            System.out.println("--------------------------------------------------------------------------------"); 
             System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Listado de los directorios, dentro de carpeta");
                File [] list2 = directorio.listFiles();
                if(list2 != null){
                    for(File lista2: list2){
                        System.out.println(lista2);
                    }
            }
            System.out.println("--------------------------------------------------------------------------------"); 
            System.out.println("--------------------------------------------------------------------------------"); 
            System.out.println("RUTAS DEL DIRECTORIO CARPETA1 y Carpeta Padre");
             System.out.println("Ruta relativa: " + directorio.getPath());
            System.out.println("Ruta absoluta: " + directorio.getAbsolutePath());
            System.out.println("Directorio padre de: "+ficheroPlano.getName()+" es "+ficheroPlano.getParent());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------");
             System.out.println("Se puede leer y escribir");
             System.out.println("Leer: "+ ficheroPlano.canRead());
             System.out.println("Escribir: "+ ficheroPlano.canWrite());
              System.out.println("--------------------------------------------------------------------------------");
            
    }
}
