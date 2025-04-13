package com.example.diplomaapplication

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

data class Items(
    val name: String,
    val dropChance: Double
)

@RunWith(AndroidJUnit4::class)
class GenerationUnitTest {
    lateinit var items: List<Items>

    @Before
    fun fillItems() {
        items = listOf(Items("FirstItem", 0.1), Items("SecondItem", 0.07), Items("ThirdItem", 0.3))
    }

    @Test
    fun generationTest() {
        val droppedItems: MutableList<String> = mutableListOf()
        for (i in 0..10000) {
            for (j in 0..2) {
                val random = Random.nextDouble(0.0, 1.0)
                if (random <= items[j].dropChance) {
                    droppedItems.add(items[j].name)
                }
            }
        }
        val droppedCalc: MutableList<Int> = mutableListOf()
        droppedCalc.add(droppedItems.count { it == items[0].name })
        droppedCalc.add(droppedItems.count { it == items[1].name })
        droppedCalc.add(droppedItems.count { it == items[2].name })

        val droppedTheoretic = listOf<Int>(
            (10000.0 * items[0].dropChance).toInt(),
            (10000.0 * items[1].dropChance).toInt(),
            (10000.0 * items[2].dropChance).toInt()
        )
        Log.d("CustomTag", "Theoretic dropped items $droppedTheoretic")
        Log.d("CustomTag", "Practical dropped items $droppedCalc")

        assertEquals(droppedCalc, droppedTheoretic)
    }
}