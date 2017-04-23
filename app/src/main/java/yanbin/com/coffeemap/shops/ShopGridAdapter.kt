package yanbin.com.coffeemap.shops

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.db.Shop

class ShopGridAdapter(val context: Context) : RecyclerView.Adapter<ShopGridViewHolder>() {

    var shops: List<Shop> = ArrayList()

    override fun onBindViewHolder(holder: ShopGridViewHolder, position: Int) {
        val shop = shops[position]
        holder.textName.text = shop.name
        holder.textLocation.text = shop.address

        val colorRes : Int
        when (position % 10) {
            0 -> colorRes = R.color.colorPicker_1
            1 -> colorRes = R.color.colorPicker_2
            2 -> colorRes = R.color.colorPicker_3
            3 -> colorRes = R.color.colorPicker_4
            4 -> colorRes = R.color.colorPicker_5
            5 -> colorRes = R.color.colorPicker_6
            6 -> colorRes = R.color.colorPicker_7
            7 -> colorRes = R.color.colorPicker_8
            8 -> colorRes = R.color.colorPicker_9
            9 -> colorRes = R.color.colorPicker_10
            else -> colorRes = R.color.colorPicker_1
        }

        val color = ContextCompat.getColor(context, colorRes)
        holder.imageShop.setBackgroundColor(color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopGridViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_grid, parent, false)
        return ShopGridViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return shops.size
    }
}

class ShopGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textName: TextView = itemView.findViewById(R.id.textName) as TextView
    val textLocation: TextView = itemView.findViewById(R.id.textLocation) as TextView
    val imageShop: ImageView = itemView.findViewById(R.id.imageShop) as ImageView
}