package com.application.alertbox

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.application.alertbox.databinding.ActivityMainBinding

class Fotoframe : AppCompatActivity() {

    var currentimage = 0
    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fotoframe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNext = findViewById<ImageButton>(R.id.btnnext)
        val btnPrev = findViewById<ImageButton>(R.id.btnprev)

        btnNext.setOnClickListener {
            val currentImageString = "pic$currentimage"
            val currentImageInt = this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(currentImageInt)
            image.alpha = 0f

            currentimage = (4 + currentimage + 1) % 4

            val imagetoShowString = "pic$currentimage"
            val imagetoShowInt = this.resources.getIdentifier(imagetoShowString, "id", packageName)
            image = findViewById(imagetoShowInt)
            image.alpha = 1f
        }

        btnPrev.setOnClickListener {
            val currentImageString = "pic$currentimage"
            val currentImageInt = this.resources.getIdentifier(currentImageString,"id", packageName)
            image = findViewById(currentImageInt)
            image.alpha = 0f

            currentimage = (4 + currentimage - 1) % 4

            val imagetoShowString = "pic$currentimage"
            val imagetoShowInt = this.resources.getIdentifier(imagetoShowString, "id", packageName)
            image = findViewById(imagetoShowInt)
            image.alpha = 1f
        }
    }
}