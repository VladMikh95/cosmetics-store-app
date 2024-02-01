package ml.vladmikh.projects.cosmetics_store_app.utils

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textfield.TextInputLayout
import ml.vladmikh.projects.hotel_app.R

fun EditText.bindTextTwoWay(liveData: MutableLiveData<String>, lifecycleOwner: LifecycleOwner) {
    this.doOnTextChanged { s, start, count, after ->
        liveData.value = s.toString()

    }

    liveData.observe(lifecycleOwner) { text ->
        //  проверка делается для того, чтобы не провоцировать рекурсию при изменении значения editText на точно такое же
        if (this.text.toString() == text) return@observe

        this.setText(text)
    }
}

fun EditText.setCyrillicValidation(textInputLayout: TextInputLayout,
                                   editText1: EditText,
                                   editText2: EditText,
                                   editText3: EditText,
                                   button: Button) {
    this.addTextChangedListener(object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?,
                                   p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            if (isCyrillicValid(p0.toString())) {
                textInputLayout.boxBackgroundColor =
                    context?.let { ContextCompat.getColor(it, R.color.light_grey) }!!
                Log.i("abc1", editText1.text.toString())
                Log.i("abc2", editText2.text.toString())
                Log.i("abc3", editText3.text.toString())
                    if (!editText1.text.isNullOrEmpty() && !editText2.text.isNullOrEmpty() && isCorrectNumber(editText3.text.toString())) {
                        button.isEnabled = true
                        button.setBackgroundResource(R.drawable.button_pink_drawable)
                    }

            } else {
                textInputLayout.boxBackgroundColor =
                    context?.let { ContextCompat.getColor(it, R.color.light_pink) }!!
                button.isEnabled = false
                button.setBackgroundResource(R.drawable.button_light_pink_drawable)
            }
        }
    })
}

//Проверка валидации символы содержат только кириллицу
fun isCyrillicValid(string: String): Boolean {
    return string.all { char -> char in '\u0400'..'\u04FF' }
}

fun isCorrectNumber(string: String): Boolean {
    return !string.any {char -> char == '*'}
}