package com.vhjv0i.planty.data

import androidx.room.*
import com.vhjv0i.planty.model.SpeciesLight

@Dao
interface SpeciesLightDAO {
    @Query("SELECT * FROM plantitem")
    fun findAllItems(): List<SpeciesLight>

    @Insert
    fun insertItem(item: SpeciesLight): Long

    @Delete
    fun deleteItem(item: SpeciesLight)

    @Update
    fun updateItem(item: SpeciesLight)
}