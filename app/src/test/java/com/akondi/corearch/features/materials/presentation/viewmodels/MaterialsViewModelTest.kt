package com.akondi.corearch.features.materials.presentation.viewmodels

import com.akondi.corearch.core.exception.Failure
import com.akondi.corearch.core.functional.Either
import com.akondi.corearch.features.materials.domain.entities.materials.Material
import com.akondi.corearch.features.materials.domain.repository.MaterialsRepository
import com.akondi.corearch.features.materials.domain.usecases.GetMaterials
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.assertEquals


class MaterialsViewModelTest {

    private lateinit var viewModel: MaterialsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val dispatcherRule = MainCoroutineRule()

    @Before
    fun setUp() {
        viewModel = MaterialsViewModel(getMaterials = GetMaterials(TestMaterialsRepository()))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun settingMainDispatcher() = runTest {
        launch {
            viewModel.loadMaterials()
        }
        advanceUntilIdle()
        assertEquals(2, viewModel.materials.value.size)
    }

    class TestMaterialsRepository : MaterialsRepository {
        private val materials = listOf(
            Material("", "", "", "", "", ""),
            Material("", "", "", "", "", "")
        )

        override fun materials(): Either<Failure, List<Material>> = Either.Right(materials)
    }
}