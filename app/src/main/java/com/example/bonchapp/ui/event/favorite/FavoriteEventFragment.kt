package com.example.bonchapp.ui.event.favorite

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.LifecycleOwner
import com.example.bonchapp.R
import com.example.bonchapp.presenter.event.EventPresenter
import com.example.bonchapp.ui.event.IEventView
import kotlinx.android.synthetic.main.fragment_main_event.*
import kotlinx.android.synthetic.main.fragment_storage.*

class FavoriteEventFragment : Fragment(), IEventView {

    val presenter = EventPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_event, container, false)
    }


    override fun getFragmentContext(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFragment(): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRecyclerVisible(isVisible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRecyclerFilter(): Filter {
        return (eventRecyclerView.adapter as Filterable).filter
    }

    override fun getLifecycleOwner(): LifecycleOwner {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateRecycler(data: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}