package one.digitalinnovation.coroutines.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import one.digitalinnovation.coroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindEvents()
    }

    private fun bindEvents() = with(binding) {
        // TODO
    }
}