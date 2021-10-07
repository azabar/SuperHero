package app.org.superhero.data.network

import app.org.superhero.core.RetrofitHelper
import app.org.superhero.data.model.CallCharactersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersService @Inject constructor() {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getCharacters(): CallCharactersModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CallsApiClient::class.java).getCharacters()
            response.body()!!
        }
    }
}