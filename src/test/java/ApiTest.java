
import org.junit.Test;
import org.junit.jupiter.api.Order;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest extends Methods {

    @Test
    @Order(1)
    public void findByStatus(){
        given(getByStatus(status))
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    @Order(2)
    public void addNewPet() {

        given(getAddPet(requestBody))
                .post()
                .then()
                .statusCode(200)
                .body("id", is(petId))
                .body("name", is(petName))
                .extract().response();
    }

    @Test
    @Order(3)
    public void changeInfoPet() {

        given(getChangePetInfo(changedPetName))
                .post()
                .then()
                .statusCode(200)
                .body("id", is(petId))
                .body("name", is(changedPetName))
                .extract().response();
    }

    @Test
    @Order(4)
    public void deletePet() {

        given(getDeletePet(petId))
                    .delete()
                    .then()
                    .statusCode(200);
    }
}

