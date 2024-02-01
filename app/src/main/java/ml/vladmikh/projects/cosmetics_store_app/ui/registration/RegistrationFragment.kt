package ml.vladmikh.projects.cosmetics_store_app.ui.registration

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ml.vladmikh.projects.cosmetics_store_app.ui.custom_view.PhoneNumberMask
import ml.vladmikh.projects.cosmetics_store_app.utils.bindTextTwoWay
import ml.vladmikh.projects.cosmetics_store_app.utils.setCyrillicValidation
import ml.vladmikh.projects.hotel_app.R
import ml.vladmikh.projects.hotel_app.databinding.FragmentRegistrationBinding
import java.util.regex.Pattern


@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private val viewModel by viewModels<RegistrationViewModel>()
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegistrationBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.buttonRegistration.isEnabled = false

        binding.editTextName.bindTextTwoWay(viewModel.editTextName, viewLifecycleOwner)
        binding.editTextSurname.bindTextTwoWay(viewModel.editTextSurname, viewLifecycleOwner)
        binding.editTextPhoneNumber.bindTextTwoWay(viewModel.editTextPhoneNumber, viewLifecycleOwner)

        binding.editTextName.setCyrillicValidation(binding.textInputLayoutName,
            binding.editTextName,
            binding.editTextSurname,
            binding.editTextPhoneNumber,
            binding.buttonRegistration)
        binding.editTextSurname.setCyrillicValidation(binding.textInputLayoutSurname,
            binding.editTextName,
            binding.editTextSurname,
            binding.editTextPhoneNumber,
            binding.buttonRegistration)

        binding.editTextPhoneNumber.setText(PhoneNumberMask.MASK)
        binding.editTextPhoneNumber.addTextChangedListener(
            PhoneNumberMask(binding.editTextName,
                binding.editTextSurname,
                binding.editTextPhoneNumber,
                binding.buttonRegistration){})

        binding.buttonRegistration.setOnClickListener {
            Log.i("abc", "All is good")
        }
    }
}