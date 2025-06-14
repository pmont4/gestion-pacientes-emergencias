package list;

import entity.Paciente;

public class ConsultaMedicaList {

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

}
