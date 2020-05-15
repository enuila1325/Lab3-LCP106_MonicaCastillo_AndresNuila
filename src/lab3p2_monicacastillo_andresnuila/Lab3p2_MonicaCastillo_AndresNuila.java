/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p2_monicacastillo_andresnuila;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author enuil
 */
public class Lab3p2_MonicaCastillo_AndresNuila {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Integer> IDs = new ArrayList();
    static ArrayList<String> usernames = new ArrayList();
    static ArrayList<String> contraseñas = new ArrayList();
    static ArrayList<Local> locales = new ArrayList();
    static ArrayList<Persona> personas = new ArrayList();
    static ArrayList<Producto> productos = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        char resp = 's';
        while (resp == 's' || resp == 'S') {
            System.out.println("***MENU***");
            System.out.println("1) Log In");
            System.out.println("2) Sign In");
            System.out.println("3) Salida");
            System.out.print("Ingrese la opcion deseada: ");
            int opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Es usted un administrador o un cliente?");
                    System.out.println("1) Administrador");
                    System.out.println("2) Cliente");
                    System.out.print("Ingrese la opcion deseada: ");
                    int opcion1 = entrada.nextInt();
                    switch (opcion1) {
                        case 1:
                            System.out.print("Ingrese su username: ");
                            String user = entrada.next();
                            while (user.equals("SUDO")) {
                                System.out.println("¡Su username no es valido!");
                                System.out.print("Ingrese su username: ");
                                user = entrada.next();
                            } // Fin While Validacion
                            System.out.println("¡Bienvenido Administrador!");
                            System.out.println("¿Que desea hacer el dia de hoy?");
                            System.out.println("1) Agregar Elemento");
                            System.out.println("2) Modificar Elemento");
                            System.out.println("3) Eliminar Elemento");
                            System.out.println("4) Listar Elemento");
                            System.out.print("Ingrese la opcion deseada: ");
                            int opcion3 = entrada.nextInt();
                            switch (opcion3) {
                                case 1:
                                    System.out.println("¿Que desea agregar?");
                                    System.out.println("1) Agregar Local");
                                    System.out.println("2) Agregar Producto");
                                    System.out.println("3) Agregar Empleado");
                                    System.out.print("Ingrese la opcion deseada: ");
                                    int opcion2 = entrada.nextInt();
                                    switch (opcion2) {
                                        case 1:
                                            System.out.println("Ingrese el nombre del local");
                                            String local = entrada.next();
                                            System.out.println("--------------------------");
                                            String cadena = "";
                                            for (int i = 0; i < 10; i++) {
                                                if (personas.get(i) instanceof Empleado) {
                                                    cadena += "[" + i + "]" + personas.get(i);
                                                }
                                                cadena += "\n";
                                            }
                                            System.out.println("--------------------------");
                                            System.out.println("Ingrese el indice del empleado que sera gerente");
                                            int ind = entrada.nextInt();
                                            Persona gerente = personas.get(ind);
                                            System.out.println("Ingrese el tipo de local que sera");
                                            System.out.println("1. Tienda \n2. Quiosco \n3. Bar");
                                            int tipoLocal = entrada.nextInt();
                                            while (tipoLocal < 1 || tipoLocal > 3) {
                                                System.out.println("ingrese una entrada valida");
                                                tipoLocal = entrada.nextInt();
                                            }
                                            switch (tipoLocal) {
                                                case 1:
                                                    //llamar a constructor Tienda
                                                    Tienda t = new Tienda();
                                                    locales.add(t);
                                                    break;
                                                case 2:
                                                    Quiosco q = new Quiosco();
                                                    locales.add(q);
                                                    break;
                                                case 3:
                                                    Bar b = new Bar();
                                                    locales.add(b);
                                                    break;
                                                case 4:
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            System.out.print("Ingrese su ID: ");
                                            int ID = entrada.nextInt();
                                            while (IDs(ID) == true) {
                                                System.out.println("¡El ID ingresado ya se encuentra registrado!");
                                                System.out.print("Ingrese su ID: ");
                                                ID = entrada.nextInt();
                                            } // Fin While
                                            System.out.print("Ingrese su username: ");
                                            String username = entrada.next();
                                            while (Usernames(username) == true) {
                                                System.out.println("¡El username ingresado ya se encuentra registrado!");
                                                System.out.print("Ingrese su username: ");
                                                username = entrada.next();
                                            } // Fin While
                                            System.out.print("Ingrese su contraseña: ");
                                            String contraseña = entrada.next();
                                            System.out.println("Ingrese su correo electronico: ");
                                            String correo = entrada.next();
                                            System.out.println("Ingrese su nombre completo: ");
                                            String nombre = entrada.nextLine();
                                            System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
                                            String fecha = entrada.next();
                                            System.out.println("Empleado agregado exitosamente");
                                            Empleado e = new Empleado();
                                            personas.add(e);
                                            break;
                                        case 3:
                                            System.out.println("Ingrese el nombre del articulo");
                                            String producto = entrada.next();
                                            entrada = new Scanner(System.in);
                                            System.out.println("ingrese el precio");
                                            double precio = entrada.nextDouble();
                                            entrada = new Scanner(System.in);
                                            System.out.println("Ingrese una breve descripcion del articulo");
                                            String descripcion = entrada.nextLine();
                                            entrada.nextLine();
                                            entrada = new Scanner(System.in);
                                            System.out.println("ingrese el tipo de producto");
                                            System.out.println("1. Ropa");
                                            System.out.println("2. Juguete");
                                            System.out.println("3. comida");
                                            System.out.println("Seleccione una opcion");
                                            int aux = entrada.nextInt();
                                            switch (aux) {
                                                case 1:
                                                    System.out.println("Ingrese la talla");
                                                    System.out.println("1. S \n2. M \n3. L");
                                                    int t = entrada.nextInt();
                                                    while (t < 1 || t > 3) {
                                                        System.out.println("Ingrese una entrada valida");
                                                        t = entrada.nextInt();
                                                    }
                                                    String talla,
                                                     genero;
                                                    switch (t) {
                                                        case 1:
                                                            talla = "S";
                                                        case 2:
                                                            talla = "M";
                                                        case 3:
                                                            talla = "L";
                                                        default:
                                                            break;
                                                    }
                                                    System.out.println("Ingrese el sexo");
                                                    System.out.println("1. Masculino \n2. Femenino");
                                                    int g = entrada.nextInt();
                                                    while (g < 1 || g > 2) {
                                                        System.out.println("Ingrese una entrada valida");
                                                        g = entrada.nextInt();
                                                    }
                                                    switch (t) {
                                                        case 1:
                                                            genero = "Masculino";
                                                        case 2:
                                                            genero = "Femenino";
                                                        default:
                                                            break;
                                                    }
                                                    //llamar metodo constructor ropa
                                                    Ropa r = new Ropa();
                                                    productos.add(r);
                                                    break;
                                                case 2:
                                                    //Llamar metodo construcor de juguete
                                                    Juguete j = new Juguete();
                                                    productos.add(j);
                                                    break;
                                                case 3:
                                                    System.out.println("Ingrese si es comida o bebida");
                                                    System.out.println("1. bebida 2. Comida");
                                                    int ti = entrada.nextInt();
                                                    switch (ti) {
                                                        case 1:
                                                            String tipo = "Bebida";
                                                            break;
                                                        case 2:
                                                            tipo = "Comida";
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                    SimpleDateFormat n = new SimpleDateFormat("dd/MM/yyyy");
                                                    System.out.println("Ingrese la fecha de caducidad dd/MM/yyyy");
                                                    String fecha2 = entrada.next();
                                                    Date d = n.parse(fecha2);//aqui parsear con simple date format
                                                    //Llamar metodo constructor Comida
                                                    Comida c = new Comida();
                                                    productos.add(c);
                                                    break;
                                                default:
                                                    break;
                                            }
                                            break;
                                        default:
                                            System.out.println("¡Entrada no valida!");
                                    } // Fin Switch Agregar
                                    break;
                                case 2:
                                    System.out.println("¿Que desea modificar?");
                                    System.out.println("1) Modificar Local");
                                    System.out.println("2) Modificar Producto");
                                    System.out.println("3) Modificar Persona");
                                    System.out.print("Ingrese la opcion deseada: ");
                                    int opcion4 = entrada.nextInt();
                                    switch (opcion4) {
                                        case 1:
                                            System.out.println("Locales: ");
                                            for (Object o : locales) {
                                                System.out.println(locales.indexOf(o) + " = " + o);
                                            } // Fin For
                                            System.out.print("Ingrese el local que desea modificar: ");
                                            int pos = entrada.nextInt();
                                            System.out.print("¿Que atributo desea modificar?");
                                            System.out.println("1) Nombre");
                                            System.out.println("2) Empleado");
                                            System.out.println("3) Producto");
                                            System.out.println("4) Gerente");
                                            System.out.print("Ingrese la opcion deseada: ");
                                            int op2 = entrada.nextInt();
                                            switch (op2) {
                                                case 1:
                                                    System.out.print("Ingrese el nuevo nombre: ");
                                                    String nombre2 = entrada.nextLine();
                                                    locales.get(pos).setNombre(nombre2);
                                                    break;
                                                case 2:
                                                    System.out.println("Empleados");
                                                    System.out.println(locales.get(pos).getEmpleados());
                                                    System.out.print("Ingrese la posicion del empleado que desea modificar: ");
                                                    int pose = entrada.nextInt();
                                                    System.out.print("¿Que atributo desea modificar?");
                                                    System.out.println("1) ID");
                                                    System.out.println("2) Username");
                                                    System.out.println("3) Contraseña");
                                                    System.out.println("4) Correo Electronico");
                                                    System.out.println("5) Nombre");
                                                    System.out.println("6) Fecha de Nacimiento");
                                                    System.out.println("7) Horario de trabajo");
                                                    System.out.print("Ingrese la opcion deseada: ");
                                                    int op3 = entrada.nextInt();
                                                    switch (op3) {
                                                        case 1:
                                                            IDs.remove(pose);
                                                            System.out.print("Ingrese el nuevo ID: ");
                                                            int ID = entrada.nextInt();
                                                            while (IDs(ID) == true) {
                                                                System.out.println("¡El ID ingresado ya se encuentra registrado!");
                                                                System.out.print("Ingrese su ID: ");
                                                                ID = entrada.nextInt();
                                                            } // Fin While
                                                            ((Empleado) personas.get(pose)).setID(ID);
                                                            IDs.add(ID);
                                                            break;
                                                        case 2:
                                                            usernames.remove(pose);
                                                            System.out.print("Ingrese su username: ");
                                                            String username = entrada.next();
                                                            while (Usernames(username) == true) {
                                                                System.out.println("¡El username ingresado ya se encuentra registrado!");
                                                                System.out.print("Ingrese su username: ");
                                                                username = entrada.next();
                                                            } // Fin While
                                                            ((Empleado) personas.get(pose)).setUsername(username);
                                                            usernames.add(username);
                                                            break;
                                                        case 3:
                                                            System.out.print("Ingrese la nueva contraseña: ");
                                                            String contraseña = entrada.next();
                                                            ((Empleado) personas.get(pose)).setContraseña(contraseña);
                                                            break;
                                                        case 4:
                                                            System.out.print("Ingrese su nuevo correo electronico: ");
                                                            String correo = entrada.next();
                                                            ((Empleado) personas.get(pose)).setContraseña(correo);
                                                            break;
                                                        case 5:
                                                            System.out.print("Ingrese el nuevo nombre: ");
                                                            String nombre = entrada.next();
                                                            ((Empleado) personas.get(pose)).setNombre(nombre);
                                                            break;
                                                        case 6:
                                                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                                            System.out.println("Ingrese la nueva fecha de nacimiento");
                                                            String nacimiento = entrada.next();
                                                            ((Empleado) personas.get(pose)).setNacimiento(sdf.parse(nacimiento));
                                                        case 7:
                                                            System.out.print("Ingrese el nuevo horario de trabajo");
                                                            String horario = entrada.nextLine();
                                                            ((Empleado) personas.get(pose)).setHorario(horario);
                                                        default:
                                                            System.out.println("¡Entrada no valida!");
                                                    } // Fin Switch Modificar Empleado Tienda
                                                    break;
                                                case 3:
                                                    break;
                                                case 4:
                                                    break;
                                                default:
                                                    System.out.println("¡Entrada no valida!");
                                            } // Fin Switch Tienda
                                            break;
                                        case 2:
                                            System.out.println("Productos: ");
                                            for (Object o : productos) {
                                                System.out.println(productos.indexOf(o) + " = " + o);
                                            } // Fin For
                                            System.out.print("Ingrese el local que desea modificar: ");
                                            int pos2 = entrada.nextInt();
                                            System.out.print("¿Que atributo desea modificar?");
                                            System.out.println("1) Descripcion");
                                            System.out.println("2) Nombre");
                                            System.out.println("3) Precio");
                                            System.out.print("Ingrese la opcion deseada: ");
                                            int op3 = entrada.nextInt();
                                            switch (op3) {
                                                case 1:
                                                    System.out.println("Ingrese la nueva descripcion: ");
                                                    String descripcion = entrada.nextLine();
                                                    productos.get(pos2).setDescripcion(descripcion);
                                                    break;
                                                case 2:
                                                    System.out.println("Ingrese ");
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    System.out.println("¡Entrada no valida!");
                                            } // Fin Switch
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("¡Entrada no valida!");
                                    } // Fin Switch Modificar
                                    break;
                                case 3:
                                    System.out.println("¿Que desea eliminar?");
                                    System.out.println("1) Eliminar Local");
                                    System.out.println("2) Eliminar Producto");
                                    System.out.println("3) Eliminar Empleado");
                                    System.out.print("Ingrese la opcion deseada: ");
                                    int opcion5 = entrada.nextInt();
                                    int eliminar;
                                    switch (opcion5) {
                                        case 1:
                                            String cadenaLocales = "";
                                            for (int i = 0; i < locales.size(); i++) {
                                                cadenaLocales += "[" + i + "]" + locales.get(i);
                                            }
                                            System.out.println("Ingrese el indice a eliminar");
                                            eliminar = entrada.nextInt();
                                            locales.remove(eliminar);
                                            break;
                                        case 2:
                                            String cadenaProductos = "";
                                            for (int i = 0; i < productos.size(); i++) {
                                                cadenaProductos += "[" + i + "]" + productos.get(i);
                                            }
                                            System.out.println("Ingrese el indice a eliminar");
                                            eliminar = entrada.nextInt();
                                            productos.remove(eliminar);
                                            break;
                                        case 3:
                                            cadenaLocales = "";
                                            Persona o = new Persona();
                                            for (int i = 0; i < locales.size(); i++) {
                                                o = personas.get(i);
                                                cadenaLocales += "[" + i + "]" + locales.get(i);
                                            }
                                            System.out.println("Ingrese el indice a eliminar");
                                            eliminar = entrada.nextInt();
                                            personas.remove(eliminar);
                                            break;
                                        default:
                                            System.out.println("¡Entrada no valida!");
                                    } // Fin Switch Eliminar
                                    break;
                                case 4:
                                    System.out.println("¿Que desea listar?");
                                    System.out.println("1) Listar Local");
                                    System.out.println("2) Listar Empleado");
                                    System.out.println("3) Listar Producto");
                                    System.out.print("Ingrese la opcion deseada: ");
                                    int opcion6 = entrada.nextInt();
                                    switch (opcion6) {
                                        case 1:
                                            System.out.println("¿Que desea listar?");
                                            System.out.println("1) Tiendas");
                                            System.out.println("2) Quiscos");
                                            System.out.println("3) Bares");
                                            System.out.print("Ingrese la opcion deseada: ");
                                            int opcion7 = entrada.nextInt();
                                            switch (opcion7) {
                                                case 1:
                                                    break;
                                                case 2:
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    System.out.println("¡Entrada no valida!");
                                            } // Fin Switch Listar Locales
                                            break;
                                        case 2:
                                            System.out.println("¿Que desea listar?");
                                            System.out.println("1) Empleados");
                                            System.out.println("2) Clientes");
                                            System.out.print("Ingrese la opcion deseada: ");
                                            int opcion8 = entrada.nextInt();
                                            switch (opcion8) {
                                                case 1:
                                                    break;
                                                case 2:
                                                    break;
                                                default:
                                                    System.out.println("¡Entrada no valida!");
                                            } // Fin Switch Listar Personas
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("¡Entrada no valida!");
                                            break;
                                    } // Fin Switch Listar
                                default:
                                    System.out.println("¡Entrada no valida!");
                            } // Fin Switch CRUD
                            break;
                        case 2:
                            System.out.println("Ingrese su username: ");
                            String user2 = entrada.next();
                            while (Usernames(user2) == false) {
                                System.out.println("¡El username ingresado no se encuentra registrado!");
                                System.out.print("Ingrese su username: ");
                                user2 = entrada.next();
                            } // Fin While
                            System.out.println("Ingrese su contraseña: ");
                            String contra2 = entrada.next();
                            while (Registro(user2, contra2) == false) {
                                System.out.println("¡Contraseña no valida!");
                                System.out.print("Ingrese su username: ");
                                user2 = entrada.next();
                            } // Fin While
                            System.out.println("¿Con cuenta dinero cuenta el dia de hoy?");
                            double dinero = entrada.nextDouble();
                            System.out.println("¡Bienvenido Cliente!");
                            System.out.println("¿Que desea hacer el dia de hoy?");
                            System.out.println("1) ");
                            System.out.print("Ingrese la opcion deseada: ");
                            int opcion2 = entrada.nextInt();
                            switch (opcion2) {
                                default:
                                    System.out.println("¡Entrada no valida!");
                            } // Fin Break Sign In
                            break;
                        default:
                            System.out.println("¡Entrada no valida!");
                    } // Fin Switch Roles
                    break;

                case 2:
                    System.out.println("Porfavor ingrese los siguientes datos: ");
                    System.out.print("Ingrese su ID: ");
                    int ID = entrada.nextInt();
                    while (IDs(ID) == true) {
                        System.out.println("¡El ID ingresado ya se encuentra registrado!");
                        System.out.print("Ingrese su ID: ");
                        ID = entrada.nextInt();
                    } // Fin While
                    IDs.add(ID);
                    System.out.print("Ingrese su username: ");
                    String username = entrada.next();
                    while (Usernames(username) == true) {
                        System.out.println("¡El username ingresado ya se encuentra registrado!");
                        System.out.print("Ingrese su username: ");
                        username = entrada.next();
                    } // Fin While
                    usernames.add(username);
                    System.out.print("Ingrese su contraseña: ");
                    String contraseña = entrada.next();
                    contraseñas.add(contraseña);
                    System.out.println("Ingrese su correo electronico: ");
                    String correo = entrada.next();
                    System.out.println("Ingrese su nombre completo: ");
                    String nombre = entrada.nextLine();
                    System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
                    String fecha = entrada.next();
                    System.out.println("¡Se ha logrado registrar exitosamente!");
                    Cliente cliente = new Cliente();
                    personas.add(cliente);
                    break;
                case 3:
                    // Aqui va la Salida
                    resp = 'n';
                    break;
                default:
                    System.out.println("¡Entrada no valida!");
            } // Fin Switch Log In
        } // Fin While Resp
    } // Fin Main

    public static boolean IDs(int ID) {
        for (int i = 0; i < IDs.size(); i++) {
            if (IDs.get(i) == ID) {
                return true;
            } else {
                return false;
            } // Fin If
        } // Fin For
        return false;
    } // Fin Codigos

    public static boolean Usernames(String username) {
        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(username)) {
                return true;
            } else {
                return false;
            } // Fin If
        } // Fin For
        return false;
    } // Fin Codigos

    public static boolean Registro(String username, String password) {
        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(username)) {
                if (contraseñas.get(i).equals(password)) {
                    return true;
                } else {
                    return false;
                }// Fin If
            } // Fin If
        } // Fin For
        return false;
    }
} // Fin Class
