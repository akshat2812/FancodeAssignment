import io.restassured.response.Response;

import org.testng.annotations.Test;
import pojo.UserDetails;
import pojo.Users;
import utils.RestClient;
import pojo.ApiEndpoints;
import constants.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class Fancode{
    @Test(priority = 1)
    public void getEligibleUsers() {
        Response resBody = RestClient.ReponseBody(ApiEndpoints.USERS.getUri());
        List<UserDetails> users = List.of(resBody.as(UserDetails[].class));

        List<UserDetails> filteredUsers = users.stream()
                .filter(userDetails -> {
                    double lat = Double.parseDouble(userDetails.getAddress().getGeo().getLat());
                    double lng = Double.parseDouble(userDetails.getAddress().getGeo().getLng());
                    return (lat >= Constants.START_LAT && lat <= Constants.END_LAT)
                            && (lng >= Constants.START_LONG && lng <= Constants.END_LONG);
                })
                .toList();

        //System.out.println(filteredUsers);

        List<Integer> ids =  filteredUsers.stream().map(UserDetails::getId).toList();
        //System.out.println(ids);
    }

}
