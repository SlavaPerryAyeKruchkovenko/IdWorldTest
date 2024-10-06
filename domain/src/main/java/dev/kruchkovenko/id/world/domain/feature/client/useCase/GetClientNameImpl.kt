package dev.kruchkovenko.id.world.domain.feature.client.useCase

import dev.kruchkovenko.id.world.domain.feature.client.repository.ClientRepository

class GetClientNameImpl(private val repository: ClientRepository) : GetClientName {
    override fun invoke(): String = repository.name
}
