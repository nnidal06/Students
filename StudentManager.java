import java.util.*;
public class StudentManager {
    record Student(int id, String name, double grade) {}
    public static void main(String[] args) {
        Map<Integer, Student> students = new LinkedHashMap<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1 Add | 2 List | 3 Search | 4 Delete | 5 Average | 0 Exit");
            try {
                switch (Integer.parseInt(in.nextLine())) {
                    case 0 -> { return; }
                    case 1 -> {
                        System.out.print("ID: "); int id = Integer.parseInt(in.nextLine());
                        System.out.print("Name: "); String name = in.nextLine();
                        System.out.print("Grade: "); double grade = Double.parseDouble(in.nextLine());
                        if (!Double.isFinite(grade) || grade < 0 || grade > 100 || name.isBlank() || students.containsKey(id)) System.out.println("Invalid or duplicate record");
                        else students.put(id, new Student(id, name, grade));
                    }
                    case 2 -> students.values().forEach(System.out::println);
                    case 3 -> { System.out.print("ID: "); System.out.println(students.getOrDefault(Integer.parseInt(in.nextLine()), new Student(-1,"Not found",0))); }
                    case 4 -> { System.out.print("ID: "); System.out.println(students.remove(Integer.parseInt(in.nextLine())) != null ? "Deleted" : "Not found"); }
                    case 5 -> System.out.println(students.values().stream().mapToDouble(Student::grade).average().orElse(0));
                    default -> System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) { System.out.println("Enter a valid number"); }
        }
    }
}
