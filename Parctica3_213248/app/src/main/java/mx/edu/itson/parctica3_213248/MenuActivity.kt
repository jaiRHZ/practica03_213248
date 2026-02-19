package mx.edu.itson.parctica3_213248

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnAntojitos: Button = findViewById(R.id.btn_antojitos)
        val btnEspecialidades: Button = findViewById(R.id.btn_especialidades)
        val btnCombinations: Button = findViewById(R.id.btn_combinations)
        val btnTortas: Button = findViewById(R.id.btn_tortas)
        val btnSopas: Button = findViewById(R.id.btn_sopas)
        val btnDrinks: Button = findViewById(R.id.btn_drinks)

        btnAntojitos.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "antojitos")
            startActivity(intent)
        }

        btnEspecialidades.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "especialidades")
            startActivity(intent)
        }

        btnCombinations.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "combinations")
            startActivity(intent)
        }

        btnTortas.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "tortas")
            startActivity(intent)
        }

        btnSopas.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "sopas")
            startActivity(intent)
        }

        btnDrinks.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "drinks")
            startActivity(intent)
        }
    }
}