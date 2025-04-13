package com.example.diplomaapplication.domain.battle

sealed class BattleState {
    object BeforeBattle : BattleState()
    object InBattle : BattleState()
    object AfterBattle : BattleState()
}