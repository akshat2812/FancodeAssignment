package utils;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import api.TypeicodeAPIS;
public class RestClient {
    public static Response ResponseBody(String uri){
        RestAssured.baseURI = TypeicodeAPIS.typeicodeBaseUri;
        return given().header("Content-Type","application/json").when().get(uri);

    }
}
