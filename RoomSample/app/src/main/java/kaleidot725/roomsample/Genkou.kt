package kaleidot725.roomsample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genkou")
class  Genkou(
    @PrimaryKey
    var id : String
)