package kaleidot725.roomsample

import org.junit.Test
import org.junit.runner.RunWith
import androidx.room.testing.MigrationTestHelper
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
class MigrationTest {
    companion object {
        private const val TEST_DB_NAME = "migration-test"
    }

    @Test
    fun migrate1To2() {
        val helper = MigrationTestHelper(
            InstrumentationRegistry.getInstrumentation(),
            MyDatabase::class.java.canonicalName)
        val db1 = helper.createDatabase(TEST_DB_NAME, 1)
        db1.close()
        val db2 = helper.runMigrationsAndValidate(TEST_DB_NAME, 2, true, MyDatabase.MIGRATION_1_2)
        db2.close()
    }
}