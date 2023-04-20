package cryptocrack;

public class Result {
    private String message;
    private String salt;

    public Result() {
    }

    public String getMessage() {
        return message;
    }

    public String getSalt() {
        return salt;
    }

    public void setResult(String message, String salt) {
        this.message = message;
        this.salt = salt;
    }
}
