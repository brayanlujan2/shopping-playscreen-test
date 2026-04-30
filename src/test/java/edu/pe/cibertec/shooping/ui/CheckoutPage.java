package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target NAV_CARRITO = Target.the("pestaña carrito")
            .located(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc='Carrito'] | //*[contains(@text, 'Carrito')]"));

    public static final Target AGREGAR_AL_CARRITO_BTN = Target.the("botón agregar al carrito")
            .located(AppiumBy.xpath("//*[contains(@text, 'Agregar al carrito')]"));

    public static final Target COMPRAR_AHORA_BTN = Target.the("botón comprar ahora")
            .located(AppiumBy.xpath("//*[contains(@text, 'Comprar ahora')]"));

    public static final Target PROCEDER_PAGO_CARRITO_BTN = Target.the("botón proceder al pago")
            .located(AppiumBy.xpath("//*[contains(@text, 'Proceder')]"));


    public static final Target CARD_NUMBER = Target.the("campo número de tarjeta")
            .located(AppiumBy.xpath("(//android.widget.EditText)[4]"));

    public static final Target CARD_EXPIRY = Target.the("campo fecha expiración")
            .located(AppiumBy.xpath("(//android.widget.EditText)[5]"));

    public static final Target CARD_CVV = Target.the("campo CVV")
            .located(AppiumBy.xpath("(//android.widget.EditText)[6]"));

    public static final Target CONFIRM_PURCHASE_BTN = Target.the("botón confirmar compra")
            .located(AppiumBy.xpath("//*[contains(@text, 'Confirmar Compra')] | //android.widget.Button"));

    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de éxito")
            .located(AppiumBy.xpath("//*[contains(@text, 'Gracias')]"));

    public static final Target EMPTY_CART_MESSAGE = Target.the("mensaje carrito vacío")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Tu carrito está vacío']"));

    public static final Target ADDRESS_ERROR_MESSAGE = Target.the("mensaje de error en dirección")
            .located(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'requerida') or contains(@text, 'required')]"));

    public static final Target ADDRESS_FIELD = Target.the("campo dirección de envío")
            .located(AppiumBy.xpath("(//android.widget.EditText)[1]"));
}