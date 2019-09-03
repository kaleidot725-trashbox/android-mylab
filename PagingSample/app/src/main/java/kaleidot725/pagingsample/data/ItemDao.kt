package kaleidot725.pagingsample.data

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM Item ORDER BY name COLLATE NOCASE ASC")
    fun allItemByName(): DataSource.Factory<Int, Item>

    @Insert
    fun insert(item: List<Item>)
}