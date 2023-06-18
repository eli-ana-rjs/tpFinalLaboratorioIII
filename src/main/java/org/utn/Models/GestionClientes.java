package org.utn.Models;

import org.utn.Repositorios.ClienteRepo;

import java.util.List;
import java.util.Scanner;

public class GestionClientes {
    private ClienteRepo clienteRepo = new ClienteRepo();

    //region metodos

    // pedir datos de un cliente
    public Cliente pedirDatosCliente() {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        TipoDePlan tipoPlan;
        Genero genero;
        int opcion;

        System.out.println("Ingrese los datos del nuevo cliente:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        System.out.print("Email: ");
        String email = scanner.nextLine();
        cliente.setEmail(email);

        System.out.print("Fecha de Nacimiento (dd-MM-yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        cliente.setFechaNacimiento(fechaNacimiento);

        System.out.print("Nombre de Usuario: ");
        String nombreUsuario = scanner.nextLine();
        cliente.setUserName(nombreUsuario);

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        cliente.setPassword(password);

        System.out.print("Género: FEMENINO, MASCULINO, NO_BINARIO, OTRO;  ");
        String generoStr = scanner.nextLine();

        try {
            genero = (Genero.valueOf(generoStr.toUpperCase()));
            cliente.setGenero(genero);

        } catch (IllegalArgumentException e) {
            System.out.println("Genero incorrecto");
        }

        System.out.print("Domicilio: ");
        String domicilio = scanner.nextLine();
        cliente.setDomicilio(domicilio);

        System.out.print("¿Es premium? (true/false): ");
        boolean isPremium = scanner.nextBoolean();
        cliente.setPremium(isPremium);


        try {
            if (cliente.isPremium()) {

                System.out.println("Tipo de Plan ---> 1.INDIVIDUAL, 2.DUO, 3. FAMILIAR : ");

                do {
                    System.out.print("Ingrese el número de opción: ");
                    opcion = scanner.nextInt();

                    if ((opcion < 1 || opcion > 3)) {
                        System.out.println("Opción inválida. Intente nuevamente.");
                    }
                } while (opcion < 1 || opcion > 3);

                switch (opcion) {
                    case 1:
                        tipoPlan = TipoDePlan.DUO;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                    case 2:
                        tipoPlan = TipoDePlan.INDIVIDUAL;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                    case 3:
                        tipoPlan = TipoDePlan.FAMILIAR;
                        cliente.setTipoDePlan(tipoPlan);
                        break;
                }
            } else {

                tipoPlan = TipoDePlan.GRATIS;
                cliente.setTipoDePlan(tipoPlan);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de plan incorrecto");
        }

        return cliente;

    }

    // AGREGAR CLIENTE AL JSON

    //agregar cliente
    public void agregarCliente(Cliente cliente) {
        List<Cliente> listaClientes = clienteRepo.listar();
        try {
            for (Cliente c : listaClientes) {
                if (c.getId() == cliente.getId()) {
                    throw new IllegalArgumentException("El id del cliente ya existe");
                }
            }
            listaClientes.add(cliente);
            System.out.println("Cliente agregado exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        clienteRepo.guardar();
    }

    // mostrar un cliente por id
    public void mostrarClientePorId(int id) {

    }

// listar clientes
    public void listarClientes() {
        clienteRepo.listar().forEach(System.out::println);
    }

    // mostrar todos los clientes
    public void mostrarClientes(){
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    public void eliminarCliente(Cliente cliente) {
        try{
            if (cliente.getId() == 0){
                throw new IllegalArgumentException("El id del cliente no puede ser cero 0");
            }
            else{
                clienteRepo.eliminar(cliente);
                System.out.println("Cliente"+ cliente.getNombre()+"eliminado exitosamente");
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarCliente(Cliente cliente) {
        try{
            if (cliente.getId() == 0){
                throw new IllegalArgumentException("El id del cliente no puede ser cero 0");
            }
            else{
                clienteRepo.modificar(cliente);
                System.out.println("Cliente"+ cliente.getNombre()+"modificado exitosamente");
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }


    //endregion
}
