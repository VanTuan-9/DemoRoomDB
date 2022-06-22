package com.example.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.recycleview.ListUserAdapter
import com.example.recycleview.onClickItem
import com.example.roomDB.AppDatabase
import com.example.roomDB.entity.User
import com.example.views.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase
    private lateinit var adapter: ListUserAdapter
    private lateinit var onClickItem: onClickItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        db = AppDatabase.get(this)
        binding.create.setOnClickListener {
            binding.edtUsername.text?.let { username->
                binding.edtPassword.text?.let { password->
                    val userDao = db.userDao()
                    userDao.insertUser(User(username = username.toString(), password = password.toString()))
                    Toast.makeText(this, "Thêm thành công.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = ListUserAdapter(db.userDao().getAllUser())
        binding.listUser.layoutManager = layoutManager
        binding.listUser.adapter = adapter
        binding.get.setOnClickListener {
            adapter = ListUserAdapter(db.userDao().getAllUser())
            binding.listUser.adapter = adapter
        }
    }
}