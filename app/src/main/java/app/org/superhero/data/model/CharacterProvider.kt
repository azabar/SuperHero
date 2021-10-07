package app.org.superhero.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterProvider @Inject constructor() {
    var character: CallCharacterModel? = null
}