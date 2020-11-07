package kb.sivasankaran.fluid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kb.sivasankaran.fluid.R
import kb.sivasankaran.fluid.databinding.ActivityScheduleListBinding
import kb.sivasankaran.fluid.dialog.ScheduleTask

class ScheduleList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityScheduleListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            ScheduleTask().show(supportFragmentManager, "schedule_list_task_dialog")
        }
    }
}