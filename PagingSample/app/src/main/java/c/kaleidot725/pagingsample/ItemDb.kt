package c.kaleidot725.pagingsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = true)
abstract  class  ItemDb : RoomDatabase() {

    abstract fun itemDao() : ItemDao

    companion object {
        @Volatile
        private var instance : ItemDb? = null

        fun getInstance(context : Context) : ItemDb = instance ?: synchronized(this) {
            Room.databaseBuilder(context, ItemDb::class.java, "paging_sample.db")
            .build()
        }
    }
}