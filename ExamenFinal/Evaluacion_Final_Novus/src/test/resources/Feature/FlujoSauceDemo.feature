Feature: Loguearme en la plataforma web de SauceDemo
  Como usuario deseo revisar el inventario de productos
  Quiero comprar un producto
  Para luego eliminarlo y regresar a la ventana principal

@Prueba1
Scenario: 001 - El usuario ingresa al sistema web para agregar un producto y luego lo elimina del carro de compras.
  Given El usuario inicia sesion en la plataforma
  When hace clic en el boton add to cart de cualquier producto
  Then se dirige al icono del carrito de compras
  And aparece el producto seleccionado previamente
  And decide remover su producto para elegir otro de su preferencia
  And regresa al catalogo general productos

  @Prueba2
  Scenario: 002 - El usuario valida un producto y agrega al carro de compras para finalizar el proceso.
    Given El usuario se loguea en la web de SauceDemo
    When elige un producto previa validacion de nombre y precio
    Then se dirige a realizar el checkout
    And el usuario ingresa sus datos personales
    And revisa la descripcion general del producto
    And finaliza la compra para regresar al inventario

  @Prueba3
  Scenario: 003 - Verificar el nombre de varios productos del sistema web
    Given el usuario esta en la pagina de inventarios
    When valida la disponibilidad de los productos en stock
        | nombreProducto              |
        | Sauce Labs Backpack         |
        | Sauce Labs Bike Light       |
        | Sauce Labs Fleece Jacket    |
    Then los productos se encuentran en la galeria para comprar

    @Prueba4
  Scenario Outline: 004 - Validar productos del inventario de manera individual
    Given el usuario esta en la pagina de inventarios
    When busca el producto "<nombreProducto>"
    Then el producto "<nombreProducto>" esta activo en la galeria.

      Examples:
        | nombreProducto              |
        | Sauce Labs Backpack         |
        | Sauce Labs Bike Light       |
        | Sauce Labs Fleece Jacket    |




