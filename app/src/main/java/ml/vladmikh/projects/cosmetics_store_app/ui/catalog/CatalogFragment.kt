package ml.vladmikh.projects.cosmetics_store_app.ui.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
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

}