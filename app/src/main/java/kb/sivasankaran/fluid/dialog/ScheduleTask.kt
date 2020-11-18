package kb.sivasankaran.fluid.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.DialogFragment
import kb.sivasankaran.fluid.R
import kb.sivasankaran.fluid.databinding.DialogScheduleTaskBinding

class ScheduleTask: DialogFragment() {

    class TaskInfo{
        var description: String = ""
        var start: String = ""
    }

    val taskInfo = TaskInfo()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DialogScheduleTaskBinding.inflate(layoutInflater)
        
        binding.addButton.setOnClickListener{
            val exclamationMark = ContextCompat.getDrawable(inflater.context, R.drawable.ic_exclamation)

            taskInfo.description = binding.taskLabel.text.toString()

            if(taskInfo.description.isEmpty()) {
                binding.taskLabel.setError("Can't be empty!", exclamationMark)
                binding.taskLabel.requestFocus()
                return@setOnClickListener
            }

            taskInfo.start = binding.taskStart.text.toString()

            if(taskInfo.start.isEmpty()) {
                binding.taskStart.setError("Can't be empty!", exclamationMark)
                binding.taskStart.requestFocus()
                return@setOnClickListener
            }
        }
        
        return binding.root
    }
}