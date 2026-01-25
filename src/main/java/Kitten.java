import java.util.Scanner;

public class Kitten {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hey! I'm Kitten~ Good to see you again!");
        System.out.println("     What can I do for you? I'm always here to be with you~");
        System.out.println("    ____________________________________________________________\n");

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while(!line.equals("bye")) {
            System.out.println("     " + line);
            System.out.println("    ____________________________________________________________\n");
            line = in.nextLine();
        }

        System.out.println("     Bye~ Have a nice day and all the best!");
        System.out.println("    ____________________________________________________________");
    }
}
