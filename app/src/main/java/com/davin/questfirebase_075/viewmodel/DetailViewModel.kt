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

sealed interface StatusUIDetail {
    data class Success(val satuSiswa: Siswa?) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositorySiswa: RepositorySiswa
) : ViewModel() {

    // KUNCI ERROR: ID dikirim sebagai String dari Navigasi, harus di-convert ke Long
    private val idSiswa: Long = savedStateHandle.get<String>(DestinasiDetail.itemIdArg)?.toLong()
        ?: error("idSiswa tidak ditemukan di SavedStateHandle")

    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa() {
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading
            statusUIDetail = try {
                StatusUIDetail.Success(satuSiswa = repositorySiswa.getSatuSiswa(idSiswa))
            } catch (e: IOException) {
                StatusUIDetail.Error
            } catch (e: Exception) {
                StatusUIDetail.Error
            }
        }
    }

    suspend fun hapusSatuSiswa() {
        try {
            repositorySiswa.hapusSatuSiswa(idSiswa)
            println("Sukses Hapus Data: $idSiswa")
        } catch (e: Exception) {
            println("Gagal Hapus Data: ${e.message}")
        }
    }
}