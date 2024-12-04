package hospital;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame {

    // Constructor for the homepage
    public Homepage() {
        // Set title for the homepage
        setTitle("Hospital Management System");
        setSize(800, 600); // Set size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a layered pane for background image and components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600);

        // Set background image
        ImageIcon backgroundIcon = new ImageIcon("src/resources/background.jpg"); // Path to your background image
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 600);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        // Create a menubar
        JMenuBar menuBar = new JMenuBar();

        // Doctor Menu with a menu item
        JMenu doctorMenu = new JMenu("Doctor");
        JMenuItem viewDoctorDetails = new JMenuItem("View Doctor Details");
        doctorMenu.add(viewDoctorDetails);
        menuBar.add(doctorMenu);

        // Patient Menu with menu items
        JMenu patientMenu = new JMenu("Patient");
        JMenuItem addPatient = new JMenuItem("Add Patient");
        JMenuItem removePatient = new JMenuItem("Remove Patient");
        JMenuItem patientDetails = new JMenuItem("Patient Details");
        patientMenu.add(addPatient);
        patientMenu.add(removePatient);
        patientMenu.add(patientDetails);
        menuBar.add(patientMenu);

        // Appointment Menu with menu items
        JMenu appointmentMenu = new JMenu("Appointment");
        JMenuItem addAppointment = new JMenuItem("Add Appointment");
        JMenuItem appointmentList = new JMenuItem("Appointment List");
        appointmentMenu.add(addAppointment);
        appointmentMenu.add(appointmentList);
        menuBar.add(appointmentMenu);

        // Schedule Menu
        JMenu scheduleMenu = new JMenu("Schedule");
        menuBar.add(scheduleMenu);

        // Blood Menu with sub-menu items
        JMenu bloodMenu = new JMenu("Blood");
        JMenuItem addBlood = new JMenuItem("Add Blood");
        JMenuItem bloodDetails = new JMenuItem("Blood Details");
        bloodMenu.add(addBlood);
        bloodMenu.add(bloodDetails);
        menuBar.add(bloodMenu);

        // Add the menubar to the frame
        setJMenuBar(menuBar);

        // Add the layered pane to the frame
        add(layeredPane);

        // Set visibility
        setVisible(true);

        // Add action listeners for the menu items
        viewDoctorDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoctorDetails(); // Open Doctor Details window
            }
        });

        addPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatient(); // Open Add Patient form
            }
        });

        removePatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemovePatient(); // Open Remove Patient form
            }
        });

        patientDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientDetails(); // Open Patient Details window
            }
        });

        addAppointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentForm(); // Open Add Appointment form
            }
        });

        appointmentList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentList(); // Open Appointment List window
            }
        });

        // Add Blood Menu Item Action
        addBlood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBloodForm(); // Open Add Blood form
            }
        });

        // Blood Details Menu Item Action
        bloodDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BloodDetailsForm(); // Open Blood Details form
            }
        });
    }

    // Main method to run the application
    public static void main(String[] args) {
        new Homepage(); // Create and display the homepage
    }

    private static final long serialVersionUID = 1L;
}
