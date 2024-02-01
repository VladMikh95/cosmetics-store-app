package ml.vladmikh.projects.cosmetics_store_app.ui.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ml.vladmikh.projects.cosmetics_store_app.data.local.entities.UserLocalDataSource
import ml.vladmikh.projects.cosmetics_store_app.data.repository.UserLocalDataSourceRepository
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repository: UserLocalDataSourceRepository): ViewModel() {

    val editTextName = MutableLiveData<String>()
    val editTextSurname = MutableLiveData<String>()
    val editTextPhoneNumber = MutableLiveData<String>()

    fun registration() {
        viewModelScope.launch {

            repository.insert(
                UserLocalDataSource(0,
                    editTextName.value.toString(),
                    editTextSurname.value.toString(),
                    editTextPhoneNumber.value.toString())
            )
        }
    }
}