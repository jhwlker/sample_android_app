package com.oldawg.zipcodesample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oldawg.zipcodesample.R
import com.oldawg.zipcodesample.databinding.FragmentResultsBinding
import com.oldawg.zipcodesample.di.Injectable
import com.oldawg.zipcodesample.viewmodels.ZipCodesViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ResultsFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ZipCodesViewModel by activityViewModels {
        viewModelFactory
    }

    private var _binding: FragmentResultsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ZipCodeAdapter(viewModel)

        val rv = view.findViewById<RecyclerView>(R.id.rv_ZipCodes)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(view.context)

        viewModel.zipCodes.observe(viewLifecycleOwner, Observer { codes ->
            //set up ui
            adapter.setZipCodes(codes)
        })

        viewModel.zip.observe(viewLifecycleOwner, { zip ->
            val zipView = view.findViewById<TextView>(R.id.entered_zip)
            zipView.text = "Entered Zip Code $zip"
        })

        viewModel.radius.observe(viewLifecycleOwner, { distance ->
            val distView = view.findViewById<TextView>(R.id.entered_distance)
            distView.text = "Radius $distance km"
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}