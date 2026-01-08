package com.davin.questfirebase_075.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle // Import PENTING ini sering lupa
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.davin.questfirebase_075.repositori.AplikasiDataSiswa

fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiDataSiswa().container.repositorySiswa) }
        initializer { EntryViewModel(aplikasiDataSiswa().container.repositorySiswa) }

        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiDataSiswa().container.repositorySiswa
            )
        }


    }
}