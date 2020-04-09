package com.example.bonchapp.ui.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bonchapp.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class AuthorizationFragment : Fragment() {

    private lateinit var pager: ViewPager2
    private lateinit var dotsIndicator: DotsIndicator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_authorization, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View) {
        pager = view.findViewById(R.id.auth_pager)
        pager.adapter = PagerAdapter()
        dotsIndicator = view.findViewById(R.id.dots_indicator)
        dotsIndicator.setViewPager2(pager)
    }

    class PagerAdapter : RecyclerView.Adapter<PagerAdapter.PagerVH>() {
        inner class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
            return if (viewType == 0) PagerVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.authorization,
                    parent,
                    false
                )
            )
            else PagerVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.fragment_timetable,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return 2
        }

        override fun getItemViewType(position: Int): Int {
            return if (position == 0) 0 else 1
        }

        override fun onBindViewHolder(holder: PagerVH, position: Int) {

        }
    }

}