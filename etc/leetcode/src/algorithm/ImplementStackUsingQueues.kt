package algorithm

class ImplementStackUsingQueues {
    val holder = mutableListOf<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        holder.add(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return holder.removeAt(holder.size - 1)
    }

    /** Get the top element. */
    fun top(): Int {
        return holder.last()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return holder.isEmpty()
    }
}