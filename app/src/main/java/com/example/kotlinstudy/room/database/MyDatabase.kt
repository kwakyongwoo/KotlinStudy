package com.example.kotlinstudy.room.database

import android.content.Context
import android.view.View
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinstudy.room.dao.TodoDao
import com.example.kotlinstudy.room.entitiy.TodoItem

@Database(version = 1, entities = [TodoItem::class])
abstract class MyDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        private var myDatabase: MyDatabase? = null

        fun getInstance(context: Context) : MyDatabase?{
            if(myDatabase == null) {
                myDatabase = Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, "MyDatabase.db")
                    .allowMainThreadQueries()
                    .build()
            }

            return myDatabase
        }
    }
}