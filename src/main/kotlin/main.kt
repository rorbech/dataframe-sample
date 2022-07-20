import org.jetbrains.kotlinx.dataframe.DataColumn
import org.jetbrains.kotlinx.dataframe.api.columnOf
import org.jetbrains.kotlinx.dataframe.api.toColumn

fun main(args: Array<String>) {
    println("Hello World!")

    val student: DataColumn<String> by columnOf("Alice", "Bob")
    println(listOf("Alice", "Bob").toColumn("name"))
    println(student)
