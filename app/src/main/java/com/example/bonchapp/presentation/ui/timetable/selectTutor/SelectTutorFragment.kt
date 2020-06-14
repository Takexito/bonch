<<<<<<< HEAD:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/SelectTutorFragment.kt
package com.example.bonchapp.presentation.ui.timetable
=======
package com.example.bonchapp.presentation.ui.timetable.selectTutor
>>>>>>> timeTable:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/selectTutor/SelectTutorFragment.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
<<<<<<< HEAD:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/SelectTutorFragment.kt
import com.example.bonchapp.presentation.ui.adapters.SelectTutorAdapter
=======
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.timetable.ITimetableTutorPresenter
import javax.inject.Inject
>>>>>>> timeTable:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/selectTutor/SelectTutorFragment.kt


class SelectTutorFragment() : Fragment(), ITimetableTutorView {

    lateinit var tutorListAdapter: SelectTutorAdapter
    lateinit var arrSubjects: ArrayList<String>
    lateinit var root: View

    @Inject
    lateinit var presenter: ITimetableTutorPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_select_tutor, container, false)
        presenter.attachView(this)


        return root

    }

    init {
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.loadList()


        initRecyclerView(root)
        initSearchField(root)
        initBackButton(root)
    }

    private fun initRecyclerView(root: View) {
        tutorListAdapter =
            SelectTutorAdapter(root.context)
        val recyclerView = root.findViewById<RecyclerView>(R.id.rv_selectGroup)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = tutorListAdapter

        //timeTable_recyclerView.apply {
        //  groupsListAdapter
        //}
    }

    private fun initSearchField(root: View) {
        val textSearch = root.findViewById<SearchView>(R.id.search_field)
        textSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                findInArray(newText.toString())
                return false
            }
        })
    }

    private fun initBackButton(root: View) {
        val btn = root.findViewById<ImageButton>(R.id.backButton)

        btn.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun findInArray(str: String) {

        if (str == "")
            tutorListAdapter.setGroups(arrSubjects)
        else {
            val arr: ArrayList<String> = arrayListOf()

            arrSubjects.forEach {
                if (it.contains(str, true)) {
                    arr.add(it)
                }
            }

            tutorListAdapter.setGroups(arr)
        }
    }

    override fun setList(list: ArrayList<String>){
        arrSubjects = list
        tutorListAdapter.setGroups(arrSubjects)
    }
}
