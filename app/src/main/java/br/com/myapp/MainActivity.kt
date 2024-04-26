package br.com.myapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navEntreTelas()
    }
    private fun navEntreTelas() {
        binding.buttonAcessar.setOnClickListener {
            val Tela_incial = Intent(this, Tela_incial::class.java)
            startActivity(Tela_incial)
        }
        binding.RedefinirSenha.setOnClickListener {
            val Redefinir_senha = Intent(this, Redefinir_senha::class.java)
            startActivity(Redefinir_senha)
        }
    }
}
