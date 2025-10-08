# Recarga Abono Bus GUI (.form, IntelliJ)

Proyecto **Maven** con **IntelliJ GUI Designer (.form)** para una interfaz Swing de recarga de abono **solo Bus**.

## Requisitos
- IntelliJ IDEA (tienes 2025.2.1 CE con `com.intellij.uiDesigner` 👍)
- JDK 8+
- Maven 3+

## Abrir y ejecutar en IntelliJ
1. **File → Open...** y selecciona la carpeta del proyecto.
2. Espera a que se indexe y se descarguen dependencias Maven.
3. Abre `RecargaAbonoBus.form` para ver/editar el diseño con el GUI Designer (drag & drop).
4. Ejecuta `RecargaAbonoBus.main()` (click derecho → Run).

> **Nota importante:** La instrumentación del `.form` la realiza IntelliJ al compilar desde el IDE. Si intentas ejecutar **desde la consola con Maven** sin IntelliJ, el formulario no se generará automáticamente.

## Dependencias
- `com.toedter:jcalendar:1.4` (para `JMonthChooser`).

## ¿Qué incluye la UI?
- `JLabel`: “Seleccione el mes para recargar su abono:”
- `JMonthChooser` (componente de JCalendar)
- `JCheckBox`: “Confirmo que los datos son correctos”
- `JButton`: “Recargar Abono” con tooltip
- Layout Grid (GUI Designer) y lógica en `RecargaAbonoBus.java`:
  - Validación de la casilla antes de recargar
  - `JOptionPane` confirmando en español el **mes seleccionado**
  - Confirmación al cerrar la ventana

¡Listo para que lo modifiques a tu gusto con el diseñador visual!
