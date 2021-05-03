package com.vhjv0i.planty.interactor.plants

import android.util.Log
import com.vhjv0i.planty.interactor.plants.event.GetAboutEvent
import com.vhjv0i.planty.interactor.plants.event.GetPlantDetailsEvent
import com.vhjv0i.planty.interactor.plants.event.GetPlantsEvent
import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.model.PlantBase
import com.vhjv0i.planty.model.SpeciesLight
import com.vhjv0i.planty.model.SpeciesLightBase
import com.vhjv0i.planty.network.PlantsApi
import org.greenrobot.eventbus.EventBus
import retrofit2.Response
import javax.inject.Inject

class PlantsInteractor @Inject constructor(private var plantsApi: PlantsApi) {
    fun getPlants(name: String) {
        val event = GetPlantsEvent()

        try {
            val plantList = ArrayList<SpeciesLight>()

            val plantItem1 = SpeciesLight(1, "Evergreen oak", "quercus-rotundifolia", "Quercus rotundifolia",
                1785, "Encycl. 1: 723 (1785)", "Lam.", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Beech family", "Quercus", 588, "Quercus", "https://bs.plantnet.org/image/o/1a03948baf0300da25558c2448f086d39b41ca30")
            val plantItem2 = SpeciesLight(2, "European mountain ash", "sorbus-aucuparia", "Sorbus aucuparia",
                1753, "Sp. Pl.: 477 (1753)", "L.", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Rose family", "Rosaceae", 677, "Sorbus", "https://www.minnesotawildflowers.info/udata/r9ndp23q/trees/sorbus-aucuparia-european-mountain-ash_0803_180842.jpg")
            val plantItem3 = SpeciesLight(3, "Christmastree", "abies-alba", "Abies alba",
                1756, "Gard. Dict. ed. 7: n.º 1 (1756)", "Mill.", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Pine family", "Pinaceae", 322, "Quercus", "https://www.monaconatureencyclopedia.com/wp-content/uploads/2014/06/l_abies_alba_gia_presente_sulla_terra_55_milioni_di_anni_fa_raggiunge_i_75_m_d_altezza.jpg")
            val plantItem4 = SpeciesLight(4, "Spreading hedgeparsley", "torilis-arvensis", "Torilis arvensis",
                1821, "Enum. Hort. Berol. Alt. 1: 265 (1821)", "(Huds.) Link", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Carrot family", "Apiaceae", 456, "Torilis", "https://wildflowerfinder.org.uk/Flowers/H/HedgeParsley(Upright)/Parsley(UprightHedge)_2015_07_31_Hope_LadybowerResr_Hathersage_083p55.jpg")
            val plantItem5 = SpeciesLight(5, "White ash", "fraxinus-americana", "Fraxinus americana",
                1753, "Sp. Pl.: 1057 (1753)", "L.", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Olive family", "Oleaceae", 689, "Fraxinus", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Fraxinus_americana_002.jpg/330px-Fraxinus_americana_002.jpg")
            val plantItem6 = SpeciesLight(6, "Clustered field sedge", "carex-praegracilis", "Carex praegracilis",
                1884, "Bot. Gaz. 9: 87 (1884)", "W.Boott", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Sedge family", "Cyperaceae", 690, "Carex", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Carexpraegracilis1.jpg/330px-Carexpraegracilis1.jpg")
            val plantItem7 = SpeciesLight(7, "Senecio gamolepis", "senecio-gamolepis", "Senecio gamolepis",
                1955, "Notas Mus. La Plata, Bot. 18(89): 222 (1955)", "Cabrera", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Aster family", "Asteracea", 356, "Senecio", "https://inaturalist-open-data.s3.amazonaws.com/photos/53180602/medium.jpeg?1570172682")

            val mockList = arrayListOf(plantItem1, plantItem2, plantItem3, plantItem4, plantItem5, plantItem6, plantItem7)
            plantList.addAll(mockList)

            val speciesLightBase = SpeciesLightBase(plantList)

//            val plantsQueryCall = plantsApi.getPlants("w13pBqSMuB6hYsXmOhlty-Ctb_olDiHchWFLkg3AdeA", name)
//
//            val response = object : Response<SpceciesLightBase> {
//
//            }
//            Log.d("Reponse", response.body().toString())
//            if (response.code() != 200) {
//                throw Exception("Result code is not 200")
//            }
            event.code = 200
            event.plants = speciesLightBase.data
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getPlantDetails(id: String) {
        val event = GetPlantDetailsEvent()

        try {

//            val plantsQueryCall = plantsApi.getPlantDetails(id,"w13pBqSMuB6hYsXmOhlty-Ctb_olDiHchWFLkg3AdeA")
//
//            val response = plantsQueryCall.execute()
//            Log.d("Reponse", response.body().toString())
//            if (response.code() != 200) {
//                throw Exception("Result code is not 200")
//            }

            val plantList = ArrayList<Plant>()
            val plantItem1 = Plant(1,"Evergreen oak", "quercus-rotundifolia", "Quercus rotundifolia",
                "https://bs.plantnet.org/image/o/1a03948baf0300da25558c2448f086d39b41ca30", 1785, "Encycl. 1: 723 (1785)", "Lam.", "Beech family", 588, 1, false, "SW. Europe, N. Africa")
            val plantItem2 = Plant(2,"European mountain ash", "sorbus-aucuparia", "Sorbus aucuparia",
                "https://www.minnesotawildflowers.info/udata/r9ndp23q/trees/sorbus-aucuparia-european-mountain-ash_0803_180842.jpg", 1753, "Sp. Pl.: 477 (1753)", "L.", "Rose family", 677, 2, false, "N. Europe, Asia")
            val plantItem3 = Plant(3, "Christmastree", "abies-alba", "Abies alba",
                "https://www.monaconatureencyclopedia.com/wp-content/uploads/2014/06/l_abies_alba_gia_presente_sulla_terra_55_milioni_di_anni_fa_raggiunge_i_75_m_d_altezza.jpg", 1756, "Gard. Dict. ed. 7: n.º 1 (1756)", "Mill.", "Pine family",  322, 3, false, "Europe" )
            val plantItem4 = Plant(4, "Spreading hedgeparsley", "torilis-arvensis", "Torilis arvensis",
                "https://wildflowerfinder.org.uk/Flowers/H/HedgeParsley(Upright)/Parsley(UprightHedge)_2015_07_31_Hope_LadybowerResr_Hathersage_083p55.jpg", 1821, "Enum. Hort. Berol. Alt. 1: 265 (1821)", "(Huds.) Link",  "Carrot family", 456, 4, true, "Europe, N. America" )
            val plantItem5 = Plant(5, "White ash", "fraxinus-americana", "Fraxinus americana",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Fraxinus_americana_002.jpg/330px-Fraxinus_americana_002.jpg", 1753, "Sp. Pl.: 1057 (1753)", "L.","Olive family",  689, 5, false, "East and central America" )
            val plantItem6 = Plant(6, "Clustered field sedge", "carex-praegracilis", "Carex praegracilis",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Carexpraegracilis1.jpg/330px-Carexpraegracilis1.jpg", 1884, "Bot. Gaz. 9: 87 (1884)", "W.Boott",  "Sedge family",  690,6,  false, "E. America" )
            val plantItem7 = Plant(7, "Senecio gamolepis", "senecio-gamolepis", "Senecio gamolepis",
                "https://inaturalist-open-data.s3.amazonaws.com/photos/53180602/medium.jpeg?1570172682", 1955, "Notas Mus. La Plata, Bot. 18(89): 222 (1955)", "Cabrera",  "Aster family",  356, 7, false )

            val mockList = arrayListOf(plantItem1, plantItem2, plantItem3, plantItem4, plantItem5, plantItem6, plantItem7)
            plantList.addAll(mockList)
            val selectedItem = plantList.first { it.id.toString() == id}
            val plantBase = PlantBase(selectedItem)
            event.code = 200
            event.plant = plantBase.data
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getAbout(id: String) {
        val event = GetAboutEvent()

        try {
            event.code = 1
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

}