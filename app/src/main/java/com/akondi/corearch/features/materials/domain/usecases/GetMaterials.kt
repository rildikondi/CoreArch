package com.akondi.corearch.features.materials.domain.usecases

import com.akondi.corearch.core.interactor.UseCase
import com.akondi.corearch.features.materials.domain.entities.materials.Material
import com.akondi.corearch.features.materials.domain.repository.MaterialsRepository
import javax.inject.Inject

class GetMaterials @Inject constructor(private val materialsRepository: MaterialsRepository) :
    UseCase<List<Material>, UseCase.None>() {

    override suspend fun run(params: None) = materialsRepository.materials()
}