package com.akondi.corearch.features.materials.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.akondi.corearch.features.materials.domain.entities.materials.MaterialView
import com.akondi.corearch.ui.theme.Material3AppTheme

@Composable
fun MaterialsScreen(navController: NavController, materials: List<MaterialView>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Materials",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 7.5.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            itemsIndexed(
                items = materials
            ) { index, material ->
                MaterialItem(material = material,
                    onClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "material",
                            material
                        )
                        navController.navigate(Screen.MaterialDetailsScreen.route)
                    }
                )
            }
        }
    }
}


@Composable
fun MaterialItem(
    material: MaterialView,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                top = 10.dp,
                start = 10.dp,
                end = 10.dp
            )
            .height(200.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp,
            focusedElevation = 4.dp
        )
    ) {
        Column() {
            material.thumbUrl.let { url ->
                Image(
                    painter = rememberAsyncImagePainter(
                        model = material.thumbUrl,
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.large)
                        .fillMaxWidth()
                        .aspectRatio(3f / 2f)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, bottom = 6.dp, start = 8.dp, end = 8.dp)
            ) {
                material.title?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                material.author?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}
