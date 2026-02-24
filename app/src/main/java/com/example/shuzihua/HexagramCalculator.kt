package com.example.shuzihua

data class HexagramResult(
    val upperTrigramNum: Int,
    val lowerTrigramNum: Int,
    val movingLine: Int,
    val hexagram: Hexagram,
    val changedHexagram: Hexagram
)

object HexagramCalculator {

    fun calculateFromPhone(phone: String): HexagramResult {
        val digits = phone.filter { it.isDigit() }
        require(digits.length >= 4) { "手机号码至少需要4位数字" }
        val half      = digits.length / 2
        val sumFirst  = digits.substring(0, half).sumOf { it.digitToInt() }
        val sumSecond = digits.substring(half).sumOf { it.digitToInt() }
        val sumTotal  = digits.sumOf { it.digitToInt() }
        return buildResult(remainder8(sumFirst), remainder8(sumSecond), remainder6(sumTotal))
    }

    fun calculateFromThreeNums(num1: Int, num2: Int, num3: Int): HexagramResult =
        buildResult(remainder8(num2), remainder8(num1), remainder6(num3))

    private fun remainder8(n: Int) = if (n % 8 == 0) 8 else n % 8
    private fun remainder6(n: Int) = if (n % 6 == 0) 6 else n % 6

    private fun buildResult(upper: Int, lower: Int, moving: Int) = HexagramResult(
        upper, lower, moving,
        HexagramData.hexagrams[upper][lower],
        calcChangedHexagram(upper, lower, moving)
    )

    private fun calcChangedHexagram(upperNum: Int, lowerNum: Int, moving: Int): Hexagram {
        val lo = HexagramData.trigrams[lowerNum]!!.lines.clone()
        val up = HexagramData.trigrams[upperNum]!!.lines.clone()
        if (moving in 1..3) lo[moving - 1] = 1 - lo[moving - 1]
        else                up[moving - 4] = 1 - up[moving - 4]
        val nl = HexagramData.getTrigramNumberFromLines(lo)
        val nu = HexagramData.getTrigramNumberFromLines(up)
        return if (nl != -1 && nu != -1) HexagramData.hexagrams[nu][nl]
               else Hexagram("未知", 0, 0, 0, "")
    }
}
