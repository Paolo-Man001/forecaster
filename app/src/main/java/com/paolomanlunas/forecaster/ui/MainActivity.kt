package com.paolomanlunas.forecaster.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.paolomanlunas.forecaster.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   private lateinit var navController: NavController

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

      // set custom-toolbar/actionbar as ToolBar
      setSupportActionBar(toolbar)

      // SET a navController-Instance for nav-graph & Activity
      navController = Navigation.findNavController(this, R.id.nav_host_fragment)

      // SET BottomNav as NavController. This will call
      // [android.view.MenuItem.onNavDestinationSelected] when a menu item is selected.
      bottom_nav.setupWithNavController(navController)
      NavigationUI.setupActionBarWithNavController(this, navController)

   }

   override fun onSupportNavigateUp(): Boolean {
      return NavigationUI.navigateUp(navController, null)
   }

}