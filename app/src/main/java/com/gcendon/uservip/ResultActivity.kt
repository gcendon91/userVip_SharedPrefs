package com.gcendon.uservip

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gcendon.uservip.UserVipApplication.Companion.prefs
import com.gcendon.uservip.databinding.ActivityMainBinding
import com.gcendon.uservip.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initUI()
    }

    fun initUI() {
        binding.btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
        val userName = prefs.getName()
        binding.tvName.text = "Bienvenido $userName"
        if (prefs.getVIP()) {
            setVIPColorBackground()
        }
    }

    fun setVIPColorBackground() {
        binding.container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip_yellow))
    }
}