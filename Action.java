package sample;

public class Action {

    private State state;
    private Shape oldShape;
    private Shape newShape;

    public Action(State state, Shape newShape) {
        this.state = state;
        this.newShape = newShape;
    }

    public Action(State state, Shape newShape, Shape oldShape) {
        this.state = state;
        this.newShape = newShape;
        this.oldShape = oldShape;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Shape getNewShape() {
        return newShape;
    }

    public void setNewShape(Shape newShape) {
        this.newShape = newShape;
    }

    public Shape getOldShape() {
        return oldShape;
    }

    public void setOldShape(Shape oldShape) {
        this.oldShape = oldShape;
    }
}
