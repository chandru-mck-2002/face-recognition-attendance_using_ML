import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DatabaseAWTEventProgram extends Frame implements ActionListener {

    // JDBC URL, username, and password of MySQL server
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";

    TextArea resultTextArea;

    public DatabaseAWTEventProgram() {
        Label titleLabel = new Label("Database AWT Event Program");
        Button retrieveButton = new Button("Retrieve Data");
        resultTextArea = new TextArea(10, 30);

        // Add action listener to the button
        retrieveButton.addActionListener(this);

        // Add components to the frame
        setLayout(new FlowLayout());
        add(titleLabel);
        add(retrieveButton);
        add(resultTextArea);

        setTitle("Database AWT Event Program");
        setSize(400, 300);
        setVisible(true);
        
        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Retrieve Data")) {
            try {
                // Open a connection
                Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query
                String sql = "SELECT id, name, age FROM users";
                ResultSet rs = stmt.executeQuery(sql);

                // Display result in text area
                StringBuilder result = new StringBuilder();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    result.append("ID: ").append(id).append(", Name: ").append(name).append(", Age: ").append(age).append("\n");
                }
                resultTextArea.setText(result.toString());

                // Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DatabaseAWTEventProgram();
    }
}