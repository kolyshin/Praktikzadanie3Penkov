package com.example.praktik_zadanie3__penkov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

var likeCount = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = getSharedPreferences("LIKES_PREFS", MODE_PRIVATE)
        likeCount = preferences.getInt("likeCount", 0)
        val countLikes = findViewById<TextView>(R.id.countlikes)
        likeCount.toString().also { countLikes.text = it }

        val likeButton = findViewById<ImageButton>(R.id.likebnt)
        likeButton.setOnClickListener {

            likeCount++
            countLikes.text = likeCount.toString()


            val editor = getSharedPreferences("LIKES_PREFS", MODE_PRIVATE).edit()
            editor.putInt("likeCount", likeCount)
            editor.apply()
        }

    }

}