package ml.vladmikh.projects.cosmetics_store_app.ui.catalog

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ml.vladmikh.projects.cosmetics_store_app.data.network.model.ItemRemoteDataSource
import ml.vladmikh.projects.cosmetics_store_app.data.repository.ItemRemoteDataSourceRepository
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(private val repository: ItemRemoteDataSourceRepository): ViewModel(){

    private val _itemRemoteDataSource = MutableLiveData<ItemRemoteDataSource>()
    val itemRemoteDataSource: LiveData<ItemRemoteDataSource> get() = _itemRemoteDataSource

    init {
        viewModelScope.launch {
            try {
                _itemRemoteDataSource.value  = repository.getItemRemoteDataSource().body()!!
                Log.i("abc", _itemRemoteDataSource.value.toString())
            } catch (e: Exception) {

            }
        }
    }
}