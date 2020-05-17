package com.example.bonchapp.presentation.ui.event.my

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.router.MainRouter
import com.example.bonchapp.presentation.presenter.event.MyEventPresenter
import com.example.bonchapp.presentation.ui.event.IEventView
import com.example.bonchapp.router.MainCoordinator
import kotlinx.android.synthetic.main.fragment_my_event.*


class MyEventFragment : Fragment(), IEventView {
    val presenter =
        MyEventPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_event, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //presenter.onStart()
        init()
    }

    private fun init(){
        initRecycler()
        calendarEvent.setOnClickListener {
            MainCoordinator.navigateToCalendarEvent(this)
        }
    }


//    <androidx.recyclerview.widget.RecyclerView
//    android:id="@+id/myEventRecycler"
//    android:layout_width="match_parent"
//    android:layout_height="0dp"
//    app:layout_constraintBottom_toBottomOf="parent"
//    app:layout_constraintEnd_toEndOf="parent"
//    app:layout_constraintStart_toStartOf="parent"
//    app:layout_constraintTop_toBottomOf="@+id/linearLayout" />

    private fun initRecycler(){
//            myEventRecycler.apply {
//                adapter = EventAdapter(presenter)
//                layoutManager = LinearLayoutManager(context)
//            }
//
//            presenter.testData.observe(
//                viewLifecycleOwner,
//                androidx.lifecycle.Observer {
//                    (myEventRecycler.adapter as EventAdapter).setData(
//                        presenter.testData.value ?: arrayListOf()
//                    )
//                    myEventRecycler.adapter?.notifyDataSetChanged()
//                })
    }

    override fun getFragmentContext(): Context {
        return requireContext()
    }

    override fun getFragment(): Fragment {
        return this
    }

    override fun setRecyclerVisible(isVisible: Boolean) {
//        if(isVisible)
//            myEventRecycler.visibility = View.VISIBLE
//        else
//            myEventRecycler.visibility = View.GONE
    }

    override fun getRecyclerFilter(): Filter {
        TODO("Not yet implemented")
    }

//    override fun getRecyclerFilter(): Filter {
////        return (myEventRecycler.adapter as Filterable).filter
//        return Filter()
//    }

    override fun getLifecycleOwner(): LifecycleOwner {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateRecycler(data: List<Event>) {
        TODO("Not yet implemented")
    }

}