# am2_group2017_2
Curso de Aplicaciones Móviles 2 - Grupo 2017 02

## Semana 2

- Fragments

  - Fundamentos
  - Agregar un fragment mediante ui(xml)
  - Acceder a un fragment desde una Actividad
  - Comunicación entre fragments

### [1] Bienvenido !

En esta sesión veremos sobre fragments , ¿Qué es un fragment? ¿Cómo se diferencia con una activity?

Un fragment es :

- Un módulo reusables con código y diseño.
- Carga un vista XML (fragment_sample.xml)
- No se requiere registrar en el Manifest
- Un fragment se puede agregar, reemplazar, remover de una activity.
- Necesita de un activity.
- Tiene su propio ciclo de vida


### [2] Descargar los ejemplos de clase

Si usas GIT , puedes descargar los ejemplos de clase de la siguiente manera :

```
  git clone -b "S2_Fragments" https://github.com/emedinaa/am2_group2017_2.git Semana2
```
O tambien puedes descargar los archivos en el siguiente link

```
https://github.com/emedinaa/am2_group2017_2/archive/S2_Fragments.zip
```
Despues de descargar y descomprimir el archivo, podemos encontrar dos carpetas

- AM2Fragments , esta carpeta es el proyecto Android de la clase
- Images

### [3] Revisar el proyecto

El proyecto base es "AM2Fragments" y lo abrimos con el IDE Android Studio

```
  File / Open file or Project
```

El proyecto tiene la siguiente estructura

- build.gradle
- [app] /
  - build.gradle
  - [src] /
    - [main] /
      - AndroidManifest.xml
        - [java] /
        - [res] /
  - [build]/
  - [libs]/

¿Dónde se encuentra nuestro código?

```
  AM2Fragments / app / src / main /
```

En este proyecto contamos con varias actividades

- MainMessageActivity , este ejemplo nos muestra como crear un fragment, el uso de interfaces y como comunicar dos fragments , pasando información de una fragment al otro.

- MainActivity & EventDetailsActivity , en este ejemplo tenemos un listado de eventos y una pantalla de detalle. Esta realizado solo con Activities.

- MainFragmentActivity & EventDetailsActivity , este ejemplos es similar al anterior pero hemos usado fragments

- MainTabletActivity , en este ejemplo solo usamos fragments para mostrar un listado de eventos y una pantalla de detalle.


### [4] Ejecutar nuestros ejemplos

```
  Run / Run App
```

- MainMessageActivity (appMessage)

<img src="./images/screenshotmessage.png" height="480">

- MainActivity (app)

<img src="./images/screenshot1.png" height="480"> <img src="./images/screenshot2.png" height="480">

- MainFragmentActivity (appFragment)

<img src="./images/screenshot1.png" height="480"> <img src="./images/screenshot2.png" height="480">

- MainTabletActivity (appTablet)

<img src="./images/screenshottablet.png" height="480">

### [5] Aprender más

-  Creando un fragment https://developer.android.com/training/basics/fragments/creating.html

- Construyendo UI dinámicas con fragments https://developer.android.com/training/basics/fragments/index.html
