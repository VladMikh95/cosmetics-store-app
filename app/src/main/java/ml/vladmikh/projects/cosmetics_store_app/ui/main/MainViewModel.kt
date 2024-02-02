package ml.vladmikh.projects.cosmetics_store_app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ml.vladmikh.projects.cosmetics_store_app.data.local.entities.UserLocalDataSource
import ml.vladmikh.projects.cosmetics_store_app.data.repository.UserLocalDataSourceRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: UserLocalDataSourceRepository): ViewModel() {

    val listUsers: LiveData<List<UserLocalDataSource>> = repository.getAllUsers().asLiveData()
}