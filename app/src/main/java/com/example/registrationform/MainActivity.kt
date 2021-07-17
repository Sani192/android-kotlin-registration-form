package com.example.registrationform

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var selectedDept = ""
        var deptList = arrayListOf<String>("Computer Science", "Information Technology", "Others")
        val deptSpinner: Spinner = findViewById(R.id.deptSpinner)
        deptSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            deptList)
        deptSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedDept = deptList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        // handle button click
        var mySendBtn = findViewById<Button>(R.id.mySendButton)
        mySendBtn.setOnClickListener {
            val text = findViewById<TextView>(R.id.nameTextBox)
            val name = text.text.toString()
            var gender = ""
            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()

            var radioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)
            var genderId = radioGroup.checkedRadioButtonId
            if(genderId != -1) {
                val selected_gender : RadioButton = findViewById(genderId)
                gender = selected_gender.text.toString()
            }

            var intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("referName", name)
                putExtra("referGender", gender)
                putExtra("referDept", selectedDept)
            }
            startActivity(intent)
        }
    }
}