package com.example.holaandroid

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.example.holaandroid.data.Blog
import com.example.holaandroid.data.Student
import com.example.holaandroid.databinding.ActivityMainBinding
import java.io.Serializable


class MainActivity : AppCompatActivity(), OnClickListener{
    lateinit var btnSimpleIntent: Button
    lateinit var btnSimpleIntentAndData: Button
    lateinit var  btnParcelableIntent: Button
    lateinit var btnSerializableIntent: Button
    lateinit var btnBrowserIntent: Button
    lateinit var btnMapsIntent: Button
    lateinit var btnGenericIntent: Button
    lateinit var btnCustom: Button

    val arrayList: ArrayList<String> = arrayListOf()
    lateinit var binding: ActivityMainBinding

    fun Context.gotoClass(targetType: Class<*>) =
        ComponentName(this, targetType)
    fun Context.startActivity(f: Intent.() -> Unit): Unit =
        Intent().apply(f).run(this::startActivity)
    inline fun <reified T : Activity> Context.start(
        noinline createIntent: Intent.() -> Unit = {}
    ) = startActivity {
        component = gotoClass(T::class.java)
        createIntent(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBrowserIntent = findViewById(R.id.btnBrowserIntent)
        btnSimpleIntent = findViewById(R.id.btnSimpleIntent)
        btnSimpleIntentAndData = findViewById(R.id.btnSimpleIntentAndData)
        btnParcelableIntent = findViewById(R.id.btnParcelableIntent)
        btnSerializableIntent = findViewById(R.id.btnSerializableIntent)
        btnMapsIntent = findViewById(R.id.btnMapsIntent)
        btnGenericIntent = findViewById(R.id.btnGenericIntent)
        btnCustom = findViewById(R.id.CustomButton)

        btnSimpleIntent.setOnClickListener(this)
        btnSimpleIntentAndData.setOnClickListener(this)
        btnParcelableIntent.setOnClickListener(this)
        btnSerializableIntent.setOnClickListener(this)
        btnBrowserIntent.setOnClickListener(this)
        btnMapsIntent?.setOnClickListener(this)
        btnGenericIntent?.setOnClickListener(this)
        btnCustom.setOnClickListener(this)

        arrayList.add("Androidly")
        arrayList.add("Android")
        arrayList.add("Intents")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSimpleIntent -> {
                val intent = Intent(this, OtherActivity::class.java)
                startActivity(intent)
            }
            R.id.btnSimpleIntentAndData -> {
                val intent = Intent(this, OtherActivity::class.java)
                with(intent)
                {
                    putExtra("keyString", "Androidly String data")
                    putStringArrayListExtra("arrayList", arrayList)
                    putExtra("keyBoolean", true)
                    putExtra("keyFloat", 1.2f)
                }
                startActivity(intent)
            }
            R.id.btnParcelableIntent -> {

                val student = Student()
                val intent = Intent(this, OtherActivity::class.java)
                intent.putExtra("studentData", student)
                startActivity(intent)
            }
            R.id.btnSerializableIntent -> {
                val blog = Blog("a", 1)
                val sintent = Intent(this, OtherActivity::class.java)
                sintent.putExtra("blogData", blog as Serializable)
                startActivity(sintent)
            }
            R.id.btnBrowserIntent -> {
                val webIntent: Intent = Uri.parse("https://www.android.com").let { webpage ->
                    Intent(Intent.ACTION_VIEW, webpage)
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(webIntent)
                } else {
                    Toast.makeText(applicationContext, "No application found", LENGTH_LONG).show()
                }
            }
            R.id.btnMapsIntent -> {

                val loc = "12.9538477,77.3507442"
// Map point based on address
                val mapIntent: Intent = Uri.parse(
                    "geo:0,0?q="+loc
                ).let { location ->
                    // Or map point based on latitude/longitude
                    // val location: Uri = Uri.parse("geo:37.422219,-122.08364?z=14") // z param is zoom level
                    Intent(Intent.ACTION_VIEW, location)
                }


                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(mapIntent)
                } else {
                    Toast.makeText(applicationContext, "No application found", LENGTH_LONG).show()
                }
            }
            R.id.CustomButton ->  {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            else -> start<OtherActivity> {
                putExtra("keyString", "Androidly Generic Intent")
            }
        }
    }
}
