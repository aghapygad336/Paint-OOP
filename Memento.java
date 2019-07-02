package sample;

public class Memento {
    private Action action;

    public Memento() {

    }

    public Memento(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return this.action;
    }



}



