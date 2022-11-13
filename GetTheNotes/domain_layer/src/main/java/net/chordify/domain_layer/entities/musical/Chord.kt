package net.chordify.domain_layer.entities.musical

import net.chordify.domain_layer.utilities.Util

data class Chord(
    val rootChord:String?=null,
    var type:Int = Util.ROOTCHORD,
    var childChordList : MutableList<ChildChord> = ArrayList(),
    var isExpanded:Boolean = false
)



