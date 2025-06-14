package list;

import entity.Paciente;

import java.util.Scanner;

public class PacienteList {

    private Paciente primerPaciente = null;
    private Paciente ultimoPaciente = null;

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
                String nombre = entrada.next();
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
                String hora = entrada.next();
                if (hora.contains(":")) {
                    String[] split = hora.split(":");
                    if (split[0].length() == 2) {
                        if (split[1].length() == 2) {
                            paciente.setHora_llegada(hora);
                        } else {
                            System.out.println("Formato de minutos ingresado no es valido.");
                            return;
                        }
                    } else {
                        System.out.println(split[0].length());
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

    public void mostrarPacientes() {
        Paciente aux = primerPaciente;
        if (primerPaciente != null) {
            while (aux != null) {
                System.out.println("\nID paciente: " + aux.getId_paciente() + "\nNombre: " + aux.getNombre_paciente() + "\nNivel de urgencia: " + aux.getNivel_urgencia() + "\nHora de llegada: " + aux.getHora_llegada());
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("No se han registrado pacientes.");
        }
    }

    public void atenderPaciente() {
        if (primerPaciente != null) {
            System.out.println("Se atendera ahora al paciente: " + primerPaciente.getNombre_paciente());
            primerPaciente = primerPaciente.getSiguiente();
        } else {
            System.out.println("No hay pacientes para atender.");
        }
    }

    public void eliminarPaciente(Scanner entrada) {
        Paciente aux = primerPaciente;
        Paciente lstPaciente = null;
        Scanner scn = new Scanner(System.in);
        boolean exists = false;
        System.out.println("Ingrese el ID del paciente que desea eliminar: ");
        int id = scn.nextInt();
        if (primerPaciente != null) {
            while (aux != null && !exists) {
                if (aux.getId_paciente() == id) {
                    if (aux == primerPaciente) {
                        primerPaciente = primerPaciente.getSiguiente();
                    } else if (aux == ultimoPaciente) {
                        lstPaciente.setSiguiente(null);
                        ultimoPaciente = lstPaciente.getSiguiente();
                    } else {
                        lstPaciente.setSiguiente(aux.getSiguiente());
                    }
                    System.out.println("El paciente fue correctamente eliminado");
                    exists = true;
                }
                lstPaciente = aux;
                aux = aux.getSiguiente();
            }
            if (!exists) {
                System.out.println("No existe ningun paciente con ese ID en la lista");

            }
        } else {
            System.out.println("No existen elementos para eliminar en la lista.");
        }
    }

    public int cantidadPacientes() {
        int size = 0;
        Paciente aux = primerPaciente;
        if (primerPaciente != null) {
            while (aux != null) {
                size++;
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("No se han registrado pacientes.");
        }
        return size;
    }

}
