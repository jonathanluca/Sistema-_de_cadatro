package br.com.myapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.myapp.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navEntreTelas()

    }

    private fun autenticar(email:String, senha:String){
        auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Toast.makeText(baseContext,"Autenticado", Toast.LENGTH_LONG)

            }
        }
    }
    private fun navEntreTelas() {
        binding.buttonAcessar.setOnClickListener {

            auth = Firebase.auth
            val email = findViewById<EditText>(R.id.edit_email).text.toString()
            val senha = findViewById<EditText>(R.id.edit_senha).text.toString()

            if (email.isNotEmpty()&&senha.isNotEmpty()) {
                autenticar(email,senha)
                val Tela_incial = Intent(this, Tela_incial::class.java)
                startActivity(Tela_incial)
            }

        }
        binding.RedefinirSenha.setOnClickListener {
            val Redefinir_senha = Intent(this, Redefinir_senha::class.java)
            startActivity(Redefinir_senha)
        }
    }
}
