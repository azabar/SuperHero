package app.org.superhero.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.org.superhero.data.model.CallCharactersModel
import app.org.superhero.data.model.CharacterModel
import app.org.superhero.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel(){

    val charactersModel = MutableLiveData<CallCharactersModel>()
    val isLoading = MutableLiveData<Boolean>()
    val hasError = MutableLiveData<Boolean>()
    var charactersList = MutableLiveData<List<CharacterModel>>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            hasError.postValue(false)
            try {
                val result = getCharactersUseCase()
                if(result.code == 200){
                    charactersModel.postValue(result)
                    charactersList.postValue(result.data.results)
                    isLoading.postValue(false)
                }
            } catch (e: Exception) {
                isLoading.postValue(false)
                hasError.postValue(true)
            }
        }
    }

    fun getResourceURI(position: Int): String {
        var list = charactersList.value
        return list?.get(position)!!.resourceURI
    }
}