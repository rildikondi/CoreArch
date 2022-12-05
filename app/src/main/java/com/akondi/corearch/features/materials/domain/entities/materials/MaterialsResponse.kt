package com.akondi.corearch.features.materials.domain.entities.materials

data class MaterialsResponse(
    val hits: List<Hit>
) {
    companion object {
        fun empty() = MaterialsResponse(emptyList())
    }
}