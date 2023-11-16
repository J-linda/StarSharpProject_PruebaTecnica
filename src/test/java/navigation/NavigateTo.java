package navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theStartSharpLoginPage() {
        return Task.where("{0} opens the StartSharp login page",
                Open.browserOn().the(LoginPage.class)
        );
    }
}
