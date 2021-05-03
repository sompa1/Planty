package com.vhjv0i.planty.test

import android.os.Build
import android.os.Looper
import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.testInjector
import com.vhjv0i.planty.ui.plants.PlantDetailsPresenter
import com.vhjv0i.planty.ui.plants.PlantDetailsScreen
import com.vhjv0i.planty.utils.mock
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import javax.inject.Inject

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class PlantDetailsTest {

    @Inject
    lateinit var plantDetailsPresenter: PlantDetailsPresenter

    private lateinit var plantDetailsScreen: PlantDetailsScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        plantDetailsScreen = mock()
        plantDetailsPresenter.attachScreen(plantDetailsScreen)
    }

    @Test
    fun testPlantDetails() {
        plantDetailsPresenter.getPlantById("1")
        val plantCaptor: ArgumentCaptor<Plant> = ArgumentCaptor.forClass(
            Plant::class.java
        )
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        Mockito.verify(plantDetailsScreen).showPlantDetails(plantCaptor.capture());
        Assert.assertNotNull(plantCaptor.getValue())
    }

    @After
    fun tearDown() {
        plantDetailsPresenter.detachScreen()
    }
}