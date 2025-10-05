package ru.gorynkin.personservice.repository

import ru.gorynkin.personservice.domain.PersonEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CoroutineCrudRepository<ru.gorynkin.personservice.domain.PersonEntity, Int>
