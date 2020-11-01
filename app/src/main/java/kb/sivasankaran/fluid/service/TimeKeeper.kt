package kb.sivasankaran.fluid.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class TimeKeeper : Service() {

    val binder = object: Binder(){
        val service: TimeKeeper
            get() = this@TimeKeeper
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

}