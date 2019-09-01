package kaleidot725.roomsample

import androidx.room.testing.MigrationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import org.junit.Rule
import androidx.test.runner.AndroidJUnit4
import androidx.test.InstrumentationRegistry

@RunWith(AndroidJUnit4::class)
class MigrationTest {
    companion object {
        private const val TEST_DB_NAME = "migration-test"
    }

    @Test
    fun migrate1To2() {
        val helper: MigrationTestHelper = MigrationTestHelper(
            InstrumentationRegistry.getInstrumentation(),
            MyDatabase::class.java.canonicalName)

        val db1 = helper.createDatabase(TEST_DB_NAME, 1).also {
            it.close()
        }

        val db2 = helper.runMigrationsAndValidate(TEST_DB_NAME, 2, true, MyDatabase.MIGRATION_1_2).also {
            it.close()
        }
    }
}