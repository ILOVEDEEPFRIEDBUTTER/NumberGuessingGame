import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementApp extends JFrame {

    // =========================
    // DATA MODEL
    // =========================

    static class Student {
        private String id;
        private String name;
        private String age;
        private String grade;
        private String email;

        public Student(String id, String name, String age,
                       String grade, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.email = email;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public String getGrade() {
            return grade;
        }

        public String getEmail() {
            return email;
        }
    }

    // =========================
    // VARIABLES
    // =========================

    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField emailField;

    private JComboBox<String> gradeCombo;

    private JTextField searchField;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    private JLabel statusLabel;

    private List<Student> students;

    // =========================
    // CONSTRUCTOR
    // =========================

    public StudentManagementApp() {

        students = new ArrayList<>();

        setTitle("Student Management System");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenuBar();
        createMainPanel();

        setVisible(true);
    }

    // =========================
    // MENU BAR
    // =========================

    private void createMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        fileMenu.add(exitItem);

        // Help menu
        JMenu helpMenu = new JMenu("Help");

        JMenuItem aboutItem = new JMenuItem("About");

        aboutItem.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Student Management System\n" +
                    "Created using Java Swing\n\n" +
                    "Version 1.0",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    // =========================
    // MAIN PANEL
    // =========================

    private void createMainPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Header
        JPanel headerPanel = createHeaderPanel();

        // Form
        JPanel formPanel = createFormPanel();

        // Table
        JPanel tablePanel = createTablePanel();

        // Search
        JPanel searchPanel = createSearchPanel();

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.WEST);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.add(searchPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    // =========================
    // HEADER
    // =========================

    private JPanel createHeaderPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Student Management System");

        title.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel subtitle = new JLabel(
                "Manage student records using Java Swing"
        );

        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        textPanel.add(title);
        textPanel.add(subtitle);

        panel.add(textPanel, BorderLayout.WEST);

        return panel;
    }

    // =========================
    // FORM
    // =========================

    private JPanel createFormPanel() {

        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(300, 400));

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel formTitle = new JLabel("Student Information");

        formTitle.setFont(new Font("Arial", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(formTitle, gbc);

        gbc.gridwidth = 1;

        // ID
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(new JLabel("Student ID:"), gbc);

        idField = new JTextField();

        gbc.gridx = 1;

        panel.add(idField, gbc);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 2;

        panel.add(new JLabel("Name:"), gbc);

        nameField = new JTextField();

        gbc.gridx = 1;

        panel.add(nameField, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 3;

        panel.add(new JLabel("Age:"), gbc);

        ageField = new JTextField();

        gbc.gridx = 1;

        panel.add(ageField, gbc);

        // Grade
        gbc.gridx = 0;
        gbc.gridy = 4;

        panel.add(new JLabel("Grade:"), gbc);

        gradeCombo = new JComboBox<>();

        gradeCombo.addItem("Grade 6");
        gradeCombo.addItem("Grade 7");
        gradeCombo.addItem("Grade 8");
        gradeCombo.addItem("Grade 9");
        gradeCombo.addItem("Grade 10");
        gradeCombo.addItem("Grade 11");
        gradeCombo.addItem("Grade 12");

        gbc.gridx = 1;

        panel.add(gradeCombo, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 5;

        panel.add(new JLabel("Email:"), gbc);

        emailField = new JTextField();

        gbc.gridx = 1;

        panel.add(emailField, gbc);

        // Buttons
        JButton addButton = new JButton("Add Student");
        JButton clearButton = new JButton("Clear");
        JButton deleteButton = new JButton("Delete Selected");

        addButton.addActionListener(e -> addStudent());

        clearButton.addActionListener(e -> clearFields());

        deleteButton.addActionListener(e -> deleteStudent());

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        panel.add(addButton, gbc);

        gbc.gridy = 8;

        panel.add(deleteButton, gbc);

        gbc.gridy = 9;

        panel.add(clearButton, gbc);

        return panel;
    }

    // =========================
    // TABLE
    // =========================

    private JPanel createTablePanel() {

        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {
                "ID",
                "Name",
                "Age",
                "Grade",
                "Email"
        };

        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        studentTable = new JTable(tableModel);

        studentTable.setRowHeight(30);

        studentTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        studentTable.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        JScrollPane scrollPane =
                new JScrollPane(studentTable);

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // =========================
    // SEARCH
    // =========================

    private JPanel createSearchPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel searchLabel = new JLabel("Search:");

        searchField = new JTextField();

        JButton searchButton = new JButton("Search");

        JButton showAllButton = new JButton("Show All");

        searchButton.addActionListener(e -> searchStudents());

        showAllButton.addActionListener(e -> refreshTable());

        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));

        leftPanel.add(searchLabel, BorderLayout.WEST);
        leftPanel.add(searchField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(searchButton);
        buttonPanel.add(showAllButton);

        panel.add(leftPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.EAST);

        statusLabel = new JLabel("Ready");

        panel.add(statusLabel, BorderLayout.WEST);

        return panel;
    }

    // =========================
    // ADD STUDENT
    // =========================

    private void addStudent() {

        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String age = ageField.getText().trim();
        String grade = (String) gradeCombo.getSelectedItem();
        String email = emailField.getText().trim();

        // Validation

        if (id.isEmpty() ||
            name.isEmpty() ||
            age.isEmpty() ||
            email.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Check ID

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {

                JOptionPane.showMessageDialog(
                        this,
                        "A student with this ID already exists.",
                        "Duplicate ID",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }
        }

        // Validate age

        try {

            int ageNumber = Integer.parseInt(age);

            if (ageNumber < 5 || ageNumber > 100) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid age.",
                        "Invalid Age",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Age must be a number.",
                    "Invalid Age",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Validate email

        if (!email.contains("@")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid email address.",
                    "Invalid Email",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Create student

        Student student =
                new Student(
                        id,
                        name,
                        age,
                        grade,
                        email
                );

        students.add(student);

        refreshTable();

        clearFields();

        statusLabel.setText(
                "Student added successfully."
        );
    }

    // =========================
    // DELETE STUDENT
    // =========================

    private void deleteStudent() {

        int selectedRow =
                studentTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a student first.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String name =
                tableModel.getValueAt(
                        selectedRow,
                        1
                ).toString();

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete " + name + "?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (result == JOptionPane.YES_OPTION) {

            String id =
                    tableModel.getValueAt(
                            selectedRow,
                            0
                    ).toString();

            students.removeIf(
                    student ->
                            student.getId().equals(id)
            );

            refreshTable();

            statusLabel.setText(
                    "Student deleted."
            );
        }
    }

    // =========================
    // CLEAR
    // =========================

    private void clearFields() {

        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        emailField.setText("");

        gradeCombo.setSelectedIndex(0);

        idField.requestFocus();
    }

    // =========================
    // REFRESH TABLE
    // =========================

    private void refreshTable() {

        tableModel.setRowCount(0);

        for (Student student : students) {

            Object[] row = {

                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getGrade(),
                    student.getEmail()

            };

            tableModel.addRow(row);
        }

        statusLabel.setText(
                students.size() +
                " student(s) registered."
        );
    }

    // =========================
    // SEARCH STUDENTS
    // =========================

    private void searchStudents() {

        String search =
                searchField.getText()
                        .trim()
                        .toLowerCase();

        if (search.isEmpty()) {

            refreshTable();

            return;
        }

        tableModel.setRowCount(0);

        int results = 0;

        for (Student student : students) {

            boolean matches =
                    student.getId()
                            .toLowerCase()
                            .contains(search)

                    ||

                    student.getName()
                            .toLowerCase()
                            .contains(search)

                    ||

                    student.getGrade()
                            .toLowerCase()
                            .contains(search)

                    ||

                    student.getEmail()
                            .toLowerCase()
                            .contains(search);

            if (matches) {

                Object[] row = {

                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getGrade(),
                        student.getEmail()

                };

                tableModel.addRow(row);

                results++;
            }
        }

        statusLabel.setText(
                results + " result(s) found."
        );
    }

    // =========================
    // SAMPLE DATA
    // =========================

    private void addSampleData() {

        students.add(
                new Student(
                        "001",
                        "Alex Johnson",
                        "15",
                        "Grade 10",
                        "alex@example.com"
                )
        );

        students.add(
                new Student(
                        "002",
                        "Sarah Smith",
                        "16",
                        "Grade 11",
                        "sarah@example.com"
                )
        );

        students.add(
                new Student(
                        "003",
                        "Daniel Brown",
                        "14",
                        "Grade 9",
                        "daniel@example.com"
                )
        );

        refreshTable();
    }

    // =========================
    // MAIN
    // =========================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentManagementApp app =
                    new StudentManagementApp();

            app.addSampleData();

        });
    }
}