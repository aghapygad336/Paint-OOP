package sample.Files;

import javafx.scene.paint.Color;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import sample.Shape;
import sample.ShapeFactory;
import sample.View.FileStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class XML implements FileStrategy {

    @Override
    public void save(String Path, ArrayList<sample.Shape> shapes)  {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("shapes");
        document.setRootElement(root);
        Element element;
        try
        {
            FileWriter file = new FileWriter(Path);
            for (Shape List : shapes)
            {
                element = document.getRootElement().addElement("element").addAttribute(
                        "name", ((Shape) List).get_type()).addAttribute(
                        "color", List.getColor().toString()).addAttribute(
                        "strokeWidth", List.get_strokewidth() + "").addAttribute(
                        "fillColor", List.getFillColor().toString());

                if (List.get_type().equalsIgnoreCase("line"))
                {
                    element.addAttribute("start-x",
                            ((sample.View.Line) List).getx() + "").addAttribute(
                            "start-y", ((sample.View.Line) List).gety() + "").addAttribute(
                            "stroke", ((sample.View.Line) List).get_strokewidth() + "").addAttribute(
                            "end-x", ((sample.View.Line) List).end_x() + "").addAttribute(
                            "end-y", ((sample.View.Line) List).end_y()+ "");
                }
                else if (List.get_type().equalsIgnoreCase("Rectangle"))
                {
                    element.addAttribute("start-x",
                            ((sample.View.Rectangle) List).getx() + "").addAttribute(
                            "start-y", ((sample.View.Rectangle) List).gety() + "").addAttribute(
                            "end-x", ((sample.View.Rectangle) List).get_width() + "").addAttribute(
                            "end-y", ((sample.View.Rectangle)List).get_height() + "");
                }
                else if (List.get_type().equalsIgnoreCase("square"))
                {
                    element.addAttribute("start-x",
                            ((sample.View.Square)List).getx() + "").addAttribute(
                            "start-y", ((sample.View.Square) List).gety() + "").addAttribute(
                            "end-x", ((sample.View.Square)List).get_side() + "").addAttribute(
                            "end-y", ((sample.View.Square) List).get_side() + "");
                }
                else if (List.get_type().equalsIgnoreCase("circle"))
                {
                    element.addAttribute("start-x",
                            ((sample.View.Circle) List).getx() + "").addAttribute(
                            "start-y", ((sample.View.Circle) List).gety() + "").addAttribute(
                            "center-x", ((sample.View.Circle) List).get_Centerx() + "").addAttribute(
                            "center-y", ((sample.View.Circle) List).get_Centery() + "").addAttribute(
                            "radius", ((sample.View.Circle) List).get_radius()+ "");
                }
                else if (List.get_type().equals("Ellipse"))
                {
                    element.addAttribute("start-x",
                            ((sample.View.Ellipse) List).getx() + "").addAttribute(
                            "start-y", ((sample.View.Ellipse) List).gety() + "").addAttribute(
                            "center-x", ((sample.View.Ellipse) List).getCenterX() + "").addAttribute(
                            "center-y", ((sample.View.Ellipse) List).getCenterY() + "").addAttribute(
                            "radius-x", ((sample.View.Ellipse) List).radius_x() + "").addAttribute(
                            "radius-y", ((sample.View.Ellipse) List).radius_Y() + "");
                }
            }
            document.write(file);
            file.flush();
            file.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } }

    @Override
    public ArrayList<sample.Shape> load(String Path) {
       String[] array = new String[20];
        ShapeFactory s = new ShapeFactory();
        Shape shape;
        ArrayList<Shape> shapesList = new ArrayList<>();
        int j=0;

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new FileReader(Path));
            Element root = document.getRootElement();

            for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
                Element element = it.next();

                for (Iterator<Attribute> i = element.attributeIterator(); i.hasNext();) {
                    Attribute attribute = i.next();
                    array[j++] = attribute.getValue();
                }
                j=0;

                shape = s.constructshape(array[0]);
                shape.setColor(Color.web(array[1]));
                shape.getsize(Double.parseDouble(array[2]));
                shape.setFillColor(Color.web(array[3]));
                if(shape.get_type().equalsIgnoreCase("line"))
                {
                    ((sample.View.Line)shape).set_x(Double.parseDouble(array[4]));
                    ((sample.View.Line)shape).set_y(Double.parseDouble(array[5]));
                    ((sample.View.Line)shape).getsize(Double.parseDouble(array[6]));
                    ((sample.View.Line)shape).set_endx(Double.parseDouble(array[7]));
                    ((sample.View.Line)shape).set_endy(Double.parseDouble(array[8]));
                }
                else if(shape.get_type().equalsIgnoreCase("rectangle"))
                {
                    ((sample.View.Rectangle)shape).setX(Double.parseDouble(array[4]));
                    ((sample.View.Rectangle)shape).sety( Double.parseDouble(array[5]));
                    ((sample.View.Rectangle)shape).set_width(Double.parseDouble(array[6]));
                    ((sample.View.Rectangle)shape).set_height(Double.parseDouble(array[7]));
                }
                else if(shape.get_type().equalsIgnoreCase("square"))
                {
                    ((sample.View.Square)shape).setX(Double.parseDouble(array[4]));
                    ((sample.View.Square)shape).setY(Double.parseDouble(array[5]));
                    ((sample.View.Square)shape).side(Double.parseDouble(array[6]));
                }
                else if(shape.get_type().equalsIgnoreCase("circle"))
                {
                    ((sample.View.Circle)shape).set_x(Double.parseDouble(array[4]));
                    ((sample.View.Circle)shape).set_y(Double.parseDouble(array[5]));
                    ((sample.View.Circle)shape).setcenterx(Double.parseDouble(array[6]));
                    ((sample.View.Circle)shape).setcentery(Double.parseDouble(array[7]));
                    ((sample.View.Circle)shape).setRadius(Double.parseDouble(array[8]));
                }
                else if(shape.get_type().equalsIgnoreCase("ellipse"))
                {
                    ((sample.View.Ellipse)shape).set_x(Double.parseDouble(array[4]));
                    ((sample.View.Ellipse)shape).set_y(Double.parseDouble(array[5]));
                    ((sample.View.Ellipse)shape).setCenterX(Double.parseDouble(array[6]));
                    ((sample.View.Ellipse)shape).setCenterY( Double.parseDouble(array[7]));
                    ((sample.View.Ellipse)shape).setRadius_x(Double.parseDouble(array[8]));
                    ((sample.View.Ellipse)shape).setRadius_Y(Double.parseDouble(array[9]));

                }

                shapesList.add(shape);
            }
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return shapesList;
    }}

