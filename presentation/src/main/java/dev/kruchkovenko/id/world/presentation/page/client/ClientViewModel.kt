package dev.kruchkovenko.id.world.presentation.page.client

import androidx.lifecycle.ViewModel
import dev.kruchkovenko.id.world.domain.feature.client.useCase.GetClientName

class ClientViewModel(private val getClientName: GetClientName) : ViewModel()  {
    fun clientName() = getClientName()
}
