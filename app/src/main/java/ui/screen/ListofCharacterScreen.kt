package ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dnd_characterlist.R

@Composable
fun ListOfCharactersScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFDF1DC),
            )
    ) {
        // Верхняя панель
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 25.dp, start = 10.dp, end = 10.dp)
                .background(
                    color = Color(0xFFE5B765),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                "Персонажи",
                color = Color(0xFF46130A),
                fontSize = 22.sp
            )
        }

        // Список персонажей
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, bottom = 100.dp, start = 5.dp, end = 5.dp)
                .verticalScroll(rememberScrollState()),
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 5.dp, start = 6.dp, end = 6.dp)
                    .fillMaxWidth()
            ){
                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    OutlinedButton(
                        onClick = { navController.navigate("Browse Character") },
                        border = BorderStroke(0.dp, Color.Transparent),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .clip(RoundedCornerShape(32.dp))
                            .padding(start = 5.dp, end = 10.dp)
                            .width(350.dp)
                            .height(100.dp)
                    ) {}
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .border(
                                width = 2.dp,
                                color = Color(0xFFCDA144),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .clip(shape = RoundedCornerShape(4.dp))
                            .padding(vertical = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.playericon),
                            contentDescription = "PlayerIcon",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 8.dp)
                                .clip(shape = RoundedCornerShape(999.dp))
                                .width(80.dp)
                                .height(80.dp)
                        )
                        Column(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .weight(1f)
                        ){
                            Text("Имя персонажа",
                                color = Color(0xFF46130A),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 9.dp, start = 2.dp)
                            )
                            Text("Раса",
                                color = Color(0xFF46130A),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 3.dp, start = 2.dp)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 7.dp)
                            ){
                                Text("Здоровье:",
                                    color = Color(0xFF46130A),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .padding(start = 2.dp, end = 3.dp, bottom = 1.dp)
                                )
                                Text("100 / 100",
                                    color = Color(0xFF46130A),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .padding(end = 6.dp)
                        ){
                            Column(
                                horizontalAlignment = Alignment.End,
                                modifier = Modifier
                                    .padding(bottom = 28.dp)
                            ){
                                Text("Ур. 10",
                                    color = Color(0xFF46130A),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(start = 55.dp, end = 6.dp)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 7.dp)
                            ){
                                Text("Мана:",
                                    color = Color(0xFF46130A),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .padding(top = 4.dp, end = 6.dp)
                                )
                                Text("100 / 100",
                                    color = Color(0xFF46130A),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .padding(top = 4.dp, end = 6.dp)
                                )
                            }
                        }
                    }
                }


                // Кнопка удалить
                Box(
                    modifier = Modifier
                        .width(30.dp)
                        .height(100.dp)
                ){
                    OutlinedButton(
                        onClick = { println("Pressed!") },
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
                        painter = painterResource(id = R.drawable.trashbin),
                        contentDescription = "Trash Bin",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(22.dp)
                            .height(22.dp)
                    )
                }
            }
        }

        // Кнопка добавить пероснажа
        OutlinedButton(
            onClick = { navController.navigate("Creation Character") },
            border = BorderStroke(0.dp, Color.Transparent),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 25.dp, start = 10.dp, end = 10.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(
                    color = Color(0xFFE5B765),
                    shape = RoundedCornerShape(8.dp)
                )
        ){
            Image(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "Plus",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(end = 9.dp)
                    .width(18.dp)
                    .height(18.dp)
            )
            Text("Создать персонажа",
                color = Color(0xFF46130A),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}