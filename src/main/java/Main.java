import entity.Paciente;
import list.PacienteList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PacienteList pacienteList = new PacienteList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Registrar un paciente");
            System.out.println("2. Mostrar todos los pacientes");
            System.out.println("3. Atender paciente");
            System.out.println("4. Buscar por ID");
            System.out.println("5. Eliminar por ID");
            System.out.println("6. Cantidad de pacientes en espera");
            System.out.println("7. Salir");
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1: {
                        sc = new Scanner(System.in);
                        pacienteList.insertarPaciente(sc);
                        break;
                    }
                    case 2: {
                        pacienteList.mostrarPacientes();
                        break;
                    }
                    case 3: {
                        pacienteList.atenderPaciente();
                        break;
                    }
                    case 4: {
                        System.out.println("Ingrese el ID de paciente: ");
                        try {
                            int id = sc.nextInt();
                            if (pacienteList.obtenerPaciente(id) != null) {
                                Paciente paciente = pacienteList.obtenerPaciente(id);
                                System.out.println("\nID paciente: " + paciente.getId_paciente() + "\nNombre: " + paciente.getNombre_paciente() + "\nNivel de urgencia: " + paciente.getNivel_urgencia() + "\nHora de llegada: " + paciente.getHora_llegada());
                            } else {
                                System.out.println("No existe el ID de paciente");
                            }
                        } catch (Exception ex) {
                            System.out.println("El valor ingresado no es valido");
                        }
                        break;
                    }
                    case 5: {
                        pacienteList.eliminarPaciente(sc);
                        break;
                    }
                    case 6: {
                        System.out.println("Hay una cantidad de " + pacienteList.cantidadPacientes() + " en espera.");
                        break;
                    }
                    case 7: {
                        System.out.println("Adios");
                        sc.close();
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                System.out.println("Se ingreso un valor que no corresponde a un numero");
                return;
            }
        }
    }

}
