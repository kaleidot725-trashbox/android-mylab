package kaleidot725.navigationsample.data

class Quiz(val id : Int, val title :  String, val choices : List<String>, private val answer : String) {
    fun result(a : String) : Boolean = (a == answer)
}