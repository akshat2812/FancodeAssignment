package assignment;

import api.TypeicodeAPIS;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.TestReportUtils;

public class Fancode{
    private ExtentTest test;
    public TypeicodeAPIS typeicodeAPIS = new TypeicodeAPIS();
    List<Integer> userIds;

    @BeforeClass
    public void setUpClass() {
        TestReportUtils.initReport();

    }
    @Test(priority = 1)
    public void checkUsersApi(){
        test =TestReportUtils.createTest("Checking Users Api");
        Integer respCode = typeicodeAPIS.checkUsersApi();
        test.info("Status Code received:" + respCode);
        Assert.assertEquals(respCode,200,"Users api connection is stable");
    }

    @Test(priority = 1)
    public void checkTodisApi(){
        test = TestReportUtils.createTest("Checking Todos Api");
        Integer respCode = typeicodeAPIS.checkTodosApi();
        test.info("Status Code received:" + respCode);
        Assert.assertEquals(respCode,200,"Todos Api connection is stable");
    }

    @Test(priority = 2)
    public void getEligibleUsers() {
        test = TestReportUtils.createTest("Finding users belonging to Fancode City given the lat long conditions.");
        List<Integer> userIds = typeicodeAPIS.getEligibleUsersIds();
        this.userIds = userIds;
        test.info("Users belonging to Fancode City: " +userIds);
        Assert.assertFalse(userIds.isEmpty(),"No users found in Fancode city");

    }

    @Test(priority = 3)
    public void checkUsersTasks(){
        test = TestReportUtils.createTest("Checking users belonging to Fancode city have more than 50% completed tasks.");

        double passingPercentValue = 50;
        List<Integer> ids =typeicodeAPIS.getEligibleUsersIds();
        Map<Integer,Double> userCompletionPercentage = typeicodeAPIS.taskCompletionPercentage(ids);
        userCompletionPercentage.forEach((userId,complPerc)->{
            test.info("Given user "+ userId +" has completed "+ complPerc+ "% tasks");
            Assert.assertTrue( complPerc > passingPercentValue,String.format("User Id %s has less than 50%% tasks completed,with value: %s",userId,complPerc));


        });
    }

    @Test(priority = 4)
    public void checkPostsApi(){
        test = TestReportUtils.createTest("Checking Posts Api");
        Integer respCode = typeicodeAPIS.checkPostsApi();

        test.info("Status Code received:" + respCode);
        Assert.assertEquals(respCode,200,"Posts api connection is stable");
    }

    @Test(priority = 4)
    public void checkCommentsApi(){
        test = TestReportUtils.createTest("Checking Comments Api");
        Integer respCode = typeicodeAPIS.checkCommentsApi();
        test.info("Status Code received:" + respCode);
        Assert.assertEquals(respCode,200,"Comments api connection is stable");
    }

    @Test(priority = 4)
    public void checkAlbumsApi(){
        test = TestReportUtils.createTest("Checking Albums Api");
        Integer respCode = typeicodeAPIS.checkAlbumsApi();
        test.info("Status Code received:" + respCode);
        Assert.assertEquals(respCode,200,"Albums api connection is stable");
    }
    @Test(priority = 4)
    public void checkPhotosApi(){
        test= TestReportUtils.createTest("Checking Photos API");
        Integer respCode = typeicodeAPIS.checkPhotosApi();
        test.info("Status Code received:" + respCode);
        Assert.assertEquals(respCode,200,"Photos api connection is stable");
    }
    @AfterClass
    public void tearDownClass() {
        TestReportUtils.flushReport();
    }

}
