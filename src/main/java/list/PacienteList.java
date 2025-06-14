package list;

import entity.Paciente;

import java.util.Scanner;

public class PacienteList {

    private Paciente primerPaciente = null;
    private Paciente ultimoPaciente = null;

    private ConsultaMedicaList consultaMedicaList = new ConsultaMedicaList();
    private EmergenciaList emergenciaList = new EmergenciaList();

    public PacienteList() {
    }

    public void insertarPaciente(Scanner entrada) {
        System.out.println("Digite el ID de paciente: ");
        int id = entrada.nextInt();
        if (obtenerPaciente(id) == null) {
            Paciente paciente = new Paciente();
            paciente.setId_paciente(id);

            System.out.println("Ingrese el nombre del paciente: ");
            try {
                String nombre = entrada.nextLine();
                if (!nombre.isEmpty()) {
                    paciente.setNombre_paciente(nombre);
                } else {
                    System.out.println("El nombre del paciente no puede estar vacio, abortando.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Cadena de nombre ingresado no valida, abortando.");
                return;
            }

            System.out.println("Ingrese el nivel de urgencia del paciente (1, menor urgencia (consulta medica), 5 emergencia): ");
            try {
                int nivel_urgencia = entrada.nextInt();
                if (nivel_urgencia >= 1 && nivel_urgencia < 5) {
                    paciente.setNivel_urgencia(1);
                } else if (nivel_urgencia == 5) {
                    paciente.setNivel_urgencia(nivel_urgencia);
                } else {
                    System.out.println("Se detecto un nivel de urgencia no valido, abortando.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Se detecto un valor que no corresponde a un numero, abortando.");
                return;
            }

            System.out.println("Ingrese la hora de llegada en el siguiente formato HH:mm");
            try {
                String hora = entrada.nextLine();
                if (hora.contains(":")) {
                    String[] split = hora.split(":");
                    if (split[0].length() <= 1) {
                        if (split[1].length() <= 1) {
                            paciente.setHora_llegada(hora);
                        } else {
                            System.out.println("Formato de minutos ingresado no es valido.");
                            return;
                        }
                    } else {
                        System.out.println("Formato de horas ingresado no es valido.");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Cadena de nombre ingresado no valida, abortando.");
                return;
            }

            if (primerPaciente == null) {
                primerPaciente = paciente;
                primerPaciente.setSiguiente(null);
            } else {
                ultimoPaciente.setSiguiente(paciente);
                paciente.setSiguiente(null);
            }
            ultimoPaciente = paciente;

            switch (paciente.getNivel_urgencia()) {
                case 1: {
                    consultaMedicaList.insertarPaciente(paciente);
                    System.out.println("Paciente correctamente agregado, corresponde a un nivel de urgencia de consulta.");
                    break;
                }
                case 5: {
                    emergenciaList.insertarPaciente(paciente);
                    System.out.println("Paciente correctamente agregado, corresponde a un nivel de urgencia de emergencia.");
                    break;
                }
            }
        } else {
            System.out.println("El paciente con el ID: " + id + " ya existe.");
        }
    }

    public Paciente obtenerPaciente(int id) {
        Paciente aux = primerPaciente;
        boolean existe = false;
        if (primerPaciente != null) {
            while (aux != null && !existe) {
                if (aux.getId_paciente() == id) {
                    return aux;
                }
                if (!existe) {
                    aux = aux.getSiguiente();
                }
            }
        } else {
            return null;
        }

        return null;
    }

}
