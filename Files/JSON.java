package sample.Files;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sample.ShapeFactory;
import sample.View.FileStrategy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSON implements  FileStrategy {
    JSONObject ob ;
    JSONArray list = new JSONArray();
    @Override
    public void save(String Path, ArrayList<sample.Shape> shapes) {
        try {
            FileWriter file = new FileWriter(Path);

            for (int i = 0;i<shapes.size();i++) {
                 ob = new JSONObject();
                 Shape shape=null;
                if (shapes.get(i).get_type().equals("Line")) {
                    ob.put("Type", "Line");
                    ob.put("Start-x",((sample.View.Line)shapes.get(i)).getx());
                    ob.put("Start-y", ((sample.View.Line)shapes.get(i)).gety());
                    ob.put("end-x", ((sample.View.Line)shapes.get(i)).end_x());
                    ob.put("end-y", ((sample.View.Line)shapes.get(i)).end_y());
                    ob.put("fillColor", shapes.get(i).getColor().toString());
                    ob.put("StrokeWidth",((sample.View.Line)shapes.get(i)).get_strokewidth());

                } else if (shapes.get(i).get_type().equals("Rectangle")) {
                    ob.put("Type", "Rectangle");
                    ob.put("Start-x", ((sample.View.Rectangle)shapes.get(i)).getx());
                    ob.put("Start-y", ((sample.View.Rectangle)shapes.get(i)).gety());
                    ob.put("end-x",  ((sample.View.Rectangle)shapes.get(i)).get_width());
                    ob.put("end-y", ((sample.View.Rectangle)shapes.get(i)).get_height());
                    ob.put("getStroke", shapes.get(i).getColor().toString());
                    ob.put("fillColor", shapes.get(i).getFillColor().toString());
                    ob.put("StrokeWidth",((sample.View.Rectangle)shapes.get(i)).get_strokewidth());

                } else if (shapes.get(i).get_type().equals("Ellipse")) {
                    ob.put("Type", "Ellipse");
                    ob.put("Start-x",((sample.View.Ellipse)shapes.get(i)).getx());
                    ob.put("Start-y",((sample.View.Ellipse)shapes.get(i)).gety());
                    ob.put("setCenterX", ((sample.View.Ellipse)shapes.get(i)).getCenterX());
                    ob.put("setCenterY", ((sample.View.Ellipse)shapes.get(i)).getCenterY());
                    ob.put("setRadiusX", ((sample.View.Ellipse)shapes.get(i)).radius_x());
                    ob.put("setRadiusY", ((sample.View.Ellipse)shapes.get(i)).radius_Y());
                    ob.put("getStroke", shapes.get(i).getColor().toString());
                    ob.put("fillColor", shapes.get(i).getFillColor().toString());
                    ob.put("StrokeWidth", ((sample.View.Ellipse)shapes.get(i)).get_strokewidth());
                } else if (shapes.get(i).get_type().equals("Circle")) {
                    ob.put("Type","Circle");
                    ob.put("Start-x", shapes.get(i).getx());
                    ob.put("Start-y", (shapes.get(i)).gety());
                    ob.put("setCenterX",((sample.View.Circle)shapes.get(i)).get_Centerx());
                    ob.put("setCenterY", ((sample.View.Circle)shapes.get(i)).get_Centery());
                    ob.put("setRadiusX", ((sample.View.Circle)shapes.get(i)).get_radius());
                    ob.put("getStroke", shapes.get(i).getColor().toString());
                    ob.put("fillColor", shapes.get(i).getFillColor().toString());
                    ob.put("StrokeWidth", ((sample.View.Circle)shapes.get(i)).get_strokewidth());
                } else if (shapes.get(i).get_type().equals("triangle")) {
                    ob.put("Type", "Triangle");
                    ob.put("Start-x",((sample.View.Triangle)shapes.get(i)).getx());
                    ob.put("Start-y",((sample.View.Triangle)shapes.get(i)).gety());
                    ob.put("Start-x1",((sample.View.Triangle)shapes.get(i)).get_x2());
                    ob.put("Start-y1",((sample.View.Triangle)shapes.get(i)).get_y2());
                    ob.put("Start-x2",((sample.View.Triangle)shapes.get(i)).get_x3());
                    ob.put("Start-y2",((sample.View.Triangle)shapes.get(i)).get_y3());
                    ob.put("fillColor", shapes.get(i).getFillColor().toString());
                    ob.put("getStroke", shapes.get(i).getColor().toString());
                    ob.put("StrokeWidth",((sample.View.Triangle)shapes.get(i)).get_strokewidth());
                }
                else if (shapes.get(i).get_type().equals("Square")) {
                    ob.put("Type", "Square");
                    ob.put("Start-x",((sample.View.Square)shapes.get(i)).getx());
                    ob.put("Start-y",((sample.View.Square)shapes.get(i)).gety());
                    ob.put("SideLength",((sample.View.Square)shapes.get(i)).get_side());
                    ob.put("getStroke",  shapes.get(i).getColor().toString());
                    ob.put("fillColor", shapes.get(i).getFillColor().toString());
                    ob.put("StrokeWidth",((sample.View.Square)shapes.get(i)).get_strokewidth());
                }


                list.add(ob);
            }
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
        try (FileWriter file = new FileWriter(Path)) {
            list.writeJSONString(file);
            file.flush();
            file.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public ArrayList<sample.Shape> load(String filepath) {
        JSONParser parser = new JSONParser();
        ArrayList<sample.Shape> shapesList = new ArrayList<>();
        ShapeFactory shapeFactory = new ShapeFactory();
        javafx.scene.shape.Shape shape = null;
        sample.Shape shape1=null;

        double startX = 0;
        double startY = 0;
        double endX = 0;
        double endY = 0;
        double centerX = 0;
        double centerY = 0;
        double radius = 0;
        double radiusX = 0;
        double radiusY = 0;
        double height=0;
        double width=0;
        double sidelength=0;
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader(filepath));
            for (Object o : array) {
                JSONObject jsonObject = (JSONObject) o;
                String name = (String) jsonObject.get("Type");
                String color = (String) jsonObject.get("getStroke");
                String fillColor = (String) jsonObject.get("fillColor");
                double strokeWidth = (Double) jsonObject.get("StrokeWidth");

                if (name.equals("Line") ) {
                    startX = (Double) jsonObject.get("Start-x");
                    startY = (Double) jsonObject.get("Start-y");
                    endX = (Double) jsonObject.get("end-x");
                    endY = (Double) jsonObject.get("end-y");
                } else if (name.equals("Circle")) {
                    startX = (Double) jsonObject.get("Start-x");
                    System.out.println(startX);
                    startY = (Double) jsonObject.get("Start-y");
                    centerX = (Double) jsonObject.get("setCenterX");
                    centerY = (Double) jsonObject.get("setCenterY");
                    radius = (Double) jsonObject.get("setRadiusX");
                } else if (name.equals("Ellipse")) {
                    startX = (Double) jsonObject.get("Start-x");
                    startY = (Double) jsonObject.get("Start-y");
                    centerX = (Double) jsonObject.get("setCenterX");
                    centerY = (Double) jsonObject.get("setCenterY");
                    radiusX = (Double) jsonObject.get("setRadiusX");
                    radiusY = (Double) jsonObject.get("setRadiusY");
                }else if(name.equals("Rectangle")){

                    startX = (Double) jsonObject.get("Start-x");
                    startY = (Double) jsonObject.get("Start-y");
                    endX = (Double) jsonObject.get("end-x");
                    endY = (Double) jsonObject.get("end-y");

                }else if(name.equals("Square")){
                    startX = (Double) jsonObject.get("Start-x");
                    startY = (Double) jsonObject.get("Start-y");
                    endX = (Double) jsonObject.get("SideLength");
                    endY = (Double) jsonObject.get("SideLength");
                }
                shape1=shapeFactory.constructshape(name);

                shape1.setFillColor(Color.valueOf(fillColor));
                shape1.setColor(Color.valueOf(color));
                shape1.getsize(strokeWidth);
                switch (name) {
                    case "Line":
                        ((sample.View.Line)shape1).getinfog(startX,startY,endX,endY);
                        System.out.println(shape1.getx() + " " + shape1.gety());
                        break;

                    case "Rectangle":
                        ((sample.View.Rectangle)shape1).setX(startX);
                        ((sample.View.Rectangle)shape1).sety(startY);
                        ((sample.View.Rectangle)shape1).set_width(endX);
                        ((sample.View.Rectangle)shape1).set_height(endY);
                        break;
                    case "Square":
                        ((sample.View.Square)shape1).getInfog(startX,startY,endX,endY);
                        ((sample.View.Square)shape1).setX(startX);
                        ((sample.View.Square)shape1).setY(startY);
                        ((sample.View.Square)shape1).side(endX);

                        break;
                    case "Circle":
                        ((sample.View.Circle)shape1).setRadius(radius);
                        ((sample.View.Circle)shape1).setcenterx(centerX);
                        ((sample.View.Circle)shape1).setcentery(centerY);
                        break;
                    case "Ellipse":
                        ((sample.View.Ellipse)shape1).setCenterX(centerX);
                        ((sample.View.Ellipse)shape1).setCenterY(centerY);
                        ((sample.View.Ellipse)shape1).setRadius_x(radiusX);
                        ((sample.View.Ellipse)shape1).setRadius_Y(radiusY);
                        break;
                }


            }
shapesList.add(shape1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return shapesList;


    }
}

