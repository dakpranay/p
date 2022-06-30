package com.example.cal3
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.text.DecimalFormat
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    lateinit var zero:Button
    lateinit var one:Button
    lateinit var two:Button
    lateinit var three:Button
    lateinit var four:Button
    lateinit var five:Button
    lateinit var six:Button
    lateinit var seven:Button
    lateinit var eight:Button
    lateinit var nine:Button
    lateinit var add:Button
    lateinit var sub:Button
    lateinit var mul:Button
    lateinit var div:Button
    lateinit var clr:Button
    lateinit var equal:Button
    lateinit var input:TextView
    lateinit var output:TextView

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.nav_bar,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        when(item.itemId){
            R.id.Home ->{
                Toast.makeText(this@MainActivity,"Already On Home Page", Toast.LENGTH_LONG).show()
            }
            R.id.Login ->{
                var alert=AlertDialog.Builder(this)
                alert.setTitle("Login")
                alert.setMessage("Do You Want To Login?")
                alert.setCancelable(false)
                alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                    val intent= Intent(this@MainActivity,login::class.java)
                    startActivity(intent)
                })
                alert.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                alert.create().show()
            }
            R.id.Register ->{
                var alert=AlertDialog.Builder(this)
                alert.setTitle("Register")
                alert.setMessage("Do You Want To Register?")
                alert.setCancelable(false)
                alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                    val intent= Intent(this@MainActivity,register::class.java)
                    startActivity(intent)
                })
                alert.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                alert.create().show()
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        zero=findViewById(R.id.zero)
        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        add=findViewById(R.id.add)
        sub=findViewById(R.id.sub)
        mul=findViewById(R.id.mul)
        div=findViewById(R.id.div)
        input=findViewById(R.id.input)
        output=findViewById(R.id.output)
        clr=findViewById(R.id.clr)
        equal=findViewById(R.id.equal)
        clr.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        zero.setOnClickListener {
            input.text=addToInputText("0")
        }
        one.setOnClickListener {
            input.text=addToInputText("1")
        }
        two.setOnClickListener {
            input.text=addToInputText("2")
        }
        three.setOnClickListener {
            input.text= addToInputText("3")
        }
        four.setOnClickListener {
            input.text=addToInputText("4")
        }
        five.setOnClickListener {
            input.text= addToInputText("5")
        }
        six.setOnClickListener {
            input.text=addToInputText("6")
        }
        seven.setOnClickListener {
            input.text= addToInputText("7")
        }
        eight.setOnClickListener {
            input.text=addToInputText("8")
        }
        nine.setOnClickListener {
            input.text= addToInputText("9")
        }
        add.setOnClickListener {
            input.text= addToInputText("+")
        }
        sub.setOnClickListener {
            input.text=addToInputText("-")
        }
        mul.setOnClickListener {
            input.text= addToInputText("*")
        }
        div.setOnClickListener {
            input.text=addToInputText("/")
        }
        equal.setOnClickListener {
            showResult()
        }


        drawerLayout=findViewById(R.id.drawerLayout)
        toggle= ActionBarDrawerToggle(this@MainActivity, drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView=findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dc->{
                    val intent= Intent(this@MainActivity,discountCal::class.java)
                    startActivity(intent)
                }
                R.id.ap ->{
                    Toast.makeText(this@MainActivity,"ap",Toast.LENGTH_LONG).show()
                }
                R.id.gp ->{
                    Toast.makeText(this@MainActivity,"gp",Toast.LENGTH_LONG).show()
                }
            }
            true
        }
    }


    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

}