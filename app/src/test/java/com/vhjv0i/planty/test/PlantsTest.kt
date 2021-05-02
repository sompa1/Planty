package com.vhjv0i.planty.test

import android.os.Build
import android.os.Looper
import com.vhjv0i.planty.model.SpeciesLight
import com.vhjv0i.planty.testInjector
import com.vhjv0i.planty.ui.plants.PlantListScreen
import com.vhjv0i.planty.ui.plants.PlantsPresenter
import com.vhjv0i.planty.utils.argumentCaptor
import com.vhjv0i.planty.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import javax.inject.Inject

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class PlantsTest {

    @Inject
    lateinit var plantsPresenter: PlantsPresenter

    private lateinit var plantListScreen: PlantListScreen
    private lateinit var query: String

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        plantListScreen = mock()
        plantsPresenter.attachScreen(plantListScreen)
    }

    @Test
    fun testArtists() {
        query = "Evergreen oak"
        plantsPresenter.refreshPlants(query)
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val list = argumentCaptor<MutableList<SpeciesLight>>()
        Mockito.verify(plantListScreen).showPlants(list.capture())
        assert(list.value.size > 0)
    }

    @After
    fun tearDown() {
        plantsPresenter.detachScreen()
    }


}