package kaleidot725.roomsample

class UserRepository(private val dao : UserDao) {
    fun getAll() : List<User> {
        return dao.getAll()
    }

    fun getUser(id : Int ) : User {
        return dao.getUser(id)
    }

    fun insert(user : User) {
        return dao.insert(user)
    }

    fun delete(user: User) {
        dao.delete(user)
    }

    fun deleteAll() {
        dao.deleteAll()
    }
}