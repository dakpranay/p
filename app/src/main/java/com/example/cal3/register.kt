package com.example.cal3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class register : AppCompatActivity() {

    lateinit var register: Button


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_bar,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Home ->{
                var alert= AlertDialog.Builder(this)
                alert.setTitle("Home Page")
                alert.setMessage("Do You Want To Go On Home Page?")
                alert.setCancelable(false)
                alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                    val intent= Intent(this@register,MainActivity::class.java)
                    startActivity(intent)
                    //     Toast.makeText(this@MainActivity,"Register",Toast.LENGTH_LONG).show()
                })
                alert.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                alert.create().show()
            }
            R.id.Login ->{
                var alert=AlertDialog.Builder(this)
                alert.setTitle("Login")
                alert.setMessage("Do You Want To Login?")
                alert.setCancelable(false)
                alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                    val intent= Intent(this@register,login::class.java)
                    startActivity(intent)
                })
                alert.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                alert.create().show()
            }
            R.id.Register ->{
                Toast.makeText(this@register,"Already On Register Page", Toast.LENGTH_LONG).show()
            }

        }

        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register=findViewById(R.id.R)
        register.setOnClickListener {
                Toast.makeText(this@register, "Register Successfully", Toast.LENGTH_LONG).show()
            }
        }
    }
