import co.edu.upb.list.DoubleList;
import co.edu.upb.list.DoubleListNode;
import co.edu.upb.models.Pasajero;
import co.edu.upb.models.Ticket;
import co.edu.upb.models.Vuelo;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Sistema{
    public static void main(String[] args) {
        //creando algunos pasajeros
        DoubleList pasajeros = new DoubleList();
        Pasajero pas1 = new Pasajero("1193560933");
        pas1.setIdPasajero(pasajeros.getSize()+1);
        pas1.registrarse("Angela","Remolina","CC", pas1.numeroID, "Cra.15","3188334099","Maria","Remolina","Calle 12","3188334095");
        pasajeros.add(pas1);

        Pasajero pas2 = new Pasajero("123456789");
        pas2.setIdPasajero(pasajeros.getSize()+1);
        pas2.registrarse("Alberto","Zapata","CE", pas2.numeroID, "Cra.X","3151234567","Luis","Diaz","Calle 10","3127890456");
        pasajeros.add(pas2);

        //creando algunos vuelos
        DoubleList vuelos = new DoubleList();
        Vuelo v1 = new Vuelo("Bucaramanga","Bogotá",new GregorianCalendar(2020, Calendar.AUGUST, 30, 18, 5, 44) ,new GregorianCalendar(2020, Calendar.AUGUST, 30, 18, 40, 59));
        Vuelo v2 = new Vuelo("Bogotá","Cucuta",new GregorianCalendar(2020, Calendar.SEPTEMBER, 2, 16, 0, 0) ,new GregorianCalendar(2020, Calendar.SEPTEMBER, 2, 16, 32, 0));
        Vuelo v3 = new Vuelo("Bucaramanga","Bogotá",new GregorianCalendar(2020, Calendar.SEPTEMBER, 5, 23, 59, 44) ,new GregorianCalendar(2020, Calendar.SEPTEMBER, 6, 0, 34, 0));
        Vuelo v4 = new Vuelo("Bucaramanga","Cucuta",new GregorianCalendar(2020, Calendar.SEPTEMBER, 9, 10, 19, 24) ,new GregorianCalendar(2020, Calendar.SEPTEMBER, 9, 10, 50, 0));
        Vuelo v5 = new Vuelo("Cucuta","Bogotá",new GregorianCalendar(2020, Calendar.SEPTEMBER, 13, 13, 13, 13) ,new GregorianCalendar(2020, Calendar.SEPTEMBER, 13, 14, 0, 0));
        vuelos.add(v1);
        vuelos.add(v2);
        vuelos.add(v3);
        vuelos.add(v4);
        vuelos.add(v5);

        //asignar idAvion
        DoubleListNode vnode = vuelos.head;
        for (int i = 0; i < vuelos.getSize(); i++) {
            ((Vuelo)vnode.getObject()).setIdAvion(i+1);
            vnode = vnode.next;
        }

        //tickets comprados
        DoubleList tickets = new DoubleList();

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
                                p = p.next;
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
                        }
                    }
                    System.out.println("\n");
                    break;
                }
                case "2":{ //Sistema del agente de abordaje
                    System.out.println("¿Qué desea hacer?");
                    System.out.println("1. Consultar la lista de pasajeros\n2. Crear reportes de los vuelos con información de cada pasajero" +
                            "\n3. Reasignar vuelo si el 50% no abordó.");
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
                        case "2":{//El reporte debe contemplar la carga asociada a cada pasajero y los costos detallados y totales del vuelo.
                            System.out.println("Reportes ordenados por: \n" + "1. Nombre\n2. Apellido\n3. ID Avión");
                            String rep = scan.nextLine();
                            //Sin importar que, los vuelos se imprimirán  ordendados por id del avión (opción default)
                            DoubleListNode n = vuelos.head;
                            for (int i = 0; i < vuelos.getSize(); i++) {
                                System.out.println("--------------------VUELO " + (i + 1) + "---------------------");
                                System.out.println("Información del vuelo:");
                                System.out.println(((Vuelo) n.getObject()).toString());
                                DoubleList ticketsVuelo = ((Vuelo) n.getObject()).getTickets();
                                System.out.println("\nPasajeros:");

                                DoubleList porNombre = new DoubleList();
                                DoubleList porApellido = new DoubleList();
                                DoubleListNode t = ticketsVuelo.head;
                                int precioTotal = 0;
                                for (int j = 0; j < ticketsVuelo.getSize(); j++) {
                                    Ticket ticketActual = (Ticket)t.getObject();

                                    int precio = ticketActual.getPrecio();
                                    System.out.println("El precio del siguiente ticket es de: "+precio);
                                    precioTotal += precio;

                                    if(rep.equals("3")){
                                        System.out.println(ticketActual.getPas().toString());
                                        System.out.println("La carga de este pasajero es de: "+ ticketActual.getCarga()+"kg\n");
                                    }else if(rep.equals("2")){
                                        porApellido.add(ticketActual.getPas().getApellido().toLowerCase());
                                    }else if(rep.equals("1")){
                                        porNombre.add(ticketActual.getPas().getNombre().toLowerCase());
                                    }
                                    t = t.next;
                                }
                                if(rep.equals("1")){
                                    porNombre = porNombre.sortList();
                                    DoubleListNode pn = porNombre.head;
                                    for (int j = 0; j < porNombre.getSize(); j++) {
                                        String nombreActual = (String) pn.getObject();
                                        DoubleListNode nodoTicket = ticketsVuelo.head;
                                        Ticket ticketActual = (Ticket)nodoTicket.getObject();
                                        for (int k = 0; k < ticketsVuelo.getSize(); k++) {
                                            ticketActual = (Ticket)nodoTicket.getObject();
                                            if((ticketActual.getPas().getNombre().toLowerCase()).equals(nombreActual)){
                                                break;
                                            }
                                            nodoTicket = nodoTicket.next;
                                        }
                                        System.out.println(ticketActual.getPas().toString());
                                        System.out.println("La carga de este pasajero es de: " + ticketActual.getCarga() + "kg\n");
                                        pn = pn.next;
                                    }

                                }else if(rep.equals("2")){
                                    porApellido = porApellido.sortList();
                                    DoubleListNode pa = porApellido.head;
                                    for (int j = 0; j < porApellido.getSize(); j++) {
                                        String apellidoActual = (String) pa.getObject();
                                        DoubleListNode nodoTicket = ticketsVuelo.head;
                                        Ticket ticketActual = (Ticket)nodoTicket.getObject();
                                        for (int k = 0; k < ticketsVuelo.getSize(); k++) {
                                            ticketActual = (Ticket)nodoTicket.getObject();
                                            if((ticketActual.getPas().getApellido().toLowerCase()).equals(apellidoActual)){
                                                break;
                                            }
                                            nodoTicket = nodoTicket.next;
                                        }
                                        System.out.println(ticketActual.getPas().toString());
                                        System.out.println("La carga de este pasajero es de: " + ticketActual.getCarga() + "kg\n");
                                        pa = pa.next;
                                    }
                                }

                                if(ticketsVuelo.getSize() == 0){
                                    System.out.println("\nNo hay tickets comprados para este vuelo.");
                                }
                                System.out.println("\n ...................................");
                                System.out.println("Los costos totales asociados a este vuelo son de: "+precioTotal);
                                System.out.println(" ...................................\n");


                                n = n.next;
                            }

                            break;
                        }
                        case "3":{
                            //Los vuelos están ordenados por hora de salida
                            System.out.println("Ingrese el ID del avión del vuelo que quiere reasignar");
                            int idAReasignar = Integer.parseInt(scan.nextLine());
                            DoubleListNode v = vuelos.head;
                            for (int i = 0; i < idAReasignar-1; i++) { //encontrar el vuelo con el id que ingresó
                                v = v.next;
                            }

                            Calendar rn = Calendar.getInstance();
                            Vuelo vuelo = (Vuelo)v.getObject();
                            long minsParaSalida = (vuelo.getHoraSalida().getTimeInMillis() - rn.getTimeInMillis())/60000;
                            long minsParaLlegada = (vuelo.getHoraLlegada().getTimeInMillis() - rn.getTimeInMillis())/60000;

                            System.out.println("Minutos restantes para la salida: "+minsParaSalida);
                            System.out.println("Minutos restantes para la llegada: "+minsParaLlegada+"\n");

                            if(minsParaSalida<30 && minsParaSalida>=0){
                                int numPasajerosVuelo = 133-vuelo.getPuestosDisponibles();
                                if(numPasajerosVuelo <= 67){ // si la ocupación es del 50% o menos
                                    while (v.next != null){
                                        Vuelo siguienteVuelo = ((Vuelo)v.next.getObject());
                                        String ciudadSalidaNext = siguienteVuelo.getCiudadSalida();
                                        String ciudadLlegadaNext = siguienteVuelo.getCiudadLlegada();
                                        if(vuelo.getCiudadLlegada().equals(ciudadLlegadaNext) && vuelo.getCiudadSalida().equals(ciudadSalidaNext)){//Checkear que el vuelo siguiente sea para el mismo destino y misma salida
                                            if(siguienteVuelo.getPuestosDisponibles() >= numPasajerosVuelo){//si el vuelo siguiente tiene los puestos disponibles para ingresar a los pasajeros de este
                                                System.out.println("Avise a los pasajeros de este vuelo que se canceló y que serán reasignados al vuelo del avión de id numero: "+siguienteVuelo.getIdAvion());
                                                System.out.println("Se imprimirán los nuevos ticketes de todos los pasajeros aquí:");
                                                System.out.println("v--------------------------------------v");
                                                //reasignar todos los pasajeros al nuevo vuelo
                                                DoubleList ticketsVuelo = vuelo.getTickets();
                                                DoubleListNode nodetick = tickets.head;
                                                for (int i = 0; i < ticketsVuelo.getSize(); i++) {
                                                    Ticket ticketViejo = ((Ticket)nodetick.getObject());
                                                    Pasajero pasActual = ticketViejo.getPas();
                                                    Ticket tickNuevo = new Ticket(pasActual);
                                                    tickNuevo.comprar(siguienteVuelo,pasActual, ticketViejo.getCarga(),ticketViejo.getCategoria());
                                                    tickets.add(tickNuevo);

                                                    nodetick = nodetick.next;
                                                    System.out.println("\n...............................\n");
                                                }
                                                vuelo.setEstado("Cancelado"); //cancelar el vuelo
                                                System.out.println("^--------------------------------------^");

                                            }else{
                                                System.out.println("Los pasajeros no caben en el siguiente vuelo, éste deberá salir así");
                                            }
                                            break;
                                        }else{
                                            v = v.next;
                                        }
                                    }
                                    if(v.next == null){
                                        System.out.println("No hay vuelos para el mismo destino disponibles.");
                                    }
                                }else{
                                    System.out.println("Este avión está ocupado a más de 50%");
                                    System.out.println("Ya puede salir.");
                                }
                            }else if(minsParaLlegada <=0){
                                System.out.println("Este vuelo ya cerró. Ya llegó a su destino.");
                            }else if(minsParaSalida<=0 && minsParaLlegada>0){
                                System.out.println("Este vuelo ya despegó.");
                            }else{
                                System.out.println("Faltan más de 30 minutos para el abordaje, aun no se puede hacer esta comprobación ya que no todos los pasajeros han hecho su check-in.");
                            }
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
