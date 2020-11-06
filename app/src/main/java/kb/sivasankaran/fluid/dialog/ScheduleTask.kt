package kb.sivasankaran.fluid.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import kb.sivasankaran.fluid.R

class ScheduleTask: DialogFragment() {

    class TaskInfo{
        var description: String = ""
        var hours: Int = 0
        var minutes: Int = 0
        var am_pm: String = "AM"
    }

    val taskInfo = TaskInfo()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewRoot = inflater.inflate(R.layout.dialog_schedule_task, container, false)
        
        viewRoot.findViewById<Button>(R.id.add_button).setOnClickListener {
            taskInfo.description = viewRoot.findViewById<EditText>(R.id.task_label).text.toString()
            taskInfo.hours = viewRoot.findViewById<Spinner>(R.id.start_hr).selectedItem.toString().toInt()
            taskInfo.minutes = viewRoot.findViewById<Spinner>(R.id.start_min).selectedItem.toString().toInt()
            taskInfo.am_pm = viewRoot.findViewById<Spinner>(R.id.start_am_pm).selectedItem.toString()
        }
        
        return viewRoot
    }
}