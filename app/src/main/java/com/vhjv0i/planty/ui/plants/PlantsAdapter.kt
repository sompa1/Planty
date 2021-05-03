package com.vhjv0i.planty.ui.plants

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vhjv0i.planty.R
import com.vhjv0i.planty.model.SpeciesLight
import java.util.*
import kotlin.collections.ArrayList


class PlantsAdapter constructor(
    private val context: Context,
    private var plants: ArrayList<SpeciesLight>
) : RecyclerView.Adapter<PlantsAdapter.ViewHolder>(), Filterable {

    var plantFilterList= ArrayList<SpeciesLight>()

    init {
        plantFilterList = plants
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_plant, viewGroup, false)
        return ViewHolder(itemView)
    }

    private val mOnClickListener =
        View.OnClickListener { view ->
            val item: SpeciesLight = view.tag as SpeciesLight
            val context = view.context
            val intent = Intent(context, PlantDetailsActivity::class.java)
            intent.putExtra(PlantDetailsFragment.ARG_ITEM_ID, item.id)
            context.startActivity(intent)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = plantFilterList[position]

        plant.imageUrl?.let {
            val imageUrl = plant.imageUrl!!
            if (!imageUrl.isNullOrEmpty()) {
                Glide.with(context).load(imageUrl).into(holder.plantImage)
            }
        }

        holder.plantCommonName.text = plant.commonName
    }

    //override fun getItemCount() = plants.size

    override fun getItemCount(): Int {
        return plantFilterList.size
    }

    fun getItem(position: Int): SpeciesLight? {
        return plantFilterList[position]
    }

    override fun getFilter(): Filter {

        return object : Filter() {

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    plantFilterList = plants
                } else {
                    val resultList = ArrayList<SpeciesLight>()
                    for (row in plants) {
                        if (row.commonName!!.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    plantFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = plantFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                plantFilterList = results?.values as ArrayList<SpeciesLight>
                notifyDataSetChanged()
            }

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var plantImage: ImageView = view.findViewById(R.id.plantImage)
        var plantCommonName: TextView = view.findViewById(R.id.plantCommonName)
    }
}