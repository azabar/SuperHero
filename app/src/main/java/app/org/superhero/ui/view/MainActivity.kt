package app.org.superhero.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.org.superhero.databinding.ActivityMainBinding
import app.org.superhero.ui.viewmodel.CharactersViewModel
import app.org.superhero.adapter.CustomAdapter
import app.org.superhero.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val charactersViewModel: CharactersViewModel by viewModels()
    private val customAdapter = CustomAdapter{ position -> onListItemClick(position) }
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        // create the characters viewmodel
        charactersViewModel.onCreate()

        // prepare the NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        mNavController = navHostFragment.navController

        // initialize staggered grid layout manager
        StaggeredGridLayoutManager(
            2, // span count
            StaggeredGridLayoutManager.VERTICAL // orientation
        ).apply {
            // specify the layout manager for recycler view
            binding.recyclerView.layoutManager = this
        }

        // set recyclerview adapter with our customAdapter
        binding.recyclerView.adapter = customAdapter

        // subscribe the progressbar to the status loading of the viewmodel
        charactersViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
            binding.recyclerView.visibility = if(it) View.INVISIBLE else View.VISIBLE
        })

        charactersViewModel.hasError.observe(this, Observer {
            if(it) {
                Toast.makeText(this, getString(R.string.data_error), Toast.LENGTH_LONG).show()
            }
        })

        // subscribe the character list of the viewmodel to our custom adapter
        charactersViewModel.charactersList.observe(this, Observer {
            customAdapter.setMovieList(it)
        })

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    private fun onListItemClick(position: Int) {
        val amount = charactersViewModel.getResourceURI(position)
        val bundle = bundleOf("id" to amount)
        mNavController.navigate(R.id.nav_character_fragment, bundle)
    }
}