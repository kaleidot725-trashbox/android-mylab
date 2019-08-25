package kaleidot725.roomsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "members")
data class Genkou(
    @ColumnInfo(name = "display_name")
    var genkouName : String
)