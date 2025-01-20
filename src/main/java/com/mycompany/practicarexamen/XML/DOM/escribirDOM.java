/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicarexamen.XML.DOM;

import java.nio.file.Path;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author MariaMw
 */
public class escribirDOM {
    public static void main(String[] args) {
        Path xml = Path.of("C:\\Users\\MariaMw\\ITP_DAM\\2DAM\\AccesoDatos\\PrimerTrimestre\\practicarExamen\\xml\\Alumnos.xml");
        try{
            //1. CREAR EL DOCUMETNBUILDERFACOTORY
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
            //2. CREAR EL DOCUMENT BUILDER
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //3. CREAR EL DOMIMPLEMENTATION
            DOMImplementation domImplementation = documentBuilder.getDOMImplementation();
            //4. CREAR EL DOCUMENT
            Document document = documentBuilder.newDocument();
            //5. ESCRIBIR LAS PROPIERDADES DESEADAS, ES DECIR ELEMENTOS, ATRIBUTOS Y VALORES
            /*
            <alumnos>
                <alumno id = "1">
                    <nombre>Juan</nombre>
                    <edad>20</edad>
                </alumno>
            <alumno id = "2">
                    <nombre>Ana</nombre>
                    <edad>22</edad>
                </alumno>
            </alumnos>
            */
            Element raiz = document.createElement("alumnos");
            document.appendChild(raiz);
              // Crear el primer alumno
            Element alumno1 = document.createElement("alumno");
            alumno1.setAttribute("id", "1");
            raiz.appendChild(alumno1);
            
            Element nombreAlumno1 = document.createElement("nombre");
            nombreAlumno1.appendChild(document.createTextNode("Juan"));
            alumno1.appendChild(nombreAlumno1);
            
            Element edadAlumno1 = document.createElement("edad");
            edadAlumno1.appendChild(document.createTextNode("20"));
            alumno1.appendChild(edadAlumno1);
            
            // Crear el segundo alumno
            Element alumno2 = document.createElement("alumno");
            alumno2.setAttribute("id", "2");
            raiz.appendChild(alumno2);
            
            Element nombreAlumno2 = document.createElement("nombre");
            nombreAlumno2.appendChild(document.createTextNode("Ana"));
            alumno2.appendChild(nombreAlumno2);
            
            Element edadAlumno2 = document.createElement("edad");
            edadAlumno2.appendChild(document.createTextNode("22"));
            alumno2.appendChild(edadAlumno2);
            
            //6.TRANSFORMAR EL DOM EN MEMORIA EN UN ARCHIVO DEL DISCO
            //6.1 CREAR EL TRANSFORMERFACTORY
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            //6.2 CREAR SOURCE Y RESULT
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(xml.toFile());
            //6.3 USAR LA CLASE TRANSFORM
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
