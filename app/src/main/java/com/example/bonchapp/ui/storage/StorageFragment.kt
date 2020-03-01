package com.example.bonchapp.ui.storage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.presenter.StoragePresenter

class StorageFragment : Fragment() {

    val presenter = StoragePresenter(this)

    private lateinit var filesSpinner: Spinner
    private lateinit var filesRecycler: RecyclerView
    private lateinit var filesSearch: SearchView

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

    fun initView(view: View) {
        filesSpinner = view.findViewById(R.id.files_spinner)
        filesRecycler = view.findViewById(R.id.files_recycler)
        filesSearch = view.findViewById(R.id.files_search)
    }

    fun initSpinner() {
        //var spinnerAdapter = ArrayAdapter(this.context!!, R.layout.spinner_dropdown_item,
        //    R.id.spinner_button, string)

        val spinnerAdapter = ArrayAdapter.createFromResource(this.context!!, R.array.switch_files, R.layout.spinner_item)
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
        filesSpinner.adapter = spinnerAdapter
    }
}
