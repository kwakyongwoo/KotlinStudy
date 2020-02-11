package com.example.kotlinstudy.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinstudy.R
import com.example.kotlinstudy.main.done.DoneFragment
import com.example.kotlinstudy.main.todo.TodoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = TodoFragment()
        val fragment2 = DoneFragment()

        supportActionBar?.title = "Todo List"
        supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, fragment1).commitAllowingStateLoss()

        main_bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_main_todo -> {
                    supportActionBar?.title = "Todo List"
                    supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, fragment1)
                        .commitAllowingStateLoss()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_main_done -> {
                    supportActionBar?.title = "Done List"
                    supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, fragment2)
                        .commitAllowingStateLoss()
                    return@setOnNavigationItemSelectedListener true
                }

                else -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }
}
