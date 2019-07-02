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

public class Circle implements Shape  {
    String type;

    double Centery=0;
    double Centerx=0;
    double radius=0;
    boolean move=false;
    javafx.scene.shape.Shape last_selected;
    private javafx.scene.shape.Circle selected_shape;
    double size;
    Color color;
    Color fill_color;
    double x,y;
    double y1,x1;
    javafx.scene.shape.Circle c;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    Pane panelo=new Pane();
    public void getInfog(double x,double y,double x1,double y1)
    {
        this.x=x;
        this.y=y;
        this.x1=x1;
        this.y1=y1;
    }

    public void move(javafx.scene.shape.Shape shape) {

        shape.setOnMousePressed(circleOnMousePressedEventHandler);
        shape.setOnMouseDragged(circleOnMouseDraggedEventHandler);
    }

    @Override
    public Shape[] getShapes() {
        return new Shape[0];
    }

    @Override
    public void setPosition(Point2D position) {


    }


    @Override
    public Point2D getPosition() {
        return null;
    }

    @Override
    public double getx() {
        return x;
    }

    @Override
    public double gety() {
        return y;
    }


    @Override
    public String get_type() {
        return "Circle";
    }

    @Override
    public void setColor(Color color) {
        this.color=color;

    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public java.awt.Color setFillColor(Color color) {
        this.fill_color=color;
        return null;
    }

    @Override
    public Color getFillColor() {
        return this.fill_color;
    }
    @Override
    public double get_strokewidth(){
        return  size;
    }

    public void setRadius(double r){
        this.radius=r;
    }
    public void setcentery(double e){
        this.Centery = e;
    }
    public void setcenterx(double s){
        this.Centerx= s;
    }
    public void set_x(double s){
        this.x=s;

    }
    public void set_y(double s){
        this.y=s;

    }

    @Override
    public void draw(Object pane, int z) {
        Pane p=(Pane) pane;
        c= new javafx.scene.shape.Circle();
        c.setCursor(Cursor.MOVE);
        double diameter= Math.sqrt(Math.pow(y1-y,2)+Math.pow(x1-x,2));
        setRadius(diameter/2);
        radius=diameter/2;
       Centerx=(abs(x)+abs(x1))/2;
        Centery=(abs(y)+abs(y1))/2;
        setcenterx(Centerx);
        setcentery(Centery);
        c.setCenterX(Centerx);
        c.setCenterY(Centery);
        c.setRadius(diameter/2);
        c.setStroke(getColor());
        c.setFill(getFillColor());
        c.setStrokeWidth(size);
        EventHandler<MouseEvent> OnMousePressedEventHandler =
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        if(t.getButton().equals(MouseButton.PRIMARY)){
                            if(t.getClickCount() == 2) {
                                selected_shape=(javafx.scene.shape.Circle) t.getSource();
                                if(selected_Shapes.isEmpty())
                                    selected_Shapes.add(selected_shape);
                                else{
                                    for(int j=0;j<selected_Shapes.size();j++){
                                        if(!(selected_shape.equals(selected_Shapes.get(j))))
                                        {selected_Shapes.add(selected_shape);
                                        }}

                                }}
                            if(t.getClickCount()==3){
                                selected_shape=(javafx.scene.shape.Circle) t.getSource();
                                selected_shape.setStroke(getColor());
                                for(int i=0;i<selected_Shapes.size();i++)
                                { if(selected_Shapes.get(i).equals(selected_shape))
                                    selected_Shapes.remove(selected_shape);

                                }
                            }
                        }}

                };
        c.setOnMouseClicked(OnMousePressedEventHandler);
        move(c);
        p.getChildren().add(c);
cs.add(c);
    }
    public double get_radius(){
        return radius;
    }
    public double get_Centerx(){
        return Centerx;
    }
    public double get_Centery(){
        return Centery;
    }

    @Override
    public void getsize(double x) {
        this.size=x;

    }


    @Override
    public void removeextra(Pane pane) {
        pane.getChildren().remove(c);
        this.panelo=pane;

    }
    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    panelo.getChildren().remove(c);
                    orgTranslateX = ((javafx.scene.shape.Circle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((javafx.scene.shape.Circle)(t.getSource())).getTranslateY();
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

                    ((javafx.scene.shape.Circle)(t.getSource())).setTranslateX(newTranslateX);
                    ((javafx.scene.shape.Circle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

}
