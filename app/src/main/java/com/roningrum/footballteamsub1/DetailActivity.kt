package com.roningrum.footballteamsub1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    private var name: String = ""
    private var desc: String = ""
    private var img: Int = 1

    private lateinit var nameTeamTextView: TextView
    private lateinit var descTeamTextView: TextView
    private lateinit var imgTeamLogo: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(16)
            imgTeamLogo = imageView().lparams(width= dip(150),height = dip(150)){
                gravity = Gravity.CENTER
            }
            nameTeamTextView = textView(){
                gravity = Gravity.CENTER
                textSize = 20f
            }
                    .lparams(width= matchParent, height = wrapContent){
                        topMargin = dip(16)
                    }
            descTeamTextView = textView(){
                textSize = 14f
            }
                    .lparams(width= matchParent, height = wrapContent){
                        topMargin = dip(16)
                    }
        }
        val intent = intent
        name = intent.getStringExtra("name")
        desc = intent.getStringExtra("desc")
        img = intent.getIntExtra("img", 0)
        nameTeamTextView.text = name
        descTeamTextView.text = desc
        imgTeamLogo.setImageResource(img)
        }

    }
