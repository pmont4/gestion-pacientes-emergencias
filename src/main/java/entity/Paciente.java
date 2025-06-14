package entity;

public class Paciente {

    private int id_paciente;
    private String nombre_paciente;
    private int nivel_urgencia;
    private String hora_llegada;

    private Paciente siguiente;

    public Paciente() {}

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public int getNivel_urgencia() {
        return nivel_urgencia;
    }

    public void setNivel_urgencia(int nivel_urgencia) {
        this.nivel_urgencia = nivel_urgencia;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public Paciente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Paciente siguiente) {
        this.siguiente = siguiente;
    }

}
