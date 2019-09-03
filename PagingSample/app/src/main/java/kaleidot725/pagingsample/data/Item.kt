package kaleidot725.pagingsample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(@PrimaryKey(autoGenerate = true) var id : Int, @ColumnInfo(name = "name") var name : String)
