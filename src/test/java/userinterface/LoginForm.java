package userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginForm {

    public static final Target USERNAME = Target.the("Campo para escribir el username").located(By.id("LoginPanel0_Username"));
    public static final Target PASSWORD = Target.the("Campo para escribir el password").located(By.id("LoginPanel0_Password"));
    public static final Target BTN_SIGN_IN = Target.the("Botón SignIn").located(By.id("LoginPanel0_LoginButton"));
    public static final Target LBL_TITLE = Target.the("Titulo Dashboard").located(By.cssSelector("section>h1"));
}
