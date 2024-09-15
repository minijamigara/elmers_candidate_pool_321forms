package candidatePool.applicantPoolExecution;

import candidatePool.base.BaseTest;
import org.testng.annotations.Test;
import pages.ApplicantPoolExecutionPage;

import static org.testng.Assert.assertEquals;

public class ApplicantPoolExecutionTest extends BaseTest {

    @Test
    public void testApplicantExecutableTask(){
        ApplicantPoolExecutionPage applicantPoolExecution = new ApplicantPoolExecutionPage(driver);
        applicantPoolExecution.navigateToExecutableTasks();
    }
}
