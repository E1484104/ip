import java.util.Scanner;

public class Kitten {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hey! I'm Kitten~ Good to see you again!");
        System.out.println("     What can I do for you? I'm always here to be with you~");
        System.out.println("    ____________________________________________________________\n");

        Task[] tasks = new Task[100];
        int index = 0;

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while(!line.equals("bye")) {
            if(line.equals("list")){
                for(int i = 1; i <= index; i++) {
                    System.out.println("     " + i + ". [" + tasks[i-1].getStatusIcon() + "] " + tasks[i-1].description);
                }
                System.out.println("    ____________________________________________________________\n");
            }else{
                System.out.println("     Task added: " + line);
                System.out.println("    ____________________________________________________________\n");
                Task t = new Task(line);
                tasks[index] = t;
                index++;
            }

            line = in.nextLine();
        }

        System.out.println("     Bye~ Have a nice day and all the best!");
        System.out.println("    ____________________________________________________________");
    }
}
