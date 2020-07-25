package com.goranm.observerpatternexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_navigation)
        supportActionBar?.hide()
        val fragmentA = FragmentA()
        val fragmentB = FragmentB()
        val fragmentSheet = FragmentSheet()

        fragmentA.registerObserver(fragmentSheet)


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragmentA)
            commit()
        }

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_game-> {
                    openFragments(fragmentA)
                    return@setOnNavigationItemSelectedListener true}

                R.id.nav_sheet -> {
                    openFragments(fragmentB)
                    return@setOnNavigationItemSelectedListener true}

                else -> false
            }
        }

    }

    private fun openFragments(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}