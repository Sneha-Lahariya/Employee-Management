package com.example.employeemanagement.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insertEmployee(employee: Employee)

    @Update
    suspend fun updateEmployee(employee: Employee)

    @Delete
    suspend fun deleteEmployee(employee: Employee)

    @Query("SELECT * FROM employee_table ORDER BY id ASC")
    fun readAllData() : List<Employee>

    @Query("SELECT COUNT(*) FROM employee_table")
    suspend fun countEmployees() : Int

}