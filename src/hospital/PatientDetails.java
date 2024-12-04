package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class PatientDetails extends JFrame {

    private JTable patientTable;
    private DefaultTableModel tableModel;

    public PatientDetails() {
        setTitle("Patient Details");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null);

        // Set up the table with column headers
        String[] columnNames = {"Name", "Consulted Doctor", "Disease Details", "Phone No", "Blood Group"};
        tableModel = new DefaultTableModel(columnNames, 0);
        patientTable = new JTable(tableModel);

        // Fetch patient data and populate the table
        fetchPatientData();

        // Add table to a scroll pane for better view
        JScrollPane scrollPane = new JScrollPane(patientTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Method to fetch patient data from the database and add it to the table model
    private void fetchPatientData() {
        String url = "jdbc:mysql://localhost:3306/Save"; // Replace with actual database URL
        String user = "root"; // Replace with actual username
        String password = "password"; // Replace with actual password
        String query = "SELECT name, consulted_doctor, disease_details, phone_no, blood_group FROM patient";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Retrieve each patient's data from the ResultSet
                String name = rs.getString("name");
                String consultedDoctor = rs.getString("consulted_doctor");
                String diseaseDetails = rs.getString("disease_details");
                String phoneNo = rs.getString("phone_no");
                String bloodGroup = rs.getString("blood_group");

                // Add each row to the table model
                tableModel.addRow(new Object[]{name, consultedDoctor, diseaseDetails, phoneNo, bloodGroup});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to run the PatientDetails application
    public static void main(String[] args) {
        new PatientDetails();
    }

    private static final long serialVersionUID = 1L;
}
