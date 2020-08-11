package io.github.manuelernesto.listofspeakers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavController =   Navigation.findNavController(this, R.id.nav_host_fragment)

        NavigationUI.setupWithNavController(bottom_navigation_view, mNavController)

        NavigationUI.setupWithNavController(nav_view, mNavController)

        NavigationUI.setupActionBarWithNavController(this, mNavController, drawer_layout)
    }

    override fun onSupportNavigateUp() = NavigationUI.navigateUp(mNavController, drawer_layout)

}