package com.mycompany.practicarexamen.javaIO.Secuencial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class escribiryleerSecuencialPlano {
    public static void main(String[] args) {
        // Crear directorio
        File directorio = new File("Secuencial_Plano");
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Directorio creado con éxito");
            } else {
                System.out.println("No se pudo crear el directorio");
            }
        }

        // Crear fichero plano
        File ficheroPlano = new File(directorio, "ficheroPlano.txt");
        if (!ficheroPlano.exists()) {
            try {
                if (ficheroPlano.createNewFile()) {
                    System.out.println("Fichero creado: " + ficheroPlano.getName());
                } else {
                    System.out.println("El fichero ya existe");
                }
            } catch (IOException ex) {
                System.out.println("Error al crear el fichero");
            }
        }

        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Escribir en fichero");
            System.out.println("2. Leer desde fichero");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opc) {
                case 1:
                    System.out.print("Ingrese el texto a escribir: ");
                    String cadena = sc.nextLine();
                    escribirPlano(ficheroPlano, cadena);
                    break;
                case 2:
                    leerPlano(ficheroPlano);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opc != 3);

        sc.close();
    }

    private static void escribirPlano(File file, String cadena) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(cadena + "\n");
            System.out.println("Texto escrito correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        }
    }

    private static void leerPlano(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            int lector;
            while ((lector = fileReader.read()) != -1) {
                System.out.print((char) lector);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException io) {
            System.out.println("Error al leer el fichero");
        }
    }
}
