package org.example.multithreading.singletonCompanionInit.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Gender {
    @SerialName("Male") MALE,
    @SerialName("Female") FEMALE
}