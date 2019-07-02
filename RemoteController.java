package sample;

import sample.Controller.Controller;
import sample.Model.DrawingEngine;

import java.util.ArrayList;
import java.util.List;

public class RemoteController {
    public ArrayList<Shape> created_shapes = new ArrayList<>();
    private CareTaker caretaker;
    private DrawingEngine engine;
    private CommandFactory factory;
    private List<Shape> shapelist;

    public RemoteController(DrawingEngine engine, CareTaker caretaker, List<Shape> shapelist) {
        this.engine = engine;
        this.caretaker = caretaker;
        this.factory = new CommandFactory();
        this.shapelist = shapelist;
    }

    public RemoteController(Controller aThis, CareTaker caretaker, List<java.awt.Shape> shapeList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addShape (Shape newShape){
        Action action = new Action(State.added, newShape);
        factory.execute(engine, shapelist, action);
        caretaker.addMemento(new Memento(action));

    }

    public void removeShape (Shape shape){
        Action action = new Action(State.removed, shape);
        factory.execute(engine, shapelist, action);
        caretaker.addMemento(new Memento(action));
    }

    public void updateShape (Shape oldShape, Shape newShape){
        Action action = new Action(State.added,oldShape, newShape);
        factory.execute(engine, shapelist, action);
        caretaker.addMemento(new Memento(action)); }


}