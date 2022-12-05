package com.akondi.corearch.features.materials.domain.entities.materials

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MaterialView(
    val author: String?,
    val dateCreated: String?,
    val dateModified: String?,
    val id: String?,
    val thumbUrl: String?,
    val title: String?
) : Parcelable
