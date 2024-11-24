import kotlin.random.Random


//1 Задача


/*fun main() {
    println("Введите количество философов:")
    val philosopherCount = readLine()?.toIntOrNull() ?: return

    val forks = MutableList(philosopherCount) { true } // true - вилка доступна
    val philosophers = MutableList(philosopherCount) { "Философ ${it + 1}" }

    val shuffledPhilosophers = philosophers.shuffled() // Перемешиваем, чтобы определить случайный порядок

    val diningPhilosophers = mutableSetOf<String>()
    val thinkingPhilosophers = mutableSetOf<String>()

    for (philosopher in shuffledPhilosophers) {
        val index = philosophers.indexOf(philosopher)
        val leftFork = index
        val rightFork = (index + 1) % philosopherCount

        // Проверяем, доступны ли вилки
        if (forks[leftFork] && forks[rightFork]) {
            // Если обе вилки доступны, философ обедает
            forks[leftFork] = false
            forks[rightFork] = false
            diningPhilosophers.add(philosopher)
        } else {
            // Если хотя бы одна вилка недоступна, философ размышляет
            thinkingPhilosophers.add(philosopher)
        }
    }

    println("Результаты:")
    println("Обедают: ${diningPhilosophers.joinToString(", ")}")
    println("Размышляют: ${thinkingPhilosophers.joinToString(", ")}")
}
*/
//2 Задача
fun main() {
    // Просим пользователя ввести количество философов
    println("Введите количество философов:")
    val philosopherCount = readLine()?.toIntOrNull() ?: return // Проверяем ввод и завершаем программу, если число не введено

    // Создаем список палочек для еды. Изначально все палочки доступны (true)
    val chopsticks = MutableList(philosopherCount) { true }

    // Создаем список философов с именами "Философ 1", "Философ 2", и так далее
    val philosophers = MutableList(philosopherCount) { "Философ ${it + 1}" }

    // Перемешиваем философов в случайном порядке, чтобы определить, кто начнет первым
    val shuffledPhilosophers = philosophers.shuffled()

    // Списки для отслеживания философов, которые обедают или размышляют
    val diningPhilosophers = mutableSetOf<String>() // Множество философов, которые обедают
    val thinkingPhilosophers = mutableSetOf<String>() // Множество философов, которые размышляют

    // Цикл для обработки каждого философа
    for (philosopher in shuffledPhilosophers) {
        // Получаем индекс философа в списке
        val index = philosophers.indexOf(philosopher)

        // Определяем номера палочек для текущего философа:
        // левая палочка - текущий индекс
        val leftChopstick = index
        // правая палочка - следующий индекс (циклически)
        val rightChopstick = (index + 1) % philosopherCount

        // Проверяем, доступны ли обе палочки для философа
        if (chopsticks[leftChopstick] && chopsticks[rightChopstick]) {
            // Если обе палочки свободны, философ берет их
            chopsticks[leftChopstick] = false // Забираем левую палочку
            chopsticks[rightChopstick] = false // Забираем правую палочку
            diningPhilosophers.add(philosopher) // Философ начинает обедать
        } else {
            // Если хотя бы одна палочка занята, философ размышляет
            thinkingPhilosophers.add(philosopher)
        }
    }

    // Выводим результаты
    println("Результаты:")
    // Показываем философов, которые обедают
    println("Обедают: ${diningPhilosophers.joinToString(", ")}")
    // Показываем философов, которые размышляют
    println("Размышляют: ${thinkingPhilosophers.joinToString(", ")}")
}