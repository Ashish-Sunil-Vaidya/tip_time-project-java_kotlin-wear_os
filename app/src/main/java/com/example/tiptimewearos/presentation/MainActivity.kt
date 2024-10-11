/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.tiptimewearos.presentation

import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.tiptimewearos.R
import com.example.tiptimewearos.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateTipBtn.setOnClickListener { handleClick() }
    }

    private fun handleClick() {
        val cost = binding.serviceAmt.text.toString().toDouble()
        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId) {
            R.id.tip_twenty_percent -> 0.20
            R.id.tip_fifteen_percentage -> 0.18
            else -> 0.15
        }
        var tipAmt = cost*tipPercentage
        val roundup = binding.roundTip.isChecked;
        if (roundup)
        {
            tipAmt = kotlin.math.ceil(tipAmt);
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tipAmt);
        binding.tipResult.text = formattedTip
    }
}

