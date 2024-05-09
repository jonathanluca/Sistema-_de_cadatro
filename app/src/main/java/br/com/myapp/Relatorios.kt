import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.myapp.databinding.ActivityRelatoriosBinding
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Relatorios : AppCompatActivity() {
    private lateinit var binding: ActivityRelatoriosBinding  // Usando lateinit para evitar nullable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelatoriosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Referência para o Firebase Database
        val database = FirebaseDatabase.getInstance().reference

        // Gerar um novo timestamp
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())

        // Criar um novo nó no Firebase para cada registro
        database.child("registros").child(timestamp).setValue("Registrado em: $timestamp")

        // Configurar o evento de clique para o botão historico
        binding.relatorios.setOnClickListener {
            val relatoriosIntent = Intent(this@Relatorios, Relatorios::class.java) // Correto uso de this@Class
            startActivity(relatoriosIntent)
        }
    }
}
