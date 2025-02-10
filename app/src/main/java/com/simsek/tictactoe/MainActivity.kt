package com.simsek.tictactoe

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.simsek.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 3
    private var mod: Int? = null
    private var matrixSize = 0
    var controlList = arrayListOf<TextView>()

    private val matrix = Array(3){Array(3){ "" } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.start.setOnClickListener {
            clickListeners()
        }
    }

    private fun clickListeners() {
        val textViews = listOf(
            binding.text1, binding.text2, binding.text3,
            binding.text4, binding.text5, binding.text6,
            binding.text7, binding.text8, binding.text9
        )

        val matrixCoordinates = listOf(
            Pair(0, 0), Pair(0, 1), Pair(0, 2),
            Pair(1, 0), Pair(1, 1), Pair(1, 2),
            Pair(2, 0), Pair(2, 1), Pair(2, 2)
        )

        textViews.forEachIndexed { index, textView ->
            textView.setOnClickListener {
                handleClick(textView, matrixCoordinates[index])
                controlList.add(textView)
            }
        }
    }

    private fun handleClick(textView: TextView, coordinates: Pair<Int, Int>) {
        if (textView.text.isNotEmpty()) {
            return
        }

        mod = count % 2
        val player = if (mod == 1) "X" else "O"
        textView.text = player
        matrix[coordinates.first][coordinates.second] = player
        count++
        matrixSize()
    }

    private fun matrixSize() {

        matrixSize = 0
        for(i in matrix){
            for (x in i){
                if (x.isNotEmpty()){
                    matrixSize++
                }
            }
        }
        if (matrixSize >= 5){
            control()
        }
    }

    private fun control() {

        if (matrix[0][0] == matrix[0][1] && matrix[0][0] == matrix[0][2] && matrix[0][0].isNotEmpty()){
            when(matrix[0][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
            restartGame()
        }else if (matrix[1][0] == matrix[1][1] && matrix[1][0] == matrix[1][2] && matrix[1][0].isNotEmpty()){
            when(matrix[1][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
            restartGame()
        }else if (matrix[2][0] == matrix[2][1] && matrix[2][0] == matrix[2][2] && matrix[2][0].isNotEmpty()){
            when(matrix[2][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
            restartGame()
        }else if (matrix[0][0] == matrix[1][0] && matrix[0][0] == matrix[2][0] && matrix[0][0].isNotEmpty()){
            when(matrix[0][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
            restartGame()
        }else if (matrix[0][1] == matrix[1][1] && matrix[0][1] == matrix[2][1] && matrix[0][1].isNotEmpty()){
            when(matrix[0][1]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
            restartGame()
        }else if (matrix[0][2] == matrix[1][2] && matrix[0][2] == matrix[2][2] && matrix[0][2].isNotEmpty()){
            when(matrix[0][2]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
            restartGame()
        }else if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2] && matrix[0][0].isNotEmpty()){
            when(matrix[0][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
            restartGame()
        }else if (matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0] && matrix[0][2].isNotEmpty()){
            when(matrix[0][2]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
            restartGame()
        }
    }

    private fun restartGame() {
        /*binding.start.text = "Restart Game"
        // Matrisi boşalt
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                matrix[i][j] = ""
            }
        }
        // Sayacı sıfırla
        count = 3

        // Tüm TextView'ları temizle
        val textViews = listOf(
            binding.text1, binding.text2, binding.text3,
            binding.text4, binding.text5, binding.text6,
            binding.text7, binding.text8, binding.text9
        )
        textViews.forEach { it.text = "" }
        */
        recreate()
    }
}