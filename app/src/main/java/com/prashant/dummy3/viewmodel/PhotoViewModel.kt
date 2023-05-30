package com.prashant.dummy3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prashant.dummy3.data.Photo
import com.prashant.dummy3.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PhotoViewModel(private val photoRepository: PhotoRepository) : ViewModel() {
    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> get() = _photos

    fun fetchPhotos() {
        GlobalScope.launch(Dispatchers.Main) {
            val result = photoRepository.getPhotos()
            _photos.value = result
        }
    }
}
