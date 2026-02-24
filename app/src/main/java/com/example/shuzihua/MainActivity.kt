package com.example.shuzihua

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tabPhone: TextView
    private lateinit var tabThree: TextView
    private lateinit var layoutPhone: LinearLayout
    private lateinit var layoutThree: LinearLayout
    private lateinit var etPhone: EditText
    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var etNum3: EditText
    private lateinit var btnCalc: Button
    private lateinit var layoutResult: LinearLayout
    private lateinit var tvLines: TextView
    private lateinit var tvHexagram: TextView
    private lateinit var tvUpper: TextView
    private lateinit var tvLower: TextView
    private lateinit var tvMoving: TextView
    private lateinit var tvChanged: TextView
    private lateinit var tvMeaning: TextView
    private var mode = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        tabPhone.setOnClickListener { switchMode(0) }
        tabThree.setOnClickListener { switchMode(1) }
        switchMode(0)
        btnCalc.setOnClickListener { calculate() }
    }

    private fun bindViews() {
        tabPhone     = findViewById(R.id.tab_phone)
        tabThree     = findViewById(R.id.tab_three)
        layoutPhone  = findViewById(R.id.layout_phone)
        layoutThree  = findViewById(R.id.layout_three)
        etPhone      = findViewById(R.id.et_phone)
        etNum1       = findViewById(R.id.et_num1)
        etNum2       = findViewById(R.id.et_num2)
        etNum3       = findViewById(R.id.et_num3)
        btnCalc      = findViewById(R.id.btn_calc)
        layoutResult = findViewById(R.id.layout_result)
        tvLines      = findViewById(R.id.tv_lines)
        tvHexagram   = findViewById(R.id.tv_hexagram)
        tvUpper      = findViewById(R.id.tv_upper)
        tvLower      = findViewById(R.id.tv_lower)
        tvMoving     = findViewById(R.id.tv_moving)
        tvChanged    = findViewById(R.id.tv_changed)
        tvMeaning    = findViewById(R.id.tv_meaning)
    }

    private fun switchMode(m: Int) {
        mode = m
        layoutPhone.visibility  = if (m == 0) View.VISIBLE else View.GONE
        layoutThree.visibility  = if (m == 1) View.VISIBLE else View.GONE
        tabPhone.alpha          = if (m == 0) 1.0f else 0.5f
        tabThree.alpha          = if (m == 1) 1.0f else 0.5f
        layoutResult.visibility = View.GONE
    }

    private fun calculate() {
        try {
            val result = when (mode) {
                0 -> {
                    val p = etPhone.text.toString().trim()
                    if (p.length < 4) { toast("请输入有效的手机号码"); return }
                    HexagramCalculator.calculateFromPhone(p)
                }
                else -> {
                    val n1 = etNum1.text.toString().toIntOrNull()
                    val n2 = etNum2.text.toString().toIntOrNull()
                    val n3 = etNum3.text.toString().toIntOrNull()
                    if (n1 == null || n2 == null || n3 == null) { toast("请输入三组有效数字"); return }
                    HexagramCalculator.calculateFromThreeNums(n1, n2, n3)
                }
            }
            showResult(result)
        } catch (e: Exception) {
            toast("计算出错：${e.message}")
        }
    }

    private fun showResult(r: HexagramResult) {
        layoutResult.visibility = View.VISIBLE
        val up = HexagramData.trigrams[r.upperTrigramNum]!!
        val lo = HexagramData.trigrams[r.lowerTrigramNum]!!
        tvLines.text    = buildLines(r.upperTrigramNum, r.lowerTrigramNum, r.movingLine)
        tvHexagram.text = "📖 本卦：${r.hexagram.name}（第 ${r.hexagram.kingWenNumber} 卦）"
        tvUpper.text    = "上卦（外卦）：${up.symbol} ${up.name}  先天数 ${r.upperTrigramNum}"
        tvLower.text    = "下卦（内卦）：${lo.symbol} ${lo.name}  先天数 ${r.lowerTrigramNum}"
        tvMoving.text   = "⚡ 动爻：第 ${r.movingLine} 爻动"
        tvChanged.text  = "🔄 之卦：${r.changedHexagram.name}（第 ${r.changedHexagram.kingWenNumber} 卦）"
        tvMeaning.text  = "卦辞：${r.hexagram.meaning}"
    }

    private fun buildLines(upperNum: Int, lowerNum: Int, moving: Int): String {
        val lo  = HexagramData.trigrams[lowerNum]!!.lines
        val up  = HexagramData.trigrams[upperNum]!!.lines
        val all = lo + up
        return (5 downTo 0).joinToString("\n") { i ->
            val n    = i + 1
            val yao  = if (all[i] == 1) "———————" else "———  ———"
            val mark = if (n == moving) "  ●" else ""
            "  第${n}爻  $yao$mark"
        }
    }

    private fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
