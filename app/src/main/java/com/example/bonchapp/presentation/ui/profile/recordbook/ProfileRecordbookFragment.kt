<<<<<<< HEAD:app/src/main/java/com/example/bonchapp/presentation/ui/profile/recordbook/ProfileRecordbookFragment.kt
package com.example.bonchapp.presentation.ui.profile.recordbook
=======
package com.example.bonchapp.presentation.ui.timetable
>>>>>>> StudentProfile:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/TimetableFragment.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import com.example.bonchapp.presentation.presenter.profile.ProfilePresenter
import com.example.bonchapp.presentation.ui.profile.IProfileView
import javax.inject.Inject

class TimetableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_timetable, container, false)

        return root
    }
}