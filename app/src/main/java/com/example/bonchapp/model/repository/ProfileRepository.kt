package com.example.bonchapp.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.network.NetworkService
import com.example.bonchapp.model.pojo.AccountDTO
import com.example.bonchapp.model.pojo.DebtDTO
import com.example.bonchapp.model.pojo.ElectiveDTO
import com.example.bonchapp.model.pojo.MarkDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileRepository() : IProfileRepository {

    override fun getUserInfo(): LiveData<AccountDTO> {
        val data = MutableLiveData<AccountDTO>()

        NetworkService
            .TABLE_API
            .getUserInfo()
            .enqueue(object : Callback<AccountDTO> {
                override fun onResponse(
                    call: Call<AccountDTO>,
                    resp: Response<AccountDTO>
                ) {
                    Log.d("Test", "Good")
                    data.value = resp.body()

                }

                override fun onFailure(call: Call<AccountDTO>, t: Throwable) {
                    Log.d("Test", t.localizedMessage ?: "Error!")

                }
            })

        return data
    }


    override fun getDebt(): LiveData<ArrayList<DebtDTO>> {
        val data = MutableLiveData<ArrayList<DebtDTO>>()

        NetworkService
            .TABLE_API
            .getDebt()
            .enqueue(object : Callback<ArrayList<DebtDTO>> {
                override fun onResponse(
                    call: Call<ArrayList<DebtDTO>>,
                    resp: Response<ArrayList<DebtDTO>>
                ) {
                    Log.d("Test", "Good")
                    data.value = resp.body()

                }

                override fun onFailure(call: Call<ArrayList<DebtDTO>>, t: Throwable) {
                    Log.d("Test", t.localizedMessage ?: "Error!")

                }
            })

        return data
    }

    override fun getElectives(): LiveData<ArrayList<ElectiveDTO>> {
        val data = MutableLiveData<ArrayList<ElectiveDTO>>()

        NetworkService
            .TABLE_API
            .getHistoryElectives()
            .enqueue(object : Callback<ArrayList<ElectiveDTO>> {
                override fun onResponse(
                    call: Call<ArrayList<ElectiveDTO>>,
                    resp: Response<ArrayList<ElectiveDTO>>
                ) {
                    Log.d("Test", "Good")
                    data.value = resp.body()

                }

                override fun onFailure(call: Call<ArrayList<ElectiveDTO>>, t: Throwable) {
                    Log.d("Test", t.localizedMessage ?: "Error!")

                }
            })

        return data
    }

    override fun getMark(): LiveData<ArrayList<MarkDTO>> {
        val data = MutableLiveData<ArrayList<MarkDTO>>()

        NetworkService
            .TABLE_API
            .getMark()
            .enqueue(object : Callback<ArrayList<MarkDTO>> {
                override fun onResponse(
                    call: Call<ArrayList<MarkDTO>>,
                    resp: Response<ArrayList<MarkDTO>>
                ) {
                    Log.d("Test", "Good")
                    data.value = resp.body()

                }

                override fun onFailure(call: Call<ArrayList<MarkDTO>>, t: Throwable) {
                    Log.d("Test", t.localizedMessage ?: "Error!")

                }
            })

        return data
    }

}