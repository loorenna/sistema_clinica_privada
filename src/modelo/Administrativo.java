package modelo;

public class Administrativo extends Empleado {

    private String departamento;
    private double horasTrabajadas;
    private double valorHora;

    public Administrativo(String cedula, String nombre, int edad, String telefono, String correo,
                          String departamento, double horasTrabajadas, double valorHora) {
        super(cedula, nombre, edad, telefono, correo);
        this.departamento = departamento;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    @Override
    public double calcularPago() {
        return horasTrabajadas * valorHora;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("----- ADMINISTRATIVO -----");
        super.mostrarInformacion();
        System.out.println("Departamento: " + departamento);
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Valor por hora: " + valorHora);
        System.out.println("Pago total: " + calcularPago());
    }
}