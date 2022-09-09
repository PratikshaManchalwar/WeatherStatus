package net.chordify.getthenotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import net.chordify.getthenotes.databinding.ActivityGetTheNotesBinding
import net.chordify.getthenotes.di.InjectorUtils

class GetTheNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetTheNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_GetTheNotes_NoActionBar)

        binding = ActivityGetTheNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val viewModel = ViewModelProvider(viewModelStore, InjectorUtils.INSTANCE!!.provideMainViewModel()).get(GetTheNotesViewModel::class.java)

        binding.buttonSearch.setOnClickListener {
            binding.textInputEditText.text?.let {
                viewModel.searchNotes(it.toString())
            }
        }

        viewModel.onNotes.observe(this) {
            it?.let {
                binding.textviewSearchResult.text = it
            } ?: binding.textviewSearchResult.setText(getString(R.string.no_notes_found))
        }
    }
}