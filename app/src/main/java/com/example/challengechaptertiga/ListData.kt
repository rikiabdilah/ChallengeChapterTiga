package com.example.challengechaptertiga

// tampungan data yang berisi array berisi kumpulan kata atau frasa yang akan ditampilkan pada aplikasi

object ListData {
    private val words = arrayOf(
        "Argentina Winners Fifa World Cup",
        "Argentina Winners Copa America",
        "Argentina Winners Finalissima",
        "Adapter Android Kotlin",
        "Brazil Lose From Croatia",
        "Best Film 2023",
        "Best Player FIFA Mens Player 2022",
        "Blackpink - Tally",
        "Cardview Android Kotlin",
        "Cristiano Ronaldo",
        "Chinesse Food",
        "Come To Me",
        "Download Android Studio",
        "Destroy",
        "Destiny",
        "Deadly",
        "EA - Sport",
        "Explicit Intent",
        "Example Kotlin Code",
        "FIFA Best Mens Player 2022",
        "FIFA Best GoalKeeper 2022",
        "FIFA",
        "Greatest Of All Time",
        "Geography",
        "Goal Best All Time",
        "Google Translate",
        "Holland Bakery",
        "H&M",
        "Hard rock Coffee",
        "Indonesia",
        "Indonesia Kick From FIFA WORLD CUP U-20",
        "International Court Of Justice",
        "Instagram",
        "JavaScript",
        "Java Spring boot",
        "JohnWick",
        "James Bond",
        "Kintan Buffet",
        "Korean Drama",
        "Kopassus",
        "Kodaline",
        "Los Angeles - Time Square",
        "Lionel Messi",
        "Leopard",
        "Los Santos",
    )

    val dataList: ArrayList<String>
        get() {
            val alphabet = arrayListOf<String>()
            for (position in words.indices) {
                alphabet.add(words[position])
            }
            return alphabet
        }
}