package com.subhash1e.codingnotes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class DisplayNoteActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_note)
        supportActionBar?.hide()

        val webview = findViewById<View>(R.id.webView) as WebView
        webview.settings.javaScriptEnabled = true
//        webview.getSettings().setBuiltInZoomControls(true);
//        webview.getSettings().setDisplayZoomControls(false);
//        webview.settings.builtInZoomControls = true;
        val fileName = intent.extras!!["fileName"] as String
        val course = intent.extras!!["course"] as String
        var pdf = "https://subhash1e.github.io/s1e/VINODKUMAR_COMPUTER_NETWORKS.pdf"
        val ls = mutableMapOf<String,MutableMap<String,String>>()
        ls["C"] = mutableMapOf("Complete Note" to "https://www.vssut.ac.in/lecture_notes/lecture1424354156.pdf")
        ls["C++"] = mutableMapOf("Complete Note" to "https://www.cet.edu.in/noticefiles/285_OOPS%20lecture%20notes%20Complete.pdf")
        ls["Kotlin"] = mutableMapOf("Complete Note" to "https://riptutorial.com/Download/kotlin.pdf")
        ls["Java"] = mutableMapOf("Complete Note" to "https://mrcet.com/downloads/digital_notes/IT/JAVA%20PROGRAMMING.pdf")
        ls["Python"] = mutableMapOf("Complete Note" to "https://www.iare.ac.in/sites/default/files/IARE_OOPS_Lecture%20Notes.pdf")
        ls["SQL"] = mutableMapOf("Complete Note" to "https://book.huihoo.com/goalkicker.com/SQLBook/SQLNotesForProfessionals.pdf")
        ls["CN"] = mutableMapOf("Complete Note" to "https://subhash1e.github.io/s1e/VINODKUMAR_COMPUTER_NETWORKS.pdf")
        ls["OS"] = mutableMapOf("Complete Note" to "https://github.com/subhash1e/s1e/blob/main/lecture_note_440507181044270.pdf")
        ls["DBMS"] = mutableMapOf("Complete Note" to "https://www.cet.edu.in/noticefiles/279_DBMS%20Complete1.pdf")
        ls["OOPS"] = mutableMapOf("Complete Note" to "https://web.itu.edu.tr/bkurt/Courses/blg252e/blg252e_complete.pdf")
        ls["HR"] = mutableMapOf("How to Answer The 64 Toughest Interview Questions | OHSU" to "https://www.ohsu.edu/sites/default/files/2019-04/How-to-Answer-the-64-Toughest-Interview-Questions.pdf")

        pdf = ls[course]?.get(fileName) ?: "null"
//        println()

        /*when(fileName){
            "C" -> pdf = "https://www.vssut.ac.in/lecture_notes/lecture1424354156.pdf"
            "C++" -> pdf = "https://www.cet.edu.in/noticefiles/285_OOPS%20lecture%20notes%20Complete.pdf"
            "Kotlin" -> pdf = "https://riptutorial.com/Download/kotlin.pdf"
            "Java" -> pdf = "https://mrcet.com/downloads/digital_notes/IT/JAVA%20PROGRAMMING.pdf"
            "Python" -> pdf = "https://www.iare.ac.in/sites/default/files/IARE_OOPS_Lecture%20Notes.pdf"
            "SQL" -> pdf = "https://book.huihoo.com/goalkicker.com/SQLBook/SQLNotesForProfessionals.pdf"
            "CN" -> pdf = "https://subhash1e.github.io/s1e/VINODKUMAR_COMPUTER_NETWORKS.pdf"
            "OS" -> pdf = "https://github.com/subhash1e/s1e/blob/main/lecture_note_440507181044270.pdf"
            "DBMS" -> pdf = "https://www.cet.edu.in/noticefiles/279_DBMS%20Complete1.pdf"
            "OOPS" -> pdf = "https://web.itu.edu.tr/bkurt/Courses/blg252e/blg252e_complete.pdf"
        }*/
        webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=$pdf")
    }
}