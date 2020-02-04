package kaleidot725.myapplication

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.xmlpull.v1.XmlPullParser.END_DOCUMENT
import org.xmlpull.v1.XmlPullParser.START_TAG

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val persons = parsePerson()
        val user1 = persons.getOrNull(0)
        val user2 = persons.getOrNull(1)
        val user3 = persons.getOrNull(2)

        val name1 = findViewById<TextView>(R.id.name1_text_view)
        name1.text = user1?.name
        val age1 = findViewById<TextView>(R.id.age1_text_view)
        age1.text = user1?.age.toString()
        val icon1 = findViewById<ImageView>(R.id.icon1_view)
        icon1.setImageResource(user1?.iconRes ?: 0)

        val name2 = findViewById<TextView>(R.id.name2_text_view)
        name2.text = user2?.name
        val age2 = findViewById<TextView>(R.id.age2_text_view)
        age2.text = user2?.age.toString()
        val icon2 = findViewById<ImageView>(R.id.icon2_view)
        icon2.setImageResource(user2?.iconRes ?: 0)

        val name3 = findViewById<TextView>(R.id.name3_text_view)
        name3.text = user3?.name
        val age3 = findViewById<TextView>(R.id.age3_text_view)
        age3.text = user3?.age.toString()
        val icon3 = findViewById<ImageView>(R.id.icon3_view)
        icon3.setImageResource(user3?.iconRes ?: 0)
    }

    private fun parsePerson(): List<Person> {
        val persons = mutableListOf<Person>()

        // person_list.xml を解析するパーサーを取得する
        val parser = applicationContext.resources.getXml(R.xml.person_list)

        // 解析が完了し、ドキュメントの終端に到達するまで処理を続ける
        while (parser.eventType != END_DOCUMENT) {
            // <Person>が見つかったら、そのタグのアトリビュートを取得していく
            if (parser.eventType == START_TAG && parser.name == "person") {
                val name = parser.getAttributeValue(null, "name")
                val age = parser.getAttributeIntValue(null, "age", 0)
                val icon = parser.getAttributeResourceValue(null, "icon", 0)
                persons.add(Person(name, age, icon))
            }
            parser.next()
        }
        parser.close()
        return persons
    }
}
