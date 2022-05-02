package com.learning.codingchallengesecond

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.learning.codingchallengesecond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModelMainActivity: ViewModelMainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelMainActivity = ViewModelProvider(this)[ViewModelMainActivity::class.java]
        binding.total.text = viewModelMainActivity.getOutputValue().toString()

        binding.addition.setOnClickListener {

            viewModelMainActivity.setInputValue(binding.editText.text.toString().toInt())
            binding.total.text = viewModelMainActivity.getOutputValue().toString()
        }

    }
}