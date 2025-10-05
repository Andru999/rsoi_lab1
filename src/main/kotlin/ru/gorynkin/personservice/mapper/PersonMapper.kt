package ru.gorynkin.personservice.mapper

import ru.gorynkin.personservice.domain.PersonEntity
import ru.gorynkin.personservice.dto.PatchPersonRequest
import ru.gorynkin.personservice.dto.PersonRequest
import ru.gorynkin.personservice.dto.PersonResponse

fun ru.gorynkin.personservice.domain.PersonEntity.toPersonResponse() = ru.gorynkin.personservice.dto.PersonResponse(
    id = id,
    name = name,
    age = age,
    address = address,
    work = work
)

fun ru.gorynkin.personservice.dto.PersonRequest.toPersonEntity(id: Int = 0) =
    ru.gorynkin.personservice.domain.PersonEntity(
        id = id,
        name = name,
        age = age,
        address = address,
        work = work
    )

fun ru.gorynkin.personservice.dto.PatchPersonRequest.toPersonEntity(id: Int = 0, prevState: ru.gorynkin.personservice.domain.PersonEntity) =
    ru.gorynkin.personservice.domain.PersonEntity(
        id = id,
        name = name ?: prevState.name,
        age = age ?: prevState.age,
        address = address ?: prevState.address,
        work = work ?: prevState.work
    )
