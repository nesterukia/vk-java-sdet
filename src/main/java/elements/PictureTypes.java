package elements;

import java.io.File;

public enum PictureTypes {
    GIF(new File("src/pics/cat.gif")),
    HEIC(new File("src/pics/cat.heic")),
    JPG(new File("src/pics/cat.jpg")),
    PNG(new File("src/pics/cat.png")),
    WEBP(new File("src/pics/cat.webp"));

    private File file;

    PictureTypes(File file){
        this.file = file;
    }

    public File getFile(){
        return file;
    }
}
