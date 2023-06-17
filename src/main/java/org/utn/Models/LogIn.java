package org.utn.Models;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class LogIn implements Serializable {

    //Base para el registro de los usuarios
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
        // 3 intentos
        //Escribir persona en archivo json

    }

}
