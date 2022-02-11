package com.example.employeemanagement.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.employeemanagement.data.Employee
import com.example.employeemanagement.data.EmployeeDatabase
import com.example.employeemanagement.databinding.ItemEmployeeBinding

class EmployeeViewHolder(private val binding: ItemEmployeeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindData(employeeDatabase: EmployeeDatabase, id: Int) {
        val allEmployeeData: List<Employee> = employeeDatabase.employeeDao().readAllData()
        val employee = allEmployeeData[id]
        with(binding) {
            tvEmployeeName.text = "${employee.firstName} ${employee.lastName}"
            tvEmployeeGender.text = employee.gender
            tvEmployeeAge.text = employee.age.toString()
            tvEmployeeEmailId.text = employee.emailId
        }

    }

}