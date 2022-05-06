package cbass.restapiphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cbass.restapiphotos.databinding.ActivityMainBinding
import cbass.restapiphotos.databinding.FragmentMainBinding
import cbass.restapiphotos.viewmodel.PhotosVM

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<PhotosVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getData()
    }
}