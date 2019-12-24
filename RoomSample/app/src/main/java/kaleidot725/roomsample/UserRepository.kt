package kaleidot725.roomsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepository(private val dao : UserDao) {
    fun getAll() : List<User> {
        return dao.getAll()
    }

    fun loadAllByIds(userIds: IntArray) : List<User> {
        return dao.loadAllByIds(userIds)
    }

    fun findByName(first: String, last: String) : User {
        return dao.findByName(first, last)
    }

    fun insertAll(vararg users: User) {
        dao.insertAll(*users)
    }

    fun delete(user: User) {
        dao.delete(user)
    }
}