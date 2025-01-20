package com.mycompany.practicarexamen.javaNio.Binario;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MariaMw
 */
public class JAVAnioBinario {
    public static void main(String[] args) {
        //Para crear un directorio
        Path directorio = Path.of("BinarioNIO");
        try{
            if(!Files.exists(directorio)){
              Files.createDirectory(directorio);   
            }
        }catch(IOException  e){
            e.printStackTrace();
        }
        Path fichero = Path.of("C:\\Users\\MariaMw\\ITP_DAM\\2DAM\\AccesoDatos\\PrimerTrimestre\\practicarExamen\\BinarioNIO\\ficheroBinario");
        try{
            if(!Files.exists(fichero)){
              Files.createFile(fichero);   
            }
        }catch(IOException  e){
            e.printStackTrace();
        }
        
    }
}
