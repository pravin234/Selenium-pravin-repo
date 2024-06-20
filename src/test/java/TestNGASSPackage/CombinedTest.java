package TestNGASSPackage;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CombinedTest {

    private boolean globalSkipCondition;

    @BeforeMethod
    public void setUp() {
        // Set a condition that can skip tests globally
        globalSkipCondition = true; // You can set this based on your logic
    }

    @Test(enabled = false)
    public void skippedTest() {
        System.out.println("This test is disabled and will not run.");
    }

    @Test(invocationCount = 3)
    public void invokedTest() {
        System.out.println("This test runs multiple times.");
    }

    @Test
    public void conditionallySkippedTest() {
        if (globalSkipCondition) {
            throw new SkipException("Skipping this test based on global condition.");
        }
        System.out.println("This test will run only if the global condition is false.");
    }

    @DataProvider(name = "testData")
    public Object[][] createData() {
        return new Object[][] {
            { "scenario1", true },
            { "scenario2", false }
        };
    }

    @Test(dataProvider = "testData")
    public void dataProviderTest(String scenario, boolean skip) {
        if (skip) {
            throw new SkipException("Skipping scenario: " + scenario);
        }
        System.out.println("Executing scenario: " + scenario);
    }

    @Test
    public void invokedAndConditionalTest() {
        if (globalSkipCondition) {
            throw new SkipException("Skipping this test based on global condition.");
        }
        System.out.println("This test runs twice unless globally skipped.");
    }

    @Test
    public void invokedTestWithNegativeCount() {
        int invocationCount = -2; // Example negative invocation count
        if (invocationCount < 0) {
            throw new SkipException("Skipping this test due to negative invocation count.");
        }
        for (int i = 0; i < invocationCount; i++) {
            System.out.println("This test runs based on positive invocation count.");
        }
    }
    
    
    
}
