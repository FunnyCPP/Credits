package com.codart.credits.ui.offers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codart.credits.R
import com.codart.credits.ui.MainActivity
import com.codart.credits.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class OffersFragment : Fragment(), OffersAdapter.CharacterItemListener{

    private val viewModel: OffersViewModel by viewModels()
    private lateinit var adapter: OffersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offers, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }
    private fun setupRecyclerView() {
        adapter = OffersAdapter(this)
        val recycler: RecyclerView = requireView().findViewById(R.id.offers_recycler)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    private fun setupObservers() {

        viewModel.getOffers(MainActivity.category_id,MainActivity.country_id).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data!!.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                }

            }
        })
    }

    override fun onClickedCharacter(id: Int) {
        Timber.d("Click")
        MainActivity.product_id = id
        findNavController().navigate(R.id.action_offersFragment_to_offerDetailFragment)
    }


}