package candidatePool.formsExecution;

import candidatePool.base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class FormsExecutionTest extends BaseTest {
    @Test
    public void testSuccessfulCreate321AccountTask(){
        FormsExecutionPage formsExecution = new FormsExecutionPage(driver);
        formsExecution.navigateToCreate321Task();
    }
}
