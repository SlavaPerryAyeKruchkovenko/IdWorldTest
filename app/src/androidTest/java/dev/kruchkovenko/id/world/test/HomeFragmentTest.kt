package dev.kruchkovenko.id.world.test

import android.graphics.Color
import androidx.core.graphics.toColor
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.kruchkovenko.id.world.data.feature.client.model.Client
import dev.kruchkovenko.id.world.data.feature.client.repository.ClientRepositoryImpl
import dev.kruchkovenko.id.world.domain.feature.client.useCase.GetClientNameImpl
import dev.kruchkovenko.id.world.presentation.page.client.ClientViewModel
import dev.kruchkovenko.id.world.presentation.page.client.HomeFragment
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.test.KoinTest
import kotlin.test.assertEquals

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest : KoinTest {
    private val TAG = this::class.java.simpleName

    @Test
    fun operatorNameDisplayed() {
        testArgs().forEach {
            stopKoin()
            val client = it.first
            val themeId = it.second
            val color = Color.parseColor(it.third)
            val testModule = module {
                single { client }
                viewModel { ClientViewModel(GetClientNameImpl(ClientRepositoryImpl(get()))) }
            }
            startKoin {
                modules(testModule)
            }
            val scenario = launchFragmentInContainer<HomeFragment>(themeResId = themeId)
            scenario.onFragment {
                val curColor = it.binding.operatorName.currentTextColor
                val curText = it.binding.operatorName.text.toString()
                assertEquals(color, curColor)
                assertEquals(client.name, curText)
            }
        }
    }

    companion object {
        @JvmStatic
        private fun testArgs(): List<Triple<Client, Int, String>> {
            return listOf(
                Triple(
                    Client(name = "OperatorA"),
                    R.style.Theme_Idworldtest_OperatorA,
                    "#FF5733",
                ), Triple(
                    Client(name = "OperatorB"),
                    R.style.Theme_Idworldtest_OperatorB,
                    "#33FF57",
                ), Triple(
                    Client(name = "OperatorC"),
                    R.style.Theme_Idworldtest_OperatorC,
                    "#3357FF",
                ), Triple(
                    Client(name = "OperatorD"),
                    R.style.Theme_Idworldtest_OperatorD,
                    "#FF33A1",
                ), Triple(
                    Client(name = "OperatorE"),
                    R.style.Theme_Idworldtest_OperatorE,
                    "#A133FF",
                ), Triple(
                    Client(name = "OperatorF"),
                    R.style.Theme_Idworldtest_OperatorF,
                    "#FF8C33",
                ), Triple(
                    Client(name = "OperatorG"),
                    R.style.Theme_Idworldtest_OperatorG,
                    "#33FF8C",
                ), Triple(
                    Client(name = "OperatorH"),
                    R.style.Theme_Idworldtest_OperatorH,
                    "#8C33FF",
                ), Triple(
                    Client(name = "OperatorI"),
                    R.style.Theme_Idworldtest_OperatorI,
                    "#FF3333",
                ), Triple(
                    Client(name = "OperatorJ"),
                    R.style.Theme_Idworldtest_OperatorJ,
                    "#33FFA1",
                )
            )
        }
    }
}
