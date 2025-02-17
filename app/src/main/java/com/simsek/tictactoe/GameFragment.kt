package com.simsek.tictactoe

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.simsek.tictactoe.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private var count = 3
    private var mod: Int? = null
    private var matrixSize = 0
    private var controlList = arrayListOf<TextView>()
    private val matrix = Array(3){Array(3){ "" } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
        when(player){
            "X" -> textView.setTextColor(Color.parseColor("#B0E0E6"))
            "O" -> textView.setTextColor(Color.parseColor("#E6B8FF"))
        }
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
            alert(matrix[0][0])
        }else if (matrix[1][0] == matrix[1][1] && matrix[1][0] == matrix[1][2] && matrix[1][0].isNotEmpty()){
            alert(matrix[1][0])
        }else if (matrix[2][0] == matrix[2][1] && matrix[2][0] == matrix[2][2] && matrix[2][0].isNotEmpty()){
            alert(matrix[2][0])
        }else if (matrix[0][0] == matrix[1][0] && matrix[0][0] == matrix[2][0] && matrix[0][0].isNotEmpty()){
            alert(matrix[0][0])
        }else if (matrix[0][1] == matrix[1][1] && matrix[0][1] == matrix[2][1] && matrix[0][1].isNotEmpty()){
            alert(matrix[0][1])
        }else if (matrix[0][2] == matrix[1][2] && matrix[0][2] == matrix[2][2] && matrix[0][2].isNotEmpty()){
            alert(matrix[0][2])
        }else if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2] && matrix[0][0].isNotEmpty()){
            alert(matrix[0][0])
        }else if (matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0] && matrix[0][2].isNotEmpty()){
            alert(matrix[0][2])
        }
    }

    private fun restartGame() {
        val fragment = GameFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, fragment)
            .commit()
    }

    private fun alert(winner: String){
        val builder =  MaterialAlertDialogBuilder(requireContext(), R.style.MaterialAlertDialog_App)
        builder.setTitle("Oyun Bitti")
        builder.setMessage("$winner kazandı")
        builder.setPositiveButton("Tekrar Oyna"){dialog, which ->
            restartGame()
        }
        builder.setNegativeButton("Oyundan Çık"){dialog, which ->
            requireActivity().finishAndRemoveTask()
        }
        builder.setCancelable(false)
        builder.show()
    }
}