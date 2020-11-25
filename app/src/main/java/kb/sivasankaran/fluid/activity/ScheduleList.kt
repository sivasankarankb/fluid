package kb.sivasankaran.fluid.activity

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kb.sivasankaran.fluid.R
import kb.sivasankaran.fluid.databinding.ActivityScheduleListBinding
import kb.sivasankaran.fluid.databinding.ScheduleListItemBinding
import kb.sivasankaran.fluid.dialog.ScheduleTaskInput
import kotlin.random.Random

class ScheduleList : AppCompatActivity() {

    class ScheduleListAdapter : RecyclerView.Adapter<ScheduleListAdapter.TaskViewHolder>() {
        val data = ArrayList<ScheduleTaskInput.TaskInfo>()

        class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val binding = ScheduleListItemBinding.bind(itemView)

            fun applyData(data: ScheduleTaskInput.TaskInfo) {
                binding.taskLabel.text = data.description
                binding.taskStartTime.text = data.start
                binding.card.setCardBackgroundColor(cardColors[Random.nextInt(0, cardColors.size)])
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder =
                TaskViewHolder(
                        LayoutInflater
                                .from(parent.context)
                                .inflate(R.layout.schedule_list_item, parent, false)
                )


        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            holder.applyData(data[position])
        }

        override fun getItemCount(): Int = data.size

        fun addItem(item: ScheduleTaskInput.TaskInfo) {
            data.add(item)
            notifyItemInserted(data.lastIndex)
        }

        companion object {
            val cardColors = listOf(
                    Color.rgb(0xff,0xbb,0x11), // Mango
                    Color.rgb(0x77,0xff,0x44), // Grass green
                    Color.rgb(0x55,0x88,0xff), // Sky blue
                    Color.rgb(0xff,0x44,0x88)  // Pink
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityScheduleListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardList.apply {
            adapter = ScheduleListAdapter()
            layoutManager = LinearLayoutManager(this@ScheduleList)
        }

        binding.addButton.setOnClickListener {
            ScheduleTaskInput(
                object : ScheduleTaskInput.TaskInfoListener {
                    override fun taskInfoEntered(info: ScheduleTaskInput.TaskInfo) {
                        (binding.cardList.adapter as ScheduleListAdapter).addItem(info)
                    }

                }
            ).show(supportFragmentManager, "schedule_list_task_dialog")
        }
    }
}
