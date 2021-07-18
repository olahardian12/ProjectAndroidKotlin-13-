package com.informatika.databarang1.network

import com.informatika.databarang1.model.ResponseActionBarang
import com.informatika.databarang1.model.ResponseBarang
import com.informatika.databarang1.model.ResponseUsersItem
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET( "read.php" )
    fun getBarang() : Call<ResponseBarang>

    @FormUrlEncoded
    @POST( "create.php")
    fun insertBarang(
        @Field("Nama_Barang") namaBarang: String?,
        @Field("Jumlah_barang") jmlBarang: String?
    ): Call<ResponseActionBarang>

    @FormUrlEncoded
    @POST( "update.php")
    fun updateBarang(
        @Field( "id") id: String?
    ): Call<ResponseActionBarang>

    @FormUrlEncoded
    @POST( "delete.php")
    fun deleteBarang(
        @Field( "id") id: String?
    ): Call<ResponseActionBarang>
}