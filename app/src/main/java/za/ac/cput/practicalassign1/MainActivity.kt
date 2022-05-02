package za.ac.cput.practicalassign1
//Name :Kissimba Nyembo Isaac
//Student Number: 219383448

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import za.ac.cput.practicalassign1.ui.theme.PRACTICALASSIGN1Theme
import za.ac.cput.practicalassign1.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PRACTICALASSIGN1Theme  {
                val visible: MutableState<Boolean> = remember { mutableStateOf(false) }
                AlertDialogComponent(visible = visible)

                var h =Message("Welcome to My Jetpack Compose Journey")
                main(h)

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement= Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {

                    val context= LocalContext.current
                    Button(onClick = {
                        visible.value=true},
                        shape= Shapes.medium,
                        contentPadding = PaddingValues(10.dp),

                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = Color.DarkGray,
                            contentColor = White

                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Warning,
                            contentDescription = "Alert",
                            Modifier.padding(end = 10.dp)
                        )
                        Text(text = "INFO",
                            style= MaterialTheme.typography.button,
                            modifier= Modifier.padding(7.dp))
                    }

                    Column(

                    ){
                        Button(onClick = { 
                            val navigate = Intent(this@MainActivity, Activity2::class.java)
                            startActivity(navigate)
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Send,
                                contentDescription = "Next",
                                Modifier.padding(end = 24.dp)
                            )
                            Text(text = "Start Journey", fontSize = 18.sp)
                            
                        }
                        
                    }

                }

            }
        }
    }
}

data class Message(var msg:String)
@Composable
fun main(message: Message) {
    Column(modifier= Modifier
        .background(Gray)
        .padding(all = 6.dp)){

        Text(text ="${message.msg}", color=MaterialTheme.colors.surface,
            style= MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp), textAlign = TextAlign.Center)}
}

@Composable
fun AlertDialogComponent(visible:MutableState<Boolean>)
{
    if(visible.value){
        AlertDialog(
            onDismissRequest = { visible.value=false },
            dismissButton = {
                TextButton(onClick = {visible.value=false}) {
                    Text(text = "Clause")
                }
            },
            confirmButton = {
            },
            title = { Text(text = "Information")
            },
            text = { Text(text = "Here I will show my Good Job done in JetpackCompose so far, according to what we have learned")
                Modifier.size(10.dp)

            }
        )

    }


}

