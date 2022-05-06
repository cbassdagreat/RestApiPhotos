package cbass.restapiphotos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cbass.restapiphotos.R
import cbass.restapiphotos.adapter.PhotosAdapter
import cbass.restapiphotos.databinding.FragmentMainBinding
import cbass.restapiphotos.viewmodel.PhotosVM

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private val viewModel by activityViewModels<PhotosVM>()
    private val adapter = PhotosAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)

        val manager = LinearLayoutManager(requireContext())
        with(binding)
        {
            rvPhotos.adapter = adapter
            rvPhotos.layoutManager = manager
        }

        viewModel.photos.observe(viewLifecycleOwner, Observer{
            adapter.getData(it)
        })
        return binding.root
    }

}