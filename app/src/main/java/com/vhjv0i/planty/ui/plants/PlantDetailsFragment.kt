package com.vhjv0i.planty.ui.plants

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.vhjv0i.planty.R
import com.vhjv0i.planty.injector
import com.vhjv0i.planty.model.Plant
import javax.inject.Inject

class PlantDetailsFragment: Fragment(), PlantDetailsScreen {

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }

    private var plant: Plant? = null
    private var sciNameText: TextView? = null
    private var obsText: TextView? = null
    private var familyText: TextView? = null
    private var yearText: TextView? = null
    private var biblioText: TextView? = null
    private var imageView: ImageView? = null

    @Inject
    lateinit var plantDetailsPresenter: PlantDetailsPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        plantDetailsPresenter.attachScreen(this)
    }

    override fun onDetach() {
        plantDetailsPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val b =  requireArguments()
        val id = b.getInt("id").toString()
        plantDetailsPresenter.getPlantById(id!!)
        // Load the dummy content specified by the fragment
        // arguments. In a real-world scenario, use a Loader
        // to load content from a content provider.
        //plant = Plant()
        val activity: Activity? = this.activity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.item_details, container, false)
        this.sciNameText = rootView.findViewById<TextView>(R.id.plantSciName)
        this.obsText = rootView.findViewById<TextView>(R.id.plantObservations)
        this.familyText = rootView.findViewById<TextView>(R.id.plantFamily)
        this.yearText = rootView.findViewById<TextView>(R.id.plantDiscovery)
        this.biblioText = rootView.findViewById<TextView>(R.id.plantBiblio)
        imageView = rootView.findViewById(R.id.plantImageView)
        return rootView
    }

    override fun showPlantDetails(plant: Plant?) {
        this.plant = plant
        this.sciNameText!!.text = plant!!.scientificName
        this.obsText!!.text = plant.observations
        this.familyText!!.text = plant.familyCommonName
        this.yearText!!.text = plant.year.toString()
        this.biblioText!!.text = plant.bibliography
        plant.imageUrl?.let {
            val imageUrl = plant.imageUrl!!
            if (!imageUrl.isNullOrEmpty()) {
                Glide.with(requireContext()).load(imageUrl).into(this.imageView!!)
            }
        }
    }

    override fun showNetworkError(errorMsg: String) {
        //plantImageView
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
    }

}