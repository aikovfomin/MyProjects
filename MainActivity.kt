package com.example.calculatormy

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //объявление переменных
    private lateinit var buttonPlus : Button;
    private lateinit var buttonMinus : Button;
    private lateinit var buttonMultiply : Button;
    private lateinit var buttonDivider : Button;

    private lateinit var firstNumber: EditText;
    private lateinit var secondNumber: EditText;

    private lateinit var result: TextView;

    private lateinit var reset: Button;
    private lateinit var exit: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //инициализация переменных

        buttonPlus = findViewById(R.id.plusOperator)
        buttonMinus = findViewById(R.id.minusOperator)
        buttonMultiply = findViewById(R.id.multiplyOperator)
        buttonDivider = findViewById(R.id.dividerOperator)

        firstNumber = findViewById(R.id.firstOperandET)
        secondNumber = findViewById(R.id.secondOperandET)

        result = findViewById(R.id.result)

        reset = findViewById(R.id.buttonReset)
        exit = findViewById(R.id.buttonExit)

        //создание функций реализации работы приложения
        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivider.setOnClickListener(this)
        reset.setOnClickListener(this)
        exit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        var check = true;

        if (firstNumber.text.isEmpty() || secondNumber.text.isEmpty())
             return

        val first = firstNumber.text.toString().toDouble();
        val second = secondNumber.text.toString().toDouble();

        val resultLocale = when(v?.id){
            R.id.plusOperator ->  Operation(first, second).sum()
            R.id.minusOperator ->  Operation(first, second).dif()
            R.id.multiplyOperator ->  Operation(first, second).mul()
            R.id.dividerOperator ->  Operation(first, second).div()
            R.id.buttonReset -> {
                firstNumber.text.clear()
                secondNumber.text.clear()
                check = false;
            }
            R.id.buttonExit -> {
                finish()
            }
            else ->  0.0
        }

        if (!check) result.text = "Результат" else result.text = resultLocale.toString();
    }
}

/*setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            }*/
