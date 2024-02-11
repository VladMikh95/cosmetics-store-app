package ml.vladmikh.projects.cosmetics_store_app.ui.catalog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ml.vladmikh.projects.cosmetics_store_app.ui.adapters.ItemAdapter
import ml.vladmikh.projects.hotel_app.R
import ml.vladmikh.projects.hotel_app.databinding.FragmentCatalogBinding

@AndroidEntryPoint
class CatalogFragment : Fragment() {

    private val viewModel by viewModels<CatalogViewModel>()
    private lateinit var binding: FragmentCatalogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCatalogBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding.recyclerViewItems
        val adapter = ItemAdapter{ItemChoosing -> viewModel.viewItem(ItemChoosing)
        }
        recyclerView.adapter = adapter

        viewModel.getItem()

        viewModel.itemRemoteDataSource.observe(viewLifecycleOwner) { item ->
            Log.i("abc1", item.toString())
            adapter.submitList(item.items)
        }
    }



}