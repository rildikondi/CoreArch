package com.akondi.corearch.features.materials.domain.repository

import com.akondi.corearch.core.exception.Failure
import com.akondi.corearch.core.functional.Either
import com.akondi.corearch.core.platform.NetworkHandler
import com.akondi.corearch.features.materials.data.MaterialsService
import com.akondi.corearch.features.materials.domain.entities.materials.Material
import com.akondi.corearch.features.materials.domain.entities.materials.MaterialsResponse
import retrofit2.Call
import javax.inject.Inject

interface MaterialsRepository {
    fun materials(): Either<Failure, List<Material>>


    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: MaterialsService
    ) : MaterialsRepository {

        override fun materials(): Either<Failure, List<Material>> {
            return when (networkHandler.isConnected) {
                true -> request(
                    service.materials(),
                    {
                        it.hits.map { hits -> hits.toMaterial() } },
                    MaterialsResponse.empty()
                )
                false -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(
            call: Call<T>,
            transform: (T) -> R,
            default: T
        ): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}