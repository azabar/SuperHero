package app.org.superhero.utils

interface Constants {

    interface ServerAPI {
        companion object {
            const val BASE_URL = "https://gateway.marvel.com/"
            const val PUBLIC_KEY = "608d8a63dac5b3d5783c26a4702e42d7"
            const val HASH = "49d50beb59986d66e86be472b50ba002"
        }
    }
}