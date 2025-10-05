package ru.gorynkin.personservice.domain

import ru.gorynkin.personservice.dto.PersonRequest

object PersonRequestMother {
    fun default() = PersonRequestBuilder().apply {
        name = "Aidana"
        age = 19
        address = "Omsk, Russia"
        work = "MOPK"
    }
}

class PersonRequestBuilder : Builder<ru.gorynkin.personservice.dto.PersonRequest> {
    var name: String = ""
    var age: Int? = null
    var address: String? = null
    var work: String? = null

    override fun build() = ru.gorynkin.personservice.dto.PersonRequest(
        name = name,
        age = age,
        address = address,
        work = work
    )

}
