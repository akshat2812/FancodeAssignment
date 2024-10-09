package utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public class RequestBuilder {
    private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    public RequestBuilder(){

    }
    public RequestSpecification build() {
        return this.requestSpecBuilder.build();
    }

    public RequestBuilder setBaseUri(String uri) {
        this.requestSpecBuilder = this.requestSpecBuilder.setBaseUri(uri);
        return this;
    }

    public RequestBuilder setBasePath(String path) {
        this.requestSpecBuilder = this.requestSpecBuilder.setBasePath(path);
        return this;
    }
}
