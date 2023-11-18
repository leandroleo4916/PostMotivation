package com.example.postmotivation.repository

import androidx.lifecycle.liveData
import com.example.postmotivation.network.ApiServiceMain
import java.net.ConnectException

sealed class ResultPage<out R> {
    data class Success<out T>(val dado: T?) : ResultPage<T?>()
    data class Error(val exception: Exception) : ResultPage<Nothing>()
    data class ErrorConnection(val exception: Exception) : ResultPage<Nothing>()
}

class RepositoryPage (private val apiServiceMain: ApiServiceMain) {

    fun getImagesPage(page: Int) = liveData {
        try {
            val request = apiServiceMain.getImages(page)
            if(request.isSuccessful){
                emit(ResultPage.Success(dado = request.body()))
            } else {
                emit(ResultPage.Error(exception = Exception("Não foi possível conectar!")))
            }
        } catch (e: ConnectException) {
            emit(ResultPage.ErrorConnection(exception = Exception("Falha na comunicação com API")))
        }
        catch (e: Exception) {
            emit(ResultPage.Error(exception = e))
        }
    }

}