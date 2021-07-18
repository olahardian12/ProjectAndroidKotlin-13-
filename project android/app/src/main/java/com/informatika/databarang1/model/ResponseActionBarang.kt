package com.informatika.databarang1.model

import com.google.gson.annotations.SerializedName

data class ResponseActionBarang {

    @field:SerializedName( value = "pesan")
    val pesan: Any? = null,

    @field:SerializedName( value = "data")
    val data: List<Boolean?>? = null,

    @field:SerializedName( value = "status")
    val status: String? = null
}