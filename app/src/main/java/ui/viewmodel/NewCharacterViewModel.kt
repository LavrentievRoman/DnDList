package ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewCharacterViewModel : ViewModel()
{
    private val _characterName = MutableStateFlow("Имя персонажа")
    val characterName = _characterName.asStateFlow()

    private val _characterRace = MutableStateFlow("Раса")
    val characterRace = _characterRace.asStateFlow()

    private val _characterWorldview = MutableStateFlow("Мировоззрение")
    val characterWorldview = _characterWorldview.asStateFlow()

    private val _characterExperience = MutableStateFlow("Опыт")
    val characterExperience = _characterExperience.asStateFlow()
    
    fun updateCharacterName(newName: String) {
        if (newName.all { it.isLetter() || it.isWhitespace() }) {
            _characterName.value = newName
        }
    }

    fun updateCharacterRace(newRace: String) {
        if (newRace.all { it.isLetter() || it.isWhitespace() }) {
            _characterRace.value = newRace
        }
    }

    fun updateCharacterExperience(newExp: String) {
        _characterExperience.value = newExp
    }

    fun updateCharacterWorldview(newView: String) {
        if (newView.all { it.isLetter() || it.isWhitespace() }) {
            _characterWorldview.value = newView
        }
    }


    private val _strength = MutableStateFlow("10")
    val strength = _strength.asStateFlow()
    private val _strengthModifier = MutableStateFlow(calculateModifier(10))
    val strengthModifier = _strengthModifier.asStateFlow()

    private val _dexterity = MutableStateFlow("10")
    val dexterity = _dexterity.asStateFlow()
    private val _dexterityModifier = MutableStateFlow(calculateModifier(10))
    val dexterityModifier = _dexterityModifier.asStateFlow()

    private val _endurance = MutableStateFlow("10")
    val endurance = _endurance.asStateFlow()
    private val _enduranceModifier = MutableStateFlow(calculateModifier(10))
    val enduranceModifier = _enduranceModifier.asStateFlow()

    private val _intelligence = MutableStateFlow("10")
    val intelligence = _intelligence.asStateFlow()
    private val _intelligenceModifier = MutableStateFlow(calculateModifier(10))
    val intelligenceModifier = _intelligenceModifier.asStateFlow()

    private val _wisdom = MutableStateFlow("10")
    val wisdom = _wisdom.asStateFlow()
    private val _wisdomModifier = MutableStateFlow(calculateModifier(10))
    val wisdomModifier = _wisdomModifier.asStateFlow()

    private val _charisma = MutableStateFlow("10")
    val charisma = _charisma.asStateFlow()
    private val _charismaModifier = MutableStateFlow(calculateModifier(10))
    val charismaModifier = _charismaModifier.asStateFlow()

    fun updateStrength(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 99)) {
            _strength.value = newValue
            _strengthModifier.value = if (newValue.isEmpty()) "" else calculateModifier(newValue.toInt())
        }
    }

    fun updateDexterity(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 99)) {
            _dexterity.value = newValue
            _dexterityModifier.value = if (newValue.isEmpty()) "" else calculateModifier(newValue.toInt())

            updateAcrobaticsModifier()
            updateStealthModifier()
        }
    }

    fun updateEndurance(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 99)) {
            _endurance.value = newValue
            _enduranceModifier.value = if (newValue.isEmpty()) "" else calculateModifier(newValue.toInt())

            updateMaxHp()
        }
    }

    fun updateIntelligence(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 99)) {
            _intelligence.value = newValue
            _intelligenceModifier.value = if (newValue.isEmpty()) "" else calculateModifier(newValue.toInt())

            updateAnalysisModifier()
            updateHistoryModifier()

            updateMaxMp()
        }
    }

    fun updateWisdom(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 99)) {
            _wisdom.value = newValue
            _wisdomModifier.value = if (newValue.isEmpty()) "" else calculateModifier(newValue.toInt())

            updateAttentivenessModifier()
            updateMedicineModifier()
        }
    }

    fun updateCharisma(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 99)) {
            _charisma.value = newValue
            _charismaModifier.value = if (newValue.isEmpty()) "" else calculateModifier(newValue.toInt())

            updateDeceptionModifier()
            updateConvictionModifier()
        }
    }

    // Функция вычисления модификатора
    private fun calculateModifier(score: Int): String {
        val mod = (score - 10) / 2
        return if (mod >= 0) "+$mod" else mod.toString()
    }


    private val proficiencyBonus = 2 // Бонус мастерства

    private val _acrobaticsChecked = MutableStateFlow(false)
    val acrobaticsChecked = _acrobaticsChecked.asStateFlow()
    private val _acrobaticsModifier = MutableStateFlow("")
    val acrobaticsModifier = _acrobaticsModifier.asStateFlow()

    private val _stealthChecked = MutableStateFlow(false)
    val stealthChecked = _stealthChecked.asStateFlow()
    private val _stealthModifier = MutableStateFlow("")
    val stealthModifier = _stealthModifier.asStateFlow()

    private val _analysisChecked = MutableStateFlow(false)
    val analysisChecked = _analysisChecked.asStateFlow()
    private val _analysisModifier = MutableStateFlow("")
    val analysisModifier = _analysisModifier.asStateFlow()

    private val _historyChecked = MutableStateFlow(false)
    val historyChecked = _historyChecked.asStateFlow()
    private val _historyModifier = MutableStateFlow("")
    val historyModifier = _historyModifier.asStateFlow()

    private val _attentivenessChecked = MutableStateFlow(false)
    val attentivenessChecked = _attentivenessChecked.asStateFlow()
    private val _attentivenessModifier = MutableStateFlow("")
    val attentivenessModifier = _attentivenessModifier.asStateFlow()

    private val _medicineChecked = MutableStateFlow(false)
    val medicineChecked = _medicineChecked.asStateFlow()
    private val _medicineModifier = MutableStateFlow("")
    val medicineModifier = _medicineModifier.asStateFlow()

    private val _deceptionChecked = MutableStateFlow(false)
    val deceptionChecked = _deceptionChecked.asStateFlow()
    private val _deceptionModifier = MutableStateFlow("")
    val deceptionModifier = _deceptionModifier.asStateFlow()

    private val _convictionChecked = MutableStateFlow(false)
    val convictionChecked = _convictionChecked.asStateFlow()
    private val _convictionModifier = MutableStateFlow("")
    val convictionModifier = _convictionModifier.asStateFlow()

    fun toggleAcrobatics(isChecked: Boolean) {
        _acrobaticsChecked.value = isChecked
        updateAcrobaticsModifier()
    }

    private fun updateAcrobaticsModifier() {
        _acrobaticsModifier.value = if (_acrobaticsChecked.value && _dexterityModifier.value.isNotEmpty()) {
            val baseMod = _dexterityModifier.value.toInt()
            val finalMod = baseMod + proficiencyBonus
            if (finalMod >= 0) "+$finalMod" else finalMod.toString()
        } else {
            ""
        }
    }

    fun toggleStealth(isChecked: Boolean) {
        _stealthChecked.value = isChecked
        updateStealthModifier()
    }

    private fun updateStealthModifier() {
        _stealthModifier.value = if (_stealthChecked.value && _dexterityModifier.value.isNotEmpty()) {
            val baseMod = _dexterityModifier.value.toInt()
            val finalMod = baseMod + proficiencyBonus
            if (finalMod >= 0) "+$finalMod" else finalMod.toString()
        } else {
            ""
        }
    }

    fun toggleAnalysis(isChecked: Boolean) {
        _analysisChecked.value = isChecked
        updateAnalysisModifier()
    }

    private fun updateAnalysisModifier() {
        _analysisModifier.value = if (_analysisChecked.value && _intelligenceModifier.value.isNotEmpty()) {
            val baseMod = _intelligenceModifier.value.toInt()
            val finalMod = baseMod + proficiencyBonus
            if (finalMod >= 0) "+$finalMod" else finalMod.toString()
        } else {
            ""
        }
    }

    fun toggleHistory(isChecked: Boolean) {
        _historyChecked.value = isChecked
        updateHistoryModifier()
    }

    private fun updateHistoryModifier() {
        _historyModifier.value = if (_historyChecked.value && _intelligenceModifier.value.isNotEmpty()) {
            val baseMod = _intelligenceModifier.value.toInt()
            val finalMod = baseMod + proficiencyBonus
            if (finalMod >= 0) "+$finalMod" else finalMod.toString()
        } else {
            ""
        }
    }

    fun toggleAttentiveness(isChecked: Boolean) {
        _attentivenessChecked.value = isChecked
        updateAttentivenessModifier()
    }

    private fun updateAttentivenessModifier() {
        _attentivenessModifier.value = if (_attentivenessChecked.value && _wisdomModifier.value.isNotEmpty()) {
            val baseMod = _wisdomModifier.value.toInt()
            val finalMod = baseMod + proficiencyBonus
            if (finalMod >= 0) "+$finalMod" else finalMod.toString()
        } else {
            ""
        }
    }

    fun toggleMedicine(isChecked: Boolean) {
        _medicineChecked.value = isChecked
        updateMedicineModifier()
    }

    private fun updateMedicineModifier() {
        _medicineModifier.value = if (_medicineChecked.value && _wisdomModifier.value.isNotEmpty()) {
            val baseMod = _wisdomModifier.value.toInt()
            val finalMod = baseMod + proficiencyBonus
            if (finalMod >= 0) "+$finalMod" else finalMod.toString()
        } else {
            ""
        }
    }

    fun toggleDeception(isChecked: Boolean) {
        _deceptionChecked.value = isChecked
        updateDeceptionModifier()
    }

    private fun updateDeceptionModifier() {
        _deceptionModifier.value = if (_deceptionChecked.value && _charismaModifier.value.isNotEmpty()) {
            val baseMod = _charismaModifier.value.toInt()
            val finalMod = baseMod + proficiencyBonus
            if (finalMod >= 0) "+$finalMod" else finalMod.toString()
        } else {
            ""
        }
    }

    fun toggleConviction(isChecked: Boolean) {
        _convictionChecked.value = isChecked
        updateConvictionModifier()
    }

    private fun updateConvictionModifier() {
        _convictionModifier.value = if (_acrobaticsChecked.value && _charismaModifier.value.isNotEmpty()) {
            val baseMod = _charismaModifier.value.toInt()
            val finalMod = baseMod + proficiencyBonus
            if (finalMod >= 0) "+$finalMod" else finalMod.toString()
        } else {
            ""
        }
    }


    private val _otherAbilities = MutableStateFlow("Дополнительные способности")
    val otherAbilities = _otherAbilities.asStateFlow()

    fun updateOtherAbilities(newAbil: String) {
        _otherAbilities.value = newAbil
    }


    private val _maxHp = MutableStateFlow("10")
    val maxHp = _maxHp.asStateFlow()
    private val _currentHp = MutableStateFlow("10")
    val currentHp = _currentHp.asStateFlow()

    private val _maxMp = MutableStateFlow("10")
    val maxMp = _maxMp.asStateFlow()
    private val _currentMp = MutableStateFlow("10")
    val currentMp = _currentMp.asStateFlow()

    private fun updateMaxHp() {
        if (_enduranceModifier.value.isNotEmpty()) {
            val mod = _enduranceModifier.value.toInt()
            val hp = 10 + mod
            _maxHp.value = hp.toString()
            _currentHp.value = hp.toString()
        } else {
            _maxHp.value = ""
            _currentHp.value = ""
        }
    }

    private fun updateMaxMp() {
        if (_intelligenceModifier.value.isNotEmpty()) {
            val mod = _intelligenceModifier.value.toInt()
            val mp = 10 + mod
            _maxMp.value = mp.toString()
            _currentMp.value = mp.toString()
        } else {
            _maxMp.value = ""
            _currentMp.value = ""
        }
    }

    fun updateCurrentHp(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= (_maxHp.value.toIntOrNull() ?: 0))) {
            _currentHp.value = newValue
        }
    }

    fun updateCurrentMp(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= (_maxMp.value.toIntOrNull() ?: 0))) {
            _currentMp.value = newValue
        }
    }


    private val _attacks = MutableStateFlow(listOf(Attack()))
    val attacks = _attacks.asStateFlow()

    fun addAttack() {
        _attacks.value += Attack()
    }

    fun updateAttack(index: Int, name: String? = null, bonus: String? = null, damage: String? = null) {
        _attacks.value = _attacks.value.mapIndexed { i, attack ->
            if (i == index) {
                attack.copy(
                    name = name ?: attack.name,
                    bonus = bonus ?: attack.bonus,
                    damage = damage ?: attack.damage
                )
            } else attack
        }
    }


    private val _inventoryItems = MutableStateFlow(listOf(InventoryItem()))
    val inventoryItems = _inventoryItems.asStateFlow()

    fun addInventoryItem() {
        _inventoryItems.value += InventoryItem() // Добавляем новую атаку
    }

    fun updateInventoryItem(index: Int, name: String? = null, count: String? = null) {
        _inventoryItems.value = _inventoryItems.value.mapIndexed { i, item ->
            if (i == index) {
                item.copy(
                    name = name ?: item.name,
                    count = count ?: item.count,
                )
            } else item
        }
    }


    private val _gold = MutableStateFlow("0")
    val gold = _gold.asStateFlow()

    private val _silver = MutableStateFlow("0")
    val silver = _silver.asStateFlow()

    private val _copper = MutableStateFlow("0")
    val copper = _copper.asStateFlow()

    fun updateGold(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 999))
        {
            _gold.value = newValue
        }
    }

    fun updateSilver(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 999))
        {
            _silver.value = newValue
        }
    }
    fun updateCopper(newValue: String) {
        if (newValue.all { it.isDigit() } && (newValue.isEmpty() || newValue.toInt() <= 999))
        {
            _copper.value = newValue
        }
    }


    fun getCharacter() : CharacterData {
        val character = CharacterData(
            name = _characterName.value,
            race = _characterRace.value,
            experience = _characterExperience.value.toIntOrNull()?.toString() ?: "0",
            strength = _strength.value,
            dexterity = _dexterity.value,
            endurance = _endurance.value,
            intelligence = _intelligence.value,
            wisdom = _wisdom.value,
            charisma = _charisma.value,
            maxHp = _maxHp.value,
            currentHp = _currentHp.value,
            maxMp = _maxMp.value,
            currentMp = _currentMp.value,
            attacks = _attacks.value,
            inventory = _inventoryItems.value,
            gold = _gold.value,
            silver = _silver.value,
            copper = _copper.value
        )

        return character
    }
}
