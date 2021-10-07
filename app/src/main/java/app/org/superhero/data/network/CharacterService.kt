package app.org.superhero.data.network

import app.org.superhero.core.RetrofitHelper
import app.org.superhero.data.model.CallCharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor() {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getCharacter(id: String): CallCharacterModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CallsApiClient::class.java).getCharacter(id)
            response.body()!!
        }
    }
}