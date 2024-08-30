package au.edu.swin.sdmd.l06_detailedimages

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val location = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("location", Location::class.java)
        } else {
            intent.getParcelableExtra<Location>("location")
        }

        location?.let {
            val vName = findViewById<TextView>(R.id.name)
            vName.text = location.name

            val vAuthor = findViewById<TextView>(R.id.author)
            vAuthor.text = location.author
        }

    }
}