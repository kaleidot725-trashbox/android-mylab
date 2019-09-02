package kaleidot725.roomsample

import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.runner.AndroidJUnit4
import androidx.test.InstrumentationRegistry
import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MigrationTest {
    companion object {
        private const val TEST_DB_NAME = "migration-test"
    }

    @Rule @JvmField
    var migrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        MyDatabase::class.java!!.getCanonicalName()!!,
        FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    fun migrate1To2() {
        val db1 = migrationTestHelper.createDatabase(TEST_DB_NAME, 1)
        db1.close()

        val db2 = migrationTestHelper.runMigrationsAndValidate(TEST_DB_NAME, 2, true, MyDatabase.MIGRATION_1_2)
        db2.close()
    }
}