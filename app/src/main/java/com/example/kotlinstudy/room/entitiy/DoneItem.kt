package com.example.kotlinstudy.room.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DoneItem")
data class DoneItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    var name: String,
    var sDate: String,
    var dDate: String,
    var memo: String,
    var doneDate: String
)