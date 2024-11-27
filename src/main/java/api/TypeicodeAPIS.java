package api;
import java.sql.ResultSet;
import constants.Constants;
import io.restassured.response.Response;
import pojo.ApiEndpoints;
import pojo.UserDetails;
import pojo.Todo;
import utils.RestClient;
import java.util.*;
import java.util.stream.Collectors;
import java.util.List;

public class TypeicodeAPIS {
    public static String typeicodeBaseUri = "http://jsonplaceholder.typicode.com";

    public Integer checkUsersApi() {
        Response resBody = RestClient.ResponseBody(ApiEndpoints.USERS.getUri());

        return resBody.getStatusCode();
    }

    public Integer checkTodosApi() {
        Response resBody = RestClient.ResponseBody(ApiEndpoints.TODOS.getUri());
        return resBody.getStatusCode();
    }
    public Integer checkPostsApi(){
        Response resBody = RestClient.ResponseBody(ApiEndpoints.POSTS.getUri());
        return resBody.getStatusCode();
    }

    public List<Integer> getEligibleUsersIds() {
        Response resBody = RestClient.ResponseBody(ApiEndpoints.USERS.getUri());
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

        List<Integer> ids = filteredUsers.stream().map(UserDetails::getId).toList();
        return ids;
    }

    public  Map<Integer, Double> taskCompletionPercentage(List<Integer> ids) {
        Map<Integer, Double> userIdToCompletionPercentage = new HashMap<>();
        Response resBody = RestClient.ResponseBody(ApiEndpoints.TODOS.getUri());
        List<Todo> todos = List.of(resBody.as(Todo[].class));
        Map<Integer, List<Todo>> filteredTasks = todos.stream().filter(todo -> ids.contains(todo.getUserId())).collect(Collectors.groupingBy(Todo::getUserId));

        //System.out.println(filteredTasks);
        for (Integer userId : ids) {
            List<Todo> userTodos = filteredTasks.getOrDefault(userId, Collections.emptyList());
            int totalTasks = userTodos.size();
            double completedCount = userTodos.stream().filter(Todo::isCompleted).count();
            double complPerc = (completedCount / totalTasks) * 100;
            userIdToCompletionPercentage.put(userId, complPerc);
        }
        return userIdToCompletionPercentage;

    }
    public Integer checkCommentsApi(){
        Response resBody = RestClient.ResponseBody(ApiEndpoints.COMMENTS.getUri());
        return resBody.getStatusCode();
    }

    public Integer checkAlbumsApi(){
        Response resBody = RestClient.ResponseBody((ApiEndpoints.ALBUMS.getUri()));
        return resBody.getStatusCode();
    }

    public Integer checkPhotosApi(){
        Response resBody = RestClient.ResponseBody(ApiEndpoints.PHOTOS.getUri());
        return resBody.getStatusCode();
    }
}
