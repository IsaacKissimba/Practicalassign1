package za.ac.cput.practicalassign1
//Name :Kissimba Nyembo Isaac
//Student Number: 219383448

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import za.ac.cput.practicalassign1.ui.theme.PRACTICALASSIGN1Theme
import za.ac.cput.practicalassign1.ui.theme.Shapes

class MainActivity : ComponentActivity() {

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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PRACTICALASSIGN1Theme  {
                val visible: MutableState<Boolean> = remember { mutableStateOf(false) }
                AlertDialogComponent(visible = visible)

                var h =Message("Welcome to My Jetpack Compose Journey")
                main(h)

                Column(
                    verticalArrangement= Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val context= LocalContext.current
                    Button(onClick = {
                        visible.value=true},
                        shape= Shapes.medium,
                        contentPadding = PaddingValues(18.dp),

                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = Red,
                            contentColor = White

                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Warning,
                            contentDescription = "Alert",
                            Modifier.padding(end = 24.dp)
                        )
                        Text(text = "INFO",
                            style= MaterialTheme.typography.button,
                            modifier= Modifier.padding(7.dp))
                    }

                }

            }
        }
    }
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
