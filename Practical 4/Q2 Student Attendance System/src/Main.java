//Aim: To maintain unique student attendance entries and prevent duplicate names.


import java.util.HashSet;
import java.util.Scanner;

class Attendance {
    HashSet<String> students = new HashSet<>();

    void markAttendance(String name) {
        if (students.add(name)) {
            System.out.println("Attendance marked for " + name);
        } else {
            System.out.println(name + " is already marked present");
        }
    }

    void displayAttendance() {
        System.out.println("Present Students:");
        for (String name : students) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attendance attendance = new Attendance();

        System.out.print("Enter name to mark attendance: ");
        attendance.markAttendance(sc.nextLine());

        System.out.print("Enter name to mark attendance: ");
        attendance.markAttendance(sc.nextLine());

        attendance.displayAttendance();
        sc.close();
    }
}
