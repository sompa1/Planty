package com.vhjv0i.planty.ui.plants

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.vhjv0i.planty.R

class PlantDetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        //val toolbar = findViewById<View>(R.id.details_toolbar) as Toolbar
        //setSupportActionBar(toolbar)


        // Show the Up button in the action bar.
        //val actionBar = supportActionBar
        //actionBar?.setDisplayHomeAsUpEnabled(true)


        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val b = intent.extras
            //val plantName = b!!.getString("name")
            //val commonNameText = findViewById<TextView>(R.id.toolbar_common_name)
            //commonNameText.text = plantName

            val fragment = PlantDetailsFragment()
            fragment.arguments = b
            supportFragmentManager.beginTransaction()
                .add(R.id.item_details_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            navigateUpTo(Intent(this, PlantListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}