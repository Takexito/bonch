package com.example.bonchapp.data.repository

import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.domain.entities.AccountDTO
import com.example.bonchapp.domain.entities.DebtDTO
import com.example.bonchapp.domain.entities.ElectiveDTO
import com.example.bonchapp.domain.entities.MarkDTO
import com.example.bonchapp.domain.repository.IProfileRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val networkService: NetworkService) :
    IProfileRepository {
    override fun loadUserInfo(
        callback: (resp: Response<AccountDTO>) -> Unit,
        callbackError: (error: String) -> Unit
    ) {
        networkService.getUserInfo(
        ).enqueue(object : Callback<AccountDTO> {
            override fun onResponse(
                call: Call<AccountDTO>,
                resp: Response<AccountDTO>
            ) {
                callback(resp)
            }

            override fun onFailure(call: Call<AccountDTO>, t: Throwable) {
                callbackError(t.localizedMessage)
            }
        })
    }

    override fun loadDebt(
        callback: (resp: Response<ArrayList<DebtDTO>>) -> Unit,
        callbackError: (error: String) -> Unit
    ) {
        networkService.getDebt(
        ).enqueue(object : Callback<ArrayList<DebtDTO>> {
            override fun onResponse(
                call: Call<ArrayList<DebtDTO>>,
                resp: Response<ArrayList<DebtDTO>>
            ) {
                callback(resp)
            }

            override fun onFailure(call: Call<ArrayList<DebtDTO>>, t: Throwable) {
                callbackError(t.localizedMessage)
            }
        })
    }

    override fun loadElectives(
        callback: (resp: Response<ArrayList<ElectiveDTO>>) -> Unit,
        callbackError: (error: String) -> Unit
    ) {
        networkService.getHistoryElectives(
        ).enqueue(object : Callback<ArrayList<ElectiveDTO>> {
            override fun onResponse(
                call: Call<ArrayList<ElectiveDTO>>,
                resp: Response<ArrayList<ElectiveDTO>>
            ) {
                callback(resp)
            }

            override fun onFailure(call: Call<ArrayList<ElectiveDTO>>, t: Throwable) {
                callbackError(t.localizedMessage)
            }
        })
    }

    override fun loadMark(
        callback: (resp: Response<ArrayList<MarkDTO>>) -> Unit,
        callbackError: (error: String) -> Unit
    ) {
        networkService.getMark(
        ).enqueue(object : Callback<ArrayList<MarkDTO>> {
            override fun onResponse(
                call: Call<ArrayList<MarkDTO>>,
                resp: Response<ArrayList<MarkDTO>>
            ) {
                callback(resp)
            }

            override fun onFailure(call: Call<ArrayList<MarkDTO>>, t: Throwable) {
                callbackError(t.localizedMessage)
            }
        })
    }
}