package com.example.employeemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.employeemanagement.adapter.EmployeeAdapter
import com.example.employeemanagement.databinding.ActivityShowAllEmployeesBinding

class ShowAllEmployeesActivity : AppCompatActivity() {

    lateinit var binding:ActivityShowAllEmployeesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowAllEmployeesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpAdapter()
    }

    private fun setUpAdapter() {
        val employeeAdapter = EmployeeAdapter(AddEmployeeActivity.getDb())
        binding.rvEmployees.adapter = employeeAdapter
    }
}