package ui.screen

import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.dnd_characterlist.R

@Composable
fun NotesScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFDF1DC),
            )
    ){
        // Верхняя панель
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 25.dp, start = 10.dp, end = 10.dp)
                .background(
                    color = Color(0xFFE5B765),
                    shape = RoundedCornerShape(8.dp)
                )
        ){
            Box(
                modifier = Modifier
                    .padding(end = 100.dp, start = 5.dp)
                    .width(48.dp)
                    .height(48.dp)
            ){ // Кнопка Назад
                OutlinedButton(
                    onClick = { navController.navigate("Browse Character") },
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .clip(RoundedCornerShape(32.dp))
                        .fillMaxSize()
                        .background(
                            color = Color(0xFFE5B765),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {}
                Image(
                    painter = painterResource(id = R.drawable.backarrow),
                    contentDescription = "BackArrow",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .width(48.dp)
                        .height(48.dp)
                )
            }
            Text("Заметки",
                color = Color(0xFF46130A),
                fontSize = 22.sp,
            )
        }

        // Поле заметок
        Column(
            modifier = Modifier
                .padding(top = 85.dp, bottom = 20.dp, start = 15.dp, end = 15.dp)
                .fillMaxSize()
                .background(
                    color = Color(0xFFFDF1DC),
                )
                .verticalScroll(rememberScrollState())
        ){
            BasicTextField(
                value = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam " +
                        "nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, " +
                        "sed diam voluptua. At vero eos et accusam et justo duo dolores et ea " +
                        "rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum " +
                        "dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, s" +
                        "ed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam " +
                        "erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea " +
                        "rebum. ",
                onValueChange = { println("Text Changed") },
                textStyle = TextStyle(
                    color = Color(0xFF58180D),
                    fontSize = 16.sp,
                ),
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
