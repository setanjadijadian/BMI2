package com.example.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var etnama: EditText
    private lateinit var etberat: EditText
    private lateinit var ettinggi: EditText
    private lateinit var radiolaki: RadioButton
    private lateinit var radioperempuan: RadioButton
    private lateinit var btnHitung: Button
    private lateinit var btnReset: Button
    private lateinit var btnKeluar: Button
    private lateinit var tvNama: TextView
    private lateinit var tvAnalisa: TextView
    private lateinit var tvBeratIdeal: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        etnama = findViewById(R.id.editnama)
        etberat = findViewById(R.id.editberat)
        ettinggi = findViewById(R.id.edittinggi)
        radiolaki = findViewById(R.id.rdbLaki)
        radioperempuan = findViewById(R.id.rdbPerempuan)
        btnHitung = findViewById(R.id.btncek)
        btnReset = findViewById(R.id.btnclear)
        btnKeluar = findViewById(R.id.btnexit)
        tvNama = findViewById(R.id.hasilket1)
        tvAnalisa = findViewById(R.id.hasilket2)
        tvBeratIdeal = findViewById(R.id.hasilideal)
        btnHitung.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if(v?.id == R.id.btncek){
            val inputNama = etnama.text.toString().trim()
            val inputBerat = etberat.text.toString().trim()
            val inputTinggi = ettinggi.text.toString().trim()
            var tinggi = inputTinggi.toDouble()
            var berat = inputBerat.toDouble()

            if (radiolaki.isChecked){
                var hasil = (tinggi - 100) - ((tinggi - 100) * 10 / 100)
                tvNama.text = "Nama : $inputNama"
                tvBeratIdeal.text = "Berat Ideal : ${hasil.toString()}"
                if (berat < hasil){
                    tvAnalisa.text = "Berat badan anda kurang"
                } else if (berat > hasil){
                    tvAnalisa.text = "Beras badan anda berlebih"
                } else {
                    tvAnalisa.text = "Selamat berat badan anda ideal"
                }
            } else if (radioperempuan.isChecked){
                var hasil = (tinggi - 100) - ((tinggi - 100) * 15 / 100)
                tvNama.text = "Nama : $inputNama"
                tvBeratIdeal.text = "Berat badan ideal anda adalah ${hasil.toString()}"
                if (berat < hasil){
                    tvAnalisa.text = "Berat badan anda kurang"
                } else if (berat > hasil){
                    tvAnalisa.text = "Berat badan anda berlebih"
                } else {
                    tvAnalisa.text = "Berat badan anda ideal"
                }
            }
        }
    }
}