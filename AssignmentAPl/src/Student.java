import java.util.HashMap;
import java.util.Map;

// Class to manage individual student data and logic
class Student {
    private String studentId;
    private String name;
    private Map<String, Double> subjects;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.subjects = new HashMap<>();
    }

    // Update or add a subject score
    public void updateScore(String subject, double score) {
        subjects.put(subject, score);
    }

    // Delete a subject
    public void deleteSubject(String subject) {
        if (subjects.containsKey(subject)) {
            subjects.remove(subject);
            System.out.println("Subject '" + subject + "' removed for " + name);
        } else {
            System.out.println("Subject not found.");
        }
    }

    // Convert score to grade point
    private double getGradePoint(double score) {
        if (score >= 90) return 4.0;
        else if (score >= 80) return 3.0;
        else if (score >= 70) return 2.0;
        else if (score >= 60) return 1.0;
        else return 0.0;
    }

    // Calculate GPA
    public double calculateGPA() {
        if (subjects.isEmpty()) return 0.0;

        double totalGradePoints = 0.0;
        for (double score : subjects.values()) {
            totalGradePoints += getGradePoint(score);
        }
        return totalGradePoints / subjects.size();
    }

    // Determine Pass/Fail status
    public String getPassFailStatus() {
        return calculateGPA() >= 2.0 ? "Pass" : "Fail";
    }

    // Display transcript
    public void printTranscript() {
        System.out.println("\n--- Transcript ---");
        System.out.println("Name: " + name + " (ID: " + studentId + ")");
        System.out.println("Subjects:");

        if (subjects.isEmpty()) {
            System.out.println("  No subjects recorded.");
        } else {
            for (Map.Entry<String, Double> entry : subjects.entrySet()) {
                String subject = entry.getKey();
                double score = entry.getValue();
                System.out.printf("  - %-10s: Score = %.1f | Grade Point = %.1f%n",
                        subject, score, getGradePoint(score));
            }
        }

        System.out.printf("Total GPA: %.2f%n", calculateGPA());
        System.out.println("Status: " + getPassFailStatus());
        System.out.println("------------------\n");
    }
}

// Class to manage the overall system and multiple students
class GPASystem {
    private Map<String, Student> students;

    public GPASystem() {
        students = new HashMap<>();
    }

    public void addStudent(String studentId, String name) {
        if (!students.containsKey(studentId)) {
            students.put(studentId, new Student(studentId, name));
            System.out.println("Student " + name + " added successfully.");
        } else {
            System.out.println("Student ID already exists.");
        }
    }

    public void updateScore(String studentId, String subject, double score) {
        Student student = students.get(studentId);
        if (student != null) {
            student.updateScore(subject, score);
            System.out.println("Score updated for " + studentId + " in " + subject);
        } else {
            System.out.println("Error: Student not found.");
        }
    }

    public void deleteSubject(String studentId, String subject) {
        Student student = students.get(studentId);
        if (student != null) {
            student.deleteSubject(subject);
        } else {
            System.out.println("Error: Student not found.");
        }
    }

    public void viewTranscript(String studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            student.printTranscript();
        } else {
            System.out.println("Error: Student not found.");
        }
    }
}
