package assignment;

import api.TypeicodeAPIS;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;


public class Fancode{

    public TypeicodeAPIS typeicodeAPIS = new TypeicodeAPIS();

    @Test(priority = 1)
    public void checkUsersApi(){
        Integer respCode = typeicodeAPIS.checkUsersApi();
        Assert.assertEquals(respCode,200,"Users api connection is stable");
    }

    @Test(priority = 1)
    public void checkTodisApi(){
        Integer respCode = typeicodeAPIS.checkTodosApi();
        Assert.assertEquals(respCode,200,"Todos Api connection is stable");
    }

    @Test(priority = 2)
    public void getEligibleUsers() {

        Assert.assertFalse(typeicodeAPIS.getEligibleUsersIds().isEmpty(),"No users found in Fancode city");

    }

    @Test(priority = 3)
    public void checkUsersTasks(){
        double passingPercentValue = 50;
        List<Integer> ids =typeicodeAPIS.getEligibleUsersIds();
        Map<Integer,Double> userCompletionPercentage = typeicodeAPIS.taskCompletionPercentage(ids);
        userCompletionPercentage.forEach((userId,complPerc)->{
            Assert.assertTrue( complPerc > passingPercentValue,"User Id"+ userId+"has less than 50% tasks completed,with value:"+complPerc);
        });
    }

    @Test(priority = 4)
    public void checkPostsApi(){
        Integer respCode = typeicodeAPIS.checkPostsApi();
        Assert.assertEquals(respCode,200,"Posts api connection is stable");
    }

    @Test(priority = 4)
    public void checkCommentsApi(){
        Integer respCode = typeicodeAPIS.checkCommentsApi();
        Assert.assertEquals(respCode,200,"Comments api connection is stable");
    }

    @Test(priority = 4)
    public void checkAlbumsApi(){
        Integer respCode = typeicodeAPIS.checkAlbumsApi();
        Assert.assertEquals(respCode,200,"Albums api connection is stable");
    }
    @Test(priority = 4)
    public void checkPhotosApi(){
        Integer respCode = typeicodeAPIS.checkPhotosApi();
        Assert.assertEquals(respCode,200,"Photos api connection is stable");
    }


}
