package com.example.bonchapp.ui.event.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import com.example.bonchapp.presenter.event.MyEventPresenter
import kotlinx.android.synthetic.main.fragment_my_event.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyEventFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var futureEventFragment: FutureEventFragment? = null
    private var pastEventFragment: PastEventFragment? = null
    private var applicationEventFragment: ApplicationEventFragment? = null
    val presenter = MyEventPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        futureEventFragment = FutureEventFragment.newInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_event, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onStart()
        init()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun init(){
        event_block1.setOnClickListener { presenter.onChangeTab(0) }
        event_block2.setOnClickListener { presenter.onChangeTab(1) }
        event_block3.setOnClickListener { presenter.onChangeTab(2) }
    }

    fun getPastEventFragment(): PastEventFragment {
        if (pastEventFragment == null) pastEventFragment = PastEventFragment.newInstance()
        return pastEventFragment as PastEventFragment
    }

    fun getApplicationEventFragment(): ApplicationEventFragment {
        if (applicationEventFragment == null) applicationEventFragment =
            ApplicationEventFragment.newInstance()
        return applicationEventFragment as ApplicationEventFragment
    }

    fun getFutureEventFragment(): FutureEventFragment {
        if (futureEventFragment == null) futureEventFragment = FutureEventFragment.newInstance()
        return futureEventFragment as FutureEventFragment
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyEventFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}