package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.LoginForm;

public class LoginUserTask implements Task {

    private final String username;
    private final String password;
    public LoginUserTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable with(String username, String password){
        return Tasks.instrumented(LoginUserTask.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(LoginForm.USERNAME),
                Clear.field(LoginForm.PASSWORD),
                Enter.theValue(username).into(LoginForm.USERNAME),
                Enter.theValue(password).into(LoginForm.PASSWORD),
                Click.on(LoginForm.BTN_SIGN_IN)
        );
    }
}
