package com.example.homework_015

import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.example.homework_013.extensions.glideExtension
import com.example.homework_015.databinding.ProfileFragmentLayoutBinding
import kotlinx.coroutines.flow.map


class ProfileFragment :
    BaseFragment<ProfileFragmentLayoutBinding, ProfileModel>(ProfileFragmentLayoutBinding::inflate) {

    override fun getViewModel() = ProfileModel::class.java
    override var useSharedViewModel = false


    override fun start() {


        setListeners()

        readFromStore()

    }

    private fun setListeners() {
        binding.btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.actionToEditProfileFragment)

        }
    }



    private fun readFromStore(){
        requireContext().dataStore.data.map {
            it[firstNameKey] ?: "first name"

        }.asLiveData().observe(viewLifecycleOwner,{
            binding.ivFirstName.text=it
        })

        requireContext().dataStore.data.map {
            it[ageKey] ?: "age"

        }.asLiveData().observe(viewLifecycleOwner,{
            binding.ivAge.text=it
        })

        requireContext().dataStore.data.map {
            it[imageKey] ?: "https://m.media-amazon.com/images/I/51KomX7KPZL._AC_SY741_.jpg"

        }.asLiveData().observe(viewLifecycleOwner,{
            binding.image.glideExtension(it)
        })

        requireContext().dataStore.data.map {
            it[phoneKey] ?: "000-00000"

        }.asLiveData().observe(viewLifecycleOwner,{
            binding.ivPhone.text=it
        })

        requireContext().dataStore.data.map {
            it[genderKey] ?: "lgbtqiwtf"

        }.asLiveData().observe(viewLifecycleOwner,{
            binding.ivGender.text=it
        })

        requireContext().dataStore.data.map {
            it[lastNameKey] ?: "last name"

        }.asLiveData().observe(viewLifecycleOwner,{
            binding.ivLastName.text=it
        })





    }


}