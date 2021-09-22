package one.digitalinnovation.coroutines.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import one.digitalinnovation.coroutines.data.repository.ViaCepRepository

class MainViewModel(
    private val repository: ViaCepRepository = ViaCepRepository()
) : ViewModel() {

    private val _state = MutableLiveData<String>()
    val state: LiveData<String> = _state

    fun findAddress(cep: String) = viewModelScope.launch {
        runCatching {
            repository.findAddress(cep)
        }.onSuccess { address ->
            _state.value = address.toString()
        }.onFailure { throwable ->
            _state.value = throwable.message
        }
    }
}
