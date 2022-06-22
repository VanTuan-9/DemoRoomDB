package com.example.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomDB.entity.User
import com.example.views.R

class ListUserAdapter(private val listUser: List<User>): RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        listUser?.let {
            holder.bindTo(it.get(position))
        }

    }

    override fun getItemCount(): Int {
        return listUser?.let { it.size } ?:0
    }
//    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val username: TextView = itemView.findViewById(R.id.username)
//        val password: TextView = itemView.findViewById(R.id.password)
//        val delete: Button = itemView.findViewById(R.id.delete)
//    }
}