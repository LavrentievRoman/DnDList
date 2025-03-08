package ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.content.Context
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListofCharactersViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<CharacterData>>(listOf())
    val characters = _characters.asStateFlow()

    private val sharedPrefsKey = "saved_characters"

    fun loadCharacters(context: Context) {
        val prefs = context.getSharedPreferences("character_prefs", Context.MODE_PRIVATE)
        val json = prefs.getString(sharedPrefsKey, null)

        if (!json.isNullOrEmpty()) {
            _characters.value = Json.decodeFromString(json)
        }
    }

    fun saveCharacter(context: Context, character: CharacterData) {
        viewModelScope.launch {
            val updatedList = _characters.value + character
            _characters.value = updatedList

            val prefs = context.getSharedPreferences("character_prefs", Context.MODE_PRIVATE)
            prefs.edit()
                .putString(sharedPrefsKey, Json.encodeToString(updatedList))
                .apply()
        }
    }

    fun deleteCharacter(context: Context, index: Int) {
        viewModelScope.launch {
            val updatedList = _characters.value.toMutableList().apply { removeAt(index) }
            _characters.value = updatedList

            val prefs = context.getSharedPreferences("character_prefs", Context.MODE_PRIVATE)
            prefs.edit()
                .putString(sharedPrefsKey, Json.encodeToString(updatedList))
                .apply()
        }
    }

    fun clearCharactersIfFirstRun(context: Context) {
        val prefs = context.getSharedPreferences("character_prefs", Context.MODE_PRIVATE)
        val isFirstRun = prefs.getBoolean("is_first_run", true)

        if (isFirstRun) {
            prefs.edit().remove("saved_characters").apply() // Удаляем сохранённых персонажей
            prefs.edit().putBoolean("is_first_run", false).apply() // Запоминаем, что запуск был
            println("Первый запуск: данные очищены")
        } else {
            println("Не первый запуск: данные не трогаем")
        }
    }
}
