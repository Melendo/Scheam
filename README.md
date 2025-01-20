# Scheam
El proyecto Scheam ha sido realizado en contexto de la asignatura de Ingeniería del Software II, del grado Ingeniería del Software. Ha sido desarrollado por ocho alumnos de la asignatura.

El objetivo de este proyecto es crear una aplicación de gestión para una empresa que desarrolla y vende videojuegos, siguiendo el proceso de ingeniería de software. Por lo tanto, hemos diseñado, documentado y desarrollado la aplicación.
## Análisis de Requisitos
Los requisitos de nuestro proyecto se basan en los requisitos necesarios para una aplicación de gestión de datos de una empresa que vende y desarrolla videojuegos. Así, es necesario poder introducir y manipular datos en seis módulos principales: Producto, Equipo, Empleados, Tareas, Factura y Clientes. Además, hemos especializado los módulos Equipo (Equipo de Diseño y Equipo de Desarrollo) y Cliente (Distribuidor y Particular), para que se adapte a las necesidades que pueda tener la empresa en su gestión.

Entre los requisitos funcionales se encuentran en cada módulo, la capacidad de dar de alta, baja y modificar cualquiera de los objetos que formen parte de los módulos, y las capacidades de listar un objeto o todos a la vez. Además, por cada módulo se han añadido otros requisitos, dependiendo de la necesidad de cada uno.

Entre los requisitos no funcionales encontramos aquellos que ayudan con la consistencia de datos en la base de datos, además de algunos que nos ayudan con la consistencia de la gestión de la empresa, como los controles al cerrar y publicar productos, una acción que no se podrá hacer si este producto tiene tareas pendientes. 

El análisis de requisitos se encuentra más completo y documentado en nuestra SRS.
## Diseño
Como ya hemos expuesto en el apartado anterior, contamos con seis módulos principales. La arquitectura del proyecto se basó en la multicapa, por lo tanto el diseño de la aplicación se basa en tres partes principales: Presentación, Negocio e Integración. Esta arquitectura multicapa nos ayuda con la encapsulación, la manejabilidad y empaquetamiento, además de comprender mejor la funcionalidad de la aplicación.

- Presentación: 
Es la parte del diseño que maneja todas las vistas, se basa en el patrón MVC, con un controlador pasivo y único para el proyecto. Las vistas generan eventos que se envían al controlador, y el controlador se encarga de enviar estos eventos a Negocio para realizar las acciones necesarias. 
Las vistas son generadas por una FactoríaVistas que aplica el patrón Singleton y que recoge eventos para devolver nuevas vistas.
Excepto en casos muy concretos (mostrar carrito), sólo habrá una vista abierta de la aplicación a la vez.
- Negocio: 
Es la parte del diseño que recoge la funcionalidad de la aplicación, el núcleo. Con esta parte usamos los patrones de Transferencia, que nos permiten mover datos entre capas para cada módulo y el patrón de Servicio de Aplicación
Existe un Servicio de Aplicación por módulo que recoge las funciones de la aplicación. También hay uno o más transfers por módulo, dependiendo de los que necesitemos.
- Integración:
Es la parte del diseño que interactúa con la base de datos MySQL. Con ella usamos el patrón DAO
Existe un DAO por cada módulo.
