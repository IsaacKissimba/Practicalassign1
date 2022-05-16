package za.ac.cput.practicalassign1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val visible: MutableState<Boolean> = remember { mutableStateOf(false) }
            AlertDialogComponent(visible = visible)
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "CURRENT MODULES", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "Application Development Practice: Practical- Year module", fontSize = 14.sp)
                Text(text = "Application Development Theory: Theory- Year module", fontSize = 14.sp)
                Text(text = "Information System: Theory and Practical- Year module", fontSize = 14.sp)
                Text(text = "Project Management: Theory and Practical- Semester module", fontSize = 14.sp)
                Text(text = "Project: Practical- Year module", fontSize = 14.sp)
                Text(text = "Professional Practice: Theory- Semester module", fontSize = 14.sp)
                Text(text = "Project Presentation: Practical- Year module", fontSize = 14.sp)
                Text(text = "Elective Mobile Programming:- Semester module", fontSize = 14.sp)

                Button(onClick = {
                    val navigate = Intent(this@Activity3, Activity2::class.java)
                    startActivity(navigate)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "return",
                        Modifier.padding(end = 24.dp)
                    )
                    Text(text = "Back", fontSize = 18.sp)

                }

            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                val context= LocalContext.current
                Button(onClick = {
                    visible.value=true},
                    contentPadding = PaddingValues(10.dp),

                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.Blue,
                        contentColor = Color.White

                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Exit",
                        Modifier.padding(end = 10.dp)
                    )
                    Text(text = "Good Bye",
                        style= MaterialTheme.typography.button,
                        modifier= Modifier.padding(7.dp))
                }

            }
        }
    }
    @Composable
    fun AlertDialogComponent(visible:MutableState<Boolean>) {
        if (visible.value) {
            AlertDialog(
                onDismissRequest = { visible.value = false },

                dismissButton = {
                    TextButton(onClick = { visible.value = false })
                    {
                        Text(text = "No")
                    }
                },
                confirmButton = {
                    TextButton(onClick = { moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);

                    }) {
                        Text(text = "Yes")
                    }

                },
                title = {
                    Text(text = "Warning")
                },
                text = {
                    Text(text = "Leaving Now?")
                    Modifier.size(14.dp)

                }
            )

        }
    }

    }