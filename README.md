# Sistema de Gestión de Personal - Clínica Salud Total

## Descripción
Sistema desarrollado en Java para gestionar el personal de una clínica privada.

El sistema permite:
- Registrar médicos
- Registrar administrativos
- Mostrar empleados
- Buscar por cédula
- Reemplazar información
- Eliminar registros
- Calcular pagos
- Mostrar estadísticas

---

# Funcionalidades

## RF01 Registrar médicos
Permite registrar médicos con sus datos personales y laborales.

## RF02 Registrar administrativos
Permite registrar personal administrativo.

## RF03 Mostrar registros
Muestra todos los empleados registrados.

## RF04 Buscar por cédula
Busca empleados mediante la cédula.

## RF05 Reemplazar información
Permite actualizar información de empleados.

## RF06 Eliminar registros
Permite eliminar empleados registrados.

## RF07 Calcular pagos
Calcula pagos de médicos y administrativos.

## RF08 Mostrar estadísticas
Muestra estadísticas generales del sistema.

## RF09 Salir
Finaliza la ejecución del sistema.

---

# Estructura del Proyecto

```text
src/
│
├── modelo/
│   ├── Empleado.java
│   ├── Medico.java
│   └── Administrativo.java
│
├── servicio/
│   └── EmpleadoServicio.java
│
├── util/
│   └── Validador.java
│
└── app/
    └── Main.java
```

---

# Programación Orientada a Objetos

## Herencia
Las clases `Medico` y `Administrativo` heredan de la clase padre `Empleado`.

---

## Encapsulamiento
Los atributos fueron declarados privados y se accede a ellos mediante getters.

---

## Polimorfismo
Se utilizó `ArrayList<Empleado>` para almacenar diferentes tipos de empleados.
Gracias al polimorfismo, el sistema puede manejar médicos y administrativos utilizando la misma referencia de tipo `Empleado`.

---

# Excepciones

Se aplicó manejo de excepciones utilizando:

- try
- catch

Para controlar errores en:

- menú
- conversiones
- datos numéricos
- búsquedas
- listas


---

# Conversiones

## Integer.parseInt()

Convierte texto a entero.


---

## Double.parseDouble()

Convierte texto a decimal.


---

# Validaciones

El sistema valida:

- edad válida
- teléfono numérico
- correo válido
- campos vacíos
- valores mayores a cero
- cédulas repetidas

---

# Estadísticas

El sistema muestra:

- total médicos
- total administrativos
- total empleados
- pago total médicos
- pago total administrativos
- empleado con mayor ingreso

---

# UML

El proyecto incluye diagrama UML con:

- herencia
- atributos
- métodos
- relaciones entre clases

---

# Tecnologías Utilizadas

- Java
- IntelliJ IDEA
- GitHub


---

# Requisitos

- IntelliJ IDEA o NetBeans

---

# Ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar el archivo `Main.java`.
3. Utilizar el menú del sistema.

---

# GitHub

El proyecto debe contener mínimo 5 commits.

---

# Autor

Alisson Quiguango