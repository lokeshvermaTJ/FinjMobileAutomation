package listeners;

import Generics.BaseAndroidClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager extends BaseAndroidClass implements ITestListener {
    public ExtentSparkReporter sparkReporter;// Ui Of the report
    public ExtentReports extent; //  populate common info on the report
    public ExtentTest test; // Creating test case enteris in the report and update the test methos
    AppiumDriver driver;


    @Override
    public void onStart(ITestContext context) {

        //System.out.println("Test Started");
        // Create reports folder if it doesn't exist
        new File(System.getProperty("user.dir") + "/reports/").mkdirs();

        // Generate timestamp for unique report name
        String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh-mm_a").format(new Date());
        String testName = context.getName();
        String reportPath = System.getProperty("user.dir") + "/reports/" + testName + timestamp + ".html";
        // String reportPath = System.getProperty("user.dir") + "/reports/Report_" + timestamp + ".html";

        // Use the timestamped path
        sparkReporter = new ExtentSparkReporter(reportPath);

        // Reporter configuration
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Mobile Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        // Attach reporter to extent
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);  // Only attach once (you had it twice)

        // System info
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Lokesh Verma");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
    }


    // 2. When each @Test method starts
    @Override
    public void onTestStart(ITestResult result) {
        //System.out.println("[TEST METHOD START] " + result.getMethod().getMethodName());
        // Create a new test entry
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());

    }

    // 3. If test method succeeds
    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName()); // create a new entry in the report
        test.log(Status.PASS, "Test Case passed is : " + result.getName()); // Update status
        //System.out.println("[TEST PASSED] " + result.getMethod().getMethodName());
    }

    // 4. If test method fails
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[TEST FAILED] " + result.getMethod().getMethodName());
        //System.out.println("Test Fails");
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is:" + result.getThrowable());

        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        try {
            test.addScreenCaptureFromPath(getScreenshot(driver, result.getMethod().getMethodName()), result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    // Example: you can attach a screenshot or log error here


    // 5. If test method is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[TEST SKIPPED] " + result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.SKIP, "Test case SKIPPED is:" + result.getMethod().getMethodName());
    }

    // 6. If test failed but is within success percentage
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("[TEST PARTIALLY FAILED] " + result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.WARNING, "Test Partially Passed (within success %): " + result.getMethod().getMethodName());

    }

    // 7. If test failed due to timeout
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("[TEST FAILED DUE TO TIMEOUT] " + result.getMethod().getMethodName());
         onTestFailure(result); // call failure logic

    }

    // 8. After <test> tag in testng.xml finishes
    @Override
    public void onFinish(ITestContext context) {
       System.out.println("[TEST FINISH] Test context finished: " + context.getName());
        extent.flush();
    }
}
