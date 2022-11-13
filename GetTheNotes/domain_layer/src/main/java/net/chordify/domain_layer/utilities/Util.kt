package net.chordify.domain_layer.utilities

import net.chordify.domain_layer.entities.musical.ChildChord
import net.chordify.domain_layer.entities.musical.Chord

class Util {
    companion object {
        const val ROOTCHORD = 0
        const val CHILDCHORD = 1

        fun getChords(): MutableList<Chord> {
            val chordList: MutableList<Chord> = ArrayList()
            val noteList: Array<String> = arrayOf("C","D", "E", "F", "G")

            val chordListC: MutableList<ChildChord> =
                mutableListOf(ChildChord("Cmaj7"), ChildChord("C7"), ChildChord("Cmin7")
                )
            val chordListD: MutableList<ChildChord> =
                mutableListOf(ChildChord("Dmaj7"), ChildChord("D7"), ChildChord("Dmin7")
                )
            val chordListE: MutableList<ChildChord> =
                mutableListOf(ChildChord("Emaj7"), ChildChord("E7"), ChildChord("Emin7")
                )
            val chordListF: MutableList<ChildChord> =
                mutableListOf(ChildChord("Fmaj7"), ChildChord("F7"), ChildChord("Fmin7")
                )
            val chordListG: MutableList<ChildChord> =
                mutableListOf(ChildChord("Gmaj7"), ChildChord("G7"), ChildChord("Gmin7")
                )

            val chordC = Chord(
                rootChord = noteList[0],
                childChordList = chordListC
            )
            val chordD = Chord(
                rootChord = noteList[1],
                childChordList = chordListD
            )
            val chordE = Chord(
                rootChord = noteList[2],
                childChordList = chordListE
            )
            val chordF = Chord(
                rootChord = noteList[3],
                childChordList = chordListF
            )
            val chordG = Chord(
                rootChord = noteList[4],
                childChordList = chordListG
            )

            chordList.add(chordC)
            chordList.add(chordD)
            chordList.add(chordE)
            chordList.add(chordF)
            chordList.add(chordG)

            return chordList
        }
    }
}