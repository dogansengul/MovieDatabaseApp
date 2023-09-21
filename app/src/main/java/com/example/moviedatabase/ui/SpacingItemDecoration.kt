package com.example.moviedatabase.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class SpacingItemDecoration(private val padding: Int): ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val column = position % 2
        if (position == 0 || position == 1) {
            outRect.top = padding
        } else {
            outRect.top = padding / 2
        }
        if (column == 0) {
            outRect.left = padding
            outRect.right = padding / 2
            outRect.bottom = padding / 2
        } else {
            outRect.left = padding / 2
            outRect.right = padding
            outRect.bottom = padding / 2
        }
    }
}