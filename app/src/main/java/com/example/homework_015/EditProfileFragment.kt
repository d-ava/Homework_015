package com.example.homework_015

import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.homework_015.databinding.EditProfileFragmentLayoutBinding
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class EditProfileFragment :
    BaseFragment<EditProfileFragmentLayoutBinding, EditProfileModel>(
        EditProfileFragmentLayoutBinding::inflate
    ) {


    override fun getViewModel() = EditProfileModel::class.java
    override var useSharedViewModel = false


    override fun start() {


        setListeners()


    }


    private fun setListeners() {
        binding.btnSave.setOnClickListener {

            viewLifecycleOwner.lifecycleScope.launch {
                withContext(IO) {
                    writeToStore()
                }
            }
            findNavController().navigate(R.id.actionToProfileFragment)
        }
    }

    private suspend fun writeToStore() {
        val firstName = binding.etFirstName.text.toString()
        val age = binding.etAge.text.toString()
        val image = binding.etImageUrl.text.toString()
        val phone = binding.etPhone.text.toString()
        val gender = binding.etGender.text.toString()
        val email = binding.etEmail.text.toString()


        requireContext().dataStore.edit {
            it[firstNameKey] = firstName
            it[ageKey] = age
            it[imageKey] = image
            it[phoneKey] = phone
            it[genderKey] = gender
            it[emailKey] = email
        }
    }

}