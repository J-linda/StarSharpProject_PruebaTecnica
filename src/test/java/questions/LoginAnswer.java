package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import userinterface.LoginForm;

public class LoginAnswer {
    public static Question<String> validateTitleDashboard(){
        return actor -> TextContent.of(LoginForm.LBL_TITLE).answeredBy(actor).trim();
    }
}
