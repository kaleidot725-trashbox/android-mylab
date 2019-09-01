package kaleidot725.roomsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Member::class], version = 1, exportSchema = true)
abstract class MyDatabase : RoomDatabase() {

    abstract fun memberDao(): MemberDao

    companion object {
        @Volatile
        private var instance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase = instance ?: synchronized(this) {
            Room.databaseBuilder(context, MyDatabase::class.java, "techbooster.db")
                .addMigrations(MIGRATION_1_2)
                .build()
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    """
                    create table member2
                        (id text not null, progress integer not null, PRIMARY KEY(id))
                        """
                )
            }
        }
    }
}