package com.example.bonchapp.presentation.ui.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.router.Constants
import kotlinx.android.synthetic.main.fragment_full_massage.*

class FullMessageFragment : Fragment() {

    private var message: Message = Message()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            message = it.getSerializable(Constants.FULL_MESSAGE) as Message
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_massage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(message.text == "") read_message_text_view.text = "Текста нет"
        else read_message_text_view.text = message.text
        read_message_destination_view.text = message.teacher
        read_message_subject_view.text = message.theme
    }

}