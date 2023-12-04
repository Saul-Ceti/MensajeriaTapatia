# Documentación de la aplicación
## Visión General
La aplicación de mensajería es una plataforma que permite a los usuarios enviar y recibir mensajes a través de mensajeros asignados a destinatarios específicos. El proceso a seguir para un uso exitoso se describe a continuación.

## Happy Path
1. Pantalla de Carga
- Al iniciar la aplicación, se mostrará una pantalla de carga proporcionando una experiencia visual agradable mientras se inicializan los componentes esenciales de la aplicación.
2. Registro de Usuario
- El usuario accede a la pantalla de registro desde la pantalla de carga.
- Proporciona la información requerida para el registro, que incluye nombre, dirección de correo electrónico y contraseña.
- Se valida la información y, si es correcta, se crea una cuenta de usuario.
- El usuario recibe una confirmación de registro exitoso.
3. Inicio de Sesión
- Después del registro, el usuario es redirigido a la pantalla de inicio de sesión.
- Ingresa sus credenciales (correo electrónico y contraseña) para iniciar sesión.
- Las credenciales se verifican y, si son válidas, se permite el acceso a la aplicación.
- Se muestra la pantalla principal después de un inicio de sesión exitoso.
4. Pantalla Principal
- La pantalla principal muestra el nombre del usuario autenticado.
- Desde esta pantalla, el usuario puede navegar a las diferentes secciones de la aplicación.
5. Agregar Destinatario
- Desde la pantalla principal, el usuario selecciona la opción para agregar un destinatario.
- Ingresa la información requerida del destinatario, como nombre y dirección.
- Se valida la información y, si es correcta, se agrega el destinatario.
- El usuario recibe una confirmación de que el destinatario se ha agregado con éxito.
6. Agregar Mensajero
- Desde la pantalla principal, el usuario selecciona la opción para agregar un mensajero.
- Ingresa la información requerida del mensajero, como nombre de la empresa y tipo de vehículo.
- Se valida la información y, si es correcta, se agrega el mensajero.
- El usuario recibe una confirmación de que el mensajero se ha agregado con éxito.
7. Enviar Mensaje
- Desde la pantalla principal, el usuario selecciona la opción para enviar un mensaje.
- Selecciona un destinatario y un mensajero previamente agregados.
- Ingresa el contenido del mensaje.
- Se envía el mensaje y se confirma al usuario.
8. Historial de Mensajes
- El usuario accede a la sección de historial desde la pantalla principal.
- Se muestra una lista de todos los mensajes enviados, con detalles como contenido, fecha y participantes.
- El historial se presenta de manera ordenada y fácil de entender.
9. Búsqueda de Mensajes
- Desde la pantalla principal, el usuario selecciona la opción para buscar mensajes.
- Ingresa el ID del mensaje que desea buscar.
- Se muestra la información detallada del mensaje, incluidos detalles sobre el destinatario y el mensajero asociados.
10. Salida de la Aplicación
- Desde cualquier pantalla, el usuario tiene la opción de cerrar sesión y salir de la aplicación.
- Se muestra un mensaje de confirmación antes de cerrar la sesión.
- El usuario es redirigido a la pantalla de inicio de sesión después de salir.
## Detalles Técnicos
La aplicación está desarrollada en Android Studio.
Utiliza el SDK 34 de Android.
Se ha optimizado para el emulador Pixel 6 Pro como referencia principal.
Incorpora las mejores prácticas de desarrollo Android y sigue los principios de diseño de material.
