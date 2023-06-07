package org.utn.Models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class LogIn {
/*
    private final File archivo = new File("C:\\Users\\Milagros\\Desktop\\UTN\\2DOAÑO\\LaboyPrograIII\\Proyectofinal\\misCanciones.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Usuario> listaUsuarios;

try{
CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
this.listaUsuarios = mapper.readValue(archivo, CollectionType);
} catch (IOException e){
this.listaUsuarios = new Arraylist<>();
} finally{}

 */
    //Base para log in
    public void logIn (){
        Scanner scan = new Scanner(System.in);
        Usuario persona = new Cliente();

        System.out.println("Log In");

        System.out.println("Ingrese su nombre");
        persona.nombre = scan.next();
        System.out.println("Ingrese su Apellido");
        persona.apellido = scan.next();
        System.out.println("Ingrese su Email");
        persona.apellido = scan.next();
        System.out.println("Ingrese su fecha de nacimiento");
        persona.apellido = scan.next();
        System.out.println("Ingrese su Username"); //comprobacion con archivo json
        persona.apellido = scan.next();
        System.out.println("Ingrese su Password"); //requisitos minimos
        persona.apellido = scan.next(); //ocultarla

        //Escribir persona en archivo json

    }

}
