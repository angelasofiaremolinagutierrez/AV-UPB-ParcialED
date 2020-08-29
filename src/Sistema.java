import co.edu.upb.list.DoubleList;
import co.edu.upb.list.DoubleListNode;
import co.edu.upb.models.Pasajero;
import co.edu.upb.models.Ticket;
import co.edu.upb.models.Vuelo;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sistema{
    public static void main(String[] args) {
        //creando algunos pasajeros
        DoubleList pasajeros = new DoubleList();
        Pasajero pas1 = new Pasajero("1193560933");
        pas1.setIdPasajero(pasajeros.getSize()+1);
        pas1.registrarse("Angela","Remolina","CC", pas1.numeroID, "Cra.15","3188334099","Maria","Remolina","Calle 12","3188334095");
        pasajeros.add(pas1);

        //creando algunos vuelos
        DoubleList vuelos = new DoubleList();
        //todo crear vuelos reales
        Vuelo v1 = new Vuelo("Bucaramanga","Cucuta",new GregorianCalendar(2020, Calendar.AUGUST, 31, 23, 11, 44) ,new GregorianCalendar(2020, Calendar.SEPTEMBER, 1, 0, 0, 0));
        Vuelo v2 = new Vuelo("Bucaramanga","Bogotá",new GregorianCalendar(2020, Calendar.AUGUST, 27, 23, 39, 44) ,new GregorianCalendar(2020, Calendar.AUGUST, 24, 23, 59, 59));
        v1.setIdAvion(1);
        v2.setIdAvion(2);
        vuelos.add(v1);
        vuelos.add(v2);

        //tickets comprados
        DoubleList tickets = new DoubleList();
        Ticket prueba = new Ticket(pas1);
        prueba.comprar(v1,pas1,58,3);
        tickets.add(prueba);

        //INICIO DEL PROGRAMA
        System.out.println("Bienvenido a la aerolinea AV-UPB!");

        Scanner scan = new Scanner(System.in);
        boolean flag1 = true;

        while (flag1){
            System.out.println("¿quién ingresa al sistema?\n1.Pasajero\n2.Agente de abordaje\n3.Salir");
            String user = scan.nextLine();
            switch (user){
                case "1":{ //Sistema del pasajero
                    System.out.println("¿Qué desea hacer?\n1. Comprar un tiquete.\n2. Realizar su check-in.");
                    String accion = scan.nextLine();
                    switch (accion){
                        case "1":{ //comprar tiquete
                            System.out.println("Antes de iniciar la compra por favor elija su tipo de documento (Escoja un numero)");
                            System.out.println("1. CC\n2. CE \n3. Pasaporte");
                            int tipo;
                            while (true){
                                tipo = Integer.parseInt(scan.nextLine());
                                if(tipo==1 || tipo==2 || tipo==3){
                                    break;
                                }else{
                                    System.out.println("Esa no es una opción, escriba una opción de las anteriores.");
                                }
                            }
                            String tipoID = "";
                            if(tipo == 1){
                                tipoID = "CC";
                            }else if(tipo == 2){
                                tipoID = "CE";
                            }else if(tipo == 3){
                                tipoID = "Pasaporte";
                            }
                            System.out.println("Ingrese su numero de identificación");
                            String id = scan.nextLine();

                            //comprobar si ya está registrado
                            DoubleListNode p = pasajeros.head;
                            int contUser = 0;
                            Pasajero pas = null;
                            for (int i = 0; i < pasajeros.getSize(); i++) {
                                pas = (Pasajero)p.getObject();
                                if(pas.getNumeroID().equals(id) && pas.getTipoID().equals(tipoID)){
                                    break;
                                }
                                contUser++;
                            }
                            if(contUser == pasajeros.getSize()) {
                                System.out.println("Parece que usted no se encuentra en el sistema.");
                                System.out.println("¿Desea registrarse? (S/N)");
                                String siOno = scan.nextLine().toUpperCase();

                                switch (siOno) {
                                    case "S": {
                                        //llamar a un metodo registrar con la cedula que ingresó.
                                        pas = new Pasajero(id);
                                        pas.setIdPasajero(pasajeros.getSize()+1);
                                        System.out.println("Para hacer el registro ingrese los siguientes datos");
                                        System.out.println("Nombre:");
                                        String nombre = scan.nextLine();
                                        System.out.println("Apellido:");
                                        String apellido = scan.nextLine();
                                        System.out.println("Dirección:");
                                        String direccion = scan.nextLine();
                                        System.out.println("Telefono:");
                                        String telefono = scan.nextLine();
                                        System.out.println("Ahora ingrese los datos de un contacto de emergencia");
                                        System.out.println("Nombre:");
                                        String nombreSOS = scan.nextLine();
                                        System.out.println("Apellido:");
                                        String apellidoSOS = scan.nextLine();
                                        System.out.println("Dirección:");
                                        String direccionSOS = scan.nextLine();
                                        System.out.println("Telefono:");
                                        String telefonoSOS = scan.nextLine();

                                        pas.registrarse(nombre, apellido, tipoID, id, direccion, telefono, nombreSOS, apellidoSOS, direccionSOS, telefonoSOS);
                                        pasajeros.add(pas);

                                        System.out.println("Registro exitoso :)");
                                        break;
                                    }
                                    case "N": {
                                        System.out.println("Sin registrarte no puedes comprar un ticket :(");
                                        break;
                                    }
                                }
                                if(siOno.equals("N")){
                                    break;
                                }
                            }
                            System.out.println("Bienvenid@ "+pas.getNombre());

                            System.out.println("Ahora sí podemos proseguir con la compra");

                            System.out.println("Aquí están nuestros vuelos disponibles:");
                            DoubleListNode v = vuelos.head;
                            for (int i = 0; i < vuelos.getSize(); i++) {
                                System.out.println((i+1)+". "+vuelos.get(v).toString());
                                System.out.println("Disponibilidad: "+ ((Vuelo)vuelos.get(v)).getPuestosDisponibles());
                                v = v.next;
                            }
                            System.out.println("¿Cuál vuelo quiere comprar?");
                            int vNum;
                            while (true){
                                vNum = Integer.parseInt(scan.nextLine());
                                if(vNum<=0 || vNum>vuelos.getSize()){
                                    System.out.println("Ese vuelo no existe, escriba una opción de las anteriores.");

                                }else{
                                    break;
                                }
                            }
                            DoubleListNode n = vuelos.head;
                            Vuelo vueloInteres = null;
                            for (int i = 1; i <= vNum; i++) {
                                vueloInteres = (Vuelo) n.getObject();
                                n = n.next;
                            }

                            Ticket ticket;
                            System.out.println("¿En que categoría desea viajar?");
                            System.out.println("1. Premium\n2. Ejecutiva\n3. Economica");
                            int cat;
                            while (true){
                                cat = Integer.parseInt(scan.nextLine());
                                if(cat==1 || cat==2 || cat==3){
                                    break;
                                }else{
                                    System.out.println("Esa no es una opción, escriba una opción de las anteriores.");
                                }
                            }
                            System.out.println("¿Cuanto peso lleva en su maleta? (en Kilogramos)");
                            int carga = Integer.parseInt(scan.nextLine());

                            ticket = new Ticket(pas);
                            ticket.comprar(vueloInteres,pas,carga,cat);
                            tickets.add(ticket);
                            System.out.println("Gracias por la compra :D");
                            break;
                        }
                        case "2":{ //check-in
                            System.out.println("Ingrese el id de su avión");
                            int idAvion = Integer.parseInt(scan.nextLine());
                            System.out.println("Ingrese el id de registro de su ticket");
                            int idRegistro = Integer.parseInt(scan.nextLine());

                            DoubleListNode t = tickets.head;
                            int contTickets = 0;
                            Ticket tic = null;
                            for (int i = 0; i < tickets.getSize(); i++) {
                                tic = (Ticket) t.getObject();
                                if ((tic.getIdRegistro() == idRegistro) && (tic.getVuelo().getIdAvion() == idAvion)) {
                                    break;
                                }
                                t = t.next;
                                contTickets++;
                            }

                            if(contTickets == tickets.getSize()) {
                                System.out.println("Ticket invalido");
                            }else{
                                Calendar rn = Calendar.getInstance();
                                long mins = (tic.getVuelo().getHoraSalida().getTimeInMillis() - rn.getTimeInMillis())/60000;
                                if(mins<30){
                                    System.out.println("Lo siento, ya no puedes realizar el check-in, abordamos en: "+mins+" minutos.");
                                }else{
                                    boolean flag2 = true;
                                    while(flag2){
                                        System.out.println("¿Quiere modificar alguna de esta información?");
                                        System.out.println("Escriba el numero para modificar:\n1. nombre\n2. apellido\n" +
                                                "3. direccion\n4. telefono\n"+ "5. nombre contacto emergencias\n" +
                                                "6. apellido contacto emergencia\n" + "7. direccion contacto emergencias\n" +
                                                "8. telefono emergencias\n" + "9. Cambiar el peso de la maleta\n" +
                                                "10. Guardar y salir.");
                                        int mod = Integer.parseInt(scan.nextLine());
                                        switch (mod){
                                            case 1:{
                                                System.out.println("Ingrese su nombre corregido");
                                                tic.pas.setNombre(scan.nextLine());
                                                break;
                                            }
                                            case 2:{
                                                System.out.println("Ingrese su apellido corregido");
                                                tic.pas.setApellido(scan.nextLine());
                                                break;
                                            }
                                            case 3:{
                                                System.out.println("Ingrese su dirección corregida");
                                                tic.pas.setDireccion(scan.nextLine());
                                                break;
                                            }
                                            case 4:{
                                                System.out.println("Ingrese su telefono corregido");
                                                tic.pas.setTelefono(scan.nextLine());
                                                break;
                                            }
                                            case 5:{
                                                System.out.println("Ingrese el nombre de su contacto de emergencias corregido");
                                                tic.pas.setNombreContactoSOS(scan.nextLine());
                                                break;
                                            }
                                            case 6:{
                                                System.out.println("Ingrese el apellido de su contacto de emergencias corregido");
                                                tic.pas.setApellidoContactoSOS(scan.nextLine());
                                                break;
                                            }
                                            case 7:{
                                                System.out.println("Ingrese la dirección de su contacto de emergencias corregido");
                                                tic.pas.setDireccionContactoSOS(scan.nextLine());
                                                break;
                                            }
                                            case 8:{
                                                System.out.println("Ingrese el telefono de su contacto de emergencias corregido");
                                                tic.pas.setTelefono(scan.nextLine());
                                                break;
                                            }
                                            case 9:{
                                                System.out.println("Ingrese el peso actual de su maleta");
                                                tic.setCarga(Integer.parseInt(scan.nextLine()));
                                                break;
                                            }
                                            case 10:{
                                                System.out.println("Información guardada");
                                                flag2 = false;
                                            }
                                        }
                                        System.out.println("Tu información fue cambiada exitosamente.");
                                        if(tic.getCarga()>52){
                                            System.out.println("Tu maleta es muy pesada, no puedes ingresar así, sacale peso antes de abordar");
                                        }
                                    }
                                }
                                break;
                            }

                            /*todo
                             vuelo 1 y vuelo 2, si antes de abordar el vuelo 1 su ocupación es del 50%
                             y el siguiente vuelo 2 es del 50%, se deberá reasignar todos los pasajeros
                             en el vuelo 2 (cualquier parecido con la realidad es pura coincidencia).
                             Tenga en cuenta que, si un puesto esta ocupado deberá asignarle el siguiente,
                             si esta ocupado deberá asignar el siguiente, hasta que encuentre uno libre.
                             En caso de llegar al final de los puestos, deberá ir al primer asiento de su
                             categoría para continuar con la búsqueda de puesto.
                             */
                        }
                    }
                    System.out.println("\n");
                    break;
                }
                case "2":{ //Sistema del agente de abordaje
                    System.out.println("¿Qué desea hacer?");
                    System.out.println("1. Consultar la lista de pasajeros\n2. Crear reportes de los pasajeros");
                    String op = scan.nextLine();
                    switch (op){
                        case "1":{
                            DoubleListNode n = pasajeros.head;
                            for (int i = 0; i < pasajeros.getSize(); i++) {
                                System.out.println("------------PASAJERO "+(i+1)+"-------------");
                                System.out.println(((Pasajero)n.getObject()).toString());
                                n = n.next;
                            }
                            break;
                        }
                        case "2":{//El reporte debe contemplar la carga asociada a cada uno de ellos y los costos detallados y totales del vuelo.
                            System.out.println("Reportes ordenados por: \n" +
                                    "1. Nombre\n2. Apellido\n3. ID Avión");


                            break;
                        }
                    }
                    System.out.println("\n");
                    break;
                }
                case "3":{
                    System.out.println("Gracias por usar el sistema :)");
                    flag1 = false;
                    System.out.println("\n");
                    break;
                }
                default:{
                    System.out.println("Esa no es una opción intentelo de nuevo");
                    System.out.println("\n");
                }
            }
        }

    }
}
