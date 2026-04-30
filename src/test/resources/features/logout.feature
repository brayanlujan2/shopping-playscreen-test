@logout
Feature: Cerrar sesion

  Background:
    Given Andrea opens the shopping Cart application
    And she enters her email "user1@test.com" and password "password1"
    And she taps the Login button

  Scenario: Logout exitoso
    Given que el usuario esta logueado en la aplicacion
    When hace clic en el menu de usuario
    And hace clic en cerrar sesion
    Then deberia regresar a la pantalla de login