package ui.screen

import androidx.lifecycle.viewmodel.compose.viewModel
import ui.viewmodel.NewCharacterViewModel
import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.dnd_characterlist.R
import ui.viewmodel.ListofCharactersViewModel

@Composable
fun NewCharacterCreationScreen(
    navController: NavController,
    viewModel: NewCharacterViewModel = viewModel(),
    listViewModel: ListofCharactersViewModel = viewModel()
) {
    val characterName by viewModel.characterName.collectAsState()
    val characterRace by viewModel.characterRace.collectAsState()
    val characterExperience by viewModel.characterExperience.collectAsState()
    val characterWorldview by viewModel.characterWorldview.collectAsState()


    val strength by viewModel.strength.collectAsState()
    val strengthModifier by viewModel.strengthModifier.collectAsState()

    val dexterity by viewModel.dexterity.collectAsState()
    val dexterityModifier by viewModel.dexterityModifier.collectAsState()

    val endurance by viewModel.endurance.collectAsState()
    val enduranceModifier by viewModel.enduranceModifier.collectAsState()

    val intelligence by viewModel.intelligence.collectAsState()
    val intelligenceModifier by viewModel.intelligenceModifier.collectAsState()

    val wisdom by viewModel.wisdom.collectAsState()
    val wisdomModifier by viewModel.wisdomModifier.collectAsState()

    val charisma by viewModel.charisma.collectAsState()
    val charismaModifier by viewModel.charismaModifier.collectAsState()


    val acrobaticsChecked by viewModel.acrobaticsChecked.collectAsState()
    val acrobaticsModifier by viewModel.acrobaticsModifier.collectAsState()

    val stealthChecked by viewModel.stealthChecked.collectAsState()
    val stealthModifier by viewModel.stealthModifier.collectAsState()

    val analysisChecked by viewModel.analysisChecked.collectAsState()
    val analysisModifier by viewModel.analysisModifier.collectAsState()

    val historyChecked by viewModel.historyChecked.collectAsState()
    val historyModifier by viewModel.historyModifier.collectAsState()

    val attentivenessChecked by viewModel.attentivenessChecked.collectAsState()
    val attentivenessModifier by viewModel.attentivenessModifier.collectAsState()

    val medicineChecked by viewModel.medicineChecked.collectAsState()
    val medicineModifier by viewModel.medicineModifier.collectAsState()

    val deceptionChecked by viewModel.deceptionChecked.collectAsState()
    val deceptionModifier by viewModel.deceptionModifier.collectAsState()

    val convictionChecked by viewModel.convictionChecked.collectAsState()
    val convictionModifier by viewModel.convictionModifier.collectAsState()


    val otherAbilities by viewModel.otherAbilities.collectAsState()


    val maxHp by viewModel.maxHp.collectAsState()
    val currentHp by viewModel.currentHp.collectAsState()

    val maxMp by viewModel.maxMp.collectAsState()
    val currentMp by viewModel.currentMp.collectAsState()


    val attacks by viewModel.attacks.collectAsState()


    val inventoryItems by viewModel.inventoryItems.collectAsState()


    val gold by viewModel.gold.collectAsState()
    val silver by viewModel.silver.collectAsState()
    val copper by viewModel.copper.collectAsState()


    val context = LocalContext.current

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
                    .padding(end = 35.dp, start = 5.dp)
                    .width(48.dp)
                    .height(48.dp)
            ){ // Кнопка Назад
                OutlinedButton(
                    onClick = { navController.navigate("List of Character") },
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
            Text("Новый лист персонажа",
                color = Color(0xFF46130A),
                fontSize = 22.sp,
            )
        }

        // Лист персонажа
        Column(
            modifier = Modifier
                .padding(top = 75.dp, bottom = 70.dp, start = 5.dp, end = 5.dp)
                .fillMaxSize()
                .background(
                    color = Color(0xFFFDF1DC),
                )
                .verticalScroll(rememberScrollState())
        ){
            // Поля для ввода
            Box(
                modifier = Modifier
                    .padding(start = 9.dp, end = 9.dp, bottom = 9.dp, top = 9.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCDA144),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .height(45.dp)
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 15.dp)
            ){ // Поле ввода "Имя персонажа"
                BasicTextField(
                    value = characterName,
                    onValueChange = { viewModel.updateCharacterName(it) },
                    textStyle = TextStyle(
                        color = Color(0xFFADADAD),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart)
                )
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 5.dp, start = 9.dp, end = 9.dp)
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .weight(1f)
                ){
                    Box(
                        modifier = Modifier
                            .padding(bottom = 9.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCDA144),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clip(shape = RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .height(45.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 15.dp)
                    ){ // Поле ввода "Раса"
                        BasicTextField(
                            value = characterRace,
                            onValueChange = { viewModel.updateCharacterRace(it) },
                            textStyle = TextStyle(
                                color = Color(0xFFADADAD),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterStart)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(bottom = 9.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCDA144),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clip(shape = RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .height(45.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 15.dp)
                    ){ // Поле ввода "Мировоззренние"
                        BasicTextField(
                            value = characterWorldview,
                            onValueChange = { viewModel.updateCharacterWorldview(it) },
                            textStyle = TextStyle(
                                color = Color(0xFFADADAD),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterStart)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(bottom = 9.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCDA144),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clip(shape = RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .height(45.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 15.dp)
                    ){ // Поле ввода "Опыт"
                        BasicTextField(
                            value = characterExperience,
                            onValueChange = { viewModel.updateCharacterExperience(it) },
                            textStyle = TextStyle(
                                color = Color(0xFFADADAD),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterStart)
                        )
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.playerimage),
                    contentDescription = "PlayerImage",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(153.dp)
                        .height(153.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCDA144),
                            shape = RoundedCornerShape(8.dp)
                        )
                )
            }

            // Характеристики, навыки, умения
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 5.dp, start = 9.dp, end = 9.dp)
                    .fillMaxWidth()
            ){
                // Характеристики
                Column(
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCDA144),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(shape = RoundedCornerShape(8.dp))
                        .padding(vertical = 5.dp)
                ){
                    Text("Характеристики",
                        color = Color(0xFF58180D),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 7.dp, start = 11.dp, end = 11.dp)
                    )

                    // Сила
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 7.dp, start = 8.dp, end = 8.dp)
                    ){
                        Surface( // Название
                            shape = RoundedCornerShape(2.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .wrapContentSize()
                        ){
                            Text(
                                text = "СИЛ",
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(vertical = 8.dp, horizontal = 11.dp)
                            )
                        }
                        Box( // Поле для ввода
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFCABA98),
                                    shape = RoundedCornerShape(100.dp)
                                )
                        ){
                            BasicTextField(
                                value = strength,
                                onValueChange = { viewModel.updateStrength(it) },
                                textStyle = TextStyle(
                                    color = Color(0xFFADADAD),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 8.dp)
                                    .width(35.dp)
                            )
                        }
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(47.dp)
                        ){
                            Text(
                                text = strengthModifier,
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            )
                        }
                    }

                    // Ловкость
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 7.dp, start = 8.dp, end = 8.dp)
                    ){
                        Surface( // Название
                            shape = RoundedCornerShape(2.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .wrapContentSize()
                        ){
                            Text(
                                text = "ЛВК",
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(vertical = 8.dp, horizontal = 11.dp)
                            )
                        }
                        Box( // Поле для ввода
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFCABA98),
                                    shape = RoundedCornerShape(100.dp)
                                )
                        ){
                            BasicTextField(
                                value = dexterity,
                                onValueChange = { viewModel.updateDexterity(it) },
                                textStyle = TextStyle(
                                    color = Color(0xFFADADAD),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 8.dp)
                                    .width(35.dp)
                            )
                        }
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(47.dp)
                        ){
                            Text(
                                text = dexterityModifier,
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
                            )
                        }
                    }

                    // Выносливость
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 7.dp, start = 8.dp, end = 8.dp)
                    ){
                        Surface( // Название
                            shape = RoundedCornerShape(2.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .wrapContentSize()
                        ){
                            Text(
                                text = "ВНС",
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(vertical = 8.dp, horizontal = 11.dp)
                            )
                        }
                        Box( // Поле для ввода
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFCABA98),
                                    shape = RoundedCornerShape(100.dp)
                                )
                        ){
                            BasicTextField(
                                value = endurance,
                                onValueChange = { viewModel.updateEndurance(it) },
                                textStyle = TextStyle(
                                    color = Color(0xFFADADAD),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 8.dp)
                                    .width(35.dp)
                            )
                        }
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(47.dp)
                        ){
                            Text(
                                text = enduranceModifier,
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
                            )
                        }
                    }

                    // Интелект
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 7.dp, start = 8.dp, end = 8.dp)
                    ){
                        Surface( // Название
                            shape = RoundedCornerShape(2.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .wrapContentSize()
                        ){
                            Text(
                                text = "ИНТ",
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 11.dp)
                            )
                        }
                        Box( // Поле для ввода
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFCABA98),
                                    shape = RoundedCornerShape(100.dp)
                                )
                        ){
                            BasicTextField(
                                value = intelligence,
                                onValueChange = { viewModel.updateIntelligence(it) },
                                textStyle = TextStyle(
                                    color = Color(0xFFADADAD),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 8.dp)
                                    .width(35.dp)
                            )
                        }
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(47.dp)
                        ){
                            Text(
                                text = intelligenceModifier,
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
                            )
                        }
                    }

                    // Мудрость
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 7.dp, start = 8.dp, end = 8.dp)
                    ){
                        Surface( // Название
                            shape = RoundedCornerShape(2.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .wrapContentSize()
                        ){
                            Text(
                                text = "МДР",
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(vertical = 8.dp, horizontal = 9.dp)
                            )
                        }
                        Box( // Поле для ввода
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFCABA98),
                                    shape = RoundedCornerShape(100.dp)
                                )
                        ){
                            BasicTextField(
                                value = wisdom,
                                onValueChange = { viewModel.updateWisdom(it) },
                                textStyle = TextStyle(
                                    color = Color(0xFFADADAD),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 8.dp)
                                    .width(35.dp)
                            )
                        }
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(47.dp)
                        ){
                            Text(
                                text = wisdomModifier,
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
                            )
                        }
                    }

                    // Харизма
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp, bottom = 7.dp)
                    ){
                        Surface( // Название
                            shape = RoundedCornerShape(2.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .wrapContentSize()
                        ){
                            Text(
                                text = "ХАР",
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(vertical = 8.dp, horizontal = 12.dp)
                            )
                        }
                        Box( // Поле для ввода
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFCABA98),
                                    shape = RoundedCornerShape(100.dp)
                                )
                        ){
                            BasicTextField(
                                value = charisma,
                                onValueChange = { viewModel.updateCharisma(it) },
                                textStyle = TextStyle(
                                    color = Color(0xFFADADAD),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 8.dp)
                                    .width(35.dp)
                            )
                        }
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(47.dp)
                        ){
                            Text(
                                text = charismaModifier,
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
                            )
                        }
                    }
                }

                // Навыки
                Column(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCDA144),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(shape = RoundedCornerShape(8.dp))
                        .weight(1f)
                        .padding(vertical = 6.dp)
                ){
                    Text(
                        text = "Навыки",
                        color = Color(0xFF58180D),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )

                    // Акробатика
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Checkbox(
                            checked = acrobaticsChecked,
                            onCheckedChange = { viewModel.toggleAcrobatics(it) },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF58180D),
                                uncheckedColor = Color(0xFF58180D),
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = "Акробатика",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 9.dp, bottom = 9.dp)
                                .width(120.dp)
                        )
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(39.dp)
                        ){
                            Text(
                                text = acrobaticsModifier,
                                color = Color(0xFF461209),
                                fontSize = 13.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                            )
                        }
                    }

                    // Скрытность
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Checkbox(
                            checked = stealthChecked,
                            onCheckedChange = { viewModel.toggleStealth(it) },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF58180D),
                                uncheckedColor = Color(0xFF58180D),
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = "Скрытность",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 9.dp, bottom = 9.dp)
                                .width(120.dp)
                        )
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(39.dp)
                        ){
                            Text(
                                text = stealthModifier,
                                color = Color(0xFF461209),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                            )
                        }
                    }

                    // Анализ
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Checkbox(
                            checked = analysisChecked,
                            onCheckedChange = { viewModel.toggleAnalysis(it) },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF58180D),
                                uncheckedColor = Color(0xFF58180D),
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = "Анализ",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 9.dp, bottom = 9.dp)
                                .width(120.dp)
                        )
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(39.dp)
                        ){
                            Text(
                                text = analysisModifier,
                                color = Color(0xFF461209),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                            )
                        }
                    }

                    // История
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Checkbox(
                            checked = historyChecked,
                            onCheckedChange = { viewModel.toggleHistory(it) },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF58180D),
                                uncheckedColor = Color(0xFF58180D),
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = "История",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 9.dp, bottom = 9.dp)
                                .width(120.dp)
                        )
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(39.dp)
                        ){
                            Text(
                                text = historyModifier,
                                color = Color(0xFF461209),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                            )
                        }
                    }

                    // Внимательность
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Checkbox(
                            checked = attentivenessChecked,
                            onCheckedChange = { viewModel.toggleAttentiveness(it) },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF58180D),
                                uncheckedColor = Color(0xFF58180D),
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = "Внимательность",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 9.dp, bottom = 9.dp)
                                .width(120.dp)
                        )
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(39.dp)
                        ){
                            Text(
                                text = attentivenessModifier,
                                color = Color(0xFF461209),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                            )
                        }
                    }

                    // Медицина
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Checkbox(
                            checked = medicineChecked,
                            onCheckedChange = { viewModel.toggleMedicine(it) },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF58180D),
                                uncheckedColor = Color(0xFF58180D),
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = "Медицина",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 9.dp, bottom = 9.dp)
                                .width(120.dp)
                        )
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(39.dp)
                        ){
                            Text(
                                text = medicineModifier,
                                color = Color(0xFF461209),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                            )
                        }
                    }

                    // Обман
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Checkbox(
                            checked = deceptionChecked,
                            onCheckedChange = { viewModel.toggleDeception(it) },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF58180D),
                                uncheckedColor = Color(0xFF58180D),
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = "Обман",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 9.dp, bottom = 9.dp)
                                .width(120.dp)
                        )
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(39.dp)
                        ){
                            Text(
                                text = deceptionModifier,
                                color = Color(0xFF461209),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                            )
                        }
                    }

                    // Убеждение
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Checkbox(
                            checked = convictionChecked,
                            onCheckedChange = { viewModel.toggleConviction(it) },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF58180D),
                                uncheckedColor = Color(0xFF58180D),
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = "Убеждение",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 9.dp, bottom = 9.dp)
                                .width(120.dp)
                        )
                        Surface( // Модификатор
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .width(39.dp)
                        ){
                            Text(
                                text = convictionModifier,
                                color = Color(0xFF461209),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                            )
                        }
                    }

                }
            }

            // Прочие способности
            Column(
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 9.dp, end = 9.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCDA144),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(vertical = 7.dp)
            ){
                Text("Прочие способности",
                    color = Color(0xFF58180D),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 6.dp, start = 8.dp)
                )
                Box( // Поле для ввода
                    modifier = Modifier
                        .padding(end = 5.dp, start = 5.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCABA98),
                            shape = RoundedCornerShape(8.dp)
                        )
                ){
                    BasicTextField(
                        value = otherAbilities,
                        onValueChange = { viewModel.updateOtherAbilities(it) },
                        textStyle = TextStyle(
                            color = Color(0xFFADADAD),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .align(Alignment.TopStart)
                    )
                }
            }

            // Здоровье, Мана
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 9.dp, end = 9.dp)
                    .fillMaxWidth()
            ){
                // Здоровье
                Column(
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCDA144),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(shape = RoundedCornerShape(8.dp))
                        .weight(1f)
                        .padding(vertical = 7.dp)
                ){
                    Text("Здоровье",
                        color = Color(0xFF58180D),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 1.dp, start = 7.dp)
                    )

                    Row( // Пояснения
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 2.dp, start = 6.dp, end = 6.dp)
                            .fillMaxWidth()
                            .padding(top = 4.dp, end = 36.dp)
                    ){
                        Text("Тек.",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Text("Макс.",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Row( // Значения
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .fillMaxWidth()
                    ){
                        Box( // Поле для ввода текущего значения
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFCABA98),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ){
                            BasicTextField(
                                value = currentHp,
                                onValueChange = { viewModel.updateCurrentHp(it) },
                                textStyle = TextStyle(
                                    color = Color(0xFFADADAD),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .width(75.dp)
                            )
                        }
                        Text("/",
                            color = Color(0xFF58180D),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 4.dp, bottom = 4.dp, start = 10.dp, end = 10.dp)
                        )
                        Surface( // Максимальное здоровье
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .wrapContentSize()
                        ){
                            Text(
                                text = maxHp,
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .width(80.dp)
                            )
                        }
                    }
                }

                // Мана
                Column(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCDA144),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(shape = RoundedCornerShape(8.dp))
                        .weight(1f)
                        .padding(vertical = 7.dp)
                ){
                    Text("Мана",
                        color = Color(0xFF58180D),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 1.dp, start = 7.dp)
                    )

                    Row( // Пояснения
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 2.dp, start = 6.dp, end = 6.dp)
                            .fillMaxWidth()
                            .padding(top = 4.dp, end = 36.dp)
                    ){
                        Text("Тек.",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Text("Макс.",
                            color = Color(0xFF58180D),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Row( // Значения
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .fillMaxWidth()
                    ){
                        Box( // Поле для ввода текущего значения
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFCABA98),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ){
                            BasicTextField(
                                value = currentMp,
                                onValueChange = { viewModel.updateCurrentMp(it) },
                                textStyle = TextStyle(
                                    color = Color(0xFFADADAD),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .width(75.dp)
                            )
                        }
                        Text("/",
                            color = Color(0xFF58180D),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 4.dp, bottom = 4.dp, start = 10.dp, end = 10.dp)
                        )
                        Surface( // Максимальная мана
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFFFD489),
                            modifier = Modifier
                                .wrapContentSize()
                        ){
                            Text(
                                text = maxMp,
                                color = Color(0xFF461209),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .width(80.dp)
                            )
                        }
                    }
                }
            }

            // Атаки
            Column(
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 9.dp, end = 9.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCDA144),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(vertical = 7.dp, horizontal = 6.dp)
            ){
                Text("Атака",
                    color = Color(0xFF58180D),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 2.dp, start = 3.dp)
                )

                // Таблица
                Column(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                ){
                    // Заголовок
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFD489),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(vertical = 5.dp, horizontal = 8.dp)
                    ){
                        Text(
                            text = "Название",
                            color = Color(0xFF46130A),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 6.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .weight(1f)
                                .padding(vertical = 6.dp)
                        )
                        Text(
                            text = "Бонус",
                            color = Color(0xFF46130A),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(8.dp))
                                .padding(top = 6.dp, bottom = 6.dp, start = 25.dp, end = 7.dp)
                        )
                        Text(
                            text = "Урон",
                            color = Color(0xFF46130A),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(8.dp))
                                .padding(top = 6.dp, bottom = 6.dp, start = 40.dp, end = 7.dp)
                        )
                    }

                    // Строки
                    attacks.forEachIndexed { index, attack ->
                        val rowColor = if (index % 2 == 0) Color(0xFFFADFB0) else Color(0xFFFFD489)

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(horizontal = 2.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .fillMaxWidth()
                                .background(
                                    color = rowColor,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(vertical = 5.dp, horizontal = 8.dp)
                        ){
                            Box( // Поле ввода названия
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFCABA98),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .width(220.dp)
                            ){
                                BasicTextField(
                                    value = attack.name,
                                    onValueChange = { viewModel.updateAttack(index, name = it) },
                                    textStyle = TextStyle(
                                        color = Color(0xFFADADAD),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Start
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 7.dp)
                                        .padding(start = 5.dp, end = 5.dp)
                                )
                            }
                            Box( // Поле ввода бонуса
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFCABA98),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .width(50.dp)
                            ){
                                BasicTextField(
                                    value = attack.bonus,
                                    onValueChange = { viewModel.updateAttack(index, bonus = it) },
                                    textStyle = TextStyle(
                                        color = Color(0xFFADADAD),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.End
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 7.dp)
                                        .padding(start = 5.dp, end = 5.dp)
                                        .align(Alignment.CenterEnd)
                                )
                            }
                            Box( // Поле ввода Урона
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFCABA98),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .width(90.dp)
                            ){
                                BasicTextField(
                                    value = attack.damage,
                                    onValueChange = { viewModel.updateAttack(index, damage = it) },
                                    textStyle = TextStyle(
                                        color = Color(0xFFADADAD),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.End
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 7.dp)
                                        .padding(start = 5.dp, end = 5.dp)
                                        .align(Alignment.CenterEnd)
                                )
                            }
                        }
                    }

                    // Кнопка добавить
                    Box(
                        modifier = Modifier
                            .padding(end = 25.dp)
                            .width(25.dp)
                            .height(25.dp)
                    ){
                        OutlinedButton(
                            onClick = { viewModel.addAttack() },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxSize()
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = "Add",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .align(Alignment.Center)
                                .width(30.dp)
                                .height(30.dp)
                        )
                    }
                }
            }

            // Инвентарь
            Column(
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 9.dp, end = 9.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCDA144),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(vertical = 7.dp, horizontal = 6.dp)
            ){
                Text("Инвентарь ",
                    color = Color(0xFF58180D),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 2.dp, start = 3.dp)
                )

                // Таблица предметов
                Column(
                    modifier = Modifier
                        .padding(bottom = 2.dp)
                        .fillMaxWidth()
                ){
                    // Заголовок
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFD489),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(vertical = 5.dp, horizontal = 8.dp)
                    ){
                        Text(
                            text = "Предмет",
                            color = Color(0xFF46130A),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 6.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .weight(1f)
                                .padding(vertical = 6.dp)
                        )
                        Text(
                            text = "Количество",
                            color = Color(0xFF46130A),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 95.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .weight(1f)
                        )
                    }

                    inventoryItems.forEachIndexed { index, item ->
                        val rowColor = if (index % 2 == 0) Color(0xFFFADFB0) else Color(0xFFFFD489)

                        // 1 строка
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(horizontal = 2.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .fillMaxWidth()
                                .background(
                                    color = rowColor,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(vertical = 5.dp, horizontal = 8.dp)
                        ){
                            Box( // Поле ввода названия
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFCABA98),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .width(270.dp)
                            ){
                                BasicTextField(
                                    value = item.name,
                                    onValueChange = { viewModel.updateInventoryItem(index, name = it) },
                                    textStyle = TextStyle(
                                        color = Color(0xFFADADAD),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Start
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 7.dp)
                                        .padding(start = 5.dp, end = 5.dp)
                                )
                            }
                            Box( // Поле ввода количества
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFCABA98),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .width(90.dp)
                            ){
                                BasicTextField(
                                    value = item.count,
                                    onValueChange = { viewModel.updateInventoryItem(index, count = it) },
                                    textStyle = TextStyle(
                                        color = Color(0xFFADADAD),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.End
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 7.dp)
                                        .padding(start = 5.dp, end = 5.dp)
                                        .align(Alignment.CenterEnd)
                                )
                            }
                        }
                    }

                    // Кнопка добавить
                    Box(
                        modifier = Modifier
                            .padding(end = 25.dp)
                            .width(25.dp)
                            .height(25.dp)
                    ){
                        OutlinedButton(
                            onClick = { viewModel.addInventoryItem() },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxSize()
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = "Add",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .align(Alignment.Center)
                                .width(30.dp)
                                .height(30.dp)
                        )
                    }
                }

                // Деньги
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                ){
                    Text("Деньги",
                        color = Color(0xFF58180D),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 6.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        // Золото
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(end = 18.dp)
                                .weight(1f)
                        ){
                            Text("З",
                                color = Color(0xFF58180D),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 10.dp, bottom = 13.dp, start = 6.dp, end = 10.dp)
                            )
                            Box( // Поле для ввода текущего значения
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 2.dp,
                                        color = Color(0xFFDEBF15),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ){
                                BasicTextField(
                                    value = gold,
                                    onValueChange = { viewModel.updateGold(it) },
                                    textStyle = TextStyle(
                                        color = Color(0xFFADADAD),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 10.dp)
                                        .width(75.dp)
                                )
                            }
                        }

                        // Серебро
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(end = 18.dp)
                                .weight(1f)
                        ){
                            Text("С",
                                color = Color(0xFF58180D),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 10.dp, bottom = 13.dp, start = 6.dp, end = 10.dp)
                            )
                            Box( // Поле для ввода текущего значения
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 2.dp,
                                        color = Color(0xFFB9B6A1),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ){
                                BasicTextField(
                                    value = silver,
                                    onValueChange = { viewModel.updateSilver(it) },
                                    textStyle = TextStyle(
                                        color = Color(0xFFADADAD),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 10.dp)
                                        .width(75.dp)
                                )
                            }
                        }

                        // Медь
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(end = 18.dp)
                                .weight(1f)
                        ){
                            Text("М",
                                color = Color(0xFF58180D),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 10.dp, bottom = 13.dp, start = 6.dp, end = 10.dp)
                            )
                            Box( // Поле для ввода текущего значения
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 2.dp,
                                        color = Color(0xFFEA7C2D),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ){
                                BasicTextField(
                                    value = copper,
                                    onValueChange = { viewModel.updateCopper(it) },
                                    textStyle = TextStyle(
                                        color = Color(0xFFADADAD),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 10.dp)
                                        .width(75.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Кнопка сохранить пероснажа
        OutlinedButton(
            onClick = {
                val character = viewModel.getCharacter()
                listViewModel.saveCharacter(context, character)
                navController.navigate("List of Character")
            },
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
                painter = painterResource(id = R.drawable.save),
                contentDescription = "Save",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(end = 9.dp)
                    .width(18.dp)
                    .height(18.dp)
            )
            Text("Сохранить персонажа",
                color = Color(0xFF46130A),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}