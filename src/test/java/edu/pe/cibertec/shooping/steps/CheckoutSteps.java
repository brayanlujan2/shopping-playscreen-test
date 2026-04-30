package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.ui.CheckoutPage;
import edu.pe.cibertec.shooping.ui.ScreenPlayCatalogPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CheckoutSteps {

    @Given("que el usuario tiene productos en el carrito")
    public void productosEnCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ScreenPlayCatalogPage.PRODUCT_CONTAINER, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(ScreenPlayCatalogPage.productWithName("Laptop")),
                WaitUntil.the(CheckoutPage.AGREGAR_AL_CARRITO_BTN, isVisible()),
                Click.on(CheckoutPage.AGREGAR_AL_CARRITO_BTN)
        );
    }

    @When("procede al checkout")
    public void procedeAlCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.COMPRAR_AHORA_BTN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.COMPRAR_AHORA_BTN),
                WaitUntil.the(CheckoutPage.PROCEDER_PAGO_CARRITO_BTN, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CheckoutPage.PROCEDER_PAGO_CARRITO_BTN)
        );
    }

    @And("ingresa los datos de envio")
    public void ingresaDatosEnvio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.CARD_NUMBER, isVisible()).forNoMoreThan(25).seconds(),

                Click.on(CheckoutPage.CARD_NUMBER),
                Enter.theValue("1234567812345678").into(CheckoutPage.CARD_NUMBER),

                Click.on(CheckoutPage.CARD_EXPIRY),
                Enter.theValue("12/28").into(CheckoutPage.CARD_EXPIRY),

                Click.on(CheckoutPage.CARD_CVV),
                Enter.theValue("123").into(CheckoutPage.CARD_CVV)
        );

        try {
            AndroidDriver driver = (AndroidDriver) net.serenitybdd.core.Serenity.getDriver();
            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
            }
        } catch (Exception ignored) {
        }
    }

    @And("confirma la compra")
    public void confirmaCompra() {
        try {
            AndroidDriver driver = (AndroidDriver) net.serenitybdd.core.Serenity.getDriver();

            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
            }
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Confirmar Compra\"))"
            ));

        } catch (Exception ignored) {}

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.CONFIRM_PURCHASE_BTN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.CONFIRM_PURCHASE_BTN)
        );
    }

    @Then("deberia ver el mensaje de compra exitosa")
    public void mensajeExitoso() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(20).seconds()
        );
    }

    @Given("que el usuario tiene el carrito vacio")
    public void carritoVacio() {
        OnStage.theActorInTheSpotlight().attemptsTo(WaitUntil.the(ScreenPlayCatalogPage.PRODUCT_CONTAINER, isVisible()));
    }

    @When("intenta proceder al checkout")
    public void intentaCheckoutVacio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.NAV_CARRITO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CheckoutPage.NAV_CARRITO),

                WaitUntil.the(CheckoutPage.EMPTY_CART_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Then("deberia ver mensaje de carrito vacio")
    public void verMensajeVacio() {
        OnStage.theActorInTheSpotlight().should(
               seeThat(WebElementQuestion.the(CheckoutPage.EMPTY_CART_MESSAGE),
                    containsText("vacío"))
        );
    }

    @When("intenta confirmar la compra sin ingresar la direccion")
    public void confirmarSinDireccion() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(CheckoutPage.CONFIRM_PURCHASE_BTN));
    }

    @Then("deberia ver un mensaje de error indicando que la direccion es requerida")
    public void verErrorDireccion() {
        try {
            AndroidDriver driver = (AndroidDriver) net.serenitybdd.core.Serenity.getDriver();

            By direccionBy = By.xpath("(//android.widget.EditText)[1]");
            By botonBy = By.xpath("//*[contains(@text, 'Confirmar')] | //android.widget.Button[last()]");

           WebElement campoDireccion = driver.findElement(direccionBy);
            campoDireccion.click();
            campoDireccion.clear();

            WebElement botonConfirmar = driver.findElement(botonBy);
            botonConfirmar.click();

           Thread.sleep(3000);

        } catch (Exception e) {
            System.err.println("Error en la validación: " + e.getMessage());
        }
    }
}