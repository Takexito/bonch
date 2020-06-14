package com.example.bonchapp.presentation.ui.event.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.event.IFavoriteEventPresenter
import com.example.bonchapp.presentation.ui.event.main.EventAdapter
import kotlinx.android.synthetic.main.fragment_favorite_event.*
import kotlinx.android.synthetic.main.fragment_main_event.*
import javax.inject.Inject

class FavoriteEventFragment : Fragment(), IFavoriteEventView {

    @Inject
    lateinit var eventAdapter: FavoriteEventAdapter

    @Inject
    lateinit var presenter: IFavoriteEventPresenter

    init {
        App.appComponent.inject(this)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initRecycler()
        presenter.firstLoad()
    }

    private fun initRecycler() {
        favoriteEventRecycler.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun setRecyclerVisible(isVisible: Boolean) {

//        if(isVisible)
//            favoriteEventRecycler.visibility = View.VISIBLE
//        else
//            favoriteEventRecycler.visibility = View.GONE
    }

    override fun getRecyclerFilter(): Filter {
        return (favoriteEventRecycler.adapter as Filterable).filter
    }

    override fun getLifecycleOwner(): LifecycleOwner {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateRecycler(data: List<Event>) {
        eventAdapter.apply {
            setData(data)
            notifyDataSetChanged()
        }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun addToFavorite(event: Event) {
        TODO("Not yet implemented")
    }

}