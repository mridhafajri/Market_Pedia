package com.example.marketpedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.marketpedia.fragment.ChatFragment
import com.example.marketpedia.fragment.FavoritesFragment
import com.example.marketpedia.fragment.HomeFragment
import com.example.marketpedia.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    lateinit var buttomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val chatFragment = ChatFragment()
        val favoritesFragment = FavoritesFragment()
        val profileFragment = ProfileFragment()

        loadFragment(homeFragment)

        buttomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView
        buttomNav.setOnItemSelectedListener{
//            Log.i("nav", it.toString())
            when(it.itemId) {
                R.id.menu_home -> {
                    loadFragment(homeFragment)
                    true
                }
                R.id.menu_chat -> {
                    loadFragment(chatFragment)
                    true
                }
                R.id.menu_love -> {
                    loadFragment(favoritesFragment)
                    true
                }
                R.id.menu_profile -> {
                    loadFragment(profileFragment)
                    true
                }

                else -> {
                    loadFragment(homeFragment)
                    true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fram_nav, fragment)
        transaction.commit()
    }

}