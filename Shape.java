package sample;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public interface Shape {
    public ArrayList<Shape> createdshapes = new ArrayList<>();
    public ArrayList<javafx.scene.shape.Shape> cs = new ArrayList<>();
    public ArrayList<javafx.scene.shape.Shape>created=new ArrayList<>();
    List<javafx.scene.shape.Shape> selected_Shapes = new ArrayList<>();
    List<javafx.scene.shape.Shape> deleted_Shapes = new ArrayList<>();
    List<javafx.scene.shape.Circle> cirlces = new ArrayList<>();
    List<javafx.scene.shape.Rectangle> Rectangles = new ArrayList<>();
    List<javafx.scene.shape.Polygon> triangles = new ArrayList<>();
    List<javafx.scene.shape.Ellipse> ellipse = new ArrayList<>();
    public Shape[] getShapes();
    void setPosition(Point2D position);
    Point2D getPosition();
    public double getx();
    public double gety();
    public String get_type();
    void setColor(Color color);
    Color getColor();
    java.awt.Color setFillColor(Color color);
    Color getFillColor();
    void draw(Object pane,int z);
    void getsize(double x);
    void removeextra(Pane pane);
    public double get_strokewidth();
}

