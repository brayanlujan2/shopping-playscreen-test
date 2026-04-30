@checkout
Feature: Proceso de compra

  Background:
    Given Andrea opens the shopping Cart application
    And she enters her email "user1@test.com" and password "password1"
    And she taps the Login button

  Scenario: Completar compra exitosamente
    Given que el usuario tiene productos en el carrito
    When procede al checkout
    And ingresa los datos de envio
    And confirma la compra
    Then deberia ver el mensaje de compra exitosa

  Scenario: Carrito vacio no permite checkout
    Given que el usuario tiene el carrito vacio
    When intenta proceder al checkout
    Then deberia ver mensaje de carrito vacio

  Scenario: Validar direccion de envio obligatoria
    Given que el usuario tiene productos en el carrito
    And procede al checkout
    When intenta confirmar la compra sin ingresar la direccion
    Then deberia ver un mensaje de error indicando que la direccion es requerida