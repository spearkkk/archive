import java.util.*

class SolutionLevel2nd1 {
    private val commandToDescription: Map<String, String> = mapOf(
        Pair("Enter", "들어왔습니다."),
        Pair("Leave", "나갔습니다."),
        Pair("Change", ""))

    private val userIdToNickname: MutableMap<String, String> = mutableMapOf()

    private fun parse(record: String): Triple<String, String, String> {
        val tmp = record.split(" ")

        return Triple(tmp[0], tmp[1], if (tmp.size == 3) tmp[2] else "")
    }

    fun solution(record: Array<String>): Array<String> {
        val holder = arrayListOf<Pair<String, String>>()

        for (rec in record) {
            val tmp = parse(rec)

            when(tmp.first) {
                "Enter" ->  {
                    userIdToNickname.put(tmp.second, tmp.third)
                    holder.add(Pair(tmp.second, tmp.first))
                }
                "Leave" -> {
                    holder.add(Pair(tmp.second, tmp.first))
                }
                "Change" -> {
                    userIdToNickname.put(tmp.second, tmp.third)
                }
            }
        }

        return holder.map { "${userIdToNickname[it.first]}님이 ${commandToDescription[it.second]}" }.toTypedArray()
    }
}
