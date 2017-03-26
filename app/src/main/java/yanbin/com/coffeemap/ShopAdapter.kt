package yanbin.com.coffeemap

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ShopAdapter : RecyclerView.Adapter<ShopViewHolder>(){

    var shops:List<Shop> = ArrayList()

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val shop = shops[position]
        holder.textName.text = shop.name
        holder.textLocation.text = shop.location
        holder.textTime.text = shop.time
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_shop, parent, false)
        return ShopViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return shops.size
    }
}

class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val textName:TextView = itemView.findViewById(R.id.textName) as TextView
    val textLocation:TextView = itemView.findViewById(R.id.textLocation) as TextView
    val textTime:TextView = itemView.findViewById(R.id.textTime) as TextView
}