package app.org.superhero.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.org.superhero.data.model.CallCharacterModel
import app.org.superhero.data.model.CharacterModel
import app.org.superhero.domain.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel(){

    val callCharacterModel = MutableLiveData<CallCharacterModel>()
    val characterModel = MutableLiveData<CharacterModel>()
    val isLoading = MutableLiveData<Boolean>()
    val hasError = MutableLiveData<Boolean>()
    var mID : String = "0"

    fun onCreate() {

    }

    fun setID(uri: String) {
        val strs = uri.split("/").toTypedArray()
        mID = strs[strs.size - 1]
    }

    fun loadCharacter() {
        viewModelScope.launch {
            isLoading.postValue(true)
            hasError.postValue(false)
            try {
                val result = getCharacterUseCase(mID)

                callCharacterModel.postValue(result)
                characterModel.postValue(result.data.results[0])
                isLoading.postValue(false)
            } catch (e: Exception) {
                isLoading.postValue(false)
                hasError.postValue(true)
            }
        }
    }
}