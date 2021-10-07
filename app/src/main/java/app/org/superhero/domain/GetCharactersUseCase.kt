package app.org.superhero.domain

import app.org.superhero.data.repository.CharactersRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: CharactersRepository)  {
    suspend operator fun invoke() = repository.getCharacters()
}