package kg.nurik.pagination.data.model

import com.google.gson.annotations.SerializedName
data class Data (

	@SerializedName("open") val open : Double,
	@SerializedName("high") val high : Double,
	@SerializedName("low") val low : Double,
	@SerializedName("close") val close : Double,
	@SerializedName("volume") val volume : Int,
	@SerializedName("adj_high") val adj_high : Double,
	@SerializedName("adj_low") val adj_low : Double,
	@SerializedName("adj_close") val adj_close : Double,
	@SerializedName("adj_open") val adj_open : Double,
	@SerializedName("adj_volume") val adj_volume : Int,
	@SerializedName("symbol") val symbol : String,
	@SerializedName("exchange") val exchange : String,
	@SerializedName("date") val date : String
)