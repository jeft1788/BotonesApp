package com.example.holaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.holaandroid.databinding.ActivityMain2Binding
import com.example.holaandroid.databinding.ActivityMainBinding
import kotlinx.parcelize.Parcelize





class MainActivity2 : AppCompatActivity(), OnClickListener {
    //Creo vriables para los botones
    //lateinit var btnSimple: Button
    //lateinit var btnSimpleIcon: Button
    //lateinit var  btnOutlined: Button
    //lateinit var btnOutlinedIcon: Button
    //lateinit var btnText: Button
    //lateinit var btnText2: Button
    //Declarar la variable binding que vincula la vista
    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Enlazar el diseño utilizando viewBinding
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //inicalizo los botones
        //btnSimple = findViewById(R.id.btnSimple)
        //btnSimpleIcon = findViewById(R.id.btnIcon)
        //btnOutlined = findViewById(R.id.btnOutlined)
        //btnOutlinedIcon = findViewById(R.id.btnOutlinedIcon)
        //btnText = findViewById(R.id.btnText)
        //btnText2 = findViewById(R.id.btnText2)
        //btnToggleButton = findViewById(R.id.btnToogle)
        //Accedems a los elementos de la vista atraves de bindding

        binding.btnSimple.setOnClickListener(this)
        binding.btnIcon.setOnClickListener(this)
        binding.btnOutlined.setOnClickListener(this)
        binding.btnOutlinedIcon.setOnClickListener(this)
        binding.btnText.setOnClickListener(this)
        binding.btnText2.setOnClickListener(this)
        binding.btnToogle.setOnClickListener(this)
        //btnSimple.setOnClickListener(this)

        //btnSimpleIcon.setOnClickListener(this)
        //btnOutlined.setOnClickListener(this)
        //btnOutlinedIcon.setOnClickListener(this)
        //btnText.setOnClickListener(this)
        //btnText2.setOnClickListener(this)
        //btnToggleButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
    when(v){
        binding.btnSimple ->
        //R.id.btnSimple->
            Toast.makeText(applicationContext, "Click en Boton Simple",Toast.LENGTH_LONG).show()
        binding.btnIcon ->
            Toast.makeText(applicationContext, "Click en Boton Simple con Icono",Toast.LENGTH_LONG).show()
        }
    }
}