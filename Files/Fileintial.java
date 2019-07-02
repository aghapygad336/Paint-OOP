package sample.Files;

import javafx.stage.FileChooser;
import sample.Main;
import sample.Shape;
import sample.View.FileStrategy;

import java.io.File;
import java.util.ArrayList;
public class Fileintial {
    FileChooser  fileChooser;
    FileStrategy fileStrategy;
    private File file;
    String extension;

    public Fileintial()  {

        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("JSON",
                "*.json", "*.xml");

        fileChooser.getExtensionFilters().add(extensionFilter);
    }

    public void save()  {
        fileChooser.setTitle("Save");
        file = fileChooser.showSaveDialog(Main.stage);
        extension = getFileExtension(file.getName());
        if (extension.equals("json")) fileStrategy = new JSON();
        else fileStrategy = new XML();
        fileStrategy.save(file.getAbsolutePath(), Shape.createdshapes); }

    private String getFileExtension(String extension){
        return extension.substring(extension.lastIndexOf(".")+1);
    }
    public ArrayList<Shape> load() {
        fileChooser.setTitle("Open");
        file = fileChooser.showOpenDialog(Main.stage);
        extension = getFileExtension(file.getName());
        if (extension.equals("json")) fileStrategy = new JSON();
        else fileStrategy = new XML();
        return fileStrategy.load(file.getAbsolutePath());
    }
}