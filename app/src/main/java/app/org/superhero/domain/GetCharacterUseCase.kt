package app.org.superhero.domain

import app.org.superhero.data.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(private val repository: CharacterRepository)  {
    suspend operator fun invoke(id: String) = repository.getCharacter(id)
}
