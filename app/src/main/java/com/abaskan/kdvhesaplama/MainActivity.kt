package com.abaskan.kdvhesaplama

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.abaskan.kdvhesaplama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hesapla()

    }

    fun hesapla() {

        val autoComplete = binding.autocomplete
        val liste = resources.getStringArray(R.array.liste)
        val adapter = ArrayAdapter(this, R.layout.kdv_listesi, liste)
        binding.autocomplete.setAdapter(adapter)
        autoComplete.setAdapter(adapter)
        autoComplete.threshold = 1

        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = position

                binding.hesapla.setOnClickListener {
                    val girilenDegerPara = binding.editText.text.toString()
                    val tutar =girilenDegerPara .toDouble()
                    var odenenVergi = 0.0
                    when (selectedItem) {
                        0 -> odenenVergi = tutar - (tutar * 100) / 108
                        1 -> odenenVergi = tutar - (tutar * 100) / 108
                        3 -> odenenVergi = tutar - (tutar * 100) / 108
                        2 -> odenenVergi = tutar - (tutar * 100) / 250
                        4 -> odenenVergi = tutar - (tutar * 100) / 160
                    }
                    binding.textViewodenenvergi.text = "Ödenen Vergi: $odenenVergi ₺"
                }

            }

    }
}
