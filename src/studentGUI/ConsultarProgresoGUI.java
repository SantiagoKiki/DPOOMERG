package studentGUI;


import controller.StudentController;
import tracker.ProgressTracker;

import javax.swing.*;
import java.awt.*;

public class ConsultarProgresoGUI {
    private JFrame frame;

    public ConsultarProgresoGUI(StudentController studentController) {
        // Configuración inicial de la ventana
        frame = new JFrame("Consultar Progreso");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("Consultar Progreso de un Learning Path", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Verificar si hay Learning Paths inscritos
        if (studentController.getStudent().getProgressTrackers().isEmpty()) {
            JLabel noLPLabel = new JLabel("No tienes Learning Paths inscritos actualmente.");
            noLPLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            noLPLabel.setForeground(Color.RED);
            mainPanel.add(noLPLabel);
        } else {
            // ComboBox para seleccionar un Learning Path
            JLabel lpLabel = new JLabel("Selecciona un Learning Path:");
            JComboBox<String> lpComboBox = new JComboBox<>();
            for (ProgressTracker tracker : studentController.getStudent().getProgressTrackers()) {
                lpComboBox.addItem(tracker.getLearningpath().getTitle());
            }
            mainPanel.add(lpLabel);
            mainPanel.add(lpComboBox);

            // Panel de progreso
            JPanel progressPanel = new JPanel();
            progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.Y_AXIS));
            progressPanel.setBorder(BorderFactory.createTitledBorder("Detalles de Progreso"));
            JLabel progressLabel = new JLabel();
            JTextArea progressDetails = new JTextArea();
            progressDetails.setEditable(false);
            progressDetails.setFont(new Font("Monospaced", Font.PLAIN, 12));
            progressDetails.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            progressPanel.add(progressLabel);
            progressPanel.add(new JScrollPane(progressDetails));

            // Mostrar progreso al seleccionar un Learning Path
            lpComboBox.addActionListener(e -> {
                int selectedIndex = lpComboBox.getSelectedIndex();
                if (selectedIndex >= 0) {
                    ProgressTracker selectedTracker = studentController.getStudent().getProgressTrackers().get(selectedIndex);

                    // Mostrar progreso general
                    double progressPercentage = selectedTracker.getProgress();
                    progressLabel.setText("Progreso: " + String.format("%.2f", progressPercentage) + "%");

                    // Mostrar actividades completadas y pendientes
                    StringBuilder details = new StringBuilder();
                    details.append("Actividades completadas:\n");
                  
                    progressDetails.setText(details.toString());
                }
            });

            mainPanel.add(progressPanel);
        }

        frame.add(mainPanel, BorderLayout.CENTER);

        // Mostrar ventana
        frame.setVisible(true);
    }
}
