package com.example.bonchapp.presentation.ui.event

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.bonchapp.R
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.event.IFavoriteEventPresenter
import com.example.bonchapp.presentation.presenter.event.IMainEventPresenter
import com.example.bonchapp.presentation.presenter.event.IMyEventPresenter
import com.example.bonchapp.presentation.ui.event.main.EventPagerAdapter
import kotlinx.android.synthetic.main.fragment_event.*
import javax.inject.Inject

class BaseEventFragment : Fragment() {

    @Inject lateinit var mainPresenter: IMainEventPresenter
    @Inject lateinit var favPresenter: IFavoriteEventPresenter
    @Inject lateinit var myPresenter: IMyEventPresenter

    init {
        App.appComponent.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        event_view_pager.adapter =
            EventPagerAdapter(this)
        eventTabLayout.setupWithViewPager(event_view_pager)
        load()
    }

    fun load(){
        event_view_pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                Log.d("ViewPager", "ScrollStateChange")

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Log.d("ViewPager", "Scrolled $position, $positionOffset")
            }

            override fun onPageSelected(position: Int) {
                Log.d("ViewPager", "PageSelected")

                when(position){
                    0-> return//mainPresenter.firstLoad()
                    1-> favPresenter.firstLoad()
                    2-> return //myPresenter.firstLoad()
                    else-> return
                }
            }

        })
    }

}
