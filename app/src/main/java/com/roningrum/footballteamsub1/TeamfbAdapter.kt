package com.roningrum.footballteamsub1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class TeamfbAdapter (private val items: List<TeamItem>, private val listener: (TeamItem) -> Unit)
    : RecyclerView.Adapter<TeamfbAdapter.TeamViewHolder>() {

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {holder.bindItem(items[position], listener)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
     return TeamViewHolder(TeamfbUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = items.size

    class TeamfbUI:AnkoComponent<ViewGroup>{
        override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
            return linearLayout {
                lparams(width= matchParent, height = wrapContent)
                padding= dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.teamfb_img
                }.lparams(width=dip(50), height = dip (50)){
                }
                textView{
                    id = R.id.teamfb_name
                    textSize = 16f
                }.lparams(width = wrapContent, height = wrapContent){
                    margin = dip(15)
                }
            }
        }
    }
    class TeamViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {
        private val teamName : TextView = itemView.find(R.id.teamfb_name)
        private val teamImage : ImageView = itemView.find(R.id.teamfb_img)
        fun bindItem(items: TeamItem, listener: (TeamItem) -> Unit) {
            teamName.text = items.name
            Glide.with(itemView.context).load(items.image).into(teamImage)
            containerView.onClick { listener(items) }
        }
    }
}