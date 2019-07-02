package sample.View;


import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import sample.Shape;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle implements Shape {
    private Map<String, Double> properties =new HashMap<>();
    javafx.scene.shape.Polygon selected_shape;
    Point2D position;
    Polygon T;
    double size;
    Color color;
    Color fill_color;
    double x = 0, y = 0;
    double x1, y1;

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    Pane panelo=new Pane();
    public void getInfog(double x, double y, double x1, double y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }




    public javafx.scene.shape.Shape move(javafx.scene.shape.Shape shape) {
        shape.setOnMousePressed(circleOnMousePressedEventHandler);
        shape.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        return shape;
}



    @Override
    public Shape[] getShapes() {
        return new Shape[0];
    }


    @Override
    public void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public Point2D getPosition() {
        return null;
    }

    @Override
    public double getx() {
        return 0;
    }

    @Override
    public double gety() {
        return 0;
    }
@Override
    public double get_strokewidth(){
        return  size;
    }
    @Override
    public String get_type() {
        return "triangle";
    }

    @Override
    public void setColor(Color color) {
        this.color = color;

    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public java.awt.Color setFillColor(Color color) {
        this.fill_color = color;
        return null;
    }

    @Override
    public Color getFillColor() {
        return this.fill_color;
    }
    double x3,y3;
    @Override
    public void draw(Object pane ,int z) {
        Pane p = (Pane) pane;
        T = new Polygon();
        T.setCursor(Cursor.MOVE);
        double x3=sqrt(pow(x,2)+pow(x1,2));
        double y3=y1;
        T.getPoints().addAll(new Double[]{x,y,x1,y1,x3,y3});
        T= (Polygon) move(T);
        T.setStroke(getColor());
        T.setFill(getFillColor());
        EventHandler<MouseEvent> OnMousePressedEventHandler =
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        if(t.getButton().equals(MouseButton.PRIMARY)){
                            if(t.getClickCount() == 2) {
                                selected_shape=(javafx.scene.shape.Polygon) t.getSource();
                                if(selected_Shapes.isEmpty())
                                    selected_Shapes.add(selected_shape);
                                else{
                                    for(int j=0;j<selected_Shapes.size();j++){
                                        if(!(selected_shape.equals(selected_Shapes.get(j))))
                                            selected_Shapes.add(selected_shape);
                                          }

                                }}
                            if(t.getClickCount()==3){
                                selected_shape=(javafx.scene.shape.Polygon) t.getSource();
                                for(int i=0;i<selected_Shapes.size();i++)
                                { if(selected_Shapes.get(i).equals(selected_shape))
                                    selected_Shapes.remove(selected_shape);
                                }
                            }
                        }}

                };
        T.setOnMouseClicked(OnMousePressedEventHandler);
        p.getChildren().add(T);
        cs.add(T);
    }
public double get_x2(){
        return x1;

}
public double get_y2(){
return y1;
    }
    public double get_x3(){
return x3;
    }
    public double get_y3(){
return y3;
    }

    public void removeextra(Pane pane) {
        pane.getChildren().remove(T);     this.panelo=pane;
    }

    @Override
    public void getsize(double size) {
        this.size = size;
    }


    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    panelo.getChildren().remove(T);
                    orgTranslateX = ((javafx.scene.shape.Polygon)(t.getSource())).getTranslateX();
                    orgTranslateY = ((javafx.scene.shape.Polygon)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((javafx.scene.shape.Polygon)(t.getSource())).setTranslateX(newTranslateX);
                    ((javafx.scene.shape.Polygon)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

}
