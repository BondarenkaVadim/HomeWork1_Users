package com.example.homework1_users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Attributes
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var users: MutableList<User> = mutableListOf()
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            //val editTextName: EditText = findViewById(R.id.Name)
            val name = Name.text.toString()
            //val editTextSecondName: EditText = findViewById(R.id.SeconName)
            //val secondName = editTextSecondName.text.toString()
            val secondName = SecondName.text.toString() // проверить
            //val editTextAge: EditText = findViewById(R.id.Age)
            //val age = Integer.parseInt(editTextAge.text.toString())
            // var num: Int = editText.text.toString().toIntOrNull() ?: 0
            val age: Int = Age.text.toString().toIntOrNull() ?: 0
            if (checkName(name) && checSecondName(secondName) && checAge(age)) {
                val person = User(name, secondName, age)
                if (users.contains(person)) {
                    Toast.makeText(this, "Такой элемент уже есть", Toast.LENGTH_SHORT).show()
                } else {
                    users.add(person)
                }
            }
            if (users.isEmpty()) {
                Toast.makeText(this, "Пусто", Toast.LENGTH_SHORT).show()
            } else {
                textView.text = users.last().toString()
            }
        }
    }

    fun checkName(name: String): Boolean {
        if (name == "") {
            Toast.makeText(this, "Name Null", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }


    fun checSecondName(secondName: String): Boolean {
        if (secondName == "") {
            Toast.makeText(this, "Second Name Null", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }


    fun checAge(age: Int): Boolean {
        if (age == 0) {
            Toast.makeText(this, "Age Null", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

}