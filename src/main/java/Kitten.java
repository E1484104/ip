import java.util.Scanner;

public class Kitten {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Kitten");
        System.out.println("     What can I do for you?");
        System.out.println("    ____________________________________________________________\n");

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while(!line.equals("bye")) {
            System.out.println("     " + line);
            System.out.println("    ____________________________________________________________\n");
            line = in.nextLine();
        }

        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
