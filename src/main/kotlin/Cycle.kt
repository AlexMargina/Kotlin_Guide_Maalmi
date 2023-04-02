


   fun cycle(steps: Int) {

    println("ИЗУЧАЕМ ЦИКЛЫ")
    var x : Int 

    println("ЦИКЛ while: ")
    x = steps
    while (x > 0) {
        println(x--)
    }

    println("ЦИКЛ do-while: ")
    x = steps
    do {
        println(x--) // хотя x у нас изначально не подходит под условие x > 3,  цикл do-while один раз распечатает значение 3
    } while (x > 3)

    println("ЦИКЛ while c break ")
    x = steps

    while (x < 10) {
        println(x++)

        if (x == 5) break // прерываем цикл, если x == 5
    }

    println("ЦИКЛ while c continue ")
    for (i in 0..steps) {
        // если индекс — чётное число, переходим на следующую итерацию
        if (i % 2 == 0) {
            continue
        }
        println(i)
    }
    }



    fun calculate(max: Int) {
        var x : Int = 1

        while (x <= max) {
            print("$x ")
            x *= 2
        }
        println("Over")
    }




