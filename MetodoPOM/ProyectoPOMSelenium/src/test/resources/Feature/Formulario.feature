Feature: Registro de Formulario en Novus Technology
  Como alumnos de Novus Technology
  Quiero practicar mis escenarios de automatización
  Para poder desarrollar los aprendido en clase.


  @Prueba
  Scenario: 001 - Un usuario ingresa al formulario "Novus Technology"
    Given El usuario requiere registrarse en la pagina de Novus
    When ingresa datos en el campo Nombre
    And ingresa su apellido en el campo Apellido.
    And seleccionar sus pasatiempos con checks
    And selecciona el tipo de sexo
    And ingresa su telefono
    And ingresa su correo electronico
    And selecciona el departamento
    And selecciona la ciudad
    And selecciona un tipo de comando
    Then Damos click en enviar
    And validamos el nombre
    And validamos el apellidos
    And doy click en el boton

  @Prueba
  Scenario: 002 - Un usuario ingresa al formulario "Novus Technology de forma declarativa"
    Given El usuario requiere registrarse en la pagina de Novus
    When ingresa datos del usuario
    Then Damos click en enviar
    And validamos datos y cerramos registro

  @Prueba
  Scenario: 003 - Un usuario ingresa al formulario y da click en alerta
    Given El usuario requiere registrarse en la pagina de Novus
    When da click en el boton alerta
    Then aparece una mensaje de alerta en la pantalla
    And me redirige a la pantalla principal de NT

  @Prueba4
  Scenario: 004 - Un usuario ingresa datos al formulario "Novus Technology"
    Given El usuario requiere registrarse en la pagina de Novus
    When ingresa datos en el campo Nombre como "Jorge"
    And ingresa su apellido en el campo Apellido como "Paz"
    And seleccionar sus pasatiempos con checks como "deporte"
    #And seleccionar sus pasatiempos con checks como "deporte" y "lectura"
    And selecciona el tipo de sexo "Masculino"
    And ingresa su telefono "935404484"
    And ingresa su correo electronico "jorgepazdiaz@gmail.com"
    And selecciona el departamento "LIMA"
    And selecciona la ciudad "LIMA"
    And selecciona un tipo de comando "Switch Commands"
    Then Damos click en enviar
    And validamos el nombre "Jorge"
    And validamos el apellidos "Paz"
    And doy click en el boton

  @Prueba1
  Scenario: 005 - Un usuario ingresa datos al formulario Novus Technology
    Given El usuario requiere registrarse en la pagina de Novus
    When ingresa datos del usuario desde el feature
      | nombre | apellido | pasatiempo | genero    | telefono  | correo         | departamento | ciudad | comando         |
      | Jorge  | Paz      | deporte    | Masculino | 935404484 | jorge@test.com | LIMA         | LIMA   | Switch Commands |
    Then Damos click en enviar
    And validamos datos de datable y cerramos registro
      | nombre | apellido |
      | Jorge  | Diaz      |


  @Prueba
  Scenario Outline: : 006 - Un usuario ingresa datos al formulario "Novus Technology"
    Given El usuario requiere registrarse en la pagina de Novus
    When ingresa datos en el campos de texto "<nombre>" , "<apellido>" , "<telefono>" , "<correo>"
    And ingresa usamos todos los campos seleccionables "<pasatiempo>", "<genero>" , "<departamento>", "<ciudad>" , "<comandos>"
    Then Damos click en enviar
    And validamos los datos "<nombre>" , "<apellido>"
    And doy click en el boton
    Examples:
      | nombre      | apellido   | pasatiempo | genero    | telefono   | correo                | departamento | ciudad | comandos            |
      | Jorge       | Paz        | Musica     | Masculino | 935404484  | jorgepazdiaz@test.com | LIMA         | LIMA   | Switch Commands     |
      | Juan Carlos | Llerena    | Lectura    | Masculino | 9447878888 | juacarlos@test.com    | LIMA         | CAÑETE | Navigation Commands |
      | Joan        | Serrato    | Deporte    | Masculino | 955533333  | joan@test.com         | PIURA        | PIURA  | Navigation Commands |
      | Carolina    | Meza       | Lectura    | Femenino  | 913233456  | carolina@test.com     | LIMA         | LIMA   | Browser Commands    |
      | Yesica      | Estrada    | Deporte    | Femenino  | 935404484  | yesica@test.com       | LIMA         | LIMA   | Wait Commands       |
      | Madeleine   | Valenzuela | Musica     | Femenino  | 935404484  | madeleine@test.com    | LIMA         | LIMA   | WebElement Commands |

  @Prueba1
  Scenario: 007 - Un usuario ingresa datos al formulario Novus Technology
    Given El usuario requiere registrarse en la pagina de Novus
    When ingresa datos desde un archivo CSV
    Then Damos click en enviar
    And validamos datos del csv y cerramos registro
