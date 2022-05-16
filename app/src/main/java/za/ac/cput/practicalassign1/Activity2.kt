package za.ac.cput.practicalassign1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.ac.cput.practicalassign1.ui.theme.PRACTICALASSIGN1Theme

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Name: Isaac Kissimba Nyembo", fontSize = 15.sp)
                Text(text = "Department:Application Development", fontSize = 15.sp)
                Text(text = "Course: Information Communication and Technology", fontSize = 15.sp)
                Text(text = "Student Number: 219383448", fontSize = 15.sp)
                Button(onClick = {
                    val navigate = Intent(this@Activity2, Activity3 ::class.java)
                    startActivity(navigate)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Module",
                        Modifier.padding(end = 24.dp)
                    )
                    Text(text = "Current Modules", fontSize = 18.sp)
                    
                }
            }
            
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = {
                    val navigate = Intent(this@Activity2, MainActivity::class.java)
                    startActivity(navigate)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Back",
                        Modifier.padding(end = 24.dp)
                    )
                    Text(text = "Back", fontSize = 18.sp)

                }

            }
        }
    }
}



