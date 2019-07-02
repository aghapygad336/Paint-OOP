package sample.View;

import java.util.ArrayList;

public interface FileStrategy {
    void save(String Path, ArrayList<sample.Shape> shapes);
    ArrayList<sample.Shape> load(String stringg);
}
