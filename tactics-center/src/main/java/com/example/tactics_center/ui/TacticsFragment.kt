package com.example.tactics_center.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tactics_center.databinding.FragmentTacticsBinding

class TacticsFragment : Fragment() {

    private var _binding: FragmentTacticsBinding? = null
    private val binding get() = _binding!!

    private lateinit var draggableView: LinearLayout
    private lateinit var playerTwo: LinearLayout
    private var dX = 0f
    private var dY = 0f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTacticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        draggableView = binding.playerOne
        draggableView.setOnTouchListener(touchListener)
        playerTwo = binding.playerTwo
        playerTwo.setOnTouchListener(touchListener)

        binding.buttonTest.setOnClickListener {
            startActivity(Intent(requireContext(), TacticActivity::class.java))
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private val touchListener = View.OnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = view.x - event.rawX
                dY = view.y - event.rawY
            }

            MotionEvent.ACTION_MOVE -> {
                val newX = event.rawX + dX
                val newY = event.rawY + dY

                // Defina os limites da tela aqui, se necessário.
                // Por exemplo, para impedir que a view seja arrastada para fora da tela:
                // newX = maxOf(0f, minOf(newX, parentLayout.width - view.width.toFloat()))
                // newY = maxOf(0f, minOf(newY, parentLayout.height - view.height.toFloat()))

                view.animate()
                    .x(newX)
                    .y(newY)
                    .setDuration(0)
                    .start()
            }
        }
        true
    }
}
