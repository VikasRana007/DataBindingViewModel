package com.learning.codingchallengesecond

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.learning.codingchallengesecond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModelMainActivity: ViewModelMainActivity

    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(10)
        viewModelMainActivity =
            ViewModelProvider(this, viewModelFactory).get(ViewModelMainActivity::class.java)

        //  Now assigning viewModel of layout file with constructed viewModel
        binding.viewModel = viewModelMainActivity

        //  Now make this activity as life cycle owner because we are using LiveData with Data Binding
        binding.lifecycleOwner = this


//        viewModelMainActivity.totalOutput.observe(this,Observer{
//            binding.total.text = it.toString()
//        })


//        binding.addition.setOnClickListener {
//            viewModelMainActivity.setInputValue(binding.editText.text.toString().toInt())
////            binding.total.text = viewModelMainActivity.getOutputValue().toString()
//        }

    }
}