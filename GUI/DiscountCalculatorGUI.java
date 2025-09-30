import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DiscountCalculatorGUI extends JFrame {

    private JTextField priceField, discountField, resultField;
    private JButton calculateButton, clearButton;

    public DiscountCalculatorGUI() {
        setTitle("Sales Discount Calculator");
        setSize(480, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout(10, 10));

        // --- ตั้งค่าสีพื้นหลังเริ่มต้น ---
        Color backgroundColor = new Color(240, 240, 240); // Light gray
        getContentPane().setBackground(backgroundColor);

        // --- TOP Panel for Title ---
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 179, 113)); // Medium Sea Green
        JLabel titleLabel = new JLabel("Sales Discount Calculator");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // --- CENTER Panel for Inputs and Result ---
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;

        // --- Labels and Fields ---
        JLabel priceLabel = new JLabel("Full Price:");
        JLabel discountLabel = new JLabel("Discount (%):");
        JLabel resultLabel = new JLabel("Discount  Price:");
        
        Font labelFont = new Font("Segoe UI", Font.BOLD, 18);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 18);
        
        priceLabel.setFont(labelFont);
        discountLabel.setFont(labelFont);
        resultLabel.setFont(labelFont);
        
        priceField = new JTextField(15);
        discountField = new JTextField(15);
        resultField = new JTextField(15);
        
        priceField.setFont(fieldFont);
        discountField.setFont(fieldFont);
        resultField.setFont(fieldFont);
        resultField.setEditable(false);
        resultField.setBackground(new Color(230, 230, 230));

        // Position components
        gbc.gridx = 0; gbc.gridy = 0;
        centerPanel.add(priceLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        centerPanel.add(priceField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        centerPanel.add(discountLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        centerPanel.add(discountField, gbc);
        
        // --- Button Panel ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(backgroundColor);
        
        calculateButton = new JButton("Calculate");
        calculateButton.setFont(labelFont);
        calculateButton.setPreferredSize(new Dimension(160, 45));
        calculateButton.setBackground(new Color(70, 130, 180));
        calculateButton.setForeground(Color.WHITE);
        
        clearButton = new JButton("Clear Data");
        clearButton.setFont(labelFont);
        clearButton.setPreferredSize(new Dimension(160, 45));
        clearButton.setBackground(new Color(70, 130, 180));
        clearButton.setForeground(Color.WHITE);
        
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(buttonPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(resultLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        centerPanel.add(resultField, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // --- Action Listeners ---
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double price = Double.parseDouble(priceField.getText());
                    double discount = Double.parseDouble(discountField.getText());
                    
                    if (price < 0 || discount < 0) {
                        JOptionPane.showMessageDialog(null, "Please enter non-negative numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // สร้าง object ของคลาส Product เพื่อใช้ในการคำนวณ
                    Product product = new Product(price, discount);
                    double finalPrice = product.calculateDiscountedPrice();

                    resultField.setText(String.format("%.2f", finalPrice));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                priceField.setText("");
                discountField.setText("");
                resultField.setText("");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiscountCalculatorGUI());
    }