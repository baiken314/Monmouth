package edu.monmouth.cs250.instructor.demomap

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class PopupAlert: DialogFragment () {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val popupView: View =  inflater.inflate(R.layout.alert_popup, container, false)
        val doneButton: Button = popupView.findViewById(R.id.done)

        doneButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                dismiss()
            }
        })

        return popupView
    }

}