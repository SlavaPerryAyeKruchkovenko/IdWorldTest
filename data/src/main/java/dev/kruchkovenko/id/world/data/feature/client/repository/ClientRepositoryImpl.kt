package dev.kruchkovenko.id.world.data.feature.client.repository

import dev.kruchkovenko.id.world.data.feature.client.model.Client
import dev.kruchkovenko.id.world.domain.feature.client.repository.ClientRepository

class ClientRepositoryImpl(private val client: Client) : ClientRepository {
    override val name: String
        get() = client.name
}
