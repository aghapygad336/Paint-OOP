package sample.Model;

import sample.Shape;

public interface DrawingEngine {
     void refresh(Object pane);
     void resize( Shape selectedShape2);
    void move (javafx.scene.shape.Shape shape);
     void addShape(Shape shape);
     public void removeShape(Shape shape);
     public void updateShape(Shape old_shape ,Shape new_shape);
     Shape[] getShapes();
     void undo();
     void redo();
     void save(String path);
     void load(String path);
}