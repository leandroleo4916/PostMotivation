package com.example.postmotivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postmotivation.databinding.ActivityMainBinding
import com.example.postmotivation.repository.ResultPage
import com.example.postmotivation.viewModel.ViewModelPage
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: ViewModelPage by viewModel()
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observerImagesPage()
    }

    private fun observerImagesPage() {

        viewModel.getImagesPage(page).observe(this){
            it?.let { result ->
                when (result) {
                    is ResultPage.Success -> {
                        result.dado?.let { images ->
                            val img = images.photos
                        }
                    }
                    is ResultPage.Error -> {
                        result.exception.message?.let { }
                    }
                    is ResultPage.ErrorConnection -> {
                        result.exception.message?.let { }
                    }
                }
            }
        }
    }
}