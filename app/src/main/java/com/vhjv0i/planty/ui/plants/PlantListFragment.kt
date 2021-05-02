package com.vhjv0i.planty.ui.plants

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vhjv0i.planty.R
import com.vhjv0i.planty.injector
import com.vhjv0i.planty.model.SpeciesLight
import javax.inject.Inject


class PlantListFragment : Fragment(), PlantListScreen {

    private var plantList: MutableList<SpeciesLight> = mutableListOf()
    private var plantsAdapter: PlantsAdapter? = null
    //private val plant by lazy { requireArguments().getString(KEY_PLANT)!! }
    //private var selectedPlant: String? = null
    //private lateinit var listViewModel: PlantListViewModel

    @Inject
    lateinit var plantsPresenter: PlantsPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        plantsPresenter.attachScreen(this)
    }

    override fun onDetach() {
        plantsPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_plants, container, false)
        val recyclerViewPlants = view.findViewById<View>(R.id.recyclerViewPlants) as RecyclerView
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewPlants.setLayoutManager(llm)

        plantList = ArrayList()
        plantsAdapter = PlantsAdapter(requireContext(), plantList)
        recyclerViewPlants.adapter = plantsAdapter

        recyclerViewPlants.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        val intent = Intent(activity, PlantDetailsActivity::class.java)
                        val b = Bundle()
                        b.putInt("id", plantsAdapter!!.getItem(position)!!.id)
                        intent.putExtras(b) //Put your id to your next Intent
                        startActivity(intent)
                    }
                })
        )
        return view

    }

    override fun showPlants(plants: List<SpeciesLight>?) {
        plantList.clear()
        plantList.addAll(plants!!)
        plantsAdapter!!.notifyDataSetChanged()
    }


    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedPlant = plant
        //view.findViewById(R.id.etPlant).setText(selectedPlant!!)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvPlants.layoutManager = llm

        plantsAdapter = PlantsAdapter(requireContext(), displayedPlants)
        rvPlants.adapter = plantsAdapter

        swipeRefreshLayoutPlants.setOnRefreshListener {
            //selectedPlant = etArtist.text.toString()
            plantsPresenter.refreshPlants(selectedPlant!!)
        }
    }*/

    override fun showNetworkError(errorMsg: String) {
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        plantsPresenter.refreshPlants("") //TODO: common_name
    }

    companion object {
        private const val KEY_PLANT = "KEY_PLANT"

        fun newInstance(artist: String): PlantListFragment {
            val fragment = PlantListFragment()
            val bundle = Bundle()

            bundle.putString(KEY_PLANT, artist)
            fragment.arguments = bundle
            return fragment
        }
    }
}