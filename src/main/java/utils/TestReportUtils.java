package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class TestReportUtils {
    private static ExtentTest test;
    private static final String REPORT_PATH = "target/extent-reports/extent.html";
    private static ExtentReports extent;
    public static void initReport(){
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_PATH);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static String getReportPath() {
        return REPORT_PATH;
    }
}
