package com.davin.questfirebase_075.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davin.questfirebase_075.modeldata.Siswa
import com.davin.questfirebase_075.repositori.RepositorySiswa
import com.davin.questfirebase_075.view.route.DestinasiDetail
import kotlinx.coroutines.launch
import java.io.IOException

// Status UI untuk halaman Detail
sealed interface StatusUIDetail {
    data class Success(val satuSiswa: Siswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositorySiswa: RepositorySiswa
) : ViewModel() {

    // Mengambil idSiswa dari argumen navigasi (SavedStateHandle)
    private val idSiswa: Long = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])

    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa() {
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading
            statusUIDetail = try {
                StatusUIDetail.Success(repositorySiswa.getSiswaById(idSiswa))
            } catch (e: IOException) {
                StatusUIDetail.Error
            } catch (e: Exception) {
                StatusUIDetail.Error
            }
        }
    }

    // Fungsi suspend agar bisa dipanggil di Coroutine scope milik UI (Composable)

}