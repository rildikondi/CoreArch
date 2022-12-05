package com.akondi.corearch.features.materials.domain.entities.materials

data class Hit(
    val creator: Creator,
    val dateCreated: String,
    val dateModified: String,
    val id: String,
    val thumbUrl: String,
    val title: String,
    val type: String,
    val visibility: String
) {
    fun toMaterial() = Material(creator.name,  dateCreated, dateModified, id, thumbUrl, title)
}