package com.davin.questfirebase_075

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.davin.questfirebase_075.navigation.DataSiswaApp
import com.davin.questfirebase_075.ui.theme.QuestFirebase_075Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Sesuaikan nama tema dengan yang ada di folder ui.theme/Theme.kt
            QuestFirebase_075Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Pastikan composable DataSiswaApp sudah dibuat (biasanya berisi NavHost)
                    DataSiswaApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}