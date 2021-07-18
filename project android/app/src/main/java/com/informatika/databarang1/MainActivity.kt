package com.informatika.databarang1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.informatika.databarang1.adapter.ListContent
import com.informatika.databarang1.model.ResponseBarang
import com.informatika.databarang1.model.ResponseUsersItem
import com.informatika.databarang1.network.koneksi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val i = Intent(this, InsertDataActivity::class.java)
            startActivity(i)
        }
        getData()

    }
    public fun getData() {
        koneksi.service.getBarang().enqueue(object : Callback<ResponseUsersItem> {
            override fun onFailure(call: Call<ResponseBarang>, t: Throwable) {
                Log.d("pesan1", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<ResponseBarang>,
                Response: Response<ResponseBarang>
            ) {
                if (response.isSuccessful) {
                    val dataBody = Response.body()
                    val datacontent = dataBody!!.data()

                    val rvAdapter = ListContent(datacontent, this@MainActivity)
                    rvAdapter.notifyDataSetChanged()

                    rv_data_barang.apply {
                        adapter = rvAdapter
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }
        })
    }}

private fun <T> Call<T>.enqueue(callback: Callback<ResponseUsersItem>) {

}

override fun onResume() {
            super.onResume()
            getData()
        }
        override fun onCreateOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on he Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            return when (item.itemId) {
                R.id.action_settings -> true
                else -> super.onOptionsItemSelected(item)
            }
        }
    }