
import org.json.JSONObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Methods extends InitialJson {
    protected RequestSpecification getByStatus(String status) {
        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setBasePath("pet/findByStatus")
                .addQueryParam("status", status)
                .build();
    }

    protected RequestSpecification getAddPet (String body) {
        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setBasePath("pet")
                .setBody (body)
                .setContentType("application/json")
                .build();
    }

    protected RequestSpecification getChangePetInfo (String name) {
        JSONObject jsonObject = new JSONObject(requestBody);
        jsonObject.put("name", name);
        requestBody = jsonObject.toString();

        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setBasePath("pet")
                .setBody ( requestBody)
                .setContentType("application/json")
                .build();
    }

    protected RequestSpecification getDeletePet(Integer petId) {
        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setBasePath("pet/" + petId.toString())
                .build();
    }
}
