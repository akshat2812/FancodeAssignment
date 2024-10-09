package api;

import constants.Constants;
import constants.StatusCodes;
import io.restassured.response.Response;
import pojo.ApiEndpoints;
import pojo.UserDetails;
import pojo.Users;
import utils.RestClient;

import java.util.List;

public class TypeicodeAPIS {
    public static String typeicodeBaseUri = "http://jsonplaceholder.typicode.com";
    boolean shouldWeSkipLogs;
    Response response;

    StatusCodes defaultStatus = StatusCodes.OK;
    private StatusCodes expectedStatusCode = null;


}
