package kb.sivasankaran.fluid.service

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Binder
import android.os.IBinder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.Date

class TimeKeeper : Service() {

    private val time: MutableLiveData<Date> = MutableLiveData()

    private val tickReceiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == Intent.ACTION_TIME_TICK) time.value = Date()
        }
    }

    inner class LocalBinder: Binder() {
        val time: LiveData<Date>
            get() = this@TimeKeeper.time
    }

    val binder = LocalBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    private fun register_time_tick_receiver() {
        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_TIME_TICK))
    }

    override fun onCreate() {
        super.onCreate()
        time.value = Date()
        register_time_tick_receiver()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        super.onUnbind(intent)
        unregisterReceiver(tickReceiver)
        return true
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        register_time_tick_receiver()
    }
}