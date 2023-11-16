package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.TextContent;
import userinterface.LoginForm;

public class VerifyDashboardTitle implements Question <Boolean> {
    private String title;
    public VerifyDashboardTitle(String title) {
        this.title = title;
    }

    public static VerifyDashboardTitle whit (String title) {
        return new VerifyDashboardTitle(title);
    }
    @Override
    public Boolean answeredBy (Actor actor) {
        String obtainedTitle = TextContent.of(LoginForm.LBL_TITLE).answeredBy(actor).trim();

        return obtainedTitle.equals(title);
    }
}
