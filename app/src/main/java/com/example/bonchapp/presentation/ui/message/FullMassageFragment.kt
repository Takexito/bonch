package com.example.bonchapp.presentation.ui.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Message

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FullMassageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FullMassageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var messageId: Int = 0
    private lateinit var message: Message


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            messageId = it.getInt(ARG_PARAM1)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_massage, container, false)
    }

}