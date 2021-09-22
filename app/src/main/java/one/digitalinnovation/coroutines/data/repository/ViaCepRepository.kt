package one.digitalinnovation.coroutines.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import one.digitalinnovation.coroutines.data.api.RetrofitGenerator
import one.digitalinnovation.coroutines.data.api.ViaCepService
import one.digitalinnovation.coroutines.data.model.Address

class ViaCepRepository(
    private val api: ViaCepService = RetrofitGenerator.viaCepService
) {

    suspend fun findAddress(cep: String): Address {
        return withContext(Dispatchers.IO) {
            val address = api.findAddress(cep)
            if (address.error) throw CepNotFoundException("CEP inválido")
            address
        }
    }
}

class CepNotFoundException(message: String) : Throwable(message)
