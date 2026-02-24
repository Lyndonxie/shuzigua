package com.example.shuzihua

data class Trigram(val name: String, val symbol: String, val number: Int, val lines: IntArray)

data class Hexagram(val name: String, val upperNum: Int, val lowerNum: Int, val kingWenNumber: Int, val meaning: String)

object HexagramData {

    val trigrams: Map<Int, Trigram> = mapOf(
        1 to Trigram("乾", "☰", 1, intArrayOf(1, 1, 1)),
        2 to Trigram("兑", "☱", 2, intArrayOf(1, 1, 0)),
        3 to Trigram("离", "☲", 3, intArrayOf(1, 0, 1)),
        4 to Trigram("震", "☳", 4, intArrayOf(1, 0, 0)),
        5 to Trigram("巽", "☴", 5, intArrayOf(0, 1, 1)),
        6 to Trigram("坎", "☵", 6, intArrayOf(0, 1, 0)),
        7 to Trigram("艮", "☶", 7, intArrayOf(0, 0, 1)),
        8 to Trigram("坤", "☷", 8, intArrayOf(0, 0, 0))
    )

    val hexagrams: Array<Array<Hexagram>> = Array(9) { Array(9) { Hexagram("", 0, 0, 0, "") } }

    init {
        hexagrams[1][1] = Hexagram("乾为天",    1,1,1,  "元亨利贞，刚健中正，自强不息")
        hexagrams[1][2] = Hexagram("天泽履",    1,2,10, "履虎尾，不咥人，亨，谨慎前行")
        hexagrams[1][3] = Hexagram("天火同人",  1,3,13, "同人于野，亨，利涉大川，团结协作")
        hexagrams[1][4] = Hexagram("天雷无妄",  1,4,25, "元亨利贞，无妄之灾，顺天应时")
        hexagrams[1][5] = Hexagram("天风姤",    1,5,44, "女壮，勿用取女，邂逅相遇")
        hexagrams[1][6] = Hexagram("天水讼",    1,6,6,  "有孚窒，惕中吉，终凶，慎防争讼")
        hexagrams[1][7] = Hexagram("天山遁",    1,7,33, "亨，小利贞，知退守时")
        hexagrams[1][8] = Hexagram("天地否",    1,8,12, "否之匪人，不利君子贞，闭塞不通")
        hexagrams[2][1] = Hexagram("泽天夬",    2,1,43, "扬于王庭，孚号有厉，刚决柔")
        hexagrams[2][2] = Hexagram("兑为泽",    2,2,58, "亨，利贞，喜悦通达")
        hexagrams[2][3] = Hexagram("泽火革",    2,3,49, "己日乃孚，元亨利贞，悔亡，变革创新")
        hexagrams[2][4] = Hexagram("泽雷随",    2,4,17, "元亨利贞，无咎，顺势而为")
        hexagrams[2][5] = Hexagram("泽风大过",  2,5,28, "栋桡，利有攸往，亨，谨防过失")
        hexagrams[2][6] = Hexagram("泽水困",    2,6,47, "亨，贞大人吉，无咎，困境中求亨")
        hexagrams[2][7] = Hexagram("泽山咸",    2,7,31, "亨，利贞，取女吉，感应相通")
        hexagrams[2][8] = Hexagram("泽地萃",    2,8,45, "亨，王假有庙，利见大人，聚集")
        hexagrams[3][1] = Hexagram("火天大有",  3,1,14, "元亨，盛大丰收")
        hexagrams[3][2] = Hexagram("火泽睽",    3,2,38, "小事吉，乖违背离中求通")
        hexagrams[3][3] = Hexagram("离为火",    3,3,30, "利贞，亨，畜牝牛吉，文明光明")
        hexagrams[3][4] = Hexagram("火雷噬嗑",  3,4,21, "亨，利用狱，刚柔相济")
        hexagrams[3][5] = Hexagram("火风鼎",    3,5,50, "元吉，亨，革故鼎新")
        hexagrams[3][6] = Hexagram("火水未济",  3,6,64, "亨，小狐汔济，濡其尾，事未成")
        hexagrams[3][7] = Hexagram("火山旅",    3,7,56, "小亨，旅贞吉，旅途谨慎")
        hexagrams[3][8] = Hexagram("火地晋",    3,8,35, "康侯用锡马蕃庶，昼日三接，进升")
        hexagrams[4][1] = Hexagram("雷天大壮",  4,1,34, "利贞，刚健壮大")
        hexagrams[4][2] = Hexagram("雷泽归妹",  4,2,54, "征凶，无攸利，慎重婚配")
        hexagrams[4][3] = Hexagram("雷火丰",    4,3,55, "亨，王假之，勿忧，宜日中，丰盛")
        hexagrams[4][4] = Hexagram("震为雷",    4,4,51, "亨，震来虩虩，笑言哑哑，震动奋发")
        hexagrams[4][5] = Hexagram("雷风恒",    4,5,32, "亨，无咎，利贞，利有攸往，持恒")
        hexagrams[4][6] = Hexagram("雷水解",    4,6,40, "利西南，无所往其来复吉，解难脱困")
        hexagrams[4][7] = Hexagram("雷山小过",  4,7,62, "亨，利贞，可小事不可大事，小有过越")
        hexagrams[4][8] = Hexagram("雷地豫",    4,8,16, "利建侯行师，豫乐顺动")
        hexagrams[5][1] = Hexagram("风天小畜",  5,1,9,  "亨，密云不雨，自我西郊，积小成大")
        hexagrams[5][2] = Hexagram("风泽中孚",  5,2,61, "豚鱼吉，利涉大川，利贞，诚信感物")
        hexagrams[5][3] = Hexagram("风火家人",  5,3,37, "利女贞，家道和顺")
        hexagrams[5][4] = Hexagram("风雷益",    5,4,42, "利有攸往，利涉大川，损上益下")
        hexagrams[5][5] = Hexagram("巽为风",    5,5,57, "小亨，利有攸往，利见大人，随风顺入")
        hexagrams[5][6] = Hexagram("风水涣",    5,6,59, "亨，王假有庙，利涉大川，离散聚合")
        hexagrams[5][7] = Hexagram("风山渐",    5,7,53, "女归吉，利贞，循序渐进")
        hexagrams[5][8] = Hexagram("风地观",    5,8,20, "盥而不荐，有孚颙若，观瞻示范")
        hexagrams[6][1] = Hexagram("水天需",    6,1,5,  "有孚，光亨贞吉，利涉大川，等待时机")
        hexagrams[6][2] = Hexagram("水泽节",    6,2,60, "亨，苦节不可贞，节制有度")
        hexagrams[6][3] = Hexagram("水火既济",  6,3,63, "亨小利贞，初吉终乱，事已成")
        hexagrams[6][4] = Hexagram("水雷屯",    6,4,3,  "元亨利贞，勿用有攸往，利建侯，初创艰难")
        hexagrams[6][5] = Hexagram("水风井",    6,5,48, "改邑不改井，无丧无得，资源共享")
        hexagrams[6][6] = Hexagram("坎为水",    6,6,29, "习坎，有孚维心亨，行有尚，重险险阻")
        hexagrams[6][7] = Hexagram("水山蹇",    6,7,39, "利西南，不利东北，利见大人，贞吉，艰难险阻")
        hexagrams[6][8] = Hexagram("水地比",    6,8,8,  "吉，原筮元永贞无咎，亲比相辅")
        hexagrams[7][1] = Hexagram("山天大畜",  7,1,26, "利贞，不家食吉，利涉大川，积聚力量")
        hexagrams[7][2] = Hexagram("山泽损",    7,2,41, "有孚，元吉无咎可贞，损下益上")
        hexagrams[7][3] = Hexagram("山火贲",    7,3,22, "亨，小利有攸往，文饰装扮")
        hexagrams[7][4] = Hexagram("山雷颐",    7,4,27, "贞吉，观颐，自求口实，养正守中")
        hexagrams[7][5] = Hexagram("山风蛊",    7,5,18, "元亨，利涉大川，先甲三日后甲三日，振蛊革弊")
        hexagrams[7][6] = Hexagram("山水蒙",    7,6,4,  "亨，匪我求童蒙，童蒙求我，启蒙教育")
        hexagrams[7][7] = Hexagram("艮为山",    7,7,52, "艮其背，不获其身，止而不动")
        hexagrams[7][8] = Hexagram("山地剥",    7,8,23, "不利有攸往，剥落衰败")
        hexagrams[8][1] = Hexagram("地天泰",    8,1,11, "小往大来，吉亨，天地交泰")
        hexagrams[8][2] = Hexagram("地泽临",    8,2,19, "元亨利贞，至于八月有凶，临近关怀")
        hexagrams[8][3] = Hexagram("地火明夷",  8,3,36, "利艰贞，光明受损")
        hexagrams[8][4] = Hexagram("地雷复",    8,4,24, "亨，出入无疾朋来无咎，一阳来复")
        hexagrams[8][5] = Hexagram("地风升",    8,5,46, "元亨，用见大人，勿恤南征吉，升进上行")
        hexagrams[8][6] = Hexagram("地水师",    8,6,7,  "贞丈人吉，无咎，用兵治众")
        hexagrams[8][7] = Hexagram("地山谦",    8,7,15, "亨，君子有终，谦逊致远")
        hexagrams[8][8] = Hexagram("坤为地",    8,8,2,  "元亨，利牝马之贞，厚德载物")
    }

    fun getTrigramNumberFromLines(lines: IntArray): Int {
        for ((num, trigram) in trigrams) {
            if (trigram.lines.contentEquals(lines)) return num
        }
        return -1
    }
}
