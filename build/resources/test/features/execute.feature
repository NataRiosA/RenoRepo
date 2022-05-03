@test
Feature: Sanity limpieza y aprovisionamiento de recursos

  yo como que quiero realizar una limpieza de recursos
  cargar la mercancia y el inventario en la plataforma epos

  @portalCesionPreAPos
  Scenario: se requiere realizar una activacion de una linea en prepago
    Given Se ingresa al portal CRM para activacion
    When Se hace la cesion de contrato de una linea pre a pos
    Then Se deberia ver en pantalla unica la linea cedida pre

