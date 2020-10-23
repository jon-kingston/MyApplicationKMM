package com.example.myapplicationkmm.shared


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}

class TicTacToyGameLogic(){

    fun checkWinner(table: Array<Array<Int>>): String {
        var row1 = 0
        var row2 = 0
        var row3 = 0

        var columns1 = 0
        var columns2 = 0
        var columns3 = 0

        var cross1 = 0
        var cross2 = 0

        if (isFull(table)) return "noOne" else {

            row1 = (table[1][1] + table[1][2] + table[1][3])

            row2 = (table[2][1] + table[2][2] + table[2][3])

            row3 = (table[3][1] + table[3][2] + table[3][3])

            columns1 = (table[1][1] + table[2][1] + table[3][1])

            columns2 = (table[1][2] + table[2][2] + table[3][2])

            columns3 = (table[1][3] + table[2][3] + table[3][3])

            cross1 = (table[1][1] + table[2][2] + table[3][3])

            cross2 = (table[1][3] + table[2][2] + table[3][1])


            var result = "0"

            result = if (row1 == 3) "xWin" else if (row1 == 12) "oWin" else result

            result = if (row2 == 3) "xWin" else if (row2 == 12) "oWin" else result
            result = if (row3 == 3) "xWin" else if (row3 == 12) "oWin" else result

            result = if (columns1 == 3) "xWin" else if (columns1 == 12) "oWin" else result
            result = if (columns2 == 3) "xWin" else if (columns2 == 12) "oWin" else result
            result = if (columns3 == 3) "xWin" else if (columns3 == 12) "oWin" else result
            result = if (cross1 == 3) "xWin" else if (cross1 == 12) "oWin" else result
            result = if (cross2 == 3) "xWin" else if (cross2 == 12) "oWin" else result

            return result
        }
    }

    private fun isFull(table: Array<Array<Int>>): Boolean {
        return table[1][1] != 0 &&
                table[1][2] != 0 &&
                table[1][3] != 0 &&

                table[2][1] != 0 &&
                table[2][2] != 0 &&
                table[2][3] != 0 &&

                table[3][1] != 0 &&
                table[3][2] != 0 &&
                table[3][3] != 0
    }

}
