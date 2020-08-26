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
            case "1":{ //Sistema del pasajero
                System.out.println("¿Qué desea hacer?\n1. Comprar un tiquete.\n2. Realizar su check-in.");
                String accion = scan.nextLine();
                switch (accion){
                    case "1":{ //comprar tiquete
                        System.out.println("Aquí están nuestros vuelos disponibles:");
                        DoubleListNode v = vuelos.head;
                        for (int i = 0; i < vuelos.getSize(); i++) {
                            System.out.println((i+1)+". "+vuelos.get(v).toString());
                            v = v.next;
                            //todo imprimir los vuelos con su disponibilidad
                        }
                        System.out.println("¿Cuál vuelo quiere comprar?");
                        String vNum = scan.nextLine();
                        DoubleListNode n = vuelos.head;
                        Vuelo vueloInteres = null;
                        for (int i = 1; i <= Integer.parseInt(vNum)+1; i++) {
                            vueloInteres = (Vuelo) n.getObject();
                            n = n.next;
                        }
                        System.out.println("¿Ya está registrado? (S/N)");
                        //preguntar si ya está registrado (preguntar idPasajero y buscar)
                        String siOno = scan.nextLine();
                        System.out.println("Ingrese su numero de identificación");
                        String id = scan.nextLine();
                        Ticket ticket;
                        switch (siOno){
                            case "S":{
                                DoubleListNode p = pasajeros.head;
                                for (int i = 0; i < pasajeros.getSize(); i++) {
                                    Pasajero pas = (Pasajero)p.getObject();
                                    if(pas.getNumeroID() == Integer.parseInt(id)){
                                        System.out.println("¿En que categoría desea viajar?");
                                        System.out.println("1. Premium\n2. Ejecutiva\n3.Economica");
                                        int cat = Integer.parseInt(scan.nextLine());
                                        System.out.println("¿Cuanto peso lleva en su maleta? (en Kilogramos)");
                                        int carga = Integer.parseInt(scan.nextLine());

                                        ticket = new Ticket(pas);
                                        //AQUI QUEDÉ todo arreglar comprar
                                        ticket.comprar(vueloInteres,pas,carga,cat);
                                        
                                        break;
                                    }
                                }
                                System.out.println("Parece que usted no se encuentra en el sistema");
                                break;
                            }
                            case "N":{

                                //si no está registrado, primero:
                                //todo llamar a un metodo registrar con la cedula que ingresó.
                                //NOTA: ESTOS METODOS ESTÁN DENTRO DE LA CLASE PASAJERO y TICKET RESPECTIVAMENTE
                                break;
                            }
                        }


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
