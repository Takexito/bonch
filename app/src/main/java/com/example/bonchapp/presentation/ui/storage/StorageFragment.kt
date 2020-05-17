package com.example.bonchapp.presentation.ui.storage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.presentation.presenter.event.StoragePresenter

class StorageFragment : Fragment() {

    val presenter =
        StoragePresenter(this)

    private lateinit var filesSpinner: Spinner
    private lateinit var filesRecycler: RecyclerView
    private lateinit var filesSearch: SearchView

    private lateinit var recyclerAdapter: FilesAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_storage, container, false)

        initView(root)
        initSpinner()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onCreate()
        initRecycler()
    }

    fun initView(view: View) {
        filesSpinner = view.findViewById(R.id.files_spinner)
        filesRecycler = view.findViewById(R.id.files_recycler)
        filesSearch = view.findViewById(R.id.files_search)
    }

    fun initSpinner() {
        //var spinnerAdapter = ArrayAdapter(this.context!!, R.layout.spinner_dropdown_item, R.id.spinner_button, string)

        val spinnerAdapter = ArrayAdapter.createFromResource(this.context!!, R.array.switch_files, R.layout.spinner_item)
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
        filesSpinner.adapter = spinnerAdapter

        filesSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                presenter.onSpinnerSelectedItemUpdated(position)
            }

        }
    }

    fun initRecycler() {
        recyclerAdapter = FilesAdapter(this.context!!, presenter.data)
        val callback = FilesRecyclerItemTouchHelper(recyclerAdapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(filesRecycler)
        filesRecycler.layoutManager = LinearLayoutManager(this.context!!)
        filesRecycler.adapter = recyclerAdapter
    }

    fun updateAdapter(newData: MutableList<String>) {
        recyclerAdapter.data = newData
        filesRecycler.adapter!!.notifyDataSetChanged()
    }
}
