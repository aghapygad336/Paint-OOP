package sample;

public class Pane {
    private static Pane p;
    private Pane(){}
    public static Pane getInstance(){
        if(p==null)
            p=new Pane();

        return p;

    }

}
