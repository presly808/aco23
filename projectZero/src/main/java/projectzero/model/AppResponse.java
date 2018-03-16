package projectzero.model;

public class AppResponse {

    private Object response;
    private Error error;

    public AppResponse(Object response, Error error) {
        this.response = response;
        this.error = error;
    }

    public AppResponse(Object response) {
        this.response = response;
    }

    public AppResponse(Error error) {
        this.error = error;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
    

    public static class Error {
        public Error(String message) {
            this.message = message;
        }

        private String message;
    }
}
