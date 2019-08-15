package kaleidot725.roomsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Member::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun memberDao(): MemberDao

    companion object {
        @Volatile
        private var instance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase = instance ?: synchronized(this) {
                Room.databaseBuilder(context, MyDatabase::class.java, "techbooster.db").build()
        }
    }
}