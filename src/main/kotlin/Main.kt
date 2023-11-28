fun main() {
    val sum = 10000
    val comission = sum / 100 * 0.75
    val amount = if(comission > 35) {sum + comission} else {sum + 35}
println(amount)

}