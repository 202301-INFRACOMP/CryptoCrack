package cryptocrack;

public class CompleteFlag {

    private boolean flag = false;

    public CompleteFlag() {

    }

    public synchronized boolean isCompleted() {
        return flag;
    }

    public synchronized void complete() {
        flag = true;
    }

    public synchronized void reset() {
        flag = false;
    }
}
