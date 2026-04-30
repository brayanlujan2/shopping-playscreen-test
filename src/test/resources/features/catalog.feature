@catalogo
Feature: Catalogo de productos

  Background:
    Given Andrea opens the shopping Cart application
    And she enters her email "user1@test.com" and password "password1"
    And she taps the Login button

  Scenario: Ver lista de productos
    Given que el usuario esta logueado en la aplicacion
    When navega al catalogo de productos
    Then deberia ver la lista de productos disponibles

  Scenario: Buscar producto por nombre
    Given que el usuario esta en el catalogo
    When busca el producto "Laptop"
    Then deberia ver productos que contengan "Laptop"

  Scenario: Filtrar productos por categoría
    Given que el usuario esta en el catalogo
    When Andrea selects the "Electrónica" category filter
    Then Andrea should see the product "Laptop HP Pavilion"