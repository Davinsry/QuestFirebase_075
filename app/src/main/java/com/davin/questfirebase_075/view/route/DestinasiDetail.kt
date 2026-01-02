package com.davin.questfirebase_075.view.route

import com.davin.questfirebase_075.R
import com.davin.questfirebase_075.view.route.DestinasiNavigasi

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}