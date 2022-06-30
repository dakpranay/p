package com.example.cal3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class login : AppCompatActivity() {

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
                    val intent= Intent(this@login,MainActivity::class.java)
                    startActivity(intent)
                    //     Toast.makeText(this@MainActivity,"Register",Toast.LENGTH_LONG).show()
                })
                alert.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                alert.create().show()
            }
            R.id.Login ->{
                Toast.makeText(this@login,"Already On Login Page", Toast.LENGTH_LONG).show()
                //        Toast.makeText(this@MainActivity,"Login",Toast.LENGTH_LONG).show()
            }
            R.id.Register ->{
                var alert= AlertDialog.Builder(this)
                alert.setTitle("Register")
                alert.setMessage("Do You Want To Register?")
                alert.setCancelable(false)
                alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                    val intent= Intent(this@login,register::class.java)
                    startActivity(intent)
                    //     Toast.makeText(this@MainActivity,"Register",Toast.LENGTH_LONG).show()
                })
                alert.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                alert.create().show()
                //         Toast.makeText(this@MainActivity,"Register",Toast.LENGTH_LONG).show()
            }

        }

        return true
    }

    lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login=findViewById(R.id.login)

      //  supportActionBar.setDisplayHomeAsUpEnabled(true)
        login.setOnClickListener {
            Toast.makeText(this@login,"Login Succesfully",Toast.LENGTH_LONG).show()
        }


    }
}