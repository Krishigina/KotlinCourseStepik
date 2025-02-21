package org.example.multithreading.singletonCompanionInit.dogs

import org.example.multithreading.singletonCompanionInit.command.Command

sealed interface AdministratorCommands: Command {

    data class AddDog(
        val dogsRepository: DogsRepository,
        val breedName: String,
        val dogName: String,
        val weight: Double
    ): AdministratorCommands {
        override fun execute() {
            dogsRepository.addDog(breedName, dogName, weight)
        }
    }

    data class DeleteDog(
        val dogsRepository: DogsRepository,
        val dogId: Int
    ): AdministratorCommands {
        override fun execute() {
            dogsRepository.deleteDog(dogId)
        }
    }

    data class SaveChanges(
        val dogsRepository: DogsRepository
    ): AdministratorCommands {
        override fun execute() {
            dogsRepository.saveChanges()
        }
    }

}