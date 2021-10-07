package app.org.superhero.data.repository

import app.org.superhero.data.model.CallCharacterModel
import app.org.superhero.data.model.CharacterProvider
import app.org.superhero.data.network.CharacterService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterService,
    private val characterProvider: CharacterProvider
) {

    suspend fun getCharacter(id: String): CallCharacterModel{
        val response = api.getCharacter(id)
        characterProvider.character = response
        return response
    }
}