package Giaodien1;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JPanel panel;
    private JPanel tools;
    private JComboBox<String> predefinedColorsComboBox;
    private JLabel colorInfoLabel;

    public Frame() throws HeadlessException {
        super("PTIT COLOR PICKER");
        panel = new JPanel();
        tools = new JPanel();
        predefinedColorsComboBox = new JComboBox<>();
        colorInfoLabel = new JLabel("RGB: 255, 0, 0");

        setLayout(new BorderLayout());
        tools.add(new JLabel("Choose a color: "));
        add(panel, BorderLayout.CENTER);
        tools.setLayout(new FlowLayout());

        // ComboBox cho màu trước định
        predefinedColorsComboBox.addItem("Red");
        predefinedColorsComboBox.addItem("Orange");
        predefinedColorsComboBox.addItem("Yellow");
        predefinedColorsComboBox.addItem("Green");
        predefinedColorsComboBox.addItem("Blue");
        predefinedColorsComboBox.addItem("Indigo");
        predefinedColorsComboBox.addItem("Violet");
        predefinedColorsComboBox.addItem("Custom"); // Thêm tùy chọn "Custom"
        tools.add(predefinedColorsComboBox);
        tools.add(new JLabel("Or choose a custom color: "));

        // Thêm nút để mở JColorChooser
        JButton colorButton = new JButton("Choose Color");
        tools.add(colorButton);

        tools.add(colorInfoLabel);

        add(tools, BorderLayout.SOUTH);
        panel.setBackground(new Color(255, 0, 0));
        predefinedColorsComboBox.setBackground(new Color(200, 200, 200));
        predefinedColorsComboBox.setFont(new Font("Arial", Font.PLAIN, 16));

        predefinedColorsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Custom".equals(predefinedColorsComboBox.getSelectedItem())) {
                    // Xử lý chọn màu tùy chỉnh ở đây
                } else {
                    String selectedColor = predefinedColorsComboBox.getSelectedItem().toString();
                    switch (selectedColor) {
                        case "Red":
                            setColorInfoLabel(255, 0, 0);
                            break;
                        case "Orange":
                            setColorInfoLabel(255, 142, 0);
                            break;
                        case "Yellow":
                            setColorInfoLabel(255, 255, 0);
                            break;
                        case "Green":
                            setColorInfoLabel(0, 142, 0);
                            break;
                        case "Blue":
                            setColorInfoLabel(0, 192, 192);
                            break;
                        case "Indigo":
                            setColorInfoLabel(64, 0, 152);
                            break;
                        case "Violet":
                            setColorInfoLabel(142, 0, 142);
                            break;
                    }
                }
            }
        });

        // Xử lý sự kiện cho nút mở JColorChooser
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorChooser = new JColorChooser(panel.getBackground());
                AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
                for (AbstractColorChooserPanel panel : panels) {
                    if (!panel.getDisplayName().equals("RGB")) {
                        colorChooser.removeChooserPanel(panel);
                    }
                }
                int result = JOptionPane.showConfirmDialog(null, colorChooser, "Choose Color", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    Color selectedColor = colorChooser.getColor();
                    int red = selectedColor.getRed();
                    int green = selectedColor.getGreen();
                    int blue = selectedColor.getBlue();
                    setColorInfoLabel(red, green, blue);
                }
            }
        });

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setColorInfoLabel(int r, int g, int b) {
        colorInfoLabel.setText("RGB: " + r + ", " + g + ", " + b);
        panel.setBackground(new Color(r, g, b));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Frame();
        });
    }
}
