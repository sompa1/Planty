package com.vhjv0i.planty.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vhjv0i.planty.model.SpeciesLight

@Database(entities = arrayOf(SpeciesLight::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun speciesLightDAO(): SpeciesLightDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "plant.db")
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}