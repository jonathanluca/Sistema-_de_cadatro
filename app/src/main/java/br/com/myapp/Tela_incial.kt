package br.com.myapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.myapp.databinding.ActivityMainBinding
import br.com.myapp.databinding.ActivityTelaIncialBinding

class Tela_incial : AppCompatActivity() {
    private lateinit var binding: ActivityTelaIncialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaIncialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navEntreTelas()
        }
    private fun navEntreTelas() {
        binding.textSair.setOnClickListener {
            finishAffinity()
        }
        }
    }




