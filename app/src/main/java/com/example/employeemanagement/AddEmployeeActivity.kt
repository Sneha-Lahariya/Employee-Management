package com.example.employeemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.employeemanagement.data.Employee
import com.example.employeemanagement.data.EmployeeDatabase
import com.example.employeemanagement.databinding.ActivityAddEmployeeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private lateinit var db: EmployeeDatabase

class AddEmployeeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddEmployeeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddEmployeeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        db = EmployeeDatabase.getDatabase(this)
        setOnClickListener()
        verifyData()
    }

    companion object {
        fun getDb(): EmployeeDatabase {
            return db
        }
    }

    private fun setOnClickListener() {
        binding.btnSubmit.setOnClickListener {
            val etFirstName = binding.etFirstName.text.toString()
            val etLastName = binding.etLastName.text.toString()
            val rbGender = if(binding.rbFemale.isChecked) binding.rbFemale.text else if(binding.rbMale.isChecked) binding.rbMale.text else ""
            val etAge = binding.etAge.text.toString().toInt()
            val etEmailId = binding.etEmailId.text.toString()

            GlobalScope.launch {
                db.employeeDao().insertEmployee(Employee(0, etFirstName, etLastName, rbGender.toString(), etAge, etEmailId))
            }
            Toast.makeText(this, "Employee Added!", Toast.LENGTH_SHORT).show()
        }
        binding.btnVerify.setOnClickListener {
            verifyData()
        }
    }

    private fun verifyData() {
        GlobalScope.launch {
            val data = db.employeeDao().readAllData()
            data?.map {
                Log.d("employeeData", " data is ${it.toString()}")
            }
        }
    }


}