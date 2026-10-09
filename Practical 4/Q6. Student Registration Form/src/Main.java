//Aim: To create a student registration form using AWT components and display the entered details after submission.


import java.awt.*;
import java.awt.event.*;

class StudentRegistration extends Frame implements ActionListener {
    Label nameLabel, rollLabel, courseLabel;
    TextField nameField, rollField, courseField;
    Button submitButton;

    StudentRegistration() {
        setTitle("Student Registration Form");
        setLayout(new FlowLayout());

        nameLabel = new Label("Name:");
        nameField = new TextField(20);

        rollLabel = new Label("Roll No:");
        rollField = new TextField(20);

        courseLabel = new Label("Course:");
        courseField = new TextField(20);

        submitButton = new Button("Submit");

        add(nameLabel);
        add(nameField);

        add(rollLabel);
        add(rollField);

        add(courseLabel);
        add(courseField);

        add(submitButton);

        submitButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(350, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String roll = rollField.getText();
        String course = courseField.getText();

        String details =
                "Registration Successful!\n"
                        + "Name: " + name + "\n"
                        + "Roll No: " + roll + "\n"
                        + "Course: " + course;

        Dialog dialog = new Dialog(
                this, "Registration Details", true
        );

        dialog.setLayout(new FlowLayout());

        dialog.add(new Label(details));

        Button okButton = new Button("OK");
        okButton.addActionListener(ev -> dialog.dispose());

        dialog.add(okButton);
        dialog.setSize(300, 180);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
