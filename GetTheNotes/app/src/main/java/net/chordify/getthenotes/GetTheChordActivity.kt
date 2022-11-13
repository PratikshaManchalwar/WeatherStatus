package net.chordify.getthenotes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.chordify.domain_layer.utilities.Util
import net.chordify.getthenotes.databinding.ActivityGetTheChordsBinding
import net.chordify.getthenotes.di.InjectorUtils

class GetTheChordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetTheChordsBinding
    private lateinit var viewModel: GetTheChordsViewModel
    private lateinit var adapter: ChordAdapter

    private var listener = object : ChordAdapter.OnItemClickListener {
        @SuppressLint("NotifyDataSetChanged")
        override fun onItemClick(childChord: String) {
            viewModel.getTheChordDetail(childChord)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_GetTheNotes_NoActionBar)
        binding = ActivityGetTheChordsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.horizontalRecyclerview.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.horizontalRecyclerview.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.HORIZONTAL
            )
        )

        viewModel = ViewModelProvider(
            viewModelStore,
            InjectorUtils.INSTANCE!!.provideChordsViewModel()
        )[GetTheChordsViewModel::class.java]

        adapter = ChordAdapter(Util.getChords(), listener)
        binding.horizontalRecyclerview.adapter = adapter

        viewModel.chord.observe(this) {
            binding.chordName.text = ""
            binding.tones.text = ""
            for (i in it.indices) {
                binding.chordName.append(it[i].chordName.replace(",", "") + ":" + "\n")
                binding.tones.append(it[i].tones + ":" + "\n")
            }

        }
    }

}