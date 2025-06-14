package list;

import entity.Paciente;

public class EmergenciaList {

    private Paciente primerPaciente = null;
    private Paciente ultimoPaciente = null;

    public void insertarPaciente(Paciente paciente) {
        if (primerPaciente == null) {
            primerPaciente = paciente;
            primerPaciente.setSiguiente(null);
        } else {
            ultimoPaciente.setSiguiente(paciente);
            paciente.setSiguiente(null);
        }
        ultimoPaciente = paciente;
    }

    public void mostrarPacientes() {
        Paciente aux = primerPaciente;
        if (primerPaciente != null) {
            while (aux != null) {
                System.out.println("ID paciente: " + aux.getId_paciente() + "\nNombre: " + aux.getNombre_paciente() + "\nNivel de urgencia: " + aux.getNivel_urgencia() + "\nHora de llegada: " + aux.getHora_llegada());
                aux = aux.getSiguiente();
            }
        }
    }

    public int sizeLista() {
        Paciente aux = primerPaciente;
        int size = 0;

        if (primerPaciente != null) {
            while (aux != null) {
                size++;
                aux = aux.getSiguiente();
            }
        }

        return size;
    }

    public void atender() {
        if (primerPaciente != null) {
            System.out.println("Se atendera ahora al paciente: " + primerPaciente.getNombre_paciente());
            primerPaciente = primerPaciente.getSiguiente();
        } else {
            System.out.println("No se han encontrado paciente para atender.");
        }
    }

}
