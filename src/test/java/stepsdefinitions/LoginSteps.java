package stepsdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import navigation.NavigateTo;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import questions.LoginAnswer;
import questions.VerifyDashboardTitle;
import tasks.LoginUserTask;

import java.util.List;

public class LoginSteps {

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("User login in the StartSharp with the user {string} and password {string}")
    public void userLoginInTheStartSharpWithTheUserAndPassword(String user, String password) {

        OnStage.theActorCalled(user).attemptsTo(
                NavigateTo.theStartSharpLoginPage(),
                LoginUserTask.with(user, password)
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Titulo pagina principal", LoginAnswer.validateTitleDashboard(), Matchers.equalTo("Dashboard"))
        );
    }



    @Given("The user {string} enters into the page")
    public void theUserEntersIntoThePage(String user) {
        OnStage.theActorCalled(user).attemptsTo(
                NavigateTo.theStartSharpLoginPage()

        );
    }


    @When("The user enter credentials into the fields")
    public void theUserEnterCredentialsIntoTheFields(DataTable credentialsTable) {
        List<String> list = credentialsTable.asList();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginUserTask.with(list.get(0), list.get(1))
        );

    }


    @Then("The user should see the title {string}")
    public void theUserShouldSeeTheTitle(String title) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Validate title",VerifyDashboardTitle.whit(title))
        );
    }

}
