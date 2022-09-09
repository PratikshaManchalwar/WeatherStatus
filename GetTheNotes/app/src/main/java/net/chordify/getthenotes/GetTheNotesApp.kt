package net.chordify.getthenotes

import android.app.Application
import net.chordify.getthenotes.di.InjectorUtils

class GetTheNotesApp: Application() {

    override fun onCreate() {
        super.onCreate()

        InjectorUtils.getInstance()
    }
}