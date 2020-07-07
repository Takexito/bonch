package com.example.bonchapp.presentation.ui.message

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TabHost
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Messages
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.message.IMessagePresenter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_storage.*
import kotlinx.android.synthetic.main.message_in_fragment.*
import javax.inject.Inject

class MessageFragment : Fragment(), IMessageView {

    @Inject lateinit var recyclerAdapter: MessageAdapter

    @Inject lateinit var presenter: IMessagePresenter

    private lateinit var filesSearch: SearchView

    init {
        App.appComponent.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_storage, container, false)
        initView(root)
        //initSpinner()
        presenter.attachView(this)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()

        initRecycler()
        initFab()
        presenter.firstLoad()
    }


    private fun initViewPager(){
        message_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("MessageTabs", "Tab reselected id: ${tab?.position ?: -1}")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("MessageTabs", "Tab id: ${tab?.position ?: -1}")
                when(tab?.position){
                    0 -> presenter.loadInMessage()
                    1 -> presenter.loadOutMessage()
                    else -> presenter.loadInMessage()
                }
            }

        })
    }


    private fun initFab() {
        send_message_fab.setOnClickListener {
            presenter.onFabClick()
        }
    }

    private fun initView(view: View) {
        filesSearch = view.findViewById(R.id.files_search)
    }

//    fun initSpinner() {
//        //var spinnerAdapter = ArrayAdapter(this.context!!, R.layout.spinner_dropdown_item, R.id.spinner_button, string)
//
//        val spinnerAdapter = ArrayAdapter.createFromResource(this.context!!, R.array.switch_files, R.layout.spinner_item)
//        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
//        filesSpinner.adapter = spinnerAdapter
//
//        filesSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                presenter.onSpinnerSelectedItemUpdated(position)
//            }
//
//        }


    private fun initRecycler() {

        val callback = FilesRecyclerItemTouchHelper(recyclerAdapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(message_recycler.getRecyclerView())

        message_recycler.setLayoutManager(LinearLayoutManager(this.context))
        message_recycler.setAdapter(recyclerAdapter)
        message_recycler.addVeiledItems(10)
        message_recycler.veil()

    }


    override fun getLifecycleOwner(): LifecycleOwner {
        TODO("Not yet implemented")
    }

    override fun updateRecycler(data: Messages) {
        message_recycler.unVeil()
        recyclerAdapter.apply {
            setData(data)
            notifyDataSetChanged()
        }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
