package kb.sivasankaran.fluid.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.Date

class TimeKeeper : Service() {

    val time: MutableLiveData<Date> = MutableLiveData()

    val binder = object: Binder(){
        val time: LiveData<Date>
            get() = this@TimeKeeper.time
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }



}