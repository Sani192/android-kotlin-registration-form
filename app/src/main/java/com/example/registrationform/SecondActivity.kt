package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var obtainedName = intent.getStringExtra("referName")
        var obtainedGender = intent.getStringExtra("referGender")
        var obtainedDept = intent.getStringExtra("referDept")

        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = "Welcome " + obtainedName + "\nGener: " + obtainedGender + "\nDepartment: " + obtainedDept
    }
}