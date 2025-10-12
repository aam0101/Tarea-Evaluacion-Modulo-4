# 🚍 Recarga de Abono de Transporte — Módulo **Bus**

> 💡 Proyecto desarrollado en **IntelliJ IDEA** con **Maven** y la interfaz creada mediante **GUI Designer (Swing Form)**.  
> Este módulo forma parte del proyecto “Recarga de Abono de Transporte”, que incluye también un módulo paralelo de **Tren** (desarrollado por otro compañero).

---

## 🎯 **Descripción del ejercicio**

El objetivo de este módulo es diseñar una **interfaz gráfica funcional y amigable** para la **recarga del abono mensual de transporte BUS**, utilizando los componentes de **Java Swing** y el selector de mes **`JMonthChooser`** de la librería **JCalendar**.

El usuario puede:
- Introducir el número de su tarjeta 💳  
- Seleccionar el mes del abono 🗓️  
- Elegir el importe de la recarga 💰  
- Confirmar la operación con un clic ✨  
---

## 📸 **Vista previa de la interfaz**

🪟 ![Vista previa](docs/interfaz_bus.png)

---

## 🎥 **Video de demostración**

Puedes ver el video completo del funcionamiento del programa aquí:  
👉 [Ver video en YouTube](https://www.youtube.com/watch?v=kEBTkxXAOrs)

> 🎬 En el video se muestra el proceso de introducción de datos, selección de mes e importe, validación de campos y mensaje final de confirmación mediante `JOptionPane`.

---

## 🧩 **Requisitos técnicos implementados**

| Requisito | Cumplido | Descripción |
|------------|:---------:|-------------|
| 🗓️ Uso de `JMonthChooser` | ✅ | Permite seleccionar el mes para recargar. |
| 🏷️ Etiquetas (`JLabel`) | ✅ | Indican los campos de tarjeta, mes e importe. |
| 🔘 Botones (`JButton`) | ✅ | “Recargar” y “Cancelar” con eventos asociados. |
| 💬 Cuadro de diálogo (`JOptionPane`) | ✅ | Confirma la recarga y muestra el mes seleccionado. |
| 🧮 Validación de campos | ✅ | Verifica que se haya introducido un número de tarjeta. |
| 💡 Tooltip | ✅ | Botón con ayuda contextual (“Recargar el abono seleccionado”). |
| 🔒 Confirmación al cerrar | ✅ | Ventana con aviso antes de salir. |
| 🖼️ Icono personalizado | ✅ | Icono de **bus** visible en la cabecera. |

---

## 🧠 **Funcionamiento**

1. El usuario introduce su número de tarjeta.
2. Selecciona el **mes** con el componente `JMonthChooser`.
3. Elige un importe de recarga desde el menú desplegable.
4. Pulsa **“Recargar”**.  
   → Aparece un `JOptionPane` confirmando la recarga, mostrando el **nombre del mes en español**.
5. Si intenta cerrar la ventana, el programa pedirá confirmación para salir.

---

## 🧱 **Estructura del proyecto**

```
RecargaAbonoBus/
├── pom.xml                           # Configuración Maven
├── README.md                         # Este archivo
└── src/
    └── main/
        ├── java/
        │   └── com/example/recarga/
        │       ├── RecargaAbonoBus.java   # Lógica principal y eventos
        │       └── RecargaAbonoBus.form   # Interfaz gráfica (GUI Designer)
        └── resources/
            └── icons/
                └── bus.png                # Icono del módulo Bus
```

---

## ⚙️ **Dependencias Maven**

Incluidas en el `pom.xml`:

```xml
<dependencies>
  <!-- Runtime para formularios creados con IntelliJ GUI Designer -->
  <dependency>
    <groupId>com.intellij</groupId>
    <artifactId>forms_rt</artifactId>
    <version>7.0.3</version>
  </dependency>

  <!-- Librería para el selector de mes (JMonthChooser) -->
  <dependency>
    <groupId>com.toedter</groupId>
    <artifactId>jcalendar</artifactId>
    <version>1.4</version>
  </dependency>
</dependencies>
```

---

## 🚀 **Cómo ejecutar**

1. Asegúrate de tener instalado:
   - ☕ **Java 8** o superior  
   - 🧰 **Maven 3.8+**
2. Abre el proyecto en **IntelliJ IDEA** (como proyecto Maven).
3. Ejecuta desde la terminal o desde IntelliJ:

```bash
mvn clean package
mvn exec:java -Dexec.mainClass=com.example.recarga.RecargaAbonoBus
```

---

## 🪄 **Características destacadas**

✨ **Diseño intuitivo:** interfaz clara, con márgenes equilibrados y disposición mediante `GridLayoutManager`.  
🧩 **Componentes Swing** usados correctamente (`JLabel`, `JButton`, `JTextField`, `JComboBox`, `JMonthChooser`).  
💬 **Interacción fluida:** validaciones y mensajes dinámicos.  
🔔 **Eventos de ventana (WindowListener):** confirmación antes de cerrar.  
🎨 **Iconografía personalizada:** `bus.png` como icono distintivo del módulo.  

---

## 🧠 **Ejemplo de flujo**

1️⃣ **El usuario abre la aplicación.**  
2️⃣ **Introduce su número de tarjeta** y selecciona el **mes de recarga**.  
3️⃣ Pulsa **“Recargar”** → aparece un cuadro de diálogo:  
> ✅ “Su abono de transporte ha sido recargado para el mes de: **Enero**.”  
4️⃣ El programa muestra el estado en pantalla y permite continuar o salir.

---

## 👨‍💻 **Autoría**

- 🧑‍💻 *Desarrollador del módulo Bus:* **[Alberto Alcalde Montero]**  
- 🚆 *Módulo Tren:* desarrollado por otro compañero (proyecto independiente).  
- 🧠 Proyecto realizado para la asignatura de **Desarrollo de interfaces**.  

---

## 🏁 **Estado del proyecto**

> ✅ Finalizado — módulo **Bus** totalmente funcional y validado.  
> 🚧 Módulo **Tren** en desarrollo por otro integrante del equipo.

---


## 💬 **Licencia**

Este proyecto se entrega con fines educativos.  
Libre para uso académico, modificación y aprendizaje. 🧩


---

# 🚆 Recarga de Abono de Transporte — Módulo **Tren**

> 💡 Proyecto desarrollado por **Alejandro Rolón** en **IntelliJ IDEA** con **Maven**, utilizando **Swing Form (GUI Designer)**.  
> Este módulo forma parte del proyecto “Recarga de Abono de Transporte”, junto al módulo de **Bus** realizado por otro compañero.

---

## 🎯 **Descripción del ejercicio**

El objetivo de este módulo es diseñar una **interfaz gráfica sencilla y funcional** para la **recarga del abono mensual de transporte TREN**, utilizando únicamente los componentes estándar de **Java Swing** (sin dependencias externas como `JCalendar`).

El usuario puede:
- Introducir el número de su tarjeta 💳  
- Elegir el mes de recarga mediante un **menú desplegable (JComboBox)** 🚉  
- Seleccionar el importe de la recarga 💰  
- Confirmar la operación con un clic ✨  

---

## 📸 **Vista previa de la interfaz**

🪟 ![Vista previa]([docs/interfaz_tren.png](https://github.com/aam0101/Tarea-Evaluacion-Modulo-4/blob/main/FotoTren/Captura%20de%20pantalla%202025-10-12%20220749.png))

---

## 🎥 **Video de demostración**

Puedes ver el video del funcionamiento del programa aquí:  
👉 [Ver video en YouTube](https://www.youtube.com/watch?v=dummy_enlace_tren)

> 🎬 En el video se muestra el proceso de introducción de datos, selección del mes e importe, validación de campos y mensaje final de confirmación con `JOptionPane`.

---

## 🧩 **Requisitos técnicos implementados**

| Requisito | Cumplido | Descripción |
|------------|:---------:|-------------|
| 🗓️ Selector de mes (`JComboBox`) | ✅ | Permite elegir el mes sin usar librerías externas. |
| 🏷️ Etiquetas (`JLabel`) | ✅ | Indican los campos de tarjeta, mes e importe. |
| 🔘 Botones (`JButton`) | ✅ | “Recargar” y “Cancelar” con eventos. |
| 💬 Cuadro de diálogo (`JOptionPane`) | ✅ | Confirma la recarga mostrando el mes elegido. |
| 🧮 Validación de campos | ✅ | Comprueba que se introduzca un número de tarjeta. |
| 💡 Tooltip | ✅ | Botones con ayuda contextual (“Recargar el abono seleccionado”). |
| 🔒 Confirmación al cerrar | ✅ | Aviso antes de salir de la aplicación. |
| 🖼️ Icono personalizado | ✅ | Icono de **tren** en la ventana principal. |

---

## 🧠 **Funcionamiento**

1. El usuario introduce su **número de tarjeta**.  
2. Selecciona el **mes** desde un `JComboBox` con los nombres de los meses.  
3. Elige el **importe de recarga**.  
4. Pulsa **“Recargar”**.  
   → Se muestra un `JOptionPane` confirmando la operación.  
5. Si el usuario intenta cerrar la ventana, aparece una alerta para confirmar la salida.

---

## 🧱 **Estructura del proyecto**

RecargaAbonoTren/
├── pom.xml # Configuración Maven
├── README.md # Este archivo
└── src/
└── main/
├── java/
│ └── com/example/recarga/
│ ├── RecargaAbonoTren.java # Lógica principal y eventos
│ └── RecargaAbonoTren.form # Interfaz creada en GUI Designer
└── resources/
└── icons/
└── tren.png # Icono del módulo Tren

php-template
Copiar código

---

## ⚙️ **Dependencias Maven**

Solo se utiliza la librería de soporte para formularios de IntelliJ:

```xml
<dependencies>
  <!-- Runtime necesario para formularios GUI de IntelliJ -->
  <dependency>
    <groupId>com.intellij</groupId>
    <artifactId>forms_rt</artifactId>
    <version>7.0.3</version>
  </dependency>
</dependencies>
🚀 Cómo ejecutar
Requisitos previos:

☕ Java 8 o superior

🧰 Maven 3.8+

Abre el proyecto en IntelliJ IDEA (como proyecto Maven).

Ejecuta desde IntelliJ o la terminal:

bash
Copiar código
mvn clean package
mvn exec:java -Dexec.mainClass=com.example.recarga.RecargaAbonoTren
🪄 Características destacadas
✨ Interfaz limpia: diseño equilibrado con GridLayoutManager y disposición clara.
🧩 Componentes Swing nativos: JLabel, JButton, JTextField, JComboBox.
💬 Interacción fluida: validaciones y mensajes dinámicos.
🔔 Eventos de ventana: aviso antes de cerrar la aplicación.
🎨 Iconografía personalizada: tren.png como distintivo del módulo.

🧠 Ejemplo de flujo
1️⃣ El usuario abre la aplicación.
2️⃣ Introduce el número de tarjeta y selecciona el mes.
3️⃣ Pulsa “Recargar”.

✅ “Su abono de transporte de Tren ha sido recargado para el mes de: Marzo.”
4️⃣ El mensaje confirma la operación y la aplicación continúa activa.

👨‍💻 Autoría
🚆 Desarrollador del módulo Tren: Alejandro Rolón

🚌 Módulo Bus: desarrollado por otro compañero.

🧠 Proyecto realizado para la asignatura de Desarrollo de Interfaces.

🏁 Estado del proyecto
✅ Finalizado — módulo Tren completamente funcional, probado y sin dependencias externas.

💬 Licencia
Proyecto educativo creado para fines académicos.
Libre para uso, modificación y aprendizaje. 🎓
