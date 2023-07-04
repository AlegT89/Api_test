import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InitialJson extends Values {
    String  requestBody = null;

    {
        String initialBody = null;
        try {
            initialBody = new String(Files.readAllBytes(Paths.get("src/test/java/resourses.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert initialBody != null;
        JSONObject jsonObject = new JSONObject(initialBody);
        jsonObject.put("id", petId);
        jsonObject.put("name", petName);
        requestBody = jsonObject.toString();
        System.out.println(requestBody);
    }
}
