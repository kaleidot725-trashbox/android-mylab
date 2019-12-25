package kaleidot725.roomsample

import androidx.room.*

@Dao
interface UserDao {
    @Query("select * from users")
    fun getAll(): List<User>

    @Query("select * from users where id = :id")
    fun getUser(id: Int): User

    @Insert
    fun insert(user : User)

    @Update
    fun update(user : User)

    @Delete
    fun delete(user : User)

    @Query("delete from users")
    fun deleteAll()
}