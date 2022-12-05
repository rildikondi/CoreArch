package com.akondi.corearch.features.materials.domain.entities.materials

data class Material (
    val author: String,
    val dateCreated: String,
    val dateModified: String,
    val id: String,
    val thumbUrl: String,
    val title: String?
)