package utility;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class TestDataReader {
    private static final String TESTDATA_FILE_PATH = "testData.json";

    public static int getInterestCount() {
        try (FileReader fileReader = new FileReader(TESTDATA_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return jsonObject.get("interestCount").getAsInt();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getTimerValue() {
        try (FileReader fileReader = new FileReader(TESTDATA_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return jsonObject.get("timerValue").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return "00:00:00";
        }
    }

    public static String getAvatarImage() {
        try (FileReader fileReader = new FileReader(TESTDATA_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return getAvatarImageFromJson(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getAvatarImageFromJson(JsonObject jsonObject) {
        return jsonObject.get("avatarImage").getAsString();
    }
}
