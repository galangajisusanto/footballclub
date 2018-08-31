package tech.codestudio.footballclub

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()
    private lateinit var cl: Club

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        club_list.layoutManager = LinearLayoutManager(this);
        club_list.adapter = RecyclerViewAdapter(this, items) {

            cl = Club("${it.name}", "${it.image}", "${it.description}")

            val intent = Intent(this, DescriptionActivity::class.java)
            var bundle = Bundle()
            bundle.putParcelable("cl", cl)
            intent.putExtra("myBundle", bundle)
            startActivity(intent)
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_detail)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }


}