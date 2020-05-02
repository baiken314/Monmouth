package edu.monmouth.s1175816.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var exchangeRate: Double = 0.9
    val exchangeRateIncrement: Double = 0.01

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numExchangeRate.setText(exchangeRate.toString())

    }

    fun convertCurrency() {

        try {
            var value: Double
            exchangeRate = numExchangeRate.text.toString().toDouble()
            if (numCurrency1.text.isEmpty() || numCurrency1.text.toString().toDouble() == 0.0) {
                value = numCurrency2.text.toString().toDouble() / exchangeRate
                value = Math.round((value * 100)) / 100.0
                numCurrency1.setText(value.toString())
            }
            else {
                value = numCurrency1.text.toString().toDouble() * exchangeRate
                value = Math.round((value * 100)) / 100.0
                numCurrency2.setText(value.toString())
            }
        }
        catch (e: Exception) {}

    }

    fun btnConvertClick(view: View) {
        convertCurrency()
    }

    fun imbPlusMinusClick(view: View) {

        val pressedButton = view as ImageButton
        val pressedButtonId = view.context.resources.getResourceEntryName(pressedButton.id)
        if (pressedButtonId == "imbPlus") {
            exchangeRate += exchangeRateIncrement
        }
        else {
            exchangeRate -= exchangeRateIncrement
        }
        exchangeRate = Math.max(0.0, Math.round((exchangeRate * 100)) / 100.0)
        numExchangeRate.setText(exchangeRate.toString())
        convertCurrency()

    }

}
