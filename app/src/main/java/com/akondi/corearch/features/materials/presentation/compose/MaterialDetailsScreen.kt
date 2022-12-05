package com.akondi.corearch.features.materials.presentation.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akondi.corearch.features.materials.domain.entities.materials.MaterialView

@Composable
fun MaterialDetailsScreen(navController: NavController, materialView: MaterialView?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopBar(navController = navController)

        Card(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .padding(
                    bottom = 10.dp,
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp
                ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp,
                pressedElevation = 2.dp,
                focusedElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                materialView?.title?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                materialView?.id?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.Start)
                            .align(Alignment.Start),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                materialView?.author?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                materialView?.dateCreated?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                materialView?.dateModified?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    Row {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.popBackStack()
                }
        )

        Text(
            text = "Material Details",
            modifier = Modifier

                .align(CenterVertically),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

