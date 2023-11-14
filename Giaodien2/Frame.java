package Giaodien2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Frame extends JFrame {
    private JComboBox<String> shapeComboBox;
    private JComboBox<String> fillTypeComboBox;
    private JTextField sidesField;
    private JButton updateButton;
    private JButton colorButton;
    private JPanel drawingPanel;
    private Color selectedColor;
    private JSlider sizeSlider; // Declare the sizeSlider

    private int shapeSize = 100;
    private int rectWidth = 100;
    private int rectHeight = 100;
    private JTextField widthTextField;
    private JTextField heightTextField;

    public Frame() {
        super("PTIT SHAPE PAINTER");
        setLayout(new BorderLayout());

        shapeComboBox = new JComboBox<>();
        shapeComboBox.addItem("Square");
        shapeComboBox.addItem("Rectangle");
        shapeComboBox.addItem("Circle");
        shapeComboBox.addItem("Polygon");
        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUIForSelectedShape();
                updateDrawing();
            }
        });

        fillTypeComboBox = new JComboBox<>();
        fillTypeComboBox.addItem("Solid");
        fillTypeComboBox.addItem("Outline");
        fillTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDrawing();
            }
        });

        sidesField = new JTextField("6", 4);
        updateButton = new JButton("Update Polygon");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSides();
            }
        });

        sizeSlider = new JSlider(JSlider.HORIZONTAL, 10, 300, 100);
        sizeSlider.setMajorTickSpacing(20);
        sizeSlider.setMinorTickSpacing(5);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(false);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                shapeSize = sizeSlider.getValue();
                updateDrawing();
            }
        });

        colorButton = new JButton("Choose Color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorChooser = new JColorChooser(selectedColor);
                AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
                for (AbstractColorChooserPanel panel : panels) {
                    if (!panel.getDisplayName().equals("RGB")) {
                        colorChooser.removeChooserPanel(panel);
                    }
                }
                int result = JOptionPane.showConfirmDialog(null, colorChooser, "Choose Color", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    selectedColor = colorChooser.getColor();
                    updateDrawing();
                }
            }
        });

        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        controlsPanel.add(new JLabel("Shape:"), gbc);
        gbc.gridy++;
        controlsPanel.add(shapeComboBox, gbc);
        gbc.gridy++;
        controlsPanel.add(new JLabel("Fill Type:"), gbc);
        gbc.gridy++;
        controlsPanel.add(fillTypeComboBox, gbc);

        JPanel sidesPanel = new JPanel();
        sidesPanel.add(new JLabel("Sides:"));
        sidesPanel.add(sidesField);
        sidesPanel.add(updateButton);

        gbc.gridy++;
        controlsPanel.add(sidesPanel, gbc);

        sizeSlider = new JSlider(JSlider.HORIZONTAL, 10, 300, 100);
        sizeSlider.setMajorTickSpacing(20);
        sizeSlider.setMinorTickSpacing(5);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(false);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                shapeSize = sizeSlider.getValue();
                updateDrawing();
            }
        });

        JPanel sizePanel = new JPanel();
        widthTextField = new JTextField(String.valueOf(rectWidth), 4);
        heightTextField = new JTextField(String.valueOf(rectHeight), 4);
        JButton setSizeButton = new JButton("Set Size");
        setSizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSize();
            }
        });

        sizePanel.add(new JLabel("Width:"));
        sizePanel.add(widthTextField);
        sizePanel.add(new JLabel("Height:"));
        sizePanel.add(heightTextField);
        sizePanel.add(setSizeButton);

        gbc.gridy++;
        controlsPanel.add(sizeSlider, gbc);
        gbc.gridy++;
        controlsPanel.add(sizePanel, gbc);
        gbc.gridy++;
        controlsPanel.add(colorButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawShape(g);
            }
        };

        add(controlsPanel, BorderLayout.WEST);
        add(drawingPanel, BorderLayout.CENTER);

        selectedColor = Color.BLACK;

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        updateUIForSelectedShape();
    }

    private void drawShape(Graphics g) {
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        String selectedFillType = (String) fillTypeComboBox.getSelectedItem();

        g.setColor(selectedColor);

        if (selectedShape.equals("Square") || selectedShape.equals("Circle")) {
            int x = (drawingPanel.getWidth() - shapeSize) / 2;
            int y = (drawingPanel.getHeight() - shapeSize) / 2;
            if (selectedFillType.equals("Solid")) {
                if (selectedShape.equals("Square")) {
                    g.fillRect(x, y, shapeSize, shapeSize);
                } else {
                    g.fillOval(x, y, shapeSize, shapeSize);
                }
            } else {
                if (selectedShape.equals("Square")) {
                    g.drawRect(x, y, shapeSize, shapeSize);
                } else {
                    g.drawOval(x, y, shapeSize, shapeSize);
                }
            }
        } else if (selectedShape.equals("Rectangle")) {
            int x = (drawingPanel.getWidth() - rectWidth) / 2;
            int y = (drawingPanel.getHeight() - rectHeight) / 2;
            if (selectedFillType.equals("Solid")) {
                g.fillRect(x, y, rectWidth, rectHeight);
            } else {
                g.drawRect(x, y, rectWidth, rectHeight);
            }
        } else if (selectedShape.equals("Polygon")) {
            int sides;
            try {
                sides = Integer.parseInt(sidesField.getText());
            } catch (NumberFormatException ex) {
                sides = 6;
            }

            if (sides >= 3) {
                int centerX = drawingPanel.getWidth() / 2;
                int centerY = drawingPanel.getHeight() / 2;
                int radius = shapeSize / 2;

                int[] xPoints = new int[sides];
                int[] yPoints = new int[sides];

                double angle = 2 * Math.PI / sides;

                for (int i = 0; i < sides; i++) {
                    xPoints[i] = (int) (centerX + radius * Math.cos(i * angle));
                    yPoints[i] = (int) (centerY + radius * Math.sin(i * angle));
                }

                if (selectedFillType.equals("Solid")) {
                    g.fillPolygon(xPoints, yPoints, sides);
                } else {
                    g.drawPolygon(xPoints, yPoints, sides);
                }
            }
        }
    }

    private void updateSize() {
        try {
            rectWidth = Integer.parseInt(widthTextField.getText());
            rectHeight = Integer.parseInt(heightTextField.getText());
        } catch (NumberFormatException ex) {
            // Handle exception if the user enters an invalid value.
        }

        drawingPanel.repaint();
    }

    private void updateSides() {
        try {
            int sides = Integer.parseInt(sidesField.getText());
            if (sides >= 3) {
                updateDrawing();
            }
        } catch (NumberFormatException ex) {
            // Handle exception if the user enters an invalid value.
        }
    }

    private void updateUIForSelectedShape() {
        String selectedShape = (String) shapeComboBox.getSelectedItem();

        if (selectedShape.equals("Square") || selectedShape.equals("Circle")) {
            sizeSlider.setEnabled(true);
            widthTextField.setEnabled(false);
            heightTextField.setEnabled(false);
            sidesField.setEnabled(false);
            updateButton.setEnabled(false);
        } else if (selectedShape.equals("Rectangle")) {
            sizeSlider.setEnabled(false);
            widthTextField.setEnabled(true);
            heightTextField.setEnabled(true);
            sidesField.setEnabled(false);
            updateButton.setEnabled(false);
        } else if (selectedShape.equals("Polygon")) {
            sizeSlider.setEnabled(true);
            widthTextField.setEnabled(false);
            heightTextField.setEnabled(false);
            sidesField.setEnabled(true);
            updateButton.setEnabled(true);
        }
    }

    private void updateDrawing() {
        if (drawingPanel != null) {
            drawingPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Frame();
        });
    }
}