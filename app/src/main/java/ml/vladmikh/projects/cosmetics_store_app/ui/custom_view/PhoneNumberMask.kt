package ml.vladmikh.projects.cosmetics_store_app.ui.custom_view

import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import ml.vladmikh.projects.hotel_app.R

class PhoneNumberMask(private val editText1: EditText,
                      private val editText2: EditText,
                      private val editText3: EditText,
                      private val button: Button,
                      private val saveDate: (phoneNumber: String) -> Unit) :
    TextWatcher {


    companion object {
        val MASK = "+7 *** ***-**-**"

    }

    private var mSelfChange = false

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable) {

        if (mSelfChange) {
            return
        }

        //Удаление всех нецифровых элементов и текста edittext
        val preparedStr = s.replace(Regex("(\\D*)"), "")
        var resultStr = ""
        for (i in preparedStr.indices) {
            resultStr = when (i) {
                0 -> resultStr.plus("+7 ")
                1 -> resultStr.plus(preparedStr[i])
                2 -> resultStr.plus(preparedStr[i])
                3 -> resultStr.plus(preparedStr[i])
                4 -> resultStr.plus(" ".plus(preparedStr[i]))
                5 -> resultStr.plus(preparedStr[i])
                6 -> resultStr.plus(preparedStr[i])
                7 -> resultStr.plus("-".plus(preparedStr[i]))
                8 -> resultStr.plus(preparedStr[i])
                9 -> resultStr.plus("-".plus(preparedStr[i]))
                10 -> resultStr.plus(preparedStr[i])
                else -> resultStr
            }
        }

        mSelfChange = true

        editText3.setText(MASK.replaceRange(0, resultStr.length, resultStr))
        saveDate(MASK.replaceRange(0, resultStr.length, resultStr))
        editText3.setSelection(resultStr.length)

        mSelfChange = false

        if (!editText1.text.isNullOrEmpty() && !editText2.text.isNullOrEmpty() && ml.vladmikh.projects.cosmetics_store_app.utils.isCorrectNumber(
                editText3.text.toString()
            )
        ) {
            button.isEnabled = true
            button.setBackgroundResource(R.drawable.button_pink_drawable)
        }

    }

    fun isCorrectNumber(string: String): Boolean {
        return !string.any {char -> char == '*'}
    }
}