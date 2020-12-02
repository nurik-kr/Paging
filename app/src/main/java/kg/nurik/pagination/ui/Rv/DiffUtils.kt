package kg.nurik.pagination.ui.Rv

import androidx.recyclerview.widget.DiffUtil
import kg.nurik.pagination.data.model.Data

object DiffUtils {

    val diffUtilData =
        object : DiffUtil.ItemCallback<Data>() { //логику чтоб отличить один от другого
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean { //будет сравнивать все эти обьекты,если нет он его добавит
                return oldItem.date == newItem.date &&
                        oldItem.adj_close == newItem.adj_close &&
                        oldItem.adj_high == newItem.adj_high &&
                        oldItem.adj_open == newItem.adj_open &&
                        oldItem.close == newItem.close
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }

        }
}