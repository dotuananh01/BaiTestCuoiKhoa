package net.luvina.graphicseditor;

public class BMP implements iFile {
    @Override
    public void openFile() {
        System.out.println("Open file BMP");
    }

    @Override
    public void parseFile() {
        System.out.println("Parse file BMP");
    }

    @Override
    public void saveFile() {
        System.out.println("Save file BMP");
    }
}
