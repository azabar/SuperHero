package app.org.superhero.data.network

import app.org.superhero.data.model.CallCharacterModel
import app.org.superhero.data.model.CallCharactersModel
import app.org.superhero.utils.Constants.ServerAPI.Companion.HASH
import app.org.superhero.utils.Constants.ServerAPI.Companion.PUBLIC_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CallsApiClient {
    @GET("v1/public/characters?ts=1&apikey=${PUBLIC_KEY}&hash=${HASH}")
    suspend fun getCharacters(): Response<CallCharactersModel>
    @GET("v1/public/characters/{id}?ts=1&apikey=${PUBLIC_KEY}&hash=${HASH}")
    suspend fun getCharacter(@Path("id") id: String): Response<CallCharacterModel>
}