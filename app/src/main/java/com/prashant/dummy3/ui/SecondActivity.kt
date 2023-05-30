package com.prashant.dummy3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prashant.dummy3.*
import com.prashant.dummy3.repository.PhotoRepository
import com.prashant.dummy3.viewmodel.PhotoViewModel
import com.prashant.dummy3.viewmodel.PhotoViewModelFactory

class SecondActivity : AppCompatActivity() {
    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val photoRecyclerView: RecyclerView = findViewById(R.id.photoRecyclerView)
        photoRecyclerView.layoutManager = LinearLayoutManager(this)
        photoAdapter = PhotoAdapter(emptyList())
        photoRecyclerView.adapter = photoAdapter

        val photoRepository = PhotoRepository()
        val photoViewModel = ViewModelProvider(this, PhotoViewModelFactory(photoRepository)).get(
            PhotoViewModel::class.java)

        photoViewModel.photos.observe(this, Observer { photos ->
            photoAdapter = PhotoAdapter(photos)
            photoRecyclerView.adapter = photoAdapter
        })

        photoViewModel.fetchPhotos()
    }
}
