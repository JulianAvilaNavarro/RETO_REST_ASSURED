Feature:Obtener un recurso y Borrar dayos
  como un usuario registrado del sistema
  quiero obtener un recurso del sistema y luego borrar un registro
  con el fin de saber de verificar los servicios del sistema

  @regesion
  Scenario :Obtener un recurso
    Given el usuario esta en la pagina de busqueda y desea buscar la información de una persona
    When el usuario busca el recurso que desea y obtiene una respuesta <respuesta>
    Then el usuario podra ver los datos de la persona

  @regesion
  Scenario: Borrar un registro
    Given el usuario esta en la pagina y desea borrar un registro
    When el usuario escribe la instruccion de borrar el registro
    Then el usuario obtiene una la respuesta de borrado