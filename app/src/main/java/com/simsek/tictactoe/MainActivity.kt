package com.simsek.tictactoe

import android.os.Bundle
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

    private val matrix = Array(3){Array(3){ null.toString() } }

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

        binding.text1.setOnClickListener {
            if (binding.text1.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text1.text = "X"
                    matrix[0][0] = "X"
                }
                0->{
                    binding.text1.text = "O"
                    matrix[0][0] = "O"
                }
            }

            count ++
        }

        binding.text2.setOnClickListener {
            if (binding.text2.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text2.text = "X"
                    matrix[0][1] = "X"
                }
                0->{
                    binding.text2.text = "O"
                    matrix[0][1] = "O"
                }
            }

            count ++
        }

        binding.text3.setOnClickListener {
            if (binding.text3.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text3.text = "X"
                    matrix[0][2] = "X"
                }
                0->{
                    binding.text3.text = "O"
                    matrix[0][2] = "O"
                }
            }

            count ++
        }

        binding.text4.setOnClickListener {
            if (binding.text4.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text4.text = "X"
                    matrix[1][0] = "X"
                }
                0->{
                    binding.text4.text = "O"
                    matrix[1][0] = "O"
                }
            }

            count ++
        }

        binding.text5.setOnClickListener {
            if (binding.text5.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text5.text = "X"
                    matrix[1][1] = "X"
                }
                0->{
                    binding.text5.text = "O"
                    matrix[1][1] = "O"
                }
            }

            count ++
        }

        binding.text6.setOnClickListener {
            if (binding.text6.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text6.text = "X"
                    matrix[1][2] = "X"
                }
                0->{
                    binding.text6.text = "O"
                    matrix[1][2] = "O"
                }
            }

            count ++
        }

        binding.text7.setOnClickListener {
            if (binding.text7.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text7.text = "X"
                    matrix[2][0] = "X"
                }
                0->{
                    binding.text7.text = "O"
                    matrix[2][0] = "O"
                }
            }

            count ++
        }

        binding.text8.setOnClickListener {
            if (binding.text8.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text8.text = "X"
                    matrix[2][1] = "X"
                }
                0->{
                    binding.text8.text = "O"
                    matrix[2][1] = "O"
                }
            }

            count ++
        }

        binding.text9.setOnClickListener {
            if (binding.text9.text.isNotEmpty()){
                return@setOnClickListener
            }

            mod = count % 2

            when(mod){
                1->{
                    binding.text9.text = "X"
                    matrix[2][2] = "X"
                }
                0->{
                    binding.text9.text = "O"
                    matrix[2][2] = "O"
                }
            }

            count ++
        }
    }

    private fun control() {

        if (matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2]){
            when(matrix[0][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
        }else if (matrix[1][0] == matrix[1][1] && matrix[1][0] == matrix[1][2]){
            when(matrix[1][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
        }else if (matrix[2][0] == matrix[2][1] && matrix[2][0] == matrix[2][2]){
            when(matrix[2][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
        }else if (matrix[0][0] == matrix[1][0] && matrix[0][0] == matrix[2][0]){
            when(matrix[0][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
        }else if (matrix[0][1] == matrix[1][1] && matrix[0][1] == matrix[2][1]){
            when(matrix[0][1]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
        }else if (matrix[0][2] == matrix[1][2] && matrix[0][2] == matrix[2][2]){
            when(matrix[0][2]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
        }else if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]){
            when(matrix[0][0]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
        }else if (matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0]){
            when(matrix[0][2]){
                "X" -> Toast.makeText(this, "X kazandı", Toast.LENGTH_LONG).show()
                "O" -> Toast.makeText(this, "O kazandı", Toast.LENGTH_LONG).show()
            }
        }
    }
}