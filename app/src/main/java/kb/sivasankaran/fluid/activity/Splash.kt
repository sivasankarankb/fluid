package kb.sivasankaran.fluid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kb.sivasankaran.fluid.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
    }
}