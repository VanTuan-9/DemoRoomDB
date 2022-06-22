package com.example.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomDB.entity.User
import com.example.views.R

class UserViewHolder(parent : ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
) {
    private val username = itemView.findViewById<TextView>(R.id.username)
    private val password = itemView.findViewById<TextView>(R.id.password)
    private val delete = itemView.findViewById<Button>(R.id.delete)

    var user: User? = null

    fun bindTo(user: User?) {
        this.user = user
        user?.let {
            username.setText(it.username)
            password.setText(it.password)
        }
    }
}