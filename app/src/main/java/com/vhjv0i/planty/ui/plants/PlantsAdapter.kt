package com.vhjv0i.planty.ui.plants

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vhjv0i.planty.R
import com.vhjv0i.planty.model.SpeciesLight


class PlantsAdapter constructor(
    private val context: Context,
    private var plants: List<SpeciesLight>
) : RecyclerView.Adapter<PlantsAdapter.ViewHolder>() {

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
        val plant = plants[position]

        plant.imageUrl?.let {
            val imageUrl = plant.imageUrl!!
            if (!imageUrl.isNullOrEmpty()) {
                Glide.with(context).load(imageUrl).into(holder.plantImage)
            }
        }

        holder.plantCommonName.text = plant.commonName
    }

    override fun getItemCount() = plants.size

    fun getItem(position: Int): SpeciesLight? {
        return plants.get(position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var plantImage: ImageView = view.findViewById(R.id.plantImage)
        var plantCommonName: TextView = view.findViewById(R.id.plantCommonName)
    }
}