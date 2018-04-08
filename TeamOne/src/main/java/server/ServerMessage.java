package server;

public class ServerMessage {
    String message;

    public ServerMessage(String message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
