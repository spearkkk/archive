import java.util.*

class Solution42583 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {

        val bridge = LinkedList((0 until bridge_length).map { 0 }.toMutableList())
        var currentWeight = 0

        var answer = 0

        val trucks = LinkedList(truck_weights.toMutableList())

        while (bridge.isNotEmpty()) {
            answer += 1
            currentWeight -= bridge.pop()

            if (trucks.isEmpty()) {
                continue
            }

            if (currentWeight + trucks.first() > weight) {
                bridge.addLast(0)
                continue
            }

            val tmp = trucks.pop()
            bridge.addLast(tmp)
            currentWeight += tmp
        }

        return answer
    }
}
