package kg.nurik.pagination.data.model

import com.google.gson.annotations.SerializedName

data class BasePagingModel<T>(

    @SerializedName("pagination") val pagination: Pagination,
    @SerializedName("data") val data: List<T>
)