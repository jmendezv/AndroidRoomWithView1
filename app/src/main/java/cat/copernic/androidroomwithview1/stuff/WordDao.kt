package cat.copernic.androidroomwithview1.stuff

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg words: Word): List<Long>

    @Update
    suspend fun update(vararg words: Word): Int

    @Delete
    suspend fun delete(vararg words: Word): Int

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

}
