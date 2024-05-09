package br.com.myapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.myapp.databinding.ActivityTelaIncialBinding
import com.google.firebase.auth.FirebaseAuth

class Tela_incial : AppCompatActivity() {
    private lateinit var binding: ActivityTelaIncialBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaIncialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        navEntreTelas()
    }

    @SuppressLint("MissingSuperCall") // função que não deixa eu voltar para a tela de login
    override fun onBackPressed() {
        Toast.makeText(this, "Não é possível voltar para tela incial", Toast.LENGTH_SHORT).show()
    }

    private fun navEntreTelas() {
        binding.textSair.setOnClickListener {
            auth.signOut()
            finish() // Fecha todas as atividades e retorna ao login
        }

        binding.registrarPonto.setOnClickListener {
            val registrarPonto = Intent(this, Registrar_ponto::class.java)
            startActivity(registrarPonto)
        }
        binding.criarCalendario.setOnClickListener {
            val calendario = Intent(this, Calendario::class.java)
            startActivity(calendario)
        }
    }
}
