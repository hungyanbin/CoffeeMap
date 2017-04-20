package yanbin.com.coffeemap

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View


class GridItemDecoration(val gridSize: Int) : RecyclerView.ItemDecoration() {

    val gridSpacingPx = 5
    var needLeftSpacing = false;

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val frameWidth = (parent.width - (gridSpacingPx * (gridSize - 1))) / gridSize
        val padding = parent.width/gridSize - frameWidth
        val layoutParams = view.layoutParams as RecyclerView.LayoutParams
        val itemPosition = layoutParams.viewAdapterPosition

        setVerticalPadding(itemPosition, outRect)
        setHorizontalPadding(itemPosition, outRect, padding)
    }

    private fun setHorizontalPadding(itemPosition: Int, outRect: Rect, padding: Int) {
        if (itemPosition % gridSize == 0) {
            outRect.left = 0
            outRect.right = padding
            needLeftSpacing = true
        } else if ((itemPosition + 1) % gridSize == 0) {
            needLeftSpacing = false
            outRect.right = 0
            outRect.left = padding
        } else if (needLeftSpacing) {
            needLeftSpacing = false
            outRect.left = gridSpacingPx - padding
            if ((itemPosition + 2) % gridSize == 0) {
                outRect.right = gridSpacingPx - padding
            } else {
                outRect.right = gridSpacingPx / 2
            }
        } else if ((itemPosition + 2) % gridSize == 0) {
            needLeftSpacing = false
            outRect.left = gridSpacingPx / 2
            outRect.right = gridSpacingPx - padding
        } else {
            needLeftSpacing = false
            outRect.left = gridSpacingPx / 2
            outRect.right = gridSpacingPx / 2
        }
    }

    private fun setVerticalPadding(itemPosition: Int, outRect: Rect) {
        if (itemPosition < gridSize) {
            outRect.top = 0
        } else {
            outRect.top = gridSpacingPx
        }
        outRect.bottom = 0
    }
}
