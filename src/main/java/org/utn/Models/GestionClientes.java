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

        System.out.print("Ingrese su fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();
        cliente.setDomicilio(fechaNacimiento);

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
        List<Cliente> listaClientes = clienteRepo.listar();
        try {
            for (Cliente c : listaClientes) {
                if (c.getId() == id) {
                    System.out.println(c);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

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
                cliente.setUsuarioActivo(false);
                //clienteRepo.eliminar(cliente);
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

    public int idUltimoCliente(){
        List<Cliente> listaClientes = clienteRepo.listar();

        if (listaClientes.isEmpty()) {
            return 0;
        }

        Cliente ultimo = listaClientes.get(listaClientes.size() -1 );
        return ultimo.getId();
    }

    // aca aparece un error pero es porque en la clase GestionPlaylistPrivada todavia no hicieron eel metodo existe de cancion
    public Cliente existeCliente(String email){
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if(cliente.email.equals(email)){
                return cliente;
            }
        }
        throw new RuntimeException("El email ingresado no existe ");

    }


    public void listarClientesPremium() {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (cliente.isPremium()) {
                System.out.println(cliente);
            }
        }
    }
    public void listarClientesFree() {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (!cliente.isPremium()) {
                System.out.println(cliente);
            }
        }
    }

    public void listarAdministradores() {
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (cliente.isAdmin()) {
                System.out.println(cliente);
            }
        }
    }

    public boolean cambiarAdministrador(){
        boolean admin = false;
        System.out.println("Ingrese el id del cliente que desea cambiar su rol a administrador");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                cliente.setAdmin(true);
                admin = true;
            }
        }
        return admin;
    }

    public Cliente buscarClienteId(int id){
        List<Cliente> listaClientes = clienteRepo.listar();
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        throw new RuntimeException("El id ingresado no existe ");
    }

    public void cambiarPlan(Cliente cliente){
        if (!cliente.isPremium()){
            cliente.setPremium(true);
            System.out.println("El cliente "+cliente.getNombre()+" ahora es premium");
        }
        else{
            cliente.setPremium(false);
            System.out.println("El cliente "+cliente.getNombre()+" ahora es free");
        }
    }


    //endregion
}
