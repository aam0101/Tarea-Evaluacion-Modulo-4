import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * BonoTren.java
 * Interfaz de recarga de abono para Tren.
 * - No usa JCalendar ni librerías externas.
 * - Selector de mes con JComboBox.
 * - Validación básica del nº de tarjeta.
 * - Tooltip en botones.
 * - Confirmación al cerrar la ventana.
 */
public class Bono {

    public static void main(String[] args) {
        // Ejecutar en hilo de eventos
        SwingUtilities.invokeLater(() -> {
            new Bono().createAndShowGui();
        });
    }

    private JFrame frame;
    private JPanel panelPrincipal;
    private JTextField tfNumeroTarjeta;
    private JComboBox<String> cbMes;
    private JComboBox<String> cbImporte;
    private JButton btnRecargar;
    private JButton btnCancelar;

    private static final String[] MESES_ES = {
            "Enero","Febrero","Marzo","Abril","Mayo","Junio",
            "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"
    };

    private void createAndShowGui() {
        frame = new JFrame("Recarga Abono - Tren");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmarYCerrar();
            }
        });

        panelPrincipal = new JPanel(new BorderLayout(12, 12));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        // Panel izquierdo con logo
        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(createTrainIcon(180, 140))); // icono generado
        lblLogo.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        JPanel left = new JPanel(new GridBagLayout());
        left.setOpaque(false);
        left.add(lblLogo);

        // Panel derecho con formulario
        JPanel right = new JPanel(new GridBagLayout());
        right.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título (centrado a la derecha)
        JLabel lblTitulo = new JLabel("Recarga de Abono - Tren");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 20f));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        right.add(lblTitulo, gbc);

        // Subtítulo/explicación
        gbc.gridy++;
        JLabel lblSub = new JLabel("Seleccione el mes para recargar su abono:");
        lblSub.setFont(lblSub.getFont().deriveFont(13f));
        right.add(lblSub, gbc);

        // Nº Tarjeta
        gbc.gridy++;
        gbc.gridwidth = 1;
        right.add(new JLabel("Nº Tarjeta:"), gbc);

        tfNumeroTarjeta = new JTextField();
        tfNumeroTarjeta.setToolTipText("Introduce el número de tarjeta (solo dígitos).");
        gbc.gridx = 1;
        right.add(tfNumeroTarjeta, gbc);

        // Mes
        gbc.gridy++;
        gbc.gridx = 0;
        right.add(new JLabel("Mes:"), gbc);

        cbMes = new JComboBox<>(MESES_ES);
        cbMes.setSelectedIndex(java.time.LocalDate.now().getMonthValue()-1); // mes actual por defecto
        cbMes.setToolTipText("Elige el mes a recargar");
        gbc.gridx = 1;
        right.add(cbMes, gbc);

        // Importe
        gbc.gridy++;
        gbc.gridx = 0;
        right.add(new JLabel("Importe:"), gbc);

        String[] importes = {"10 €", "20 €", "30 €", "50 €"};
        cbImporte = new JComboBox<>(importes);
        cbImporte.setSelectedIndex(0);
        cbImporte.setToolTipText("Selecciona el importe a recargar");
        gbc.gridx = 1;
        right.add(cbImporte, gbc);

        // Barra separadora (opcional estética)
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JSeparator sep = new JSeparator();
        right.add(sep, gbc);

        // Botones
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        panelBotones.setOpaque(false);
        btnRecargar = new JButton("Recargar Abono");
        btnRecargar.setToolTipText("Pulsa para recargar el abono del mes seleccionado.");
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setToolTipText("Cerrar esta ventana sin recargar.");

        panelBotones.add(btnRecargar);
        panelBotones.add(btnCancelar);
        right.add(panelBotones, gbc);

        // Agregar left y right al principal
        panelPrincipal.add(left, BorderLayout.WEST);
        panelPrincipal.add(right, BorderLayout.CENTER);

        // Listeners
        btnRecargar.addActionListener(e -> accionRecargar());
        btnCancelar.addActionListener(e -> confirmarYCerrar());

        // Mostrar ventana
        frame.setContentPane(panelPrincipal);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Acción del botón Recargar
    private void accionRecargar() {
        String numero = tfNumeroTarjeta.getText().trim();

        // Validaciones
        if (numero.isEmpty()) {
            mostrarError("El número de tarjeta es obligatorio.");
            tfNumeroTarjeta.requestFocus();
            return;
        }
        if (!numero.matches("\\d+")) {
            mostrarError("El número de tarjeta debe contener solo dígitos.");
            tfNumeroTarjeta.requestFocus();
            return;
        }
        if (numero.length() < 5) {
            mostrarError("El número de tarjeta parece demasiado corto.");
            tfNumeroTarjeta.requestFocus();
            return;
        }

        String mes = (String) cbMes.getSelectedItem();
        String importe = (String) cbImporte.getSelectedItem();

        int opcion = JOptionPane.showConfirmDialog(frame,
                "¿Confirmas recargar " + importe + " para el mes de " + mes + "?",
                "Confirmar recarga",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            // Éxito (aquí iría la lógica real)
            JOptionPane.showMessageDialog(frame,
                    "Su abono de transporte ha sido recargado para el mes de: " + mes + ".",
                    "Recarga realizada",
                    JOptionPane.INFORMATION_MESSAGE);
            // limpiar campos
            tfNumeroTarjeta.setText("");
            cbMes.setSelectedIndex(java.time.LocalDate.now().getMonthValue()-1);
            cbImporte.setSelectedIndex(0);
        }
    }

    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(frame, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Confirmación al cerrar
    private void confirmarYCerrar() {
        int res = JOptionPane.showConfirmDialog(frame,
                "¿Seguro que quieres cerrar la ventana? Se perderán los datos no guardados.",
                "Confirmar cierre",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            frame.dispose();
        }
    }

    // Genera un icono simple tipo "tren" para evitar depender de ficheros externos.
    private Image createTrainIcon(int width, int height) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        // Fondo blanco con borde
        g.setColor(new Color(255,255,255));
        g.fillRoundRect(0,0,width,height,16,16);
        g.setColor(new Color(200,200,200));
        g.drawRoundRect(0,0,width-1,height-1,16,16);

        // Dibujar una locomotora simplificada
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int bw = width - 40;
        int bh = height - 60;
        int x = 20;
        int y = 20;

        // Cuerpo
        g.setColor(new Color(70,130,180)); // azul
        g.fillRoundRect(x, y+20, bw, bh-10, 10, 10);

        // Cabina
        g.setColor(new Color(40,90,140));
        g.fillRect(x + bw - 50, y, 50, 40);

        // Ventana
        g.setColor(new Color(220,240,255));
        g.fillRect(x + bw - 42, y+6, 34, 24);

        // Ruedas
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x+12, y+bh-4, 28, 28);
        g.fillOval(x+bw-46, y+bh-4, 28, 28);

        // Detalle frontal
        g.setColor(new Color(255, 215, 0));
        g.fillRect(x-8, y+30, 12, 10);

        // Texto pequeño "TREN"
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 18));
        g.drawString("TREN", x + 8, y + bh/2 + 6);

        g.dispose();
        return img;
    }
}
