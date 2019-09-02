package c.kaleidot725.pagingsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class ItemViewModel(app : Application) : AndroidViewModel(app) {
    val dao = ItemDb.getInstance(app).itemDao()

     companion object {
         private const val PAGE_SIZE = 30
         private const val ENABLE_PLACEHOLDERS = true
         private const val INITIAL_LOAD_SIZE_HINT = 40
         private const val PREFETCH_DISTANCE = 20
     }

    // LivePagedListBuilder を利用して DataSource.Factory と PagedList.Config から // LiveData<PagedList<Value>>を生成する
    val allItems = LivePagedListBuilder(dao.allItemByName(),
        PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
            .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
            .setPrefetchDistance(PREFETCH_DISTANCE)
            .build()).build()
}
