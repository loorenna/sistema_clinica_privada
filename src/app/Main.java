package app;

import modelo.Administrativo;
import modelo.Empleado;
import modelo.Medico;
import servicio.EmpleadoServicio;
import util.Validador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmpleadoServicio servicio = new EmpleadoServicio();

        int opcion = 0;

        do {

            System.out.println("\n===== CLÍNICA SALUD TOTAL =====");
            System.out.println("1. Registrar médico");
            System.out.println("2. Registrar administrativo");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Buscar por cédula");
            System.out.println("5. Reemplazar información");
            System.out.println("6. Eliminar registro");
            System.out.println("7. Calcular pagos");
            System.out.println("8. Mostrar estadísticas");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            try {

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:

                        System.out.println("\n===== REGISTRO MÉDICO =====");

                        System.out.print("Cédula: ");
                        String cedulaMedico = sc.nextLine();

                        if (servicio.cedulaExiste(cedulaMedico)) {
                            System.out.println("Error: cédula repetida.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombreMedico = sc.nextLine();

                        if (Validador.textoVacio(nombreMedico)) {
                            System.out.println("Nombre inválido.");
                            break;
                        }

                        System.out.print("Edad: ");
                        int edadMedico = Integer.parseInt(sc.nextLine());

                        if (!Validador.edadValida(edadMedico)) {
                            System.out.println("Edad inválida.");
                            break;
                        }

                        System.out.print("Teléfono: ");
                        String telefonoMedico = sc.nextLine();

                        if (!Validador.telefonoValido(telefonoMedico)) {
                            System.out.println("Teléfono inválido.");
                            break;
                        }

                        System.out.print("Correo: ");
                        String correoMedico = sc.nextLine();

                        if (!Validador.correoValido(correoMedico)) {
                            System.out.println("Correo inválido.");
                            break;
                        }

                        System.out.print("Especialidad: ");
                        String especialidad = sc.nextLine();

                        if (Validador.textoVacio(especialidad)) {
                            System.out.println("Especialidad inválida.");
                            break;
                        }

                        System.out.print("Pacientes atendidos: ");
                        int pacientes = Integer.parseInt(sc.nextLine());

                        if (!Validador.numeroMayorCero(pacientes)) {
                            System.out.println("Cantidad inválida.");
                            break;
                        }

                        System.out.print("Valor consulta: ");
                        double valorConsulta = Double.parseDouble(sc.nextLine());

                        if (!Validador.numeroMayorCero(valorConsulta)) {
                            System.out.println("Valor inválido.");
                            break;
                        }

                        Medico medico = new Medico(
                                cedulaMedico,
                                nombreMedico,
                                edadMedico,
                                telefonoMedico,
                                correoMedico,
                                especialidad,
                                pacientes,
                                valorConsulta
                        );

                        servicio.registrarEmpleado(medico);

                        break;

                    case 2:

                        System.out.println("\n===== REGISTRO ADMINISTRATIVO =====");

                        System.out.print("Cédula: ");
                        String cedulaAdmin = sc.nextLine();

                        if (servicio.cedulaExiste(cedulaAdmin)) {
                            System.out.println("Error: cédula repetida.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombreAdmin = sc.nextLine();

                        if (Validador.textoVacio(nombreAdmin)) {
                            System.out.println("Nombre inválido.");
                            break;
                        }

                        System.out.print("Edad: ");
                        int edadAdmin = Integer.parseInt(sc.nextLine());

                        if (!Validador.edadValida(edadAdmin)) {
                            System.out.println("Edad inválida.");
                            break;
                        }

                        System.out.print("Teléfono: ");
                        String telefonoAdmin = sc.nextLine();

                        if (!Validador.telefonoValido(telefonoAdmin)) {
                            System.out.println("Teléfono inválido.");
                            break;
                        }

                        System.out.print("Correo: ");
                        String correoAdmin = sc.nextLine();

                        if (!Validador.correoValido(correoAdmin)) {
                            System.out.println("Correo inválido.");
                            break;
                        }

                        System.out.print("Departamento: ");
                        String departamento = sc.nextLine();

                        if (Validador.textoVacio(departamento)) {
                            System.out.println("Departamento inválido.");
                            break;
                        }

                        System.out.print("Horas trabajadas: ");
                        double horas = Double.parseDouble(sc.nextLine());

                        if (!Validador.numeroMayorCero(horas)) {
                            System.out.println("Horas inválidas.");
                            break;
                        }

                        System.out.print("Valor por hora: ");
                        double valorHora = Double.parseDouble(sc.nextLine());

                        if (!Validador.numeroMayorCero(valorHora)) {
                            System.out.println("Valor inválido.");
                            break;
                        }

                        Administrativo administrativo = new Administrativo(
                                cedulaAdmin,
                                nombreAdmin,
                                edadAdmin,
                                telefonoAdmin,
                                correoAdmin,
                                departamento,
                                horas,
                                valorHora
                        );

                        servicio.registrarEmpleado(administrativo);

                        break;

                    case 3:

                        servicio.mostrarEmpleados();

                        break;

                    case 4:

                        System.out.print("Ingrese cédula a buscar: ");
                        String buscarCedula = sc.nextLine();

                        Empleado encontrado = servicio.buscarPorCedula(buscarCedula);

                        if (encontrado != null) {
                            encontrado.mostrarInformacion();
                        } else {
                            System.out.println("Registro no encontrado.");
                        }

                        break;

                    case 5:

                        System.out.print("Ingrese cédula del empleado a reemplazar: ");
                        String cedulaReemplazo = sc.nextLine();

                        Empleado empleadoExiste = servicio.buscarPorCedula(cedulaReemplazo);

                        if (empleadoExiste == null) {
                            System.out.println("Empleado no encontrado.");
                            break;
                        }

                        System.out.println("Seleccione tipo:");
                        System.out.println("1. Médico");
                        System.out.println("2. Administrativo");

                        int tipo = Integer.parseInt(sc.nextLine());

                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();

                        System.out.print("Nueva edad: ");
                        int nuevaEdad = Integer.parseInt(sc.nextLine());

                        System.out.print("Nuevo teléfono: ");
                        String nuevoTelefono = sc.nextLine();

                        System.out.print("Nuevo correo: ");
                        String nuevoCorreo = sc.nextLine();

                        if (tipo == 1) {

                            System.out.print("Especialidad: ");
                            String nuevaEspecialidad = sc.nextLine();

                            System.out.print("Pacientes atendidos: ");
                            int nuevosPacientes = Integer.parseInt(sc.nextLine());

                            System.out.print("Valor consulta: ");
                            double nuevoValorConsulta = Double.parseDouble(sc.nextLine());

                            Medico nuevoMedico = new Medico(
                                    cedulaReemplazo,
                                    nuevoNombre,
                                    nuevaEdad,
                                    nuevoTelefono,
                                    nuevoCorreo,
                                    nuevaEspecialidad,
                                    nuevosPacientes,
                                    nuevoValorConsulta
                            );

                            servicio.reemplazarEmpleado(cedulaReemplazo, nuevoMedico);

                        } else {

                            System.out.print("Departamento: ");
                            String nuevoDepartamento = sc.nextLine();

                            System.out.print("Horas trabajadas: ");
                            double nuevasHoras = Double.parseDouble(sc.nextLine());

                            System.out.print("Valor hora: ");
                            double nuevoValorHora = Double.parseDouble(sc.nextLine());

                            Administrativo nuevoAdmin = new Administrativo(
                                    cedulaReemplazo,
                                    nuevoNombre,
                                    nuevaEdad,
                                    nuevoTelefono,
                                    nuevoCorreo,
                                    nuevoDepartamento,
                                    nuevasHoras,
                                    nuevoValorHora
                            );

                            servicio.reemplazarEmpleado(cedulaReemplazo, nuevoAdmin);
                        }

                        System.out.println("Empleado actualizado.");

                        break;

                    case 6:

                        System.out.print("Ingrese cédula a eliminar: ");
                        String eliminarCedula = sc.nextLine();

                        if (servicio.eliminarEmpleado(eliminarCedula)) {
                            System.out.println("Empleado eliminado.");
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }

                        break;

                    case 7:

                        servicio.calcularPagos();

                        break;

                    case 8:

                        servicio.mostrarEstadisticas();

                        break;

                    case 9:

                        System.out.println("Saliendo del sistema...");

                        break;

                    default:

                        System.out.println("Error: opción inválida.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Error: debe ingresar valores numéricos válidos.");

            } catch (Exception e) {

                System.out.println("Ocurrió un error: " + e.getMessage());
            }

        } while (opcion != 9);

        sc.close();
    }
}