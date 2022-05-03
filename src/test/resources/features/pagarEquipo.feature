@test
Feature: Reno Repo masivo

  yo como cliente deseo hacer la renovacion y reposicion de equipos de manera masiva

  @portalCesionPreAPos
  Scenario: reno-repo control
    Given Se ingresa al portal CRM
    When se hace la posventa reno repo
    And se hace el pago del equipo
    Then se deberia ver el resultado de la consulta

