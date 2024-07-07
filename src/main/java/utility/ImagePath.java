package utility;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ImagePath {
    public static String getImagePath(String imageName) {
        Path rootPath = Paths.get(System.getProperty("user.dir"));
        Path imagePath = rootPath.resolve("src").resolve("main").resolve("java").resolve("resources").resolve(imageName);
        return imagePath.toString();
    }
}
