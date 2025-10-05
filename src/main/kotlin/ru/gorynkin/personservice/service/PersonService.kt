package ru.gorynkin.personservice.service

import ru.gorynkin.personservice.dto.PatchPersonRequest
import ru.gorynkin.personservice.dto.PersonRequest
import ru.gorynkin.personservice.dto.PersonResponse
import kotlinx.coroutines.flow.Flow

interface PersonService {

    // region Create
    suspend fun createPerson(person: ru.gorynkin.personservice.dto.PersonRequest): Int
    // endregion

    // region Read
    fun getAllPeople(): Flow<ru.gorynkin.personservice.dto.PersonResponse>

    suspend fun getPerson(id: Int): ru.gorynkin.personservice.dto.PersonResponse
    // endregion

    // region Update
    suspend fun updatePerson(id: Int, person: ru.gorynkin.personservice.dto.PatchPersonRequest): ru.gorynkin.personservice.dto.PersonResponse
    // endregion

    // region Delete
    suspend fun deletePerson(id: Int)
    // endregion

}
