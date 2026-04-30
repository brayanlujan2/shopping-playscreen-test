package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.ui.ProfilePage;
import edu.pe.cibertec.shooping.ui.LoginScreen;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogoutSteps {

    @When("hace clic en el menu de usuario")
    public void haceClicEnElMenuDeUsuario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ProfilePage.USER_MENU)
        );
    }

    @And("hace clic en cerrar sesion")
    public void haceClicEnCerrarSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ProfilePage.LOGOUT_BUTTON)
        );

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ProfilePage.CONFIRM_LOGOUT)
        );
    }

    @Then("deberia regresar a la pantalla de login")
    public void deberiaRegresarALaPantallaDeLogin() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La pantalla de Login es visible",
                        WebElementQuestion.the(LoginScreen.LOGIN_BUTTON), isVisible())
        );
    }
}