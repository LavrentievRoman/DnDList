package ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.dnd_characterlist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceScreen(navController: NavController) {
    var checkTypeDropMenuExposed by remember { mutableStateOf(false) }
    var checkTypeDropMenuSelectedOption by remember { mutableStateOf("Обычный бросок") }
    val checkTypeDropMenuOptions = listOf("Обычный бросок")

    var diceCountDropMenuExposed by remember { mutableStateOf(false) }
    var diceCountDropMenuSelectedOption by remember { mutableStateOf("1") }
    val diceCountDropMenuOptions = listOf("1","2","3","4","5","6")


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
                    .padding(end = 70.dp, start = 5.dp)
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
            Text(
                "Бросок кубика",
                color = Color(0xFF46130A),
                fontSize = 22.sp,
            )
        }

        // Параметры броска
        Column(
            modifier = Modifier
                .padding(top = 80.dp, bottom = 70.dp, start = 5.dp, end = 5.dp)
                .fillMaxSize()
                .background(
                    color = Color(0xFFFDF1DC),
                )
                .verticalScroll(rememberScrollState())
        ){
            // Выбор провеки, кол. кубиков
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 6.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            ){
                Text("Проверка",
                    color = Color(0xFF58180D),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    "Кол. кубиков",
                    color = Color(0xFF58180D),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            // Выпадающие списки
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            ){
                // Тип проверки
                ExposedDropdownMenuBox(
                    expanded = checkTypeDropMenuExposed,
                    onExpandedChange = { checkTypeDropMenuExposed = !checkTypeDropMenuExposed },
                    modifier = Modifier
                        .padding(end = 100.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCABA98),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(shape = RoundedCornerShape(8.dp))
                        .height(50.dp)
                        .width(200.dp)
                ) {
                    TextField(
                        value = checkTypeDropMenuSelectedOption,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            Icon(Icons.Filled.ArrowDropDown, contentDescription = null, tint = Color(0xFF46130A))
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFFFD489),
                            unfocusedContainerColor = Color(0xFFFFD489),
                            focusedTextColor = Color(0xFF46130A),
                            unfocusedTextColor = Color(0xFF46130A),
                            cursorColor = Color(0xFF46130A),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.menuAnchor()
                    )

                    ExposedDropdownMenu(
                        expanded = checkTypeDropMenuExposed,
                        onDismissRequest = { checkTypeDropMenuExposed = false },
                        modifier = Modifier.background(Color(0xFFFFD489)) // Цвет фона списка
                    ) {
                        checkTypeDropMenuOptions.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = {
                                    Text(selectionOption, color = Color(0xFF46130A)) // Цвет текста в списке
                                },
                                onClick = {
                                    checkTypeDropMenuSelectedOption = selectionOption
                                    checkTypeDropMenuExposed = false
                                }
                            )
                        }
                    }
                }

                // Кол. кубиков
                ExposedDropdownMenuBox(
                    expanded = diceCountDropMenuExposed,
                    onExpandedChange = { diceCountDropMenuExposed = !diceCountDropMenuExposed },
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCABA98),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(shape = RoundedCornerShape(8.dp))
                        .height(50.dp)
                        .width(80.dp)
                ) {
                    TextField(
                        value = diceCountDropMenuSelectedOption,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            Icon(Icons.Filled.ArrowDropDown, contentDescription = null, tint = Color(0xFF46130A))
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFFFD489),
                            unfocusedContainerColor = Color(0xFFFFD489),
                            focusedTextColor = Color(0xFF46130A),
                            unfocusedTextColor = Color(0xFF46130A),
                            cursorColor = Color(0xFF46130A),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.menuAnchor()
                    )

                    ExposedDropdownMenu(
                        expanded = diceCountDropMenuExposed,
                        onDismissRequest = { diceCountDropMenuExposed = false },
                        modifier = Modifier.background(Color(0xFFFFD489)) // Цвет фона списка
                    ) {
                        diceCountDropMenuOptions.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = {
                                    Text(selectionOption, color = Color(0xFF46130A)) // Цвет текста в списке
                                },
                                onClick = {
                                    diceCountDropMenuSelectedOption = selectionOption
                                    diceCountDropMenuExposed = false
                                }
                            )
                        }
                    }
                }
            }


            Text("Тип кубика",
                color = Color(0xFF58180D),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 6.dp, start = 8.dp)
            )
            Column(
                modifier = Modifier
                    .padding(bottom = 14.dp, start = 6.dp, end = 6.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFE5B765),
                    )
            ){
            }

            // Кубики d4, d6, d8
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            ){
                // D4
                Column(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                ){
                    Box(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(120.dp)
                            .height(120.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCABA98),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp)
                    ){
                        OutlinedButton(
                            onClick = { println("Pressed!") },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .width(120.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(0xFFFDF1DC),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.d4),
                            contentDescription = "d4",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(Alignment.Center)

                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            "D4",
                            color = Color(0xFF58180D),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                // D6
                Column(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                ){
                    Box(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(120.dp)
                            .height(120.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCABA98),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp)
                    ){
                        OutlinedButton(
                            onClick = { println("Pressed!") },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .width(120.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(0xFFFDF1DC),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.d6),
                            contentDescription = "d6",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(Alignment.Center)

                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            "D6",
                            color = Color(0xFF58180D),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                // D8
                Column(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                ){
                    Box(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(120.dp)
                            .height(120.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCABA98),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp)
                    ){
                        OutlinedButton(
                            onClick = { println("Pressed!") },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .width(120.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(0xFFFDF1DC),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.d8),
                            contentDescription = "d8",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(Alignment.Center)

                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            "D8",
                            color = Color(0xFF58180D),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

            // Кубики d10, d12, d20
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            ){
                // D10
                Column(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                ){
                    Box(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(120.dp)
                            .height(120.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCABA98),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp)
                    ){
                        OutlinedButton(
                            onClick = { println("Pressed!") },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .width(120.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(0xFFFDF1DC),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.d10),
                            contentDescription = "d10",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(Alignment.Center)

                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            "D10",
                            color = Color(0xFF58180D),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                // D12
                Column(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                ){
                    Box(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(120.dp)
                            .height(120.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCABA98),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp)
                    ){
                        OutlinedButton(
                            onClick = { println("Pressed!") },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .width(120.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(0xFFFDF1DC),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.d12),
                            contentDescription = "d12",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(Alignment.Center)

                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            "D12",
                            color = Color(0xFF58180D),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                // D20
                Column(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                ){
                    Box(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(120.dp)
                            .height(120.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCABA98),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp)
                    ){
                        OutlinedButton(
                            onClick = { println("Pressed!") },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .width(120.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(0xFFFDF1DC),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.d20),
                            contentDescription = "d20",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(Alignment.Center)

                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            "D20",
                            color = Color(0xFF58180D),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

            // Кубики d100
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            ){
                // D100
                Column(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                ){
                    Box(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(120.dp)
                            .height(120.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCABA98),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp)
                    ){
                        OutlinedButton(
                            onClick = { println("Pressed!") },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .width(120.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(0xFFFDF1DC),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.d100),
                            contentDescription = "d100",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(Alignment.Center)

                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 40.dp)
                    ){
                        Text(
                            "D100",
                            color = Color(0xFF58180D),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

            // Результат
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 11.dp, end = 11.dp)
                    .fillMaxWidth()
            ){
                Text("Результат:",
                    color = Color(0xFF58180D),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 17.dp, bottom = 17.dp, end = 27.dp)
                )
                Surface(
                    shape = RoundedCornerShape(2.dp),
                    color = Color(0xFFFFD489),
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCABA98),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(
                            color = Color(0xFFFFD489),
                            shape = RoundedCornerShape(8.dp)
                        )
                ){
                    Column(
                        modifier = Modifier
                            .padding(vertical = 18.dp, horizontal = 28.dp)
                    ){
                        Text(
                            "20",
                            color = Color(0xFF46130A),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }

        // Кнопка Бросить
        OutlinedButton(
            onClick = { println("Pressed!") },
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
                painter = painterResource(id = R.drawable.cube),
                contentDescription = "BackArrow",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(end = 9.dp)
                    .width(18.dp)
                    .height(18.dp)
            )
            Text(
                "Бросить",
                color = Color(0xFF46130A),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}