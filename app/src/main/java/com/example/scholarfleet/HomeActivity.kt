package com.example.scholarfleet

import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.scholarfleet.databinding.ActivityHomeBinding
import com.example.scholarfleet.database.Database
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tarjetauna = FormularioProFragment()
        val tarjetados = FormularioMatFragment()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)


        binding.appBarHome.fab1.setOnClickListener { view ->
            tarjetados.show(supportFragmentManager, "FormularioMatFragment")
            binding.appBarHome.grupofab.collapse()
        }
        binding.appBarHome.fab2.setOnClickListener { view ->

            tarjetauna.show(supportFragmentManager, "FormularioProFragment")
            binding.appBarHome.grupofab.collapse()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,R.id.agendaFragment, R.id.profesorFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Creación de la bd
        val admin = Database(this, "agenda", null, 1)
        //puntero
        val db = admin.writableDatabase
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        menuInflater.inflate(R.menu.home, menu)

        return true


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
}