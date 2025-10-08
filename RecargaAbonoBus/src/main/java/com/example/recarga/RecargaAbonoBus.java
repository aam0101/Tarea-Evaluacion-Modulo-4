package com.example.recarga;

import com.toedter.calendar.JMonthChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RecargaAbonoBus {

    private JPanel rootPanel;      // bound in .form
    private JTextField txtCard;    // bound in .form
    private JMonthChooser monthChooser; // bound in .form
    private JComboBox<String> cmbAmount; // bound in .form
    private JButton btnRecargar;   // bound in .form
    private JButton btnCancelar;   // bound in .form
    private JLabel lblStatus;      // bound in .form

    public RecargaAbonoBus() {
        initActions();
    }

    private void initActions() {
        btnRecargar.addActionListener(e -> onRecargar());
        btnCancelar.addActionListener(e -> onCancelar());

        // 🔧 FIX: posponemos la asignación del botón por defecto
        SwingUtilities.invokeLater(() -> {
            JRootPane root = SwingUtilities.getRootPane(btnRecargar);
            if (root != null) {
                root.setDefaultButton(btnRecargar);
            }
        });
    }

    private void onRecargar() {
        String card = txtCard.getText() != null ? txtCard.getText().trim() : "";
        Object amount = cmbAmount.getSelectedItem();
        int month = monthChooser.getMonth(); // 0..11

        if (card.isEmpty()) {
            JOptionPane.showMessageDialog(rootPanel, "Introduce el número de tarjeta.", "Falta dato", JOptionPane.WARNING_MESSAGE);
            txtCard.requestFocus();
            return;
        }
        if (amount == null) {
            JOptionPane.showMessageDialog(rootPanel, "Selecciona un importe.", "Falta dato", JOptionPane.WARNING_MESSAGE);
            cmbAmount.requestFocus();
            return;
        }

        int ok = JOptionPane.showConfirmDialog(rootPanel,
                String.format("Confirmar recarga:%nTarjeta: %s%nMes: %s%nImporte: %s", card, monthName(month), amount),
                "Confirmación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (ok == JOptionPane.OK_OPTION) {
            // Simulación de recarga
            lblStatus.setText("Recarga realizada correctamente.");
            JOptionPane.showMessageDialog(rootPanel, "¡Recarga completada!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lblStatus.setText("Recarga cancelada.");
        }
    }

    private void onCancelar() {
        Window window = SwingUtilities.getWindowAncestor(rootPanel);
        if (window != null) {
            int ok = JOptionPane.showConfirmDialog(rootPanel, "¿Salir de la aplicación?", "Confirmar salida",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (ok == JOptionPane.OK_OPTION) {
                window.dispose();
            }
        }
    }

    private static String monthName(int zeroBased) {
        String[] es = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        if (zeroBased >= 0 && zeroBased < es.length) return es[zeroBased];
        return "Mes";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Recarga Abono Bus");
            RecargaAbonoBus app = new RecargaAbonoBus();
            frame.setContentPane(app.rootPanel);
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            frame.setMinimumSize(new Dimension(520, 360));
            frame.setLocationRelativeTo(null);

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    app.onCancelar();
                }
            });

            // ✅ Aquí también podrías poner el botón por defecto
            frame.getRootPane().setDefaultButton(app.btnRecargar);

            frame.setVisible(true);
        });
    }
}
