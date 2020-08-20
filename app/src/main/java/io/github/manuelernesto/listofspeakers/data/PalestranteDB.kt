package io.github.manuelernesto.listofspeakers.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Palestrante::class], version = 1)
abstract class PalestranteDB: RoomDatabase() {

    abstract fun dao(): PalestranteDAO

    companion object {
        @Volatile
        private var TALK_INSTANCE: PalestranteDB? = null

        fun getDatabase(context: Context): PalestranteDB {
            val tempInstance = TALK_INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PalestranteDB::class.java,
                    "db_palestrante"
                ).build()
                TALK_INSTANCE = instance
                return instance
            }
        }
    }
}