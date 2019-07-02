package sample.View;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Shape;

import static java.lang.Math.abs;

public class Ellipse implements Shape {
    javafx.scene.shape.Ellipse selected_shape;
    Point2D position;
    double centerX;
    double centerY;
    double radius_x;
    double radius_y;
    javafx.scene.shape.Ellipse E;
    double size;
    Color color;
    Color fill_color;
    private double x, y;
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
    public void setCenterX(double s){
        this.centerX=s;
    }
    public void setCenterY(double s){
        this.centerY=s;
    }

    public void setRadius_x(double s){
        this.radius_x=s;
    }
    public void setRadius_Y(double s){
        this.radius_y=s;
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
    public void set_x(double x1) {
        this.x=x1;
    }

    @Override
    public double getx() {
        return x;
    }
    @Override
    public double get_strokewidth(){
        return  size;
    }

    @Override
    public double gety() {
        return y;
    }

    public double radius_x(){
        return radius_x;
    }
    public double radius_Y(){
        return radius_y;
    }
    public void set_center_x(double d){
        this.centerX=d;
    }
    public void set_center_y(double d){
        this.centerY=d;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    @Override
    public String get_type() {
        return "Ellipse";
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

    @Override
    public void draw(Object pane ,int z) {
        Pane p = (Pane) pane;

        E = new javafx.scene.shape.Ellipse();
        E.setCursor(Cursor.MOVE);
        centerY = (abs(y1) + abs(y)) / 2;
         centerX = (abs(x1) + abs(x)) / 2;
        E.setCenterX(centerX);
        E.setCenterY(centerY);
        if(x1>x&&y1>y){
            E.setRadiusY(y1-y);
            radius_y=y1-y;
            E.setRadiusX(x1 - x);
            radius_x=x1-x;
        }else if(x>x1&&y>y1) {
            E.setRadiusX(x - x1);
            E.setRadiusY(y - y1);
            radius_y=y-y1;
            radius_x=x-x1;
        }else if(x==x1&&y==y1){
        }else if(x>x1&&y1>y){
            E.setRadiusX(x - x1);
            E.setRadiusY(y1 - y);
            radius_x=x-x1;
            radius_y=y1-y;
        }else if(x1>x&&y>y1){
            E.setRadiusX(x1 - x);
            E.setRadiusY(y - y1);
            radius_x=x1-x;
            radius_y=y-y1;
        }   E= (javafx.scene.shape.Ellipse) move(E);
        E.setStroke(getColor());
        E.setFill(getFillColor());
        E.setStrokeWidth(size);
        EventHandler<MouseEvent> OnMousePressedEventHandler =
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        if(t.getButton().equals(MouseButton.PRIMARY)){
                            if(t.getClickCount() == 2) {
                                selected_shape=(javafx.scene.shape.Ellipse) t.getSource();
                                if(selected_Shapes.isEmpty())
                                        selected_Shapes.add(selected_shape);
                                else{
                                     for(int j=0;j<selected_Shapes.size();j++){
                                      if(!(selected_shape.equals(selected_Shapes.get(j))))
                                       selected_Shapes.add(selected_shape);
                                      }

                            }}
                             if(t.getClickCount()==3){
                                 selected_shape=(javafx.scene.shape.Ellipse) t.getSource();
                                for(int i=0;i<selected_Shapes.size();i++)
                                { if(selected_Shapes.get(i).equals(selected_shape))
                                    selected_Shapes.remove(selected_shape);

                                }
                            }
}}

                };

        E.setOnMouseClicked(OnMousePressedEventHandler);
        p.getChildren().add(E);
        cs.add(E);

}
public void set_y(double s){
        this.y=s;
}
    @Override
    public void getsize(double size) {
        this.size = size;

    }

    @Override
    public void removeextra(Pane pane) {
        pane.getChildren().remove(E);
        this.panelo=pane;
    }
    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    panelo.getChildren().remove(E);
                    orgTranslateX = ((javafx.scene.shape.Ellipse)(t.getSource())).getTranslateX();
                    orgTranslateY = ((javafx.scene.shape.Ellipse)(t.getSource())).getTranslateY();
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

                    ((javafx.scene.shape.Ellipse)(t.getSource())).setTranslateX(newTranslateX);
                    ((javafx.scene.shape.Ellipse)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

}
