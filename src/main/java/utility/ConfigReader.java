package utility;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    private static final String CONFIG_FILE_PATH = "config.json";

    public static int getTimeoutSeconds() {
        try (FileReader fileReader = new FileReader(CONFIG_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return jsonObject.get("timeoutSeconds").getAsInt();
        } catch (IOException e) {
            e.printStackTrace();
            return 10;
        }
    }

    public static int getTimeoutMs() {
        try (FileReader fileReader = new FileReader(CONFIG_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return jsonObject.get("timeoutMs").getAsInt();
        } catch (IOException e) {
            e.printStackTrace();
            return 1000;
        }
    }
    public static String getAppUrl() {
        try (FileReader fileReader = new FileReader(CONFIG_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return jsonObject.get("appUrl").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
