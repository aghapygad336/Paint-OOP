package sample.Controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.*;
import sample.Files.Fileintial;
import sample.Files.JSON;
import sample.Files.XML;
import sample.Model.DrawingEngine;
import sample.View.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Controller implements DrawingEngine{
    boolean selected =false;
    ArrayList<javafx.scene.shape.Shape>last=new ArrayList<>();
    private javafx.scene.shape.Shape selectedShape;
    DrawingEngine d=null;
    @FXML
    ColorPicker colorpick;
    @FXML
    ColorPicker fillcolorpick;
    @FXML
    Slider slider;
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Pane pane;
    @FXML
    Slider sizeslider;
    Brush brusheer = new Brush();
    double x=0,y=0;
XML save2=new XML();



    JSON save=new JSON();
    Fileintial File = new Fileintial();

    ArrayList<Shape> loaded=new ArrayList<Shape>();

    public Controller() {

        shapeList = new LinkedList<Shape>();
        caretaker = new CareTaker();
        remoteController = new RemoteController(this, caretaker, shapeList);
        classesList = new ArrayList<Class<? extends Shape>>();
        classesList.add(Ellipse.class);
        classesList.add(Circle.class);
        classesList.add(Line.class);
        classesList.add(sample.View.Rectangle.class);
        classesList.add(Square.class);
        classesList.add(Triangle.class);

    }
private boolean resizeselected=false;
    private boolean lineselected =false;
    private boolean circleselected=false;
    private boolean rectangleselected=false;
    private boolean ellipseselected=false;
    private boolean erasserselected=false;
    private boolean brusherselected=false;
    private  boolean squareselected=false;
    private boolean triangleselected=false;
    private boolean selectselected=false;
    private boolean deleteselected=false;
Shape shape=null;
int del=0;
ShapeFactory shapefactory = new ShapeFactory();
    public void LineSelected(ActionEvent actionEvent) {
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        selectselected=false;
        lineselected^=true;
        deleteselected=false;
        resizeselected=false;
        int i=0;
        while(!shape.cs.isEmpty())
        {
            shape.cs.remove(shape.cs.get(i));
            i++;}
    }

    public void Rectselected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected^=true;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        selectselected=false;
        deleteselected=false;
        resizeselected=false;
        int i=0;
        while(!shape.cs.isEmpty())
        {
            shape.cs.remove(shape.cs.get(i));
            i++;}
    }

    public void Circleselected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected^=true;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;


    }

    public void BrusherSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected^=true;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;


    }

    public void ErasserSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected^=true;
        triangleselected=false;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;
        del=3;
    }
    public void triangleSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected^=true;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;

    }

    public void EllipseSeleted(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected^=true;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;
        int i=0;

    }

    public void SquareSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected^=true;
        deleteselected=false;
        resizeselected=false;

    }


    public void MouseDragged(MouseEvent mouseEvent) {
        double x1 = mouseEvent.getScreenX();
        double y1 = mouseEvent.getScreenY();
        if (rectangleselected) {
            shape.removeextra(pane);
            getinforect(x1, y1);
            shape.draw(pane,del);


        }
        else if (lineselected) {
            shape.removeextra(pane);
            getinfoline(x1, y1);
            shape.draw(pane,del);


        }
        else if(circleselected){
            shape.removeextra(pane);
            getinfocircle(x1,y1);
            shape.draw(pane,del);
        }
        else if (ellipseselected) {
            shape.removeextra(pane);
            getinfoellipse(x1, y1);
            shape.draw(pane,del);
        }
        else if (squareselected) {
            shape.removeextra(pane);
            getinfosqr(x1, y1);
            shape.draw(pane,del);
        }
        else if (triangleselected) {
            shape.removeextra(pane);
            getinfotri(x1, y1);
            shape.draw(pane,del);
        } else if (brusherselected) {
            getinfobrush(x1, y1,1);
            brusheer.draw(pane);
        }else if(erasserselected){
            getinfobrush(x1, y1,2);
            brusheer.draw(pane);
        }
    }

    public void MouseMoved(MouseEvent mouseEvent) {

        label1.setText("X: "+mouseEvent.getScreenX()+"");
        label2.setText("Y: "+mouseEvent.getScreenY()+"");

    }

    public void MouseReleased(MouseEvent mouseEvent) {
        double x1 = mouseEvent.getScreenX();
        double y1 = mouseEvent.getScreenY();

        if (rectangleselected) {
            ((sample.View.Rectangle) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);
        }
        else if (lineselected) {
            ((sample.View.Line) shape).getinfog(x, y, x1, y1);
            shape.draw(pane,del);
        }else if (circleselected)
        {
            ((sample.View.Circle) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);
        } else if (ellipseselected) {
            ((sample.View.Ellipse) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);

        }
        else if (squareselected) {
            ((sample.View.Square) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);

        }
        else if (triangleselected) {
            ((sample.View.Triangle) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);
       }
        else if(brusherselected){
            brusheer.getInfog(x1,y1,1);
            brusheer.draw(pane);
        }else if(erasserselected){
            getinfobrush(x1, y1,2);
            brusheer.draw(pane);
        }
        addShape(shape);
        shape.createdshapes.add(shape);

    }

    public void MousePressed(MouseEvent mouseEvent) {

        x = mouseEvent.getScreenX();
        y = mouseEvent.getScreenY();

        if (rectangleselected) {
            shape = shapefactory.constructshape("rectangle");
        }
        else if(lineselected){
            shape=shapefactory.constructshape("line");
        }
        else if(circleselected){
            shape=shapefactory.constructshape("circle");
        }
        else if(ellipseselected){
            shape = shapefactory.constructshape("ellipse");
        }
       else if (squareselected) {
        shape = shapefactory.constructshape("square");}
        else if (triangleselected) {

            shape = shapefactory.constructshape("triangle");}

    }


    public void getinforect(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Rectangle) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    private void getinfoline(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Line) shape).getinfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    private void getinfocircle(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Circle) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    public void getinfoellipse(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Ellipse) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    public void getinfosqr(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Square) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    public void getinfotri(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Triangle) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());

    }


    public void fillcolorpick(ActionEvent actionEvent) {

    }
    private void getinfobrush(double x1, double y1,int h) {
        brusheer.setColor(colorpick.getValue());
        brusheer.getInfog(x1,y1,h);
        brusheer.getsize(slider.getValue());
    }


    public void deleteSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        deleteselected^=true;
        resizeselected=false;
        for(int i=0;i<shape.selected_Shapes.size();i++){
            pane.getChildren().remove(shape.selected_Shapes.get(i));
            shape.deleted_Shapes.add(shape.selected_Shapes.get(i));
            shape.selected_Shapes.remove(i);
        }
        removeShape(shape);

}

    public void ResizeSelected(ActionEvent actionEvent) {
        lineselected = false;
        rectangleselected = false;
        circleselected = false;
        brusherselected = false;
        ellipseselected = false;
        erasserselected = false;
        triangleselected = false;
        squareselected = false;
        deleteselected = false;
        resizeselected ^= true;
        Circle c = new Circle();
        javafx.scene.shape.Circle c2 = null;
        javafx.scene.shape.Rectangle R2 = null;
        javafx.scene.shape.Polygon T = null;
        javafx.scene.shape.Ellipse E= null;
        for (int i = 0; i < shape.selected_Shapes.size(); i++) {
                if (shape.selected_Shapes.get(i).toString().contains("Circle")) {
                    c2 = (javafx.scene.shape.Circle) shape.selected_Shapes.get(i);
                    shape.cirlces.add(c2);
                    String x1 = JOptionPane.showInputDialog(null, "Enter Radius",0);
                    y = Double.parseDouble(x1);
                    pane.getChildren().remove(c2);
                    shape.cirlces.get(0).setRadius(y);
                    pane.getChildren().remove(c2);
                    pane.getChildren().add(shape.cirlces.get(0));
                    shape.cirlces.remove(0);
                }

            else if (shape.selected_Shapes.get(i).toString().contains("Rectangle")) {
                R2 = (javafx.scene.shape.Rectangle) shape.selected_Shapes.get(i);
                shape.Rectangles.add(R2);
                String x1 = JOptionPane.showInputDialog(null, "Enter Width", 0);
                y = Double.parseDouble(x1);
                String x2 = JOptionPane.showInputDialog(null, "Enter height", 0);
                double y2 = Double.parseDouble(x2);
                pane.getChildren().remove(c2);
                shape.Rectangles.get(0).setWidth(y);
                shape.Rectangles.get(0).setHeight(y2);
                pane.getChildren().remove(R2);
                pane.getChildren().add(shape.Rectangles.get(0));
                shape.Rectangles.remove(0);
            }
            else if (shape.selected_Shapes.get(i).toString().contains("Polygon")) {
                T = (javafx.scene.shape.Polygon) shape.selected_Shapes.get(i);
                shape.triangles.add(T);
                String u = JOptionPane.showInputDialog(null, "Enter  x1", 0);
               double  x1= Double.parseDouble(u);
                String a = JOptionPane.showInputDialog(null, "Enter y1", 0);
                double y1 = Double.parseDouble(a);
                String b = JOptionPane.showInputDialog(null, "Enter x2", 0);
                double x2 = Double.parseDouble(b);
                String w= JOptionPane.showInputDialog(null, "Enter y2", 0);
                double y2 = Double.parseDouble(w);
                String d = JOptionPane.showInputDialog(null, "Enter x3", 0);
                double x3 = Double.parseDouble(d);
                String e = JOptionPane.showInputDialog(null, "Enter y3", 0);
                double y3 = Double.parseDouble(e);
                pane.getChildren().remove(T);
                shape.triangles.get(0).getPoints().addAll(x1,y1,x2,y2,x3,y3);
                pane.getChildren().remove(T);
                pane.getChildren().add(shape.triangles.get(0));
                shape.triangles.remove(0);
            }
            if (shape.selected_Shapes.get(i).toString().contains("Ellipse")) {
                E = (javafx.scene.shape.Ellipse) shape.selected_Shapes.get(i);
                shape.ellipse.add(E);
                String x1 = JOptionPane.showInputDialog(null, "Enter Radius x",0);
                double y2 = Double.parseDouble(x1);
                String x2 = JOptionPane.showInputDialog(null, "Enter Radius y",0);
                double y3 = Double.parseDouble(x2);
                pane.getChildren().remove(T);
                shape.ellipse.get(0).setRadiusX(y2);
                shape.ellipse.get(0).setRadiusY(y3);
                pane.getChildren().remove(E);
                pane.getChildren().add(shape.ellipse.get(0));
                shape.ellipse.remove(0);
                //tests
               } }}

    @Override
    public void refresh(Object pane) {

    }

    @Override
    public void resize(Shape selectedShape){

    }

    @Override
    public void move(javafx.scene.shape.Shape shape2) {


  }


    @Override
    public void save(String path) {

    }

    @Override
    public void load(String path) {

    }
javafx.scene.shape.Shape selected_shape;
    public void Copy_Selected(ActionEvent actionEvent) {
        ellipseselected=false;
        squareselected=false;
        rectangleselected=false;
        triangleselected=false;
        lineselected=false;
        circleselected=false;
        EventHandler<MouseEvent> OnMousePressedEventHandler =
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        if(t.getButton().equals(MouseButton.PRIMARY)){
                            if(t.getClickCount() == 2) {
                                selected_shape=(javafx.scene.shape.Circle) t.getSource();
                                if(shape.selected_Shapes.isEmpty())
                                    shape.selected_Shapes.add(selected_shape);
                                else{
                                    for(int j=0;j<shape.selected_Shapes.size();j++){
                                        if(!(selected_shape.equals(shape.selected_Shapes.get(j))))
                                        {shape.selected_Shapes.add(selected_shape);
                                        }}

                                }}
                            if(t.getClickCount()==3){
                                selected_shape=(javafx.scene.shape.Circle) t.getSource();
                                for(int i=0;i<shape.selected_Shapes.size();i++)
                                { if(shape.selected_Shapes.get(i).equals(selected_shape))
                                    shape.selected_Shapes.remove(selected_shape);

                                }
                            }
                        }}
                };
        for(int i=0;i<shape.selected_Shapes.size();i++)
        {
            if(shape.selected_Shapes.get(i).toString().contains("Circle")){
                {javafx.scene.shape.Circle c= new javafx.scene.shape.Circle();
                    c.setRadius(((javafx.scene.shape.Circle)shape.selected_Shapes.get(i)).getRadius());
                    c.setCenterX(0);
                    c.setCenterY(0);
                    c.setFill(((javafx.scene.shape.Circle)shape.selected_Shapes.get(i)).getFill());
                    c.setStrokeWidth(((javafx.scene.shape.Circle)shape.selected_Shapes.get(i)).getStrokeWidth());
                    c.setStroke(((javafx.scene.shape.Circle)shape.selected_Shapes.get(i)).getStroke());
                    c.setOnMouseClicked(OnMousePressedEventHandler);
                    c.setCursor(Cursor.MOVE);
                    ((sample.View.Circle)shape).move(c);
                    pane.getChildren().add(c);}
            }else if(shape.selected_Shapes.get(i).toString().contains("Rectangle")){
                javafx.scene.shape.Rectangle r=new javafx.scene.shape.Rectangle();
                r.setHeight(((javafx.scene.shape.Rectangle)shape.selected_Shapes.get(i)).getHeight());
                r.setWidth(((javafx.scene.shape.Rectangle)shape.selected_Shapes.get(i)).getWidth());
                r.setStrokeWidth(((javafx.scene.shape.Rectangle)shape.selected_Shapes.get(i)).getStrokeWidth());
                r.setStroke(((javafx.scene.shape.Rectangle)shape.selected_Shapes.get(i)).getStroke());
                r.setX(0);
                r.setFill(((javafx.scene.shape.Rectangle)shape.selected_Shapes.get(i)).getFill());
                r.setY(0);
                r.setOnMouseClicked(OnMousePressedEventHandler);
                r.setCursor(Cursor.MOVE);
                ((sample.View.Rectangle)shape).move(r);

                shape.selected_Shapes.add(r);
            }else if(shape.selected_Shapes.get(i).toString().contains("Ellipse")){
                javafx.scene.shape.Ellipse r=new javafx.scene.shape.Ellipse();
                r.setRadiusY(((javafx.scene.shape.Ellipse)shape.selected_Shapes.get(i)).getRadiusY());
                r.setRadiusX(((javafx.scene.shape.Ellipse)shape.selected_Shapes.get(i)).getRadiusX());
                r.setStrokeWidth(((javafx.scene.shape.Ellipse)shape.selected_Shapes.get(i)).getStrokeWidth());
                r.setStroke(((javafx.scene.shape.Ellipse)shape.selected_Shapes.get(i)).getStroke());
                r.setCenterX(((javafx.scene.shape.Ellipse)shape.selected_Shapes.get(i)).getCenterX());
                r.setFill(((javafx.scene.shape.Ellipse)shape.selected_Shapes.get(i)).getFill());
                r.setCenterY(((javafx.scene.shape.Ellipse)shape.selected_Shapes.get(i)).getCenterY());
                r.setCursor(Cursor.MOVE);
                r.setOnMouseClicked(OnMousePressedEventHandler);
                ((sample.View.Ellipse)shape).move(r);
                pane.getChildren().add(r);
            }else if(shape.selected_Shapes.get(i).toString().contains("Line")){
                javafx.scene.shape.Line r=new javafx.scene.shape.Line();
                r.setStartX(((javafx.scene.shape.Line)shape.selected_Shapes.get(i)).getStartX());
                r.setStartY(((javafx.scene.shape.Line)shape.selected_Shapes.get(i)).getStartY());
                r.setStrokeWidth(((javafx.scene.shape.Line)shape.selected_Shapes.get(i)).getStrokeWidth());
                r.setStroke(((javafx.scene.shape.Line)shape.selected_Shapes.get(i)).getStroke());
                r.setEndY(((javafx.scene.shape.Line)shape.selected_Shapes.get(i)).getEndY());
                r.setFill(((javafx.scene.shape.Line)shape.selected_Shapes.get(i)).getFill());
                r.setEndX(((javafx.scene.shape.Line)shape.selected_Shapes.get(i)).getEndX());
                r.setOnMouseClicked(OnMousePressedEventHandler);
                r.setCursor(Cursor.MOVE);
                ((sample.View.Line)shape).move(r);
                pane.getChildren().add(r);
            }
            else if(shape.selected_Shapes.get(i).toString().contains("Polygon")){
                javafx.scene.shape.Polygon r=new javafx.scene.shape.Polygon();
                r.getPoints().addAll(((javafx.scene.shape.Polygon)shape.selected_Shapes.get(i)).getPoints());
                r.setStrokeWidth(((javafx.scene.shape.Polygon)shape.selected_Shapes.get(i)).getStrokeWidth());
                r.setStroke(((javafx.scene.shape.Polygon)shape.selected_Shapes.get(i)).getStroke());
                r.setFill(((javafx.scene.shape.Polygon)shape.selected_Shapes.get(i)).getFill());
                r.setCursor(Cursor.MOVE);
                r.setOnMouseClicked(OnMousePressedEventHandler);
                ((sample.View.Triangle)shape).move(r);
                pane.getChildren().add(r);
                shape.selected_Shapes.add(r);
            }
        }

    }


    private CareTaker caretaker;
    private RemoteController remoteController;
    private List<Class<? extends Shape>> classesList;
    private LinkedList<Shape> shapeList;


    @Override
    public void addShape(Shape shape) {
        if (shape == null){
        }else{
            remoteController.addShape(shape);
            remoteController.created_shapes.add(shape);
        }

    }

    @Override
    public void removeShape(Shape shape) {
        if (shape == null){
            throw new NullPointerException();
        }else{
            remoteController.removeShape(shape);
            remoteController.created_shapes.remove(shape);
        }
    }

    @Override
    public Shape[] getShapes() {
        Shape[] shapes = new Shape[shapeList.size()];
        Iterator<Shape> itr = shapeList.iterator();
        int i = 0 ;
        while (itr.hasNext()){
            shapes[i] = itr.next();
            i++;
        }
        return shapes;
    }


    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        if (oldShape == null || newShape==null){
            throw new NullPointerException();
        }else{
            remoteController.updateShape(oldShape, newShape);
        }
    }
    javafx.scene.shape.Line l;
    @Override
    public void undo() {
        Memento m=caretaker.undo();
        Pane p=new Pane();
        if(m.getAction().getState().toString().equalsIgnoreCase("removed"))
        {
                System.out.println(remoteController.created_shapes.size());
            int s=23+remoteController.created_shapes.size()-1;
            if(s>=23){
          pane.getChildren().remove(s,(remoteController.created_shapes.size()+23));
          remoteController.created_shapes.remove(remoteController.created_shapes.size()-1);
            }
else {}

        }
        else if(m.getAction().getState().toString().equalsIgnoreCase("added")){
          pane.getChildren().add(shape.deleted_Shapes.get(shape.deleted_Shapes.size()-1));
          shape.created.add(shape.deleted_Shapes.get(shape.deleted_Shapes.size()-1));
          shape.deleted_Shapes.remove(shape.deleted_Shapes.size()-1);
          }}


    @Override
    public void redo() {
        circleselected=false;
       Memento m= caretaker.redo();
       if(m.getAction().getState().toString().equalsIgnoreCase("removed")){
           pane.getChildren().remove(shape.created.get(shape.created.size()-1));
           shape.deleted_Shapes.add(shape.created.get(shape.created.size()-1));
           shape.created.remove(shape.created.size()-1);
       }
       if(m.getAction().getState().toString().equalsIgnoreCase("added")){
           if (m.getAction().getNewShape().get_type().equalsIgnoreCase("circle")){
               javafx.scene.shape.Circle c=new javafx.scene.shape.Circle();
              c.setRadius(((sample.View.Circle)m.getAction().getNewShape()).get_radius());
              c.setCenterX(((sample.View.Circle)m.getAction().getNewShape()).get_Centerx());
              c.setCenterY(((sample.View.Circle)m.getAction().getNewShape()).get_Centery());
              c.setFill(((sample.View.Circle)m.getAction().getNewShape()).getFillColor());
              c.setStrokeWidth(((sample.View.Circle)m.getAction().getNewShape()).get_strokewidth());
              c.setStroke(((sample.View.Circle)m.getAction().getNewShape()).getColor());
              c.setCursor(Cursor.MOVE);
               ((sample.View.Circle)m.getAction().getNewShape()).move(c);
              pane.getChildren().add(c);
           }
          else if (m.getAction().getNewShape().get_type().equalsIgnoreCase("rectangle")){
               javafx.scene.shape.Rectangle R=new javafx.scene.shape.Rectangle();
               R.setX(((sample.View.Rectangle)m.getAction().getNewShape()).getx());
               R.setY(((sample.View.Rectangle)m.getAction().getNewShape()).gety());
               R.setWidth(((sample.View.Rectangle)m.getAction().getNewShape()).get_width());
               R.setHeight(((sample.View.Rectangle)m.getAction().getNewShape()).get_height());
               R.setFill(((sample.View.Rectangle)m.getAction().getNewShape()).getFillColor());
               R.setStrokeWidth(((sample.View.Rectangle)m.getAction().getNewShape()).get_strokewidth());
               R.setStroke(((sample.View.Rectangle)m.getAction().getNewShape()).getColor());
               R.setCursor(Cursor.MOVE);
               ((sample.View.Rectangle)m.getAction().getNewShape()).move(R);
               pane.getChildren().add(R);
           } else if (m.getAction().getNewShape().get_type().equalsIgnoreCase("ellipse")){
               javafx.scene.shape.Ellipse e=new javafx.scene.shape.Ellipse();
               e.setRadiusX(((sample.View.Ellipse)m.getAction().getNewShape()).radius_x());
               e.setCenterX(((sample.View.Ellipse)m.getAction().getNewShape()).getCenterX());
               e.setCenterY(((sample.View.Ellipse)m.getAction().getNewShape()).getCenterY());
               e.setRadiusY(((sample.View.Ellipse)m.getAction().getNewShape()).radius_Y());
               e.setFill(((sample.View.Ellipse)m.getAction().getNewShape()).getFillColor());
               e.setStrokeWidth(((sample.View.Ellipse)m.getAction().getNewShape()).get_strokewidth());
               e.setStroke(((sample.View.Ellipse)m.getAction().getNewShape()).getColor());
               e.setCursor(Cursor.MOVE);
               ((sample.View.Ellipse)m.getAction().getNewShape()).move(e);
               pane.getChildren().add(e);
           }          else if (m.getAction().getNewShape().get_type().equalsIgnoreCase("square")){
               javafx.scene.shape.Rectangle R=new javafx.scene.shape.Rectangle();
               R.setX(((sample.View.Square)m.getAction().getNewShape()).getx());
               R.setY(((sample.View.Square)m.getAction().getNewShape()).gety());
               R.setWidth(((sample.View.Square)m.getAction().getNewShape()).get_side());
               R.setHeight(((sample.View.Square)m.getAction().getNewShape()).get_side());
               R.setFill(((sample.View.Square)m.getAction().getNewShape()).getFillColor());
               R.setStrokeWidth(((sample.View.Square)m.getAction().getNewShape()).get_strokewidth());
               R.setStroke(((sample.View.Square)m.getAction().getNewShape()).getColor());
               R.setCursor(Cursor.MOVE);
               ((sample.View.Square)m.getAction().getNewShape()).move(R);
               pane.getChildren().add(R);
           }         else if (m.getAction().getNewShape().get_type().equalsIgnoreCase("triangle")){
               javafx.scene.shape.Polygon p=new javafx.scene.shape.Polygon();
               p.getPoints().addAll(((sample.View.Triangle)m.getAction().getNewShape()).getx(),((sample.View.Triangle)m.getAction().getNewShape()).gety(),
                       ((sample.View.Triangle)m.getAction().getNewShape()).get_x2(),((sample.View.Triangle)m.getAction().getNewShape()).get_y2(),
                       ((sample.View.Triangle)m.getAction().getNewShape()).get_x3(),((sample.View.Triangle)m.getAction().getNewShape()).get_y3());
               p.setFill(((sample.View.Triangle)m.getAction().getNewShape()).getFillColor());
               p.setStrokeWidth(((sample.View.Triangle)m.getAction().getNewShape()).get_strokewidth());
               p.setStroke(((sample.View.Triangle)m.getAction().getNewShape()).getColor());
               p.setCursor(Cursor.MOVE);
               ((sample.View.Triangle)m.getAction().getNewShape()).move(p);
               pane.getChildren().add(p);
           }
       }

    }

    public void clearRedoStack() {
        caretaker.clearRedoStack();
    }

    public void clearUndoStack() {
        caretaker.clearUndoStack();
    }


    public void UndoSelected(ActionEvent actionEvent) {
        circleselected=false;
        squareselected=false;
        triangleselected=false;
        ellipseselected=false;
        rectangleselected=false;
        resizeselected=false;
        deleteselected=false;
        lineselected=false;
        undo();
    }

    public void RedoSelected(ActionEvent actionEvent) {

        circleselected=false;
        redo();

    }

    public void loadselected(ActionEvent actionEvent) {
        circleselected = false;
        loaded = File.load();
        for(int i=0;i<loaded.size();i++)
        if (loaded.get(i).get_type().equals("Rectangle")) {
            javafx.scene.shape.Rectangle R = new javafx.scene.shape.Rectangle();
            R.setHeight(((sample.View.Rectangle)loaded.get(i)).get_height());
            R.setWidth(((sample.View.Rectangle)loaded.get(i)).get_width());
            R.setX(((sample.View.Rectangle)loaded.get(i)).getx());
            R.setY(((sample.View.Rectangle)loaded.get(i)).gety());
            R.setStroke(((sample.View.Rectangle)loaded.get(i)).getColor());
            R.setFill(((sample.View.Rectangle)loaded.get(i)).getFillColor());
            R.setStrokeWidth(loaded.get(i).get_strokewidth());
         pane.getChildren().add(R);
    }else if (loaded.get(i).get_type().equals("Circle")){
            javafx.scene.shape.Circle c= new javafx.scene.shape.Circle();
            c.setRadius(((sample.View.Circle)loaded.get(i)).get_radius());
            c.setStrokeWidth(((sample.View.Circle)loaded.get(i)).get_strokewidth());
            c.setStroke(((sample.View.Circle)loaded.get(i)).getColor());
            c.setCenterY(((sample.View.Circle)loaded.get(i)).get_Centery());
            c.setCenterX(((sample.View.Circle)loaded.get(i)).get_Centerx());
            c.setFill(((sample.View.Circle)loaded.get(i)).getFillColor());
            pane.getChildren().add(c);
        }else if (loaded.get(i).get_type().equals("Ellipse")){
            javafx.scene.shape.Ellipse e= new javafx.scene.shape.Ellipse();
            e.setCenterX(((sample.View.Ellipse)loaded.get(i)).getCenterX());
            e.setCenterY(((sample.View.Ellipse)loaded.get(i)).getCenterY());
            e.setRadiusX(((sample.View.Ellipse)loaded.get(i)).radius_x());
            e.setRadiusY(((sample.View.Ellipse)loaded.get(i)).radius_Y());
            e.setStroke(((sample.View.Ellipse)loaded.get(i)).getColor());
            e.setFill(((sample.View.Ellipse)loaded.get(i)).getFillColor());
            e.setStrokeWidth(((sample.View.Ellipse)loaded.get(i)).get_strokewidth());
            pane.getChildren().add(e);
        }else if (loaded.get(i).get_type().equals("Triangle")){
           javafx.scene.shape.Polygon t=new javafx.scene.shape.Polygon();
           t.getPoints().addAll((((sample.View.Triangle)loaded.get(i)).getx()),(((sample.View.Triangle)loaded.get(i)).gety()),
                   (((sample.View.Triangle)loaded.get(i)).get_x2()),(((sample.View.Triangle)loaded.get(i)).get_y2()),
                   ( ((sample.View.Triangle)loaded.get(i)).get_x3()),
                   (((sample.View.Triangle)loaded.get(i)).get_y3()));
            pane.getChildren().add(t);
        }
        else if (loaded.get(i).get_type().equals("Line")){
            javafx.scene.shape.Line l=new javafx.scene.shape.Line();
            l.setStartX(((sample.View.Line)loaded.get(i)).getx());
            l.setStartY(((sample.View.Line)loaded.get(i)).gety());
            l.setEndX(((sample.View.Line)loaded.get(i)).end_x());
            l.setEndY(((sample.View.Line)loaded.get(i)).end_y());
            l.setFill(((sample.View.Line)loaded.get(i)).getColor());
            l.setStroke(((sample.View.Line)loaded.get(i)).getFillColor());
            pane.getChildren().add(l);
        }
        else if (loaded.get(i).get_type().equals("Square")){
            javafx.scene.shape.Rectangle r=new javafx.scene.shape.Rectangle();
            r.setHeight(((sample.View.Square)loaded.get(i)).get_side());
            r.setWidth(((sample.View.Square)loaded.get(i)).get_side());
            r.setX(((sample.View.Square)loaded.get(i)).getx());
            r.setY(((sample.View.Square)loaded.get(i)).gety());
            r.setStroke(((sample.View.Square)loaded.get(i)).getColor());
            r.setFill(((sample.View.Square)loaded.get(i)).getFillColor());
            r.setStrokeWidth(loaded.get(i).get_strokewidth());
            pane.getChildren().add(r);
        }
    }

    public void saveselected(ActionEvent actionEvent) {
        File.save();
    }
}