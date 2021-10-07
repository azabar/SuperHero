package app.org.superhero.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import app.org.superhero.R
import app.org.superhero.data.model.CharacterModel
import app.org.superhero.databinding.CharacterFragmentBinding
import app.org.superhero.ui.viewmodel.CharacterViewModel
import app.org.superhero.utils.Constants.ServerAPI.Companion.HASH
import app.org.superhero.utils.Constants.ServerAPI.Companion.PUBLIC_KEY
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: CharacterFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val characterViewModel: CharacterViewModel by viewModels()
    private lateinit var mNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CharacterFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        // get ID parameter from previous fragment
        val id = arguments?.getString("id")

        // create character viewmodel
        characterViewModel.onCreate()
        characterViewModel.setID(id!!)
        // load the new character
        characterViewModel.loadCharacter()

        // subscribe the view to the character's features
        characterViewModel.characterModel.observe(viewLifecycleOwner, Observer {
            var thumbnail = it.thumbnail
            Glide.with(binding.imageViewItem.context).load(
                thumbnail.path + "." + thumbnail.extension
                        + "?ts=1&apikey=${PUBLIC_KEY}&hash=${HASH}"
            ).into(binding.imageViewItem)
            binding.nameTextView.text = it.name
            binding.descriptionTextView.text = it.description
            binding.comicsTextView.text = getCharacterComics(it)
            binding.storiesTextView.text = getCharacterStories(it)
            binding.eventsTextView.text = getCharacterEvents(it)
            binding.seriesTextView.text = getCharacterSeries(it)
        })

        // subscribe the progressbar to the status loading of the viewmodel
        characterViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
            binding.backButton.visibility = if(it) View.INVISIBLE else View.VISIBLE
            binding.scrollView.visibility = if(it) View.INVISIBLE else View.VISIBLE
        })

        characterViewModel.hasError.observe(viewLifecycleOwner, Observer {
            if(it) {
                Toast.makeText(context, getString(R.string.data_error), Toast.LENGTH_LONG).show()
                binding.backButton.callOnClick()
            }
        })

        // setting back button onClickListener
        binding.backButton.setOnClickListener {
            mNavController = Navigation.findNavController(it)
            mNavController.navigate(R.id.nav_host_fragment)
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // prepare the NavController
        mNavController = Navigation.findNavController(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getCharacterComics(characterModel: CharacterModel): String {
        var characterComics = ""
        for (i in 0..characterModel.comics.items.size-1) {
            characterComics = characterComics + characterModel.comics.items[i].name
            if(i < characterModel.comics.items.size-1)
                characterComics = characterComics + ", "
        }
        return characterComics
    }

    private fun getCharacterStories(characterModel: CharacterModel): String {
        var characterStories = ""
        for (i in 0..characterModel.stories.items.size-1) {
            characterStories = characterStories + characterModel.stories.items[i].name
            if(i < characterModel.stories.items.size-1)
                characterStories = characterStories + ", "
        }
        return characterStories
    }

    private fun getCharacterEvents(characterModel: CharacterModel): String {
        var characterEvents = ""
        for (i in 0..characterModel.events.items.size-1) {
            characterEvents = characterEvents + characterModel.events.items[i].name
            if(i < characterModel.events.items.size-1)
                characterEvents = characterEvents + ", "
        }
        return characterEvents
    }

    private fun getCharacterSeries(characterModel: CharacterModel): String {
        var characterSeries = ""
        for (i in 0..characterModel.series.items.size-1) {
            characterSeries = characterSeries + characterModel.series.items[i].name
            if(i < characterModel.series.items.size-1)
                characterSeries = characterSeries + ", "
        }
        return characterSeries
    }

}
