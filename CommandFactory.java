package sample;

import sample.Controller.Controller;
import sample.Model.DrawingEngine;

import java.util.List;

public class CommandFactory {
    public void execute(DrawingEngine engine, List<Shape> shapesList, Action action){
        State state = action.getState();

        if (state.equals(State.added)){
            new Command((Controller)engine, shapesList).addShape(action.getNewShape());
        }else if (state.equals(State.removed)){
            new Command((Controller)engine, shapesList).removeShape(action.getNewShape());
        }else if (state.equals(State.updated)){
            new Command((Controller)engine, shapesList).updateShape(action.getOldShape(), action.getNewShape());
        }

    }
}
