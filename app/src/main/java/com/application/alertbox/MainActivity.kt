package com.application.alertbox

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.application.alertbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val alertBox1 = AlertDialog.Builder(this)
            alertBox1.setTitle("Are you sure !")
            alertBox1.setMessage("Do you want to Exit the App")
            alertBox1.setIcon(R.drawable.outdoor_24)
            alertBox1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            alertBox1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            alertBox1.show()
        }

        binding.button2.setOnClickListener {
            val options = arrayOf("dal - chawal", "Sabji - Roti", "Butter Chiken")
            val alertbox2 = AlertDialog.Builder(this)
            alertbox2.setTitle("Your favroite Food...")
            alertbox2.setSingleChoiceItems(options, 0,DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "${options[i]} ... Oh Nice Choice", Toast.LENGTH_SHORT).show()
            })
            alertbox2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            alertbox2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            alertbox2.show()
        }

        binding.button3.setOnClickListener {
            val options = arrayOf("Namkeen", "Buiskit", "Chai")
            val alertbox3 = AlertDialog.Builder(this)
            alertbox3.setTitle("Select your favroite Snacks..")
            alertbox3.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->

            })
            alertbox3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            alertbox3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()
        }
        binding.button4.setOnClickListener {
            val intent1 = Intent(this, Fotoframe::class.java)
            startActivity(intent1)
        }
    }
}

