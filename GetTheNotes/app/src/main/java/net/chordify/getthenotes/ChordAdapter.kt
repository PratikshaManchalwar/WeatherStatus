package net.chordify.getthenotes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import net.chordify.domain_layer.entities.musical.ChildChord
import net.chordify.domain_layer.entities.musical.Chord
import net.chordify.domain_layer.utilities.Util

class ChordAdapter(
    private val chordList: MutableList<Chord>,
    private var listener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Util.ROOTCHORD) {
            val rowView: View =
                LayoutInflater.from(parent.context).inflate(R.layout.rootchords_row, parent, false)
            GroupViewHolder(rowView)
        } else {
            val rowView: View =
                LayoutInflater.from(parent.context).inflate(R.layout.childchord_row, parent, false)
            ChildViewHolder(rowView)
        }
    }

    override fun getItemCount(): Int = chordList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataList = chordList[position]
        if (dataList.type == Util.ROOTCHORD) {
            holder as GroupViewHolder
            holder.apply {
                rootChordTextView.text = dataList.rootChord
                rootChordTextView.setOnClickListener {
                    expandOrCollapseRootChord(dataList, position)
                }
            }
        } else {
            holder as ChildViewHolder

            holder.apply {
                val singleService = dataList.childChordList.first()
                childChordTextView.text = singleService.childChord
                holder.bindView(childChordTextView.text.toString(), listener)
            }
        }
    }

    private fun expandOrCollapseRootChord(chord: Chord, position: Int) {
        if (chord.isExpanded) {
            collapseRootChordRow(position)
        } else {
            expandRootChordRow(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun expandRootChordRow(position: Int) {
        val chordsList = chordList[position]
        chordsList.isExpanded = true
        var nextPosition = position
        if (chordsList.type == Util.ROOTCHORD) {
            chordsList.childChordList.forEach { chordData ->
                val chord = Chord()
                chord.type = Util.CHILDCHORD
                val list: ArrayList<ChildChord> = ArrayList()
                list.add(chordData)
                chord.childChordList = list
                chordList.add(++nextPosition, chord)
            }
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun collapseRootChordRow(position: Int) {
        val childChordList = chordList[position].childChordList
        chordList[position].isExpanded = false
        if (chordList[position].type == Util.ROOTCHORD) {
            childChordList.forEach { _ ->
                chordList.removeAt(position + 1)
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemViewType(position: Int): Int = chordList[position].type

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class GroupViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val rootChordTextView = row.findViewById(R.id.rootChord) as TextView
    }

    class ChildViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val childChordTextView = row.findViewById(R.id.childChord) as TextView
        private val childChordLayout = row.findViewById(R.id.childChordLayout) as ConstraintLayout

        @SuppressLint("ResourceAsColor")
        fun bindView(childChord: String, listener: OnItemClickListener) {
            childChordLayout.setOnClickListener {
                childChordLayout.setBackgroundResource(R.drawable.square_roundedcorners_green)
                listener.onItemClick(childChord)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(childChord: String)
    }
}