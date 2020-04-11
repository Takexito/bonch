package com.example.bonchapp.ui.authorization

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.google.android.material.shape.Shapeable
import kotlinx.android.synthetic.main.auth_page_1.view.*
import kotlinx.android.synthetic.main.auth_page_2.view.*

class PagerAdapter(authFragment: AuthFragment): RecyclerView.Adapter<PagerAdapter.PagerVH>() {

    private var fragment: AuthFragment = authFragment

    inner class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var emailET: EditText
        lateinit var passET: EditText
        lateinit var showPassBtn: ImageButton

        fun showHidePass() {
            if (passET.transformationMethod == PasswordTransformationMethod.getInstance()) {
                passET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                showPassBtn.setImageResource(R.drawable.ic_hide_pass)
                passET.setSelection(passET.text.length)

            } else {
                passET.transformationMethod = PasswordTransformationMethod.getInstance()
                showPassBtn.setImageResource(R.drawable.ic_show_pass)
                passET.setSelection(passET.text.length)
            }
        }

        fun signInError() {
            val background = passET.background as LayerDrawable
            val color = background.findDrawableByLayerId(R.id.bottom_line) as GradientDrawable

            color.setColor(ContextCompat.getColor(fragment.context!!, R.color.errorSignIn))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        return if (viewType == 0) PagerVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.auth_page_1,
                parent,
                false
            )
        )
        else PagerVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.auth_page_2,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        if (holder.itemViewType == 0) {
            holder.itemView.next_page.setOnClickListener {
                fragment.nextPage()
            }
        } else {
            holder.itemView.run {
                holder.passET = password
                holder.emailET = email
                holder.showPassBtn = show_pass_toggle

                back.setOnClickListener {
                    fragment.previousPage()
                }

                show_pass_toggle.setOnClickListener {
                    holder.showHidePass()
                }

                sign_in.setOnClickListener {
                    fragment.presenter!!.signIn(email.text.toString(), password.text.toString())
                    holder.signInError()
                }
            }
        }
    }

}