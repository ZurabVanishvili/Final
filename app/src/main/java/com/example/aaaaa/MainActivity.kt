package com.example.aaaaa

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.aaaaa.Fragments.HomeFragment
import com.example.aaaaa.Fragments.NotificationsFragment
import com.example.aaaaa.Fragments.ProfileFragment
import com.example.aaaaa.Fragments.SearchFragment
import com.example.aaaaa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                moveToFragments(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                moveToFragments(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_add_post -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notifications -> {
                moveToFragments(NotificationsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                moveToFragments(ProfileFragment())
                return@OnNavigationItemSelectedListener true


            }
        }


        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        moveToFragments(HomeFragment())

    }


    private fun moveToFragments(fragment:Fragment){
        val fragment_tranz =  supportFragmentManager.beginTransaction()
        fragment_tranz.replace(
            R.id.fragment_container ,
            fragment

        )
        fragment_tranz.commit()


    }
}