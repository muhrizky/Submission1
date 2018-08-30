package id.ac.undip.ce.student.muhammadrizqi.submission1

import android.content.ClipData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import id.ac.undip.ce.student.muhammadrizqi.submission1.R.array.*
import id.ac.undip.ce.student.muhammadrizqi.submission1.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items) {itemClicked(it)}
    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val description = resources.getStringArray(club_description)
        items.clear()
        for (i in name.indices) {
            items.add(item(name[i],
                    image.getResourceId(i, 0), description[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
    private fun itemClicked(items: item){
        startActivity<DetailActivity>(DetailActivity.JUDUL to items.name, DetailActivity.GAMBAR to items.image, DetailActivity.DESKRIPSI to items.description)
    }
}