package c.kaleidot725.pagingsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
class  Item(@PrimaryKey var id : String, @ColumnInfo(name = "name") var name : String)