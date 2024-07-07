package utility;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ImageUploadUtility {
    public static void uploadImage(String imagePath) {
        try {
            Robot robot = new Robot();

            robot.delay(ConfigReader.getTimeoutMs());

            StringSelection stringSelection = new StringSelection(imagePath);

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            // Simulate Ctrl+V (paste)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Simulate Enter key
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Wait for the file upload to complete (adjust the delay as needed)
            robot.delay(ConfigReader.getTimeoutMs());
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
}
