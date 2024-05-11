package com.example.notessqlite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notessqlite.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var db:TasksDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            //taking input from EditText to variables
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            //passed arguments inside the Task data class in order defined in the SQL DATA CLASS
            val task = Task(0, title, content)
            //access database and use the insertTask function we created to insert the data stored into the task variable above
            db.insertTask(task)
            //finish same as intent
            finish()
            Toast.makeText(this,"Task Added", Toast.LENGTH_SHORT).show()

        }

    }
}