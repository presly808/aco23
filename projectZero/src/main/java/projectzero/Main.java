package projectzero;

import projectzero.server.Server;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Run with 2 args");
            System.exit(-1);
        }
        new Server(9817, args[0], args[1]);
    }
}
