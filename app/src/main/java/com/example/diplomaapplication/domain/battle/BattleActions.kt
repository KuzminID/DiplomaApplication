package com.example.diplomaapplication.domain.battle

enum class BattleActions(val actionName : String) {
    Attack("Атака"),
    Defend("Защита"),
    UsePotion("Использование зелья"),
    RunAway("Сбежать")
}