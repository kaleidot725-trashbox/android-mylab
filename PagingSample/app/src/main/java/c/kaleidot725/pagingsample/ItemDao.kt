package c.kaleidot725.pagingsample

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM items ORDER BY name COLLATE NOCASE ASC")
    fun allItemByName() : DataSource.Factory<Int, Item>

    @Insert
    fun insert(item : List<Item>)
}