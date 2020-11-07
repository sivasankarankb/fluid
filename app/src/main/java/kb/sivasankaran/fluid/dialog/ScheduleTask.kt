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
        var start: String = ""
    }

    val taskInfo = TaskInfo()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewRoot = inflater.inflate(R.layout.dialog_schedule_task, container, true)
        
        viewRoot.findViewById<Button>(R.id.add_button).setOnClickListener {
            taskInfo.description = viewRoot.findViewById<EditText>(R.id.task_label).text.toString()
            taskInfo.start = viewRoot.findViewById<EditText>(R.id.task_start).text.toString()
        }
        
        return viewRoot
    }
}