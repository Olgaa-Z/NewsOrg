package com.sourcey.materiallogindemo.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sourcey.materiallogindemo.R
import com.sourcey.materiallogindemo.databinding.FragmentSourceNewsBinding
import com.sourcey.materiallogindemo.model.source.Source
import com.sourcey.materiallogindemo.view.adapter.SourceAdapter
import com.sourcey.materiallogindemo.viewmodel.ViewModelSource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourceNewsFragment : Fragment() {


    lateinit var binding : FragmentSourceNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSourceNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getName = arguments?.getString("name")
        Toast.makeText(context, "News Category : $getName", Toast.LENGTH_SHORT).show()
        showDataSources(getName.toString())

        binding.btnSearchSource.setOnClickListener{
            getSearchSource(getName.toString())
        }
    }


    fun showDataSources(category : String){
        val viewModel = ViewModelProvider(this).get(ViewModelSource::class.java)
        viewModel.callApiSource(category,requireContext())
        viewModel.getDataSource().observe(viewLifecycleOwner){
            if (it != null){
                showSource(it)
            }

        }

    }

    fun showSource(data : List<Source>){
        val adapter = SourceAdapter(data)
        binding.rvSource.adapter = adapter
        binding.rvSource.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.onClick = {
            val sourc = it.id
                val bund = Bundle()
                bund.putString("name", sourc)
            Navigation.findNavController(requireView()).navigate(R.id.action_sourceNewsFragment_to_articleFragment,bund)
        }
    }

    fun getSearchSource(category : String){
        if (binding.searchSource.text.toString().isNotEmpty()){
            val viewModel = ViewModelProvider(this).get(ViewModelSource::class.java)
            viewModel.callApiSource(category, requireContext())
            viewModel.getDataSource().observe(viewLifecycleOwner){
                if (it != null){
                    showSource(it)
                }
            }
        }
    }




}