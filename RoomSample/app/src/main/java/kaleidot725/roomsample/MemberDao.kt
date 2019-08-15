package kaleidot725.roomsample

import androidx.room.*

@Dao
interface MemberDao {
    @Query("select * from members")
    fun getAllMembsers(): List<Member>

    @Query("select * from members where id = :id")
    fun getMember(id: String): Member

    @Insert
    fun insert(member : Member)

    @Update
    fun update(member : Member)

    @Delete
    fun delete(member : Member)

    @Query("delete from members")
    fun deleteAll()
}