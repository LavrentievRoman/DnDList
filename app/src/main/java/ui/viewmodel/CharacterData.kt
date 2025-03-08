package ui.viewmodel

import kotlinx.serialization.Serializable

@Serializable
data class InventoryItem(
    var name: String = "Предмет",
    var count: String = "1",
)

@Serializable
data class Attack(
    var name: String = "Атака",
    var bonus: String = "+0",
    var damage: String = "d4+3"
)

@Serializable
data class CharacterData(
    val name: String,
    val race: String,
    val experience: String,
    val strength: String,
    val dexterity: String,
    val endurance: String,
    val intelligence: String,
    val wisdom: String,
    val charisma: String,
    val maxHp: String,
    val currentHp: String,
    val maxMp: String,
    val currentMp: String,
    val attacks: List<Attack>,
    val inventory: List<InventoryItem>,
    val gold: String,
    val silver: String,
    val copper: String,
)