package com.example.postmotivation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.postmotivation.dataclass.Page
import com.example.postmotivation.repository.RepositoryPage
import com.example.postmotivation.repository.ResultPage

class ViewModelPage (private val repository: RepositoryPage) : ViewModel() {

    fun getImagesPage(page: Int):
            LiveData<ResultPage<Page?>> = repository.getImagesPage(page)
}