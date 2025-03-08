package ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dnd_characterlist.R
import ui.viewmodel.ListofCharactersViewModel

@Composable
fun ListOfCharactersScreen(
    navController: NavController,
    listViewModel: ListofCharactersViewModel = viewModel()
) {
    val context = LocalContext.current
    val characters by listViewModel.characters.collectAsState()

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

        LaunchedEffect(Unit) {
            listViewModel.clearCharactersIfFirstRun(context)
            listViewModel.loadCharacters(context) // Загружаем сохранённых персонажей
        }

        // Список персонажей
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, bottom = 100.dp, start = 5.dp, end = 5.dp)
                .verticalScroll(rememberScrollState()),
        ){
            characters.forEachIndexed { index, character ->
                CharacterRow(character, onDelete = { listViewModel.deleteCharacter(context, index) }) {
                    navController.navigate("Browse Character")
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