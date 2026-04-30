package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ScreenPlayCatalogPage {

    public static final Target SEARCH_FIELD = Target
            .the("campo de búsqueda")
            .located(AppiumBy.xpath("//android.widget.EditText"));

    public static Target productWithName(String productName) {
        return Target.the("producto " + productName)
                .located(AppiumBy.xpath("//android.widget.TextView[contains(@text,'" + productName + "')]"));
    }

    public static final Target PRODUCT_CONTAINER = Target
            .the("contenedor de productos")
            .located(AppiumBy.xpath("//android.widget.ScrollView | //android.view.View"));
}