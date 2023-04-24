package com.trdz.motion.view

import android.os.Bundle
import android.text.style.*
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.trdz.motion.databinding.FragmentWindowMainBinding
import com.trdz.motion.utility.KEY_FINSTANCE
import org.koin.android.ext.android.inject

class WindowMain: Fragment() {


	//region Injected
	private val navigation: Navigation by inject()

	//endregion

	//region Elements
	private var _binding: FragmentWindowMainBinding? = null
	private val binding get() = _binding!!
	private var mood = 1
	private var lastChose = 1
	var isMain = true
	var isFirst = false

	//endregion

	//region Base realization
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		arguments?.let {
			isFirst = it.getBoolean(KEY_FINSTANCE)
		}
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		_binding = FragmentWindowMainBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		prepInitialize()
		initialize()
	}

	private fun prepInitialize() {}


	//endregion

	//region Main functional

	private fun initialize() {}

	//endregion

	companion object {
		@JvmStatic
		fun newInstance(first_instance: Boolean) =
			WindowMain().apply {
				arguments = Bundle().apply {
					putBoolean(KEY_FINSTANCE, first_instance)
				}
			}
	}

}