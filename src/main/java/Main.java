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
            System.out.println("4. Salir");
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
                        System.out.println("Adios.");
                        sc.close();
                        System.exit(0);
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Se ingreso un valor que no corresponde a un numero");
                return;
            }
        }
    }

}
