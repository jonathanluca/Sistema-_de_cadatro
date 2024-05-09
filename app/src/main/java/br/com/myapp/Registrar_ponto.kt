package br.com.myapp

import Relatorios
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.myapp.databinding.ActivityRegistrarPonto2Binding
import br.com.myapp.databinding.ActivityTelaIncialBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Registrar_ponto : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarPonto2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_ponto2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtendo a referência do botão pelo ID e definindo o listener de clique
        val btnRegistrarPonto = findViewById<Button>(R.id.registrar_ponto)
        btnRegistrarPonto.setOnClickListener {
            // Formatando a data e hora atual para uma string
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            val currentDateTime = dateFormat.format(Date())

            // Salvando a data e hora no SharedPreferences
            val sharedPreferences = getSharedPreferences("RegistrosPonto", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            // Usando o tempo em milissegundos como chave única para cada registro
            editor.putString(System.currentTimeMillis().toString(), currentDateTime)
            editor.apply()

            // Mostrando a data e hora em um Toast
            Toast.makeText(this, "Ponto registrado em: $currentDateTime", Toast.LENGTH_LONG).show()
        }
//        binding.historico.setOnClickListener {
//            val relatorios = Intent(this, Relatorios::class.java)
//            startActivity(relatorios)
//        }
    }
}
