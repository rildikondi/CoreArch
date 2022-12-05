package com.akondi.corearch.features.materials.data

import com.akondi.corearch.features.materials.domain.entities.materials.MaterialsResponse
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MaterialsService
@Inject constructor(retrofit: Retrofit)
    : MaterialsApi {

    private val materialsApi by lazy { retrofit.create(MaterialsApi::class.java) }

    override fun materials(filter: String?): Call<MaterialsResponse> = materialsApi.materials()
}