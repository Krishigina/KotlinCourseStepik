package org.example.multithreading.singletonCompanionInit.dogs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    @SerialName("id") val id: Int,
    @SerialName("breedName") val breedName: String,
    @SerialName("dogName") val dogName: String,
    @SerialName("weight") val weight: Double
)
