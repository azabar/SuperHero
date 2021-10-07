package app.org.superhero.data.repository

import app.org.superhero.data.model.*
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import java.util.*

class CharacterRepositoryTest : TestCase() {

    lateinit var callCharacterModel: CallCharacterModel
    lateinit var dataCharacterModel: DataCharacterModel
    lateinit var results: Array<CharacterModel>
    lateinit var characterModel: CharacterModel
    @Before
    override fun setUp(){
        characterModel = CharacterModel(
            1017100,
            "A-Bomb (HAS)",
            "",
            Date(),
            emptyList(),
            ImageModel("",""),
            "",
            ResourceListModel(0, 0, "", emptyArray()),
            ResourceListModel(0, 0, "", emptyArray()),
            ResourceListModel(0, 0, "", emptyArray()),
            ResourceListModel(0, 0, "", emptyArray())
        )
        results = arrayOf(characterModel)
        dataCharacterModel = DataCharacterModel(0, 20, 1,1, results)
        callCharacterModel = CallCharacterModel(
            200,
            "Ok",
            dataCharacterModel,
            "",
            "",
            "",
            ""
        )
    }
    @Test
    fun testNewPetitionTest() {
        assertEquals(callCharacterModel.code, 200)
    }
    @Test
    fun testGetCharacterTest() {
        assertEquals(callCharacterModel.data.results[0].id, 1017100)
    }
}