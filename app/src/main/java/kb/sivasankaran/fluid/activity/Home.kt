package kb.sivasankaran.fluid.activity

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kb.sivasankaran.fluid.R
import kb.sivasankaran.fluid.receiver.TimeTick

class Home : AppCompatActivity() {
    val tickReceiver by lazy { TimeTick() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(Intent.ACTION_TIME_TICK)
        registerReceiver(tickReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(tickReceiver)
    }
}