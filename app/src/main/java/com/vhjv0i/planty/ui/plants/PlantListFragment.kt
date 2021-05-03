package com.vhjv0i.planty.ui.plants

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList
import androidx.recyclerview.widget.SortedListAdapterCallback
import com.vhjv0i.planty.MainActivity
import com.vhjv0i.planty.R
import com.vhjv0i.planty.injector
import com.vhjv0i.planty.model.SpeciesLight
import javax.inject.Inject


class PlantListFragment : Fragment(), PlantListScreen {

    private var plantList: MutableList<SpeciesLight> = mutableListOf()
    private var plantsAdapter: PlantsAdapter? = null
    var plants: List<SpeciesLight>? = null //TODO

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
        plantsAdapter = PlantsAdapter(requireContext(), plantList as ArrayList<SpeciesLight>)
        recyclerViewPlants.adapter = plantsAdapter

        recyclerViewPlants.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        val intent = Intent(activity, PlantDetailsActivity::class.java)
                        val b = Bundle()
                        b.putInt("id", plantsAdapter!!.getItem(position)!!.id)
                        b.putString("name", plantsAdapter!!.getItem(position)!!.commonName)
                        intent.putExtras(b) //Put your id to your next Intent
                        startActivity(intent)
                    }
                })
        )

        val nameSearch = view.findViewById<SearchView>(R.id.name_search)
        val searchIcon = nameSearch.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.WHITE)
        nameSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                plantsAdapter!!.filter.filter(newText)
                return false
            }

        })

        return view

    }

    override fun showPlants(plants: List<SpeciesLight>?) {
        plantList.clear()
        plantList.addAll(plants!!)
        plantsAdapter!!.notifyDataSetChanged()
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater: MenuInflater = inflater
        inflater.inflate(R.menu.main_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView = SearchView(((context as PlantListActivity).supportActionBar?.themedContext ?: context)!!)
        menu.findItem(R.id.action_search).apply {
            setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW or MenuItem.SHOW_AS_ACTION_IF_ROOM)
            actionView = searchView
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                return false
            }

        })
    }
    */

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
        plantsPresenter.refreshPlants("")
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