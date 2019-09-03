package kaleidot725.pagingsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kaleidot725.pagingsample.data.ItemDb

class ItemViewModel(app : Application) : AndroidViewModel(app) {
    val dao = ItemDb.get(app).itemDao()

     companion object {
         private const val PAGE_SIZE = 30
         private const val ENABLE_PLACEHOLDERS = true
         private const val INITIAL_LOAD_SIZE_HINT = 40
         private const val PREFETCH_DISTANCE = 20
     }

    val allItems = LivePagedListBuilder(dao.allItemByName(),
        PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
            .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
            .setPrefetchDistance(PREFETCH_DISTANCE)
            .build()).build()
}
