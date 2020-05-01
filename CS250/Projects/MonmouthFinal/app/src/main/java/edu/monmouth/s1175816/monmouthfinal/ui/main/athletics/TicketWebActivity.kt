package edu.monmouth.s1175816.monmouthfinal.ui.main.athletics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import edu.monmouth.s1175816.monmouthfinal.R

class TicketWebActivity : AppCompatActivity() {

    private lateinit var ticketWebView: WebView

    companion object {
        fun newIntent(context: Context): Intent {
            Log.d("BRADLEY", "TicketWebActivity.newIntent: begin")
            val detailIntent = Intent(context, TicketWebActivity::class.java)
            Log.d("BRADLEY", "TicketWebActivity.newIntent: return")
            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "TicketWebActivity.onCreate: begin")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ticket_web_activity)
        title = "Tickets"
        ticketWebView = findViewById(R.id.webViewTicket)
        ticketWebView.loadUrl("https://monmouthhawks.com/sports/2006/12/7/714990.aspx")
        Log.d("BRADLEY", "TicketWebActivity.onCreate: return")
    }

}