package com.akondi.corearch.features.materials.presentation.activities


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akondi.corearch.features.materials.presentation.compose.Navigation

import com.akondi.corearch.features.materials.presentation.viewmodels.MaterialsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MaterialsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            actionBar?.hide()
            val viewModel = viewModel<MaterialsViewModel>()
            val materials = viewModel.materials.value
            Navigation(materials)
        }
    }
}


