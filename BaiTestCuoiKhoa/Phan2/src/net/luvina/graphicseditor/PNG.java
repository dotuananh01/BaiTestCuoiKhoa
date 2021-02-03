package net.luvina.graphicseditor;

public class PNG implements iFile {
    @Override
    public void openFile() {
        System.out.println("Open file JPG");
    }

    @Override
    public void parseFile() {
        System.out.println("Parse file JPG");
    }

    @Override
    public void saveFile() {
        System.out.println("Save file JPG");
    }
}
