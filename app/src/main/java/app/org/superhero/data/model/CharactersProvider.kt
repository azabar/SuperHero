package app.org.superhero.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersProvider @Inject constructor() {
    var characters: CallCharactersModel? = null
}