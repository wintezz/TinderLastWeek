package com.alexpetrov.tinder.presentation.activity

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.alexpetrov.tinder.R

class MainActivity : AppCompatActivity
    (R.layout.activity_main) {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater
            .inflate(R.menu.tinder_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite -> {
                findNavController(R.id.nav_host_fragment_activity_main)
                    .navigate(R.id.catFragment)
            }
            R.id.aboutApp -> {
                findNavController(R.id.nav_host_fragment_activity_main)
                    .navigate(R.id.programFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}