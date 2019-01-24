package c.kaleidot725.imageViewLaboratory.model

import c.kaleidot725.imageViewLaboratory.R

class ImageResources {

    private var current : Int = 0
    private val resources : List<Int> = listOf<Int>(
        R.drawable.ic_numeric_0,
        R.drawable.ic_numeric_1,
        R.drawable.ic_numeric_2,
        R.drawable.ic_numeric_3,
        R.drawable.ic_numeric_4,
        R.drawable.ic_numeric_5,
        R.drawable.ic_numeric_6,
        R.drawable.ic_numeric_7,
        R.drawable.ic_numeric_8,
        R.drawable.ic_numeric_9
    )

    fun get() : Int {
        return resources[current]
    }

    fun next() : Int {
        current = if((current + 1) == resources.count()) (0) else (current + 1)
        return resources[current]
    }

    fun back() : Int {
        current = if((current - 1) < 0) (resources.count() - 1) else (current - 1)
        return resources[current]
    }
}