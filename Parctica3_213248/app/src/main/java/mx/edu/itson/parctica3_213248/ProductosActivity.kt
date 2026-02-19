package mx.edu.itson.parctica3_213248

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductosActivity : AppCompatActivity() {

    var antojitos = ArrayList<Product>()
    var especialidades = ArrayList<Product>()
    var combinations = ArrayList<Product>()
    var tortas = ArrayList<Product>()
    var sopas = ArrayList<Product>()
    var drinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        agregarProductos()

        val image: ImageView = findViewById(R.id.titleAntojitos) // Considera cambiar el ID en el XML a titleHeader o algo genérico
        val listview: ListView = findViewById(R.id.listview)

        val menuType = intent.getStringExtra("menuType")

        // Selección de lista e imagen basada en las nuevas categorías
        val productosMostrar: ArrayList<Product> = when (menuType) {
            "antojitos" -> {
                image.setImageResource(R.drawable.antojitos)
                antojitos
            }
            "especialidades" -> {
                image.setImageResource(R.drawable.especialidades)
                especialidades
            }
            "combinations" -> {
                image.setImageResource(R.drawable.combinations)
                combinations
            }
            "tortas" -> {
                image.setImageResource(R.drawable.tortas)
                tortas
            }
            "sopas" -> {
                image.setImageResource(R.drawable.sopas)
                sopas
            }
            "drinks" -> {
                image.setImageResource(R.drawable.drinks)
                drinks
            }
            else -> antojitos
        }

        val adaptador = AdaptadorProductos(this, productosMostrar)
        listview.adapter = adaptador
    }

    fun agregarProductos() {
        // Antojitos
        antojitos.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con queso, champiñones o flor de calabaza.", 4.50))
        antojitos.add(Product("Huaraches", R.drawable.huaraches, "Base de maíz con frijoles, carne y salsa.", 6.00))


        // Especialidades
        //especialidades.add(Product("Mole Poblano", R.drawable.mole, "Pollo bañado en salsa de chocolate y chiles.", 12.00))

        // Combinations
        //combinations.add(Product("Combo Mexicano", R.drawable.combo1, "1 taco, 1 enchilada y arroz.", 10.00))

        // Tortas
        tortas.add(Product("Torta Cubana", R.drawable.tortacubana, "Jamón, pierna, queso y milanesa.", 8.50))
        tortas.add(Product("Small Mexican", R.drawable.smallmexican, "Torta pequeña de pierna de cerdo", 5.00))
        tortas.add(Product("Torta de Milanesa", R.drawable.tortamilanesa, "Torta con una milanesa de res", 9.00))
        tortas.add(Product("Torta Mixta", R.drawable.tortamixta, "Torta con pierna y milanesa", 10.00))

        // Sopas
        sopas.add(Product("Pozole Rojo", R.drawable.pozole, "Caldo de maíz con carne de cerdo y rábanos.", 9.00))
        sopas.add(Product("Caldo de Camaron", R.drawable.caldocamaron, "Caldo de Camaron, barra caliente", 10.00))
        sopas.add(Product("Menudo", R.drawable.menudo, "Caldo de maiz con pancita de cerdo", 8.00))
        sopas.add(Product("Sopa de Mariscos", R.drawable.sopamariscos, "Caldo con camaron, pescado  y pulpo", 10.00))

        // Drinks
        drinks.add(Product("Caguama", R.drawable.caguama, "Caguama bien fria", 3.00))
        drinks.add(Product("Caguama Michelada", R.drawable.caguamamichelada, "Michelada bien fria", 4.50))
        drinks.add(Product("Charolazo", R.drawable.charolazo, "Promo de cerveza bien fria con botana", 15.00))
        drinks.add(Product("Cubeta Six", R.drawable.cubetasix, "Promo Six de Cerveza", 10.00))
        drinks.add(Product("Cubetazo", R.drawable.cubetazo ,"Cubeta de cerveza 10 piezas", 15.00 ))
        drinks.add(Product("Jarritos", R.drawable.jarritos ,"Refreesco Jarritos", 1.50 ))
        drinks.add(Product("Mexican Beer", R.drawable.mexicanbeer ,"Cerveza Mexicana", 2.50 ))
        drinks.add(Product("Michelada", R.drawable.michelada ,"Michelada", 3.00 ))
        drinks.add(Product("Sodas", R.drawable.sodas ,"Soda 600ml", 1.20 ))
    }

    private class AdaptadorProductos(
        private val contexto: Context,
        private val productos: ArrayList<Product>
    ) : BaseAdapter() {

        override fun getCount(): Int = productos.size
        override fun getItem(position: Int): Any = productos[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val producto = productos[position]
            val inflador = LayoutInflater.from(contexto)
            val vista = convertView ?: inflador.inflate(R.layout.producto_view, parent, false)

            val imagen = vista.findViewById<ImageView>(R.id.producto_img)
            val nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            val desc = vista.findViewById<TextView>(R.id.producto_desc)
            val precio = vista.findViewById<TextView>(R.id.producto_precio)

            imagen.setImageResource(producto.image)
            nombre.text = producto.name
            desc.text = producto.description
            precio.text = "$${producto.price}"

            return vista
        }
    }
}