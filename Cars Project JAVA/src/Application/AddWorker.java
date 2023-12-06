package Application;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import Core.Worker;

public class AddWorker {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Add Worker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel workerNumLabel = new JLabel("Worker Number:");
        JTextField workerNumField = new JTextField();
        JLabel fullNameLabel = new JLabel("Full Name:");
        JTextField fullNameField = new JTextField();
        JLabel startWorkingDateLabel = new JLabel("Start Working Date:");
        JTextField startWorkingDateField = new JTextField();
        JLabel cityLabel = new JLabel("City:");
        JTextField cityField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JButton addButton = new JButton("Add Worker");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int workerNum = Integer.parseInt(workerNumField.getText());
                String fullName = fullNameField.getText();
                String startWorkingDateStr = startWorkingDateField.getText();

             // Convert the date string to a Date object
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             Date startWorkingDate = null;
             try {
                 java.util.Date utilDate = dateFormat.parse(startWorkingDateStr);
                 startWorkingDate = new Date(utilDate.getTime());
             } catch (ParseException e1) {
                 e1.printStackTrace();
             }
                String city = cityField.getText();
                String email = emailField.getText();

                Worker worker = new Worker(workerNum, fullName, startWorkingDate, city, email);
                sqlAddWorker(worker);

                JOptionPane.showMessageDialog(frame, "New worker added successfully!");
            }
        });

        panel.add(workerNumLabel);
        panel.add(workerNumField);
        panel.add(fullNameLabel);
        panel.add(fullNameField);
        panel.add(startWorkingDateLabel);
        panel.add(startWorkingDateField);
        panel.add(cityLabel);
        panel.add(cityField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel());
        panel.add(addButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void sqlAddWorker(Worker w) {
        String query = "INSERT INTO employee (workerNum, fullName, startWorkingDate, city, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test1", "user", "1234");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, w.getWorkerNum());
            statement.setString(2, w.getFullName());
            statement.setDate(3, new java.sql.Date(w.getStartWorkingDate().getTime()));
            statement.setString(4, w.getCity());
            statement.setString(5, w.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
