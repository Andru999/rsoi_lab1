package ru.gorynkin.personservice.domain

import ru.gorynkin.personservice.dto.PatchPersonRequest

object PatchPersonRequestMother {
    fun empty() = PatchPersonRequestBuilder()
}

class PatchPersonRequestBuilder: Builder<ru.gorynkin.personservice.dto.PatchPersonRequest> {
    var name: String = ""
    var age: Int? = null
    var address: String? = null
    var work: String? = null

    override fun build() = ru.gorynkin.personservice.dto.PatchPersonRequest(
        name = name,
        age = age,
        address = address,
        work = work
    )
}
