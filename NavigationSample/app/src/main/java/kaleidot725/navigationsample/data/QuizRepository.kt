package kaleidot725.navigationsample.data

class QuizRepository() {
    private val items : MutableList<Quiz> = mutableListOf(
        Quiz(0, "食べられないパンは？", listOf("アンパンマン", "フライパン", "ジャパン", "ルパン"), "フライパン"),
        Quiz(1, "日本の首都は？", listOf("東京", "福岡", "ニューヨーク", "埼玉"), "東京"),
        Quiz(2, "夢を英語で言うと？", listOf("ドドリア", "ドリアン", "ドライヤー", "ドリーム"), "ドリーム")
    )

    fun findAll() : List<Quiz> {
        return items.toList()
    }

    fun findById(id : Int) : Quiz {
        return items.filter { x -> x.id == id }.first()
    }
}