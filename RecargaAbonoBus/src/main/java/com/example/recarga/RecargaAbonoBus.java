package com.example.recarga;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import com.toedter.calendar.JMonthChooser;

/**
 * RecargaAbonoBus (IntelliJ GUI Designer .form)
 * 
 * Abre el .form en el GUI Designer y ajusta visualmente los componentes.
 * Para ejecutar desde IntelliJ: Run 'RecargaAbonoBus.main()'.
 * Nota: La instrumentación del .form la hace IntelliJ al compilar desde el IDE.
 */
public class RecargaAbonoBus extends JFrame {

    // --- Campos enlazados desde el .form (bindings) ---
    private JPanel rootPanel;
    private JLabel lblInstruccion;
    private JMonthChooser monthChooser;
    private JCheckBox chkConfirm;
    private JButton btnRecargar;

    public RecargaAbonoBus() {
        setTitle("Recarga de Abono - Bus");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(createCircleIcon(64, new Color(0x1E,0x88,0xE5), "B").getImage());

        // El contenido se inyecta por el código generado del .form
        setContentPane(rootPanel);
        attachEvents();
        pack();
        setLocationRelativeTo(null);
    }

    private void attachEvents() {
        // Confirmación al cerrar ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        RecargaAbonoBus.this,
                        "¿Seguro que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (option == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // Acción del botón Recargar
        btnRecargar.setToolTipText("Haz clic para recargar tu abono mensual de bus");
        btnRecargar.addActionListener(e -> {
            if (!chkConfirm.isSelected()) {
                JOptionPane.showMessageDialog(
                        RecargaAbonoBus.this,
                        "Por favor, marca la casilla de confirmación antes de recargar.",
                        "Validación requerida",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int idx = monthChooser.getMonth(); // 0..11
            String[] meses = {
                    "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
            };
            String mes = (idx >= 0 && idx < 12) ? meses[idx] : "Mes desconocido";

            JOptionPane.showMessageDialog(
                    RecargaAbonoBus.this,
                    "Su abono de bus ha sido recargado para el mes de: " + mes + ".",
                    "Recarga completada",
                    JOptionPane.INFORMATION_MESSAGE,
                    createCircleIcon(24, new Color(0x1E,0x88,0xE5), "B")
            );
        });
    }

    /** Icono circular con letra centrada (B). */
    private static ImageIcon createCircleIcon(int size, Color color, String letter) {
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        try {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(color);
            g.fillOval(0, 0, size, size);

            g.setColor(Color.WHITE);
            Font font = new Font("SansSerif", Font.BOLD, Math.max(12, (int)(size * 0.5)));
            g.setFont(font);
            FontMetrics fm = g.getFontMetrics();
            int textW = fm.stringWidth(letter);
            int textH = fm.getAscent();
            int x = (size - textW) / 2;
            int y = (size + textH) / 2 - 4;
            g.drawString(letter, x, y);
        } finally {
            g.dispose();
        }
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecargaAbonoBus frame = new RecargaAbonoBus();
            frame.setMinimumSize(new Dimension(420, 180));
            frame.setVisible(true);
        });
    }
}
