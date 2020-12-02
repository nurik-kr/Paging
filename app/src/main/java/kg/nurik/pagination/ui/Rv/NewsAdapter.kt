package kg.nurik.pagination.ui.Rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.pagination.R
import kg.nurik.pagination.data.model.Data
import kotlinx.android.synthetic.main.item_rv.view.*

class NewsAdapter : PagedListAdapter<Data, NewsViewHolder>(DiffUtils.diffUtilData) {
    //спец для пагинации а не ресайклервью
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Data?) {
        itemView.tvTitle.text = "$position             ${item?.date}"
    }
}