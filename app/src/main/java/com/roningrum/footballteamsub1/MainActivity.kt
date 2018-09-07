package com.roningrum.footballteamsub1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private var Teamitems : MutableList<TeamItem> = mutableListOf()
    private lateinit var ClubListTeam : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout {
            lparams(width= matchParent, height = wrapContent)
            ClubListTeam= recyclerView {
                lparams (width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = TeamfbAdapter (Teamitems){
                    startActivity<DetailActivity>(
                            "name" to "${it.name}",
                            "img" to it.image,
                            "desc" to "${it.desc}")
            }
                initData()
        }

    }
}
    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_detail)
        val img = resources.obtainTypedArray(R.array.club_image)

        Teamitems.clear()
        for (i in name.indices) {
            Teamitems.add(TeamItem(name[i],
                    img.getResourceId(i, 0), desc[i]))

        }
        img.recycle()
    }
}
