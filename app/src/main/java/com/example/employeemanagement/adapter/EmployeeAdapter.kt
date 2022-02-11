package com.example.employeemanagement.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeemanagement.data.EmployeeDatabase
import com.example.employeemanagement.databinding.ItemEmployeeBinding
import com.example.employeemanagement.viewholder.EmployeeViewHolder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EmployeeAdapter(private val employeeDatabase: EmployeeDatabase): RecyclerView.Adapter<EmployeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding = ItemEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bindData(employeeDatabase, position)
    }

    override fun getItemCount(): Int {
        var count= 0
        GlobalScope.launch {
             count = employeeDatabase.employeeDao().countEmployees()
        }
        return count
    }
}