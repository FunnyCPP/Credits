package com.codart.credits.ui.offer_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codart.credits.R
import com.codart.credits.ui.MainActivity
import com.codart.credits.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OfferDetailFragment : Fragment() {

    private val viewModel: OfferDetailViewModel by viewModels()
    private lateinit var adapter: OfferDetailParentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offer_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }
    private fun setupRecyclerView() {
        adapter = OfferDetailParentAdapter(requireContext())
        val recycler: RecyclerView = requireView().findViewById(R.id.offer_detail_recycler_parent)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    private fun setupObservers() {

        viewModel.getOffer(MainActivity.product_id).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data!!.data.attribute_groups.isNullOrEmpty()) adapter.setItems(ArrayList(it.data.data.attribute_groups))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                }

            }
        })
    }


}