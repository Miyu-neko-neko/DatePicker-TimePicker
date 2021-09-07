package com.example.datepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.FragmentActivity
import com.example.datepicker.databinding.ActivityMainBinding

//https://kotlin.akira-watson.com/android/date-picker.html
class MainActivity : FragmentActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {

        val str: String = getString(R.string.stringformat, year, monthOfYear+1, dayOfMonth)
        binding.textView.text = str
    }

    //pick Date Buttonを押したら
    fun showDatePickerDialog(v: View) {
        val newFragment = DatePick()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {

        val str2: String = getString(R.string.stringformat2, hourOfDay, minute)
        binding.textView2.text = str2

    }

    // pick Time Buttonを押したら
    fun showTimePickerDialog(v: View) {
        val newFragment = TimePick()
        newFragment.show(supportFragmentManager, "timePicker")

    }

}