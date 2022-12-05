package com.akondi.corearch.features.materials.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.akondi.corearch.core.interactor.UseCase
import com.akondi.corearch.features.materials.domain.usecases.GetMaterials
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.akondi.corearch.core.exception.Failure
import com.akondi.corearch.features.materials.domain.entities.materials.Material
import com.akondi.corearch.features.materials.domain.entities.materials.MaterialView
import kotlinx.coroutines.launch

@HiltViewModel
class MaterialsViewModel
@Inject constructor(private val getMaterials: GetMaterials) : ViewModel() {
    val failure: MutableState<Failure> = mutableStateOf(Failure())
    val materials: MutableState<List<MaterialView>> = mutableStateOf(listOf())

    init {
        loadMaterials()
    }

    fun loadMaterials() = viewModelScope.launch {
        getMaterials(UseCase.None()) { it.either(::handleFailure, ::handleMaterialsList) }
    }

    private fun handleMaterialsList(materials: List<Material>) {
        this.materials.value = materials.map {
            MaterialView(
                it.author,
                it.dateCreated,
                it.dateModified,
                it.id,
                it.thumbUrl.replace(Regex("\\\\"), "")
                    .replace("$1", "") ,
                it.title
            )
        }
    }
    
    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}