package com.agoda.tests;

import com.agoda.base.ForgotPassword;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ForgotPasswordTests {
    @DataProvider(name = "positive-data-provider")
    public Object[][] positiveData(){
        return new Object[][] {{"tesstes3tdsztesAn14!", "teses3tesytesAc12!"},
                                {"tesstes3tdsztesAn14!", "tesrtes3tesytesAc12@"},
                                {"tesstes3tdsztesAn14!", "tesrtes3tesytesAc12#"},
                                {"tesstes3tdsztesAn14!", "tesrtes3tesytesAc12$"},
                                {"tesstes3tdsztesAn14!", "tesrtes3tesytesAc12&"},
                                {"tesstes3tdsztesAn14!", "tesrtes3tesytesAc12*"},
                                {"tesstes3tdsztesAn14!", "tesrtes3tesytesAc12!"}

        };
    }

    @DataProvider(name = "negative-data-provider")
    public Object[][] negativeData(){
        return new Object[][] {
                {"tesstes3tdsztesAn14!", "tes3tesyAte1!"},
                {"test", "tesrtes3tesytesac12*"},
                {"test", "TESRTES3TESYTESAC12*"},
                {"test", "tesrtesHtesytesAcBF$"},
                {"test", "tesrtesHtesytesAcBF1"},
                {"test", "tesrtttHtesytesAcBF1$"},
                {"test", "tesrmvtHkesytesAcBF1$#@&%"},
                {"test", "tHksyesAc%111222333444555666677778889999"},
                {"tesstes3tdsztesAn12!", "tesrtes3tesytesAc12!"},
                {"tesstes3tdsztesAn15!", "tesrtes3tesytesAc12!"}

        };
    }

    @Test(dataProvider =  "positive-data-provider")
    public void positiveTests(String oldPassword, String newPassword) throws Exception {
        ForgotPassword.forgotPassword(oldPassword, newPassword);
    }

    @Test(dataProvider =  "negative-data-provider")
    public void negativeTests(String oldPassword, String newPassword) throws Exception {
        ForgotPassword.forgotPassword(oldPassword, newPassword);
    }
}
