package cryptocrack;

public class CompleteFlag {

    private boolean flag = false;

    public CompleteFlag() {

    }

    public boolean getStatus() {
        return flag;
    }

    public void complete() {
        flag = true;
    }

    public void reset() {
        flag = false;
    }
}
