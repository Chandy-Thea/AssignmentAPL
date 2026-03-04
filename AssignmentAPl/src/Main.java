import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    GPASystem system = new GPASystem();
    boolean running = true;

    while (running) {
      System.out.println("===== GPA MANAGEMENT SYSTEM =====");
      System.out.println("1. Add Student");
      System.out.println("2. Update Subject Score");
      System.out.println("3. Delete Subject");
      System.out.println("4. View Transcript");
      System.out.println("5. Exit");
      System.out.print("Choose option: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // clear buffer

      switch (choice) {

        case 1:
          System.out.print("Enter Student ID: ");
          String id = scanner.nextLine();

          System.out.print("Enter Student Name: ");
          String name = scanner.nextLine();

          system.addStudent(id, name);
          break;

        case 2:
          System.out.print("Enter Student ID: ");
          String updateId = scanner.nextLine();

          System.out.print("Enter Subject Name: ");
          String subject = scanner.nextLine();

          System.out.print("Enter Score: ");
          double score = scanner.nextDouble();
          scanner.nextLine();

          system.updateScore(updateId, subject, score);
          break;

        case 3:
          System.out.print("Enter Student ID: ");
          String deleteId = scanner.nextLine();

          System.out.print("Enter Subject Name to Delete: ");
          String deleteSubject = scanner.nextLine();

          system.deleteSubject(deleteId, deleteSubject);
          break;

        case 4:
          System.out.print("Enter Student ID: ");
          String viewId = scanner.nextLine();

          system.viewTranscript(viewId);
          break;

        case 5:
          running = false;
          System.out.println("Exiting system... Goodbye!");
          break;

        default:
          System.out.println("Invalid option. Try again.");
      }

      System.out.println();
    }

    scanner.close();
  }
}