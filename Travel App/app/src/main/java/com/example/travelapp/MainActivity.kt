package com.example.travelapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.ui.theme.TravelAppTheme

class MainActivity : ComponentActivity() {

    var currentImage =0
    lateinit var image : ImageView
    lateinit var namesView: TextView
    var names = arrayOf("Food","CaviusDine" , "Special Menu" , "Finder" , "Moon" )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        namesView = findViewById(R.id.tvName)

        next.setOnClickListener {
            changeImage(next = true)
        }

        prev.setOnClickListener {
            changeImage(next = false)
        }

    }

    private fun changeImage(next: Boolean) {
        // Hide current image
        val idCurrentImageString = "pic$currentImage"
        val idCurrentImageInt = resources.getIdentifier(idCurrentImageString, "id", packageName)
        val currentImageView = findViewById<ImageView?>(idCurrentImageInt)
        currentImageView?.alpha = 0f  // Safe access to avoid crashes

        // Update currentImage index
        currentImage = if (next) {
            (currentImage + 1) % 5  // Move forward
        } else {
            (currentImage - 1 + 5) % 5  // Move backward
        }

        // Show new image
        val idImageToShowString = "pic$currentImage"
        val idCurrentImageToShowInt = resources.getIdentifier(idImageToShowString, "id", packageName)
        val newImageView = findViewById<ImageView?>(idCurrentImageToShowInt)
        newImageView?.alpha = 1f  // Safe access to avoid crashes
        namesView.text = names[currentImage]
    }
}