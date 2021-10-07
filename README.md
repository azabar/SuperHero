# SuperHero App

## Arquitectura

He apostado por el patrón de arquitectura MVVM porque considero que proporciona una mayor versatilidad a la hora de recolectar datos desde el API y presentarlos en la vista, quedando perfectamente separadas tanto la Vista como el Modelo.

## Librerías utilizadas

* [Glide](https://github.com/bumptech/glide) - Librería usada para decodificar, guardar y cachear imágenes
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Inyección de dependencias para Android
* [CardView](https://developer.android.com/jetpack/androidx/releases/cardview) - Patrón de tarjeta de Material Design 
* [Retrofit](https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit) - A type-safe HTTP client for Android and Java

## Tests unitarios

He utilizado JUnit para preparar dos tests muy sencillos que permiten conocer si el repository es capaz de realizar una petición satisfatoria a la API, así como recibir la lista de personajes o un personaje en concreto

* [JUnit](https://mvnrepository.com/artifact/junit/junit) - JUnit is a unit testing framework for Java



