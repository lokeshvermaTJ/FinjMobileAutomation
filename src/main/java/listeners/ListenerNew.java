package listeners;

import Generics.BaseAndroidClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerNew extends BaseAndroidClass implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // Thread-safe for parallel execution
    AppiumDriver driver;

    // Step counters
    private static int passSteps = 0;
    private static int failSteps = 0;
    private static int infoSteps = 0;

    // Test execution tracking
    private static long suiteStartTime;
    private static long suiteEndTime;

    @Override
    public void onStart(ITestContext context) {
        new File(System.getProperty("user.dir") + "/reports/").mkdirs();

        String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh-mm_a").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/Report_" + timestamp + ".html";

        sparkReporter = new ExtentSparkReporter(reportPath);

        // Report UI config
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Mobile Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        sparkReporter.config().setTimelineEnabled(true);   // Trendline
        sparkReporter.config().setTimelineEnabled(true);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // System info
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Lokesh Verma");
        extent.setSystemInfo("OS", System.getProperty("os.name"));

        suiteStartTime = System.currentTimeMillis(); // Track start time
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName())
                .assignCategory(result.getMethod().getRealClass().getSimpleName());
        test.set(extentTest);
        extentTest.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Case Passed: " + result.getMethod().getMethodName());
    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.get().log(Status.FAIL, "Test Case FAILED: " + result.getMethod().getMethodName());
//        test.get().log(Status.FAIL, "Cause: " + result.getThrowable());
//
//        try {
//            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
//                    .get(result.getInstance());
//            test.get().addScreenCaptureFromPath(
//                    getScreenshot(driver, result.getMethod().getMethodName()),
//                    result.getMethod().getMethodName()
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Case FAILED: " + result.getMethod().getMethodName());
        test.get().log(Status.FAIL, "Cause: " + result.getThrowable());

        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());

            // Capture and save screenshot locally + get relative path
            String screenshotPath = getScreenshot(driver, result.getMethod().getMethodName());

            // Attach screenshot to report
            test.get().fail("Screenshot:",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Case Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.get().log(Status.WARNING, "Test Partially Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

//    @Override
//    public void onFinish(ITestContext context) {
//        suiteEndTime = System.currentTimeMillis();
//
//        int totalTests = context.getAllTestMethods().length;
//        int passedTests = context.getPassedTests().size();
//        int failedTests = context.getFailedTests().size();
//        int skippedTests = context.getSkippedTests().size();
//
//        int totalSteps = passSteps + failSteps + infoSteps;
//
//        long durationMillis = suiteEndTime - suiteStartTime;
//        long minutes = (durationMillis / 1000) / 60;
//        long seconds = (durationMillis / 1000) % 60;
//        long millis = durationMillis % 1000;
//
//        double passPercentage = (totalTests > 0) ? ((double) passedTests / totalTests) * 100 : 0;
//
//        // Add execution summary as a separate test node in the report
//        ExtentTest summary = extent.createTest("Execution Summary");
//        summary.log(Status.INFO, "Total Tests: " + totalTests);
//        summary.log(Status.INFO, "Passed: " + passedTests);
//        summary.log(Status.INFO, "Failed: " + failedTests);
//        summary.log(Status.INFO, "Skipped: " + skippedTests);
//        summary.log(Status.INFO, "Total Steps: " + totalSteps);
//        summary.log(Status.INFO, "Steps Passed: " + passSteps);
//        summary.log(Status.INFO, "Steps Failed: " + failSteps);
//        summary.log(Status.INFO, "Steps Info: " + infoSteps);
//        summary.log(Status.INFO, "Start Time: " + new Date(suiteStartTime));
//        summary.log(Status.INFO, "End Time: " + new Date(suiteEndTime));
//        summary.log(Status.INFO, String.format("Total Time Taken: %dm %ds %dms", minutes, seconds, millis));
//        summary.log(Status.INFO, "Pass Percentage: " + String.format("%.2f", passPercentage) + "%");
//
//        extent.flush();
//    }

    @Override
    public void onFinish(ITestContext context) {
        suiteEndTime = System.currentTimeMillis();

        int totalTests = context.getAllTestMethods().length;
        int passedTests = context.getPassedTests().size();
        int failedTests = context.getFailedTests().size();
        int skippedTests = context.getSkippedTests().size();

        int totalSteps = passSteps + failSteps + infoSteps;

        long durationMillis = suiteEndTime - suiteStartTime;
        long minutes = (durationMillis / 1000) / 60;
        long seconds = (durationMillis / 1000) % 60;
        long millis = durationMillis % 1000;

        double passPercentage = (totalTests > 0) ? ((double) passedTests / totalTests) * 100 : 0;

        // Add execution summary as a separate test node
        ExtentTest summary = extent.createTest("Execution Summary");
        summary.log(Status.INFO, "Total Tests: " + totalTests);
        summary.log(Status.INFO, "Passed: " + passedTests);
        summary.log(Status.INFO, "Failed: " + failedTests);
        summary.log(Status.INFO, "Skipped: " + skippedTests);
        summary.log(Status.INFO, "Total Steps: " + totalSteps);
        summary.log(Status.INFO, "Steps Passed: " + passSteps);
        summary.log(Status.INFO, "Steps Failed: " + failSteps);
        summary.log(Status.INFO, "Steps Info: " + infoSteps);
        summary.log(Status.INFO, "Start Time: " + new Date(suiteStartTime));
        summary.log(Status.INFO, "End Time: " + new Date(suiteEndTime));
        summary.log(Status.INFO, String.format("Total Time Taken: %dm %ds %dms", minutes, seconds, millis));
        summary.log(Status.INFO, "Pass Percentage: " + String.format("%.2f", passPercentage) + "%");

//        // Proper JSON config
//        String chartConfig = "{"
//                + "\"type\":\"pie\","
//                + "\"data\":{"
//                + "\"labels\":[\"Pass\",\"Fail\",\"Info\"],"
//                + "\"datasets\":[{"
//                + "\"data\":[" + passSteps + "," + failSteps + "," + infoSteps + "]"
//                + "}]},"
//                + "\"options\":{"
//                + "\"plugins\":{"
//                + "\"legend\":{"
//                + "\"position\":\"bottom\""
//                + "}"
//                + "}"
//                + "}"
//                + "}";
//
//// Encode for URL
//        String chartUrl = null;
//        try {
//            chartUrl = "https://quickchart.io/chart?c=" + URLEncoder.encode(chartConfig, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//
//// Attach to Extent report
//        summary.log(Status.INFO,
//                "<div style='text-align:center'>"
//                        + "<h4>Steps Distribution</h4>"
//                        + "<img src='" + chartUrl + "' width='400' height='300'/>"
//                        + "</div>");

        extent.flush();
    }


//    // Utility for step logging (use inside POM methods)
//    public static void logStep(Status status, String message) {
//        switch (status) {
//            case PASS:
//                passSteps++;
//                break;
//            case FAIL:
//                failSteps++;
//                break;
//            case INFO:
//                infoSteps++;
//                break;
//        }
//        test.get().log(status, message);'
//    public static void logStep(Status status, String message) {
//        String icon = "";
//
//        switch (status) {
//            case PASS:
//                passSteps++;
//                icon = "<span style='color:green'>✔️</span>"; // Green check
//                break;
//            case FAIL:
//                failSteps++;
//                icon = "<span style='color:red'>❌</span>"; // Red cross
//                break;
//            case INFO:
//                infoSteps++;
//                icon = "<span style='color:blue'>ℹ️</span>"; // Blue info
//                break;
//            case WARNING:
//                icon = "<span style='color:orange'>⚠️</span>"; // Orange warning
//                break;
//            default:
//                icon = "•"; // fallback
//        }
//
//        test.get().log(status, icon + " " + message);
//    }
        public static void logStep(Status status, String message) {
            String icon = "";

            switch (status) {
                case PASS:
                    passSteps++;
                    icon = "<span style='color:green'>✔️</span>"; // Green check
                    break;
                case FAIL:
                    failSteps++;
                    icon = "<span style='color:red'>❌</span>"; // Red cross
                    break;
                case INFO:
                    infoSteps++;
                    icon = "<span style='color:blue'>ℹ️</span>"; // Blue info
                    break;
                case WARNING:
                    icon = "<span style='color:orange'>⚠️</span>"; // Orange warning
                    break;
                default:
                    icon = "•"; // fallback
            }

            // Log step to ExtentTest
            if (test.get() != null) {
                test.get().log(status, icon + " " + message);
            }
        }

    }

