package com.akondi.corearch.features.materials.data

import com.akondi.corearch.features.materials.domain.entities.materials.MaterialsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MaterialsApi {
    companion object {
        private const val FILTER = "filter"
        private const val DEFAULT_FILTER = "author:geogebrateam"
        private const val MATERIALS = "applets"

    }

    @GET(MATERIALS)
    fun materials(
        @Query(FILTER) filter: String? = DEFAULT_FILTER
    ): Call<MaterialsResponse>
}