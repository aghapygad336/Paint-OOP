package sample;

import java.util.Stack;

public class CareTaker {

    public Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();

    public void addMemento(Memento memento){
        if (undoStack.size() + redoStack.size() == 20){
            undoStack.remove(0);
        }
        undoStack.push(memento);
    }

    public Memento undo (){
        if (undoStack.isEmpty()){
            return null;
        }else{
            Memento memento = undoStack.pop();
            memento = switchState(memento);
            redoStack.push(memento);
            return memento;
        }
    }

    public Memento redo (){
        if (redoStack.isEmpty()){
            return null;
        }else{
            Memento memento = redoStack.pop();
            memento = switchState(memento);
            undoStack.push(memento);
            return memento;
        }
    }

    public void clearRedoStack(){
        redoStack.clear();
    }

    public void clearUndoStack(){
        undoStack.clear();
    }

    private Memento switchState(Memento memento) {
        if (memento.getAction().getState() == State.added) {
            memento.getAction().setState(State.removed);
        } else if (memento.getAction().getState() == State.removed) {
            memento.getAction().setState(State.added);
        } else if (memento.getAction().getState() == State.updated) {
            Shape temp = memento.getAction().getOldShape();
            memento.getAction().setOldShape(
                    memento.getAction().getNewShape());
            memento.getAction().setNewShape(temp);
        }
        return memento;
    }
}
