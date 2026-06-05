package com.example.tpdesynthseroom.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tpdesynthseroom.model.Pharmacie
import com.example.tpdesynthseroom.repository.PharmacieRepository
import kotlinx.coroutines.launch

class PharmacieViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = PharmacieRepository(application)

    val pharmacies = MutableLiveData<List<Pharmacie>>()
    val isOffline = MutableLiveData<Boolean>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {

            isLoading.value = true

            isOffline.value = !repo.isConnectedPublic()

            val data = repo.getPharmacie()
            pharmacies.value = data

            isLoading.value = false
        }
    }
}