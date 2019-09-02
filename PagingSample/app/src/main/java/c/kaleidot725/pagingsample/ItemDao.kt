package c.kaleidot725.pagingsample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import javax.sql.DataSource

@Dao
interface ItemDao {
    @Query("SELECT * FROM Item ORDER BY name COLLATE NOCASE ASC")
    fun allItemByName() : DataSource.Factory<Int, Item>

    @Insert
    fun insert(item : List<Item>)
}