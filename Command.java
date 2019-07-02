package sample;

import sample.Controller.Controller;

import java.util.List;

public class Command {

    private Controller engine;
    private List<Shape> shapelist;

    public Command(Controller engine, List<Shape> shapelist) {
        this.engine = engine;
        this.shapelist= shapelist;
    }

    public void addShape (Shape newShape){
        engine.clearRedoStack();
        shapelist.add(newShape);
    }

    public void removeShape (Shape shape){
        engine.clearRedoStack();
        shapelist.remove(shape);
    }

    public void updateShape (Shape oldShape , Shape newShape){
        engine.clearRedoStack();
        int i;
        i=shapelist.indexOf(oldShape);
        shapelist.remove(i);
        shapelist.add(i, newShape);
    }
    public  void CommandFactory() {

    }
}