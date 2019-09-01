package kaleidot725.roomsample

import org.junit.Test
import org.junit.runner.RunWith
import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule

@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class MigrationTest {
    companion object {
        private const val TEST_DB_NAME = "migration-test"
    }

    @Rule @JvmField val helper: MigrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        MyDatabase::class.java.canonicalName,
        FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    fun migrate1To2() {
        val db1 = helper.createDatabase(TEST_DB_NAME, 1).also {
            it.close()
        }

        val db2 = helper.runMigrationsAndValidate(TEST_DB_NAME, 2, true, MyDatabase.MIGRATION_1_2).also {
            it.close()
        }
    }
}