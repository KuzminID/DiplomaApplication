package com.example.diplomaapplication.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "character",
    foreignKeys = [
        ForeignKey(
            entity = BaseClass::class,
            parentColumns = ["id"],
            childColumns = ["character_class_id"]
        ),
        ForeignKey(
            entity = Stats::class,
            parentColumns = ["id"],
            childColumns = ["character_stats_id"]
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["character_user_id"]
        ),
        ForeignKey(
            entity = CharacterInventory::class,
            parentColumns = ["id"],
            childColumns = ["character_inventory_id"]
        ),
        ForeignKey(
            entity = CharacterSkill::class,
            parentColumns = ["id"],
            childColumns = ["character_skills_id"]
        ),
        ForeignKey(
            entity = Location::class,
            parentColumns = ["id"],
            childColumns = ["character_current_location_id"]
        )
    ]
)
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "character_name")
    val name: String,
    @ColumnInfo(name = "character_level")
    val level: Int = 1,
    @ColumnInfo(name = "character_experience")
    val experience: Int = 0,
    @ColumnInfo(name = "character_class_id")
    val classId: Int,
    @ColumnInfo(name = "character_stats_id")
    val statsId: Int,
    @ColumnInfo(name = "character_gold")
    val gold: Int = 0,
    @ColumnInfo(name = "character_user_id") // Bond with user
    val userId: Int,
    @ColumnInfo(name = "character_inventory_id") // Bond with inventory table
    val inventoryId: Int,
    @ColumnInfo(name = "character_skills_id") // Bond with skills table
    val skillsId: Int,
    @ColumnInfo(name = "character_current_location_id") // Current location
    val locationId: Int
)

@Entity(
    tableName = "known_recipes",
    foreignKeys = [
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"]
        ),
        ForeignKey(entity = Recipe::class, parentColumns = ["id"], childColumns = ["recipe_id"])
    ]
)
data class KnownRecipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "recipe_id")
    val recipeId: Int,
    @ColumnInfo(name = "character_id") // Bond with character
    val characterId: Int
)

data class FullCharacterProfile(
    @Embedded val character: Character,
    @Relation(parentColumn = "character_id", entityColumn = "id")
    val inventory: List<InventoryItem>,
    @Relation(parentColumn = "character_id", entityColumn = "id")
    val equippedItems: List<EquippedItem>,
    @Relation(parentColumn = "character_id", entityColumn = "id")
    val knownRecipes: List<KnownRecipe>,
    @Relation(parentColumn = "character_id", entityColumn = "id")
    val baseClass: BaseClass,
    @Relation(parentColumn = "character_id", entityColumn = "id")
    val stats: Stats
)


