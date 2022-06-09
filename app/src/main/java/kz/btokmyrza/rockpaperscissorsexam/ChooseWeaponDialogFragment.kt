package kz.btokmyrza.rockpaperscissorsexam

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment

class ChooseWeaponDialogFragment : DialogFragment(R.layout.fragment_choose_weapon_dialog) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWidthPercent(90)

        view.findViewById<ImageButton>(R.id.ib_rock).setOnClickListener {
            (activity as MainActivity).chooseWeapon(it.id)
            dismiss()
        }

        view.findViewById<ImageButton>(R.id.ib_paper).setOnClickListener {
            (activity as MainActivity).chooseWeapon(it.id)
            dismiss()
        }

        view.findViewById<ImageButton>(R.id.ib_scissors).setOnClickListener {
            (activity as MainActivity).chooseWeapon(it.id)
            dismiss()
        }

    }

    private fun setWidthPercent(percentage: Int) {
        val percent = percentage.toFloat() / 100
        val dm = Resources.getSystem().displayMetrics
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = rect.width() * percent
        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

}