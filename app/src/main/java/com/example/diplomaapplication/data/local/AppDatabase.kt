package com.example.diplomaapplication.data.local

@androidx.room.Database(
    entities = [
        BaseClass::class,
        Character::class,
        Stats::class,
        CharacterInventory::class,
        InventoryItem::class,
        CharacterSkill::class,
        KnownRecipe::class,
        User::class,
        Enemy::class,
        EnemyDrop::class,
        Location::class,
        Recipe::class,
        RecipeIngredient::class,
        Item::class,
        EquipmentSlot::class,
        Equipment::class,
        Skill::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCharacterDao(): CharacterDao
    abstract fun getEnemyDao(): EnemyDao
    abstract fun getEventsDao(): EventsDao
    abstract fun getHistoryDao(): HistoryDao
    abstract fun getInventoryDao(): InventoryDao
    abstract fun getLocationsDao(): LocationsDao
    abstract fun getRecipesDao(): RecipesDao
    abstract fun getStatsDao(): StatsDao
    abstract fun getUserDao(): UserDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}