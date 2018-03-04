package projectzero;

import projectzero.server.Server;

// todo describe in read me how to run server
public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Run with 2 args");
            System.exit(-1);
        }
        // todo name args
        new Server(9817, args[0], args[1]);
    }
}
