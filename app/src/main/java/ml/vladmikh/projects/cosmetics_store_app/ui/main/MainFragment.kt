package ml.vladmikh.projects.cosmetics_store_app.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ml.vladmikh.projects.cosmetics_store_app.ui.registration.RegistrationViewModel
import ml.vladmikh.projects.hotel_app.R
import ml.vladmikh.projects.hotel_app.databinding.FragmentMainBinding
import ml.vladmikh.projects.hotel_app.databinding.FragmentRegistrationBinding

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /*viewModel.listUsers.observe(this.viewLifecycleOwner) { users ->
            Log.i("abc6",users.toString())
            if (users.isEmpty()) {
                Log.i("abc7",users.toString())
                findNavController().navigate(R.id.action_mainFragment_to_registrationFragment)
            }
        }*/

    }


}