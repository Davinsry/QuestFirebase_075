package com.davin.questfirebase_075.view.route

import com.davin.questfirebase_075.R
import com.davin.questfirebase_075.view.route.DestinasiNavigasi

object DestinasiEdit : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}