package edu.pe.cibertec.shooping.ui;

import net.serenitybdd.screenplay.targets.Target;
import io.appium.java_client.AppiumBy;

public class ProfilePage {
    public static final Target USER_MENU = Target.the("botón de perfil inferior")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Perfil']"));

    public static final Target LOGOUT_BUTTON = Target.the("icono de cerrar sesión")
            .located(AppiumBy.accessibilityId("Cerrar sesión"));

    public static final Target CONFIRM_LOGOUT = Target.the("botón confirmar cerrar sesión")
            .located(AppiumBy.xpath("(//android.widget.Button)[2]"));
}