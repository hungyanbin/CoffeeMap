package yanbin.com.coffeemap

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BaseFragment : Fragment() {

    companion object {

        val KEY_SECTION_NUMBER = "sectionNumber"

        fun newInstance(sectionNumber : Int) : BaseFragment{
            val bundle = Bundle()
            bundle.putInt(KEY_SECTION_NUMBER, sectionNumber)
            val baseFragment = BaseFragment()
            baseFragment.arguments = bundle
            return baseFragment
        }
    }

    private var textLabel: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        textLabel = rootView.findViewById(R.id.textLabel) as TextView
        textLabel?.text = getString(R.string.section_format, arguments.getInt(KEY_SECTION_NUMBER))
        return rootView
    }
}