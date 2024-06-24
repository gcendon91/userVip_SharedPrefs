package com.gcendon.uservip

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gcendon.uservip.UserVipApplication.Companion.prefs
import com.gcendon.uservip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initUI()
        checkUserValues()

    }

    fun checkUserValues() {
        if (prefs.getName().isNotEmpty()) {
            goToDetail()
        }
    }

    fun initUI() {
        binding.btnContinue.setOnClickListener { accesToDetail() }
    }

    fun accesToDetail() {
        if (binding.etName.text.toString().isNotEmpty()) {
            prefs.saveName(binding.etName.text.toString())
            prefs.saveVIP(binding.cbVIP.isChecked)
            goToDetail()
        } else {

        }
    }

    fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}
