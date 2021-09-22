package one.digitalinnovation.coroutines.data.model

import com.squareup.moshi.Json

data class Address(
    @field:Json(name = "cep")
    val cep: String,
    @field:Json(name = "logradouro")
    val street: String,
    @field:Json(name = "bairro")
    val neighborhood: String,
    @field:Json(name = "localidade")
    val city: String,
    @field:Json(name = "uf")
    val state: String,
    @field:Json(name = "erro")
    val error: Boolean
) {
    override fun toString(): String {
        return """
            cep=$cep
            street=$street
            neighborhood=$neighborhood
            city=$city
            state=$state
            """.trimIndent()
    }
}
