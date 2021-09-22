package one.digitalinnovation.coroutines.data.api

import one.digitalinnovation.coroutines.data.model.Address
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("{cep}/json")
    suspend fun findAddress(@Path("cep") cep: String): Address
}
