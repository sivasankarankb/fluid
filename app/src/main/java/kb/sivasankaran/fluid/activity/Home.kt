package kb.sivasankaran.fluid.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kb.sivasankaran.fluid.databinding.ActivityHomeBinding
import kb.sivasankaran.fluid.service.TimeKeeper
import java.text.SimpleDateFormat

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        bindService(
            Intent(this, TimeKeeper::class.java),

            object: ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    (service as TimeKeeper.LocalBinder).time.observe(this@Home, {
                        time -> binding.timeNow.text = SimpleDateFormat()
                        .apply {applyPattern("hh:mm")}
                        .format(time)
                    })
                }

                override fun onServiceDisconnected(name: ComponentName?) { }

            },

            Context.BIND_AUTO_CREATE
        )

        binding.scheduleButton.setOnClickListener{
            startActivity(Intent(this, ScheduleList::class.java))
        }
    }
}