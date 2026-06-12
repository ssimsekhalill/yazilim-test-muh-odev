import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {


    @Test
    public void kullaniciGetirTesti() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .statusCode(200)
                .time(lessThan(5000L))
                .body("name", equalTo("Leanne Graham"))
                .log().all();
    }



    @Test
    public void yeniKullaniciYaratTesti() {
        String gonderilecekVeri = "{\n" +
                "    \"name\": \"Ahmet\",\n" +
                "    \"job\": \"Test Muhendisi\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(gonderilecekVeri)
                .when()
                .post("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(201)
                .time(lessThan(5000L))
                .body("name", equalTo("Ahmet"))
                .log().all();
    }
}