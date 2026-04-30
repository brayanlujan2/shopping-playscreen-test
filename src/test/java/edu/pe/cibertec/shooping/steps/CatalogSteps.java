package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.ui.ScreenPlayCatalogPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CatalogSteps {

    @Given("que el usuario esta logueado en la aplicacion")
    public void usuarioLogueado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ScreenPlayCatalogPage.SEARCH_FIELD, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    @Given("que el usuario esta en el catalogo")
    public void usuarioEnCatalogo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ScreenPlayCatalogPage.SEARCH_FIELD, isVisible())
        );
    }

    @When("navega al catalogo de productos")
    public void navegaAlCatalogo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ScreenPlayCatalogPage.PRODUCT_CONTAINER, isVisible())
        );
    }

    @When("busca el producto {string}")
    public void buscaProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ScreenPlayCatalogPage.SEARCH_FIELD, isVisible()),
                Click.on(ScreenPlayCatalogPage.SEARCH_FIELD),
                Clear.field(ScreenPlayCatalogPage.SEARCH_FIELD),
                Enter.theValue(producto).into(ScreenPlayCatalogPage.SEARCH_FIELD)
        );

        AndroidDriver driver = (AndroidDriver) Serenity.getDriver();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        try {
            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
            }
        } catch (Exception ignored) {}
    }

    @Then("deberia ver la lista de productos disponibles")
    public void verListaProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ScreenPlayCatalogPage.PRODUCT_CONTAINER, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Then("deberia ver productos que contengan {string}")
    public void verProductos(String producto) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El producto " + producto + " es visible",
                        actor -> ScreenPlayCatalogPage.productWithName(producto).resolveFor(actor).isVisible())
        );
    }
}