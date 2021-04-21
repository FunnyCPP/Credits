package com.codart.credits.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codart.credits.R
import com.codart.credits.ui.MainActivity
import com.codart.credits.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CategoriesFragment : Fragment(), CategoriesAdapter.CharacterItemListener {

    private val viewModel: CategoriesViewModel by viewModels()
    private lateinit var adapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.categories_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()

    }
    private fun setupRecyclerView() {
        adapter = CategoriesAdapter(this)
        val recycler: RecyclerView = requireView().findViewById(R.id.categories_recycler)
        recycler.layoutManager = GridLayoutManager(requireContext(),2)
        recycler.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getCategories(MainActivity.country_id).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->{}

            }
        })
    }

    override fun onClickedCharacter(id: Int) {
        Timber.d("Click")
        MainActivity.category_id = id
        findNavController().navigate(R.id.action_categoriesFragment_to_offersFragment)
    }
}