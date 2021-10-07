package app.org.superhero.data.repository

import app.org.superhero.data.model.DataCharactersModel
import app.org.superhero.data.model.*
import com.google.gson.annotations.SerializedName
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import java.util.*

class CharactersRepositoryTest : TestCase() {

    lateinit var callCharactersModel: CallCharactersModel
    lateinit var dataCharactersModel: DataCharactersModel

    @Before
    override fun setUp(){
        dataCharactersModel = DataCharactersModel(
            0,
            20,
            1559,
            20,
                emptyList()
        )
        callCharactersModel = CallCharactersModel(
            200,
            "Ok",
            dataCharactersModel,
            "",
            "",
            "",
            ""
        )
    }

    @Test
    fun testNewPetitionTest() {
        assertEquals(callCharactersModel.code, 200)
    }

    @Test
    fun testGetCharactersTest() {
        assertEquals(callCharactersModel.data.total, 1559)
        assertNotNull(callCharactersModel.data)
    }

}