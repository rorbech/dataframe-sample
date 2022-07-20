import org.jetbrains.kotlinx.dataframe.DataColumn
import org.jetbrains.kotlinx.dataframe.annotations.DataSchema
import org.jetbrains.kotlinx.dataframe.api.cast
import org.jetbrains.kotlinx.dataframe.api.columnOf
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.dataframe.api.filter
import org.jetbrains.kotlinx.dataframe.api.print
import org.jetbrains.kotlinx.dataframe.api.toColumn

@DataSchema
interface Person {
    val name: String
    val age: Int
}

fun main(args: Array<String>) {
    println("Hello World!")

    val student: DataColumn<String> by columnOf("Alice", "Bob")
    println(listOf("Alice", "Bob").toColumn("name"))
    println(student)
    val df = dataFrameOf("name", "age")(
        "Alice", 15,
        "Bob", 20
    ).cast<Person>()
    println(df)
    
    // age only available after executing `build` or `kspKotlin`!
    val teens = df.filter { age in 10..19 }
    teens.print()
}
