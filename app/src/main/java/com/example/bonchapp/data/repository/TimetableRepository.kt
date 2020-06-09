package com.example.bonchapp.data.repository

import android.util.Log
import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.domain.entities.RequestTimeTable
import com.example.bonchapp.domain.repository.ITimetableRepository
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class TimetableRepository @Inject constructor(private val networkService: NetworkService) :
    ITimetableRepository {
    override fun loadTimetable(req:RequestTimeTable, callback: (resp: Response<ArrayList<SubjectDTO>>) -> Unit, callbackError: (error: String) -> Unit) {
        Log.d("AuthRep", "request")
        networkService.getTimeTable(
            body = req
        ).enqueue(object : Callback<ArrayList<SubjectDTO>> {
            override fun onResponse(
                call: Call<ArrayList<SubjectDTO>>,
                resp: Response<ArrayList<SubjectDTO>>
            ) {
                callback(resp)
            }

            override fun onFailure(call: Call<ArrayList<SubjectDTO>>, t: Throwable) {
                Log.d("AuthRepository", t.localizedMessage ?: "Error!")
                callbackError (t.localizedMessage)
            }
        })
    }

    override fun loadGroups(callback: (resp: Response<ArrayList<ArrayList<String>>>) -> Unit, callbackError: (error: String) -> Unit) {
        Log.d("AuthRep", "request")
        networkService.getGroups(
        ).enqueue(object : Callback<ArrayList<ArrayList<String>>> {
            override fun onResponse(
                call: Call<ArrayList<ArrayList<String>>>,
                resp: Response<ArrayList<ArrayList<String>>>
            ) {
                callback(resp)
            }

            override fun onFailure(call: Call<ArrayList<ArrayList<String>>>, t: Throwable) {
                Log.d("AuthRepository", t.localizedMessage ?: "Error!")
                callbackError (t.localizedMessage)
            }
        })
    }

    override fun loadTutors(callback: (resp: Response<ArrayList<String>>) -> Unit, callbackError: (error: String) -> Unit) {
        Log.d("AuthRep", "request")
        networkService.getTutors(
        ).enqueue(object : Callback<ArrayList<String>> {
            override fun onResponse(
                call: Call<ArrayList<String>>,
                resp: Response<ArrayList<String>>
            ) {
                callback(resp)
            }

            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                Log.d("AuthRepository", t.localizedMessage ?: "Error!")
                callbackError (t.localizedMessage)
            }
        })
    }

}


//override fun loadTimetable(body: RequestTimeTable): LiveData<ArrayList<SubjectDTO>> {
//
//    val data = MutableLiveData<ArrayList<SubjectDTO>>()
//    NetworkService
//        .TABLE_API
//        .getTimeTable(body = User.token)
//        .enqueue(object : Callback<ArrayList<SubjectDTO>> {
//            override fun onResponse(
//                call: Call<ArrayList<SubjectDTO>>,
//                resp: Response<ArrayList<SubjectDTO>>
//            ) {
//                Log.d("LoL", "Good")
//                data.value = resp.body()
//                    ?: arrayListOf(SubjectDTO())
//            }
//
//            override fun onFailure(call: Call<ArrayList<SubjectDTO>>, t: Throwable) {
//                Log.d("LoL", t.localizedMessage ?: "Error!")
//
//            }
//        })
//
//    return data
//}
//
//override fun getGroups(): LiveData<ArrayList<ArrayList<String>>> {
//
//    val data = MutableLiveData<ArrayList<ArrayList<String>>>()
//
//    NetworkService
//        .TABLE_API
//        .getGroups()
//        .enqueue(object : Callback<ArrayList<ArrayList<String>>> {
//            override fun onResponse(
//                call: Call<ArrayList<ArrayList<String>>>,
//                resp: Response<ArrayList<ArrayList<String>>>
//            ){
//                Log.d("Test", "Good")
//                data.value = resp.body()
//
//            }
//
//            override fun onFailure(call: Call<ArrayList<ArrayList<String>>>, t: Throwable) {
//                Log.d("Test", t.localizedMessage ?: "Error!")
//
//            }
//        })
//
//    return data
//}
//
//override fun getTutors(): LiveData<ArrayList<String>> {
//
//    val data = MutableLiveData<ArrayList<String>>()
//
//    NetworkService
//        .TABLE_API
//        .getTutors()
//        .enqueue(object : Callback<ArrayList<String>> {
//            override fun onResponse(
//                call: Call<ArrayList<String>>,
//                resp: Response<ArrayList<String>>
//            ){
//                Log.d("Test", "Good")
//                data.value = resp.body() ?: arrayListOf("Error!", "LOL", "statr")
//
//            }
//
//            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
//                Log.d("Test", t.localizedMessage ?: "Error!")
//
//            }
//        })
//
//    return data
//}
//
//fun loadSavedNameGroup(name:String){
//
//}}