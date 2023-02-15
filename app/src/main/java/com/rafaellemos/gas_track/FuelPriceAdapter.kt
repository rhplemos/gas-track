//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.TextView
//import com.example.gas_track.R
//import com.rafaellemos.gas_track.MainActivity
//
//class FuelPriceAdapter(context: Context, fuelPrices: ArrayList<FuelPrice>) :
//    ArrayAdapter<FuelPrice>(context, 0, fuelPrices) {
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        var convertView = convertView
//        val fuelPrice = getItem(position)
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(
//                R.layout.list_item_fuel_price, parent, false
//            )
//        }
//
//        val fuelTypeTextView = convertView!!.findViewById<TextView>(R.id.fuel_type)
//        fuelTypeTextView.text = fuelPrice!!.fuelType
//
//        val priceTextView = convertView.findViewById<TextView>(R.id.price)
//        priceTextView.text = fuelPrice.price.toString()
//
//        return convertView
//    }
//}
