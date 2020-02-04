package edu.monmouth.s1175816.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

private val TAG = "ALMainActivity"
private val TXT_MESSAGES_CONTENT = "ALMainActivityTxtMessagesContent"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TAG", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        txtMessages?.setText(savedInstanceState.getString(TXT_MESSAGES_CONTENT, ""))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(TXT_MESSAGES_CONTENT, txtMessages.text.toString())
    }


    fun btnSendClick(view: View) {
        if (etxInput.text.isNotEmpty()) {
            txtMessages.text = txtMessages.text.toString() + etxInput.text.toString() + "\n"
            etxInput.setText("")
        }
    }

}
