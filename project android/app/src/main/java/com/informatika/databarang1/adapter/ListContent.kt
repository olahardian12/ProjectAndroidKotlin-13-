package com.informatika.databarang1.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.telecom.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.informatika.databarang1.R
import com.informatika.databarang1.UpdateDataActivity
import com.informatika.databarang1.model.DataItem
import com.informatika.databarang1.model.ResponseActionBarang
import retrofit2.Response
import java.security.AccessControlContext

class ListContent(val ldata : List<DataItem?>?, val context: Context) :
    RecyclerView.Adapter<ListContent.ViewHolder>() {
    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view) {
        val namaBarang = view.findViewById<TextView>(R.id.tv_nama_barang)
        val jmlBarang = view.findViewById<TextView>(R.id.tv_jumlah_barang)
        val editBarang = view.findViewById<TextView>(R.id.tv_edit)
        val deleteBarang = view.findViewById<TextView>(R.id.tv_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_barang, parent, attachToRoot: false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ldata!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = ldata?.get(position)
        holder.namaBarang.text = model?.namaBarang
        holder.jmlBarang.text = model?.jumlahBarang
        holder.editBarang.setOnClickListener { it: View!
            val i = Intent(context, UpdateDataActivity::class.java)
            i.putExtra("IDBARANG", model?.id)
            i.putExtras("NAMABARANG", model?.namaBarang)
            i.putExtras("JMLBARANG", model?.jumlahBarang)
            context.startActivities(i)
    }
    holder.deleteBarang.setOnClickListener {
        AlertDialog.Builder(context)
            .setTitle("Delete " + model?.namaBarang)
            .setMessage("Apakah Anda Ingin Menghapus Data Ini?")
            .setPositiveButton("Ya", t.localizedMessage)
    }

override fun onResponse(
    call: Call<ResponseActionBarang>,
    response: Response<ResponseActionBarang>
) {
}

  override fun onResponse(
      call: Call<ResponseActionBarang>,
      response: Response<ResponseActionBarang>
  ){
      if (response.isSuccessful){
          Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_LONG).show()
          notifyDataSetChanged()
          notifyItemRemoved(position)
          notifyItemChanged(position)
          notifyItemRangeRemoved(position, ldata!!.size)
          Log.d("bpesan", response.body()).toString())
          }
      }
  })
})
.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
    dialog.cancel()
})
.show()
