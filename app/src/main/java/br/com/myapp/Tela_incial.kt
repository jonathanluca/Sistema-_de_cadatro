package br.com.myapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.myapp.databinding.ActivityTelaIncialBinding
import com.google.firebase.auth.FirebaseAuth

class Tela_incial : AppCompatActivity() {
    private lateinit var binding: ActivityTelaIncialBinding
    private lateinit var auth: FirebaseAuth // Declaração do FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaIncialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance() // Inicializa o FirebaseAuth

        navEntreTelas()
    }

    private fun navEntreTelas() {
        binding.textSair.setOnClickListener {
            auth.signOut() // Desconecta o usuário
            finishAffinity() // Fecha todas as atividades
        }
    }

    override fun onBackPressed() {
        // Não faz nada. Isso impedirá que o usuário use o botão Voltar para voltar à tela anterior.
    }
}
