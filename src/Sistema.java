import co.edu.upb.list.DoubleList;
import co.edu.upb.list.DoubleListNode;
import co.edu.upb.models.Pasajero;
import co.edu.upb.models.Ticket;
import co.edu.upb.models.Vuelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sistema{
    public static void main(String[] args) {
        //creando algunos pasajeros
        DoubleList pasajeros = new DoubleList();
        Pasajero pas1 = new Pasajero("1193560933");
        pas1.registrarse("Angela","Remolina","CC", pas1.numeroID, "Cra.15","3188334099","Maria","Remolina","Calle 12","3188334095");
        pasajeros.add(pas1);

        //creando algunos vuelos
        DoubleList vuelos = new DoubleList();
        Calendar today = Calendar.getInstance();
        Vuelo v1 = new Vuelo("Bucaramanga","Cucuta",new GregorianCalendar(2020, Calendar.AUGUST, 31, 23, 11, 44) ,new GregorianCalendar(2020, Calendar.SEPTEMBER, 1, 0, 0, 0));
        Vuelo v2 = new Vuelo("Bucaramanga","Bogotá",new GregorianCalendar(2020, Calendar.AUGUST, 25, 23, 4, 44) ,new GregorianCalendar(2020, Calendar.AUGUST, 24, 23, 59, 59));
        vuelos.add(v1);
        vuelos.add(v2);

        //INICIO DEL PROGRAMA
        System.out.println("Bienvenido a la aerolinea AV-UPB!");
        System.out.println("¿quién ingresa al sistema?\n1.Pasajero\n2.Agente de abordaje");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        switch (user){
            //todo poner un ciclo para que le permita hacer el check-in despues del registro
            //  o permita el ingreso de un agente de abordaje
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
                        System.out.println("Gracias por la compra :D");
                        break;
                    }
                    case "2":{ //check-in
                        //todo llamar a un metodo check-in
                        //NOTA: ESTOS METODOS LOS PUEDES PONER DENTRO DE LA CLASE TICKET
                        break;
                    }
                }
                break;
            }
            case "2":{ //Sistema del agente de abordaje
                //preguntar que quiere ver y dependiendo de eso
                //Consultarpasajeros
                //mostrarVuelos
                break;
            }
        }
    }

    public static String mostrarVuelos() {
        return null;
    }



    public static Pasajero consultarPasajero() {
        return null;
    }
}
