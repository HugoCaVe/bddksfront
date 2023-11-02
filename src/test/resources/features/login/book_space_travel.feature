# language: es
Característica: Realizar una reserva para un viaje espacial.
  Yo, como usuario
  Necesito seleccionar un destino y realizar una reserva en la página de SPACE & BEYOND,
  Para poder realizar un viaje espacial

  Escenario: Reserva éxitosa con datos aleatorios
    Dado que se ingresó a la página de SPACE & BEYOND
    Y que se valida el cargue de los campos para realizar el login
    Cuando se ingresa la información del nombre de usuario
    Y se ingresa la información de la contraseña
    Y envío la solicitud
    Y se ingresa la información de la salida y del regreso
    Y se selecciona el número de adultos y número de niños
    Y se filtra el destino por nombre del planeta y su color
    Y se realiza la reserva
    Y se diligencia los datos de Nombre, Número telefonico, Número de la Seguridad Social y teléfono
    Y se acepta los terminos y condiciones para proceder con el pago
    Entonces se completa la operación de Reserva
