package com.informatika.databarang1.model

import com.google.gson.annotations.SerializedName

data class ResponseBarang(

    @field:SerializedName( value = "pesan")
    val pesan: String? = null,

    @field:SerializedName( value = "data")
    val data: List<DataItem?>? = null,

    @field:SerializedName( value = "status")
    val status: Boolean? = null
)

data class DataItem(
    @field:SerializedName( value = "Nama_barang")
    val namaBarang: String? = null,

    @field:SerializedName( value = "Id")
    val id: String? = null,

    @field:SerializedName( value = "Jumlah_barang")
    val jumlahBarang: String? = null
)