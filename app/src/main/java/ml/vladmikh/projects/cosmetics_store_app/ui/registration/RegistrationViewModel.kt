package ml.vladmikh.projects.cosmetics_store_app.ui.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ml.vladmikh.projects.cosmetics_store_app.data.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(repository: UserRepository): ViewModel() {

    val editTextName = MutableLiveData<String>()
}