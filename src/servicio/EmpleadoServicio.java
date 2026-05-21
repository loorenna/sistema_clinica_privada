package servicio;

import modelo.Administrativo;
import modelo.Empleado;
import modelo.Medico;

import java.util.ArrayList;

public class EmpleadoServicio {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public boolean cedulaExiste(String cedula) {
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    public void registrarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado registrado correctamente.");
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No existen empleados registrados.");
            return;
        }

        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            System.out.println("--------------------------");
        }
    }

    public Empleado buscarPorCedula(String cedula) {
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(String cedula) {
        Empleado empleado = buscarPorCedula(cedula);

        if (empleado != null) {
            empleados.remove(empleado);
            return true;
        }

        return false;
    }

    public boolean reemplazarEmpleado(String cedula, Empleado nuevoEmpleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCedula().equals(cedula)) {
                empleados.set(i, nuevoEmpleado);
                return true;
            }
        }

        return false;
    }

    public void calcularPagos() {
        if (empleados.isEmpty()) {
            System.out.println("No existen empleados para calcular pagos.");
            return;
        }

        for (Empleado empleado : empleados) {
            System.out.println("Empleado: " + empleado.getNombre());
            System.out.println("Pago: " + empleado.calcularPago());
            System.out.println("--------------------------");
        }
    }

    public void mostrarEstadisticas() {
        int totalMedicos = 0;
        int totalAdministrativos = 0;
        double pagoTotalMedicos = 0;
        double pagoTotalAdministrativos = 0;
        Empleado empleadoMayorIngreso = null;

        for (Empleado empleado : empleados) {
            if (empleado instanceof Medico) {
                totalMedicos++;
                pagoTotalMedicos += empleado.calcularPago();
            } else if (empleado instanceof Administrativo) {
                totalAdministrativos++;
                pagoTotalAdministrativos += empleado.calcularPago();
            }

            if (empleadoMayorIngreso == null || empleado.calcularPago() > empleadoMayorIngreso.calcularPago()) {
                empleadoMayorIngreso = empleado;
            }
        }

        System.out.println("===== ESTADÍSTICAS =====");
        System.out.println("Total médicos: " + totalMedicos);
        System.out.println("Total administrativos: " + totalAdministrativos);
        System.out.println("Total empleados: " + empleados.size());
        System.out.println("Pago total médicos: " + pagoTotalMedicos);
        System.out.println("Pago total administrativos: " + pagoTotalAdministrativos);

        if (empleadoMayorIngreso != null) {
            System.out.println("Empleado con mayor ingreso: " + empleadoMayorIngreso.getNombre());
            System.out.println("Ingreso: " + empleadoMayorIngreso.calcularPago());
        } else {
            System.out.println("No existen empleados registrados.");
        }
    }
}