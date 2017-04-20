package yanbin.com.coffeemap.shop

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.db.Shop

class ShopGridAdapter : RecyclerView.Adapter<ShopGridViewHolder>(){

    var shops:List<Shop> = ArrayList()

    override fun onBindViewHolder(holder: ShopGridViewHolder, position: Int) {
        val shop = shops[position]
        holder.textName.text = shop.name
        holder.textLocation.text = shop.address
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopGridViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_grid, parent, false)
        return ShopGridViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return shops.size
    }
}

class ShopGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val textName: TextView = itemView.findViewById(R.id.textName) as TextView
    val textLocation: TextView = itemView.findViewById(R.id.textLocation) as TextView
}