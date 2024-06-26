package com.example.holaandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.holaandroid.data.Blog
import com.example.holaandroid.data.Student

class OtherActivity : AppCompatActivity() {
     lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        textView = findViewById(R.id.textView)
        val bundle: Bundle? = intent.extras

        bundle?.let {

            bundle.apply {
                //Intent with data
                val string: String? = getString("keyString")
                textView?.text = string

                val myArray: ArrayList<String>? = getStringArrayList("myArray")
                showToast(message = "MyArrayList size:${myArray?.size}")

                val arrayList: ArrayList<String>? = getStringArrayList("arrayList")
                showToast(message = "ArrayList size:${arrayList?.size}")

                val float: Float? = bundle.get("keyFloat") as Float?
                var boolean = bundle.get("boolean") as? Boolean

                showToast(message = "Float data is:$float")
                showToast(message = "Boolean data is:$boolean")
                boolean = bundle.get("keyBoolean") as? Boolean
                showToast(message = "Boolean correct key data is:$boolean")

            }



            bundle.apply {
                //Serializable Data
                val blog = getSerializable("blogData") as Blog?
                if (blog != null) {
                    textView?.text = "Blog name is ${blog?.name}. Year started: ${blog?.year}"

                }
            }

            bundle.apply {
                //Parcelable Data
                val student: Student? = getParcelable("studentData")
                if (student != null) {
                    textView?.text = "Name is ${student?.name}. Age: ${student?.age}"
                }
            }
        }
    }

    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_SHORT) {
        if (!message.contains("null"))
            Toast.makeText(context, message, duration).show()
    }
}