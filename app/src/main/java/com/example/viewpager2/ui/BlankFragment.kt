package com.example.viewpager2.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager2.DataModel.image
import com.example.viewpager2.Repository.ImageRepo
import com.example.viewpager2.databinding.FragmentBlankBinding
import com.example.viewpager2.viewmodel.ImageViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class BlankFragment(val filterQuery: String) : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }


    private lateinit var viewModel: ImageViewModel
    lateinit var imageRepo: ImageRepo
    lateinit var binding: FragmentBlankBinding
    private lateinit var recyclerAdapter: RecyclerAdapter

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViews()                    // intializing views
        return binding.root
    }

    private fun initViews() {
        binding = FragmentBlankBinding.inflate(layoutInflater)
        recyclerAdapter = RecyclerAdapter(requireContext())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context.applicationContext)
            adapter = recyclerAdapter
        }
        imageRepo = ImageRepo()            // initializing ImageRepo
        viewModel = ImageViewModel(imageRepo)   // intializing viewmodel
       
        lifecycleScope.launch {
            viewModel.getImages(filterQuery)     // calling to retrofit via viewmodel->imageRepo->Retrofit
        }

        viewModel.listImages.observe(viewLifecycleOwner)    // observing livadata changes
        {
            recyclerAdapter.submitList(it)
        }

    }


}
