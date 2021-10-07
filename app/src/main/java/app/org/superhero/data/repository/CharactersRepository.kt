package app.org.superhero.data.repository

import app.org.superhero.data.model.CallCharactersModel
import app.org.superhero.data.model.CharactersProvider
import app.org.superhero.data.network.CharactersService
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api: CharactersService,
    private val charactersProvider: CharactersProvider
)
{
        suspend fun getCharacters(): CallCharactersModel{
        val response = api.getCharacters()
        charactersProvider.characters = response
        return response
    }
}