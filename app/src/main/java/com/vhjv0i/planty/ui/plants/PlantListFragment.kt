package com.vhjv0i.planty.ui.plants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vhjv0i.planty.R
import com.vhjv0i.planty.ui.about.AboutViewModel
import javax.inject.Inject

class PlantListFragment : Fragment() {

    @Inject
    lateinit var plantsPresenter: PlantsPresenter
    private lateinit var listViewModel: PlantListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listViewModel =
            ViewModelProvider(this).get(PlantListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_list)
        listViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}