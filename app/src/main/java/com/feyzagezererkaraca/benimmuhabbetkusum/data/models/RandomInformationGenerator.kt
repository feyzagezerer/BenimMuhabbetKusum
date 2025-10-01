package com.feyzagezererkaraca.benimmuhabbetkusum.data.models

import kotlin.random.Random


class RandomInformationGenerator {

    private val turkishLetters = listOf(
        'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'Ğ', 'H',
        'I', 'İ', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P',
        'R', 'S', 'Ş', 'T', 'U', 'Ü', 'V', 'Y', 'Z'
    )

    private fun generateRandomLetter(): Char {
        return turkishLetters.random()
    }

    private fun generateRandomLetters(length: Int): String {
        return (1..length).map { generateRandomLetter() }.joinToString("")
    }

    /**
     * Rastgele kelime oluşturur (3-8 harf arası)
     */
    private fun generateRandomWord(): String {
        val wordLength = Random.nextInt(3, 9)
        return generateRandomLetters(wordLength)
    }

    /**
     * Rastgele kelime listesi oluşturur
     */
    private fun generateRandomWords(wordCount: Int): List<String> {
        return (1..wordCount).map { generateRandomWord() }
    }

    /**
     * Rastgele cümle oluşturur
     */
    private fun generateRandomSentence(): String {
        val wordCount = Random.nextInt(5, 15)
        val words = generateRandomWords(wordCount)
        val sentence = words.joinToString(" ")
        return sentence.replaceFirstChar { it.uppercase() } + "."
    }
    /**
     * Rastgele paragraf oluşturur
     */
    private fun generateRandomParagraph(sentenceCount: Int = 3): String {
        return (1..sentenceCount).map { generateRandomSentence() }.joinToString(" ")
    }
    /**
     * Tek bir rastgele alıntı oluşturur
     */
    fun generateSingleInformation(): RandomInformation {
        val content = generateRandomParagraph(Random.nextInt(2, 5))
        val author = generateRandomWords(2).joinToString(" ")

        return RandomInformation(
            content = content,
            author = author
        )
    }

    /**
     * Alfabetik olarak sıralanmış alıntı oluşturur
     */
    fun generateSortedInformation(): RandomInformation {
        val content = generateRandomParagraph(Random.nextInt(2, 5))
        val sortedContent = sortWordsAlphabetically(content)

        val author = generateRandomWords(2).joinToString(" ")
        val sortedAuthor = sortWordsAlphabetically(author)

        return RandomInformation(
            content = sortedContent,
            author = sortedAuthor
        )
    }
    /**
     * Alfabetik olarak sıralanmış alıntı listesi oluşturur
     */
    fun generateSortedInformations(count: Int): List<RandomInformation> {
        return (1..count).map { generateSortedInformation() }
    }

    /**
     * Kelimeleri alfabetik olarak sıralar
     */
    private fun sortWordsAlphabetically(text: String): String {
        return text.split(" ")
            .filter { it.isNotBlank() }
            .sorted()
            .joinToString(" ")
    }

    /**
     * Harfleri alfabetik olarak sıralar (boşluklar olmadan)
     */
    private fun sortLettersAlphabetically(text: String): String {
        return text.toCharArray()
            .filter { it.isLetter() }
            .sorted()
            .joinToString("")
    }
    /**
     * Belirtilen sayıda rastgele alıntı oluşturur
     */
    fun generateMultipleInformations(count: Int): List<RandomInformation> {
        return (1..count).map { generateSingleInformation() }
    }
    /**
     * Sadece sıralı harflerden oluşan alıntı (kelimeler yok)
     */
    fun generateSortedLettersInformation(letterCount: Int = 50): RandomInformation {
        val randomLetters = generateRandomLetters(letterCount)
        val sortedLetters = sortLettersAlphabetically(randomLetters)

        // Her 5 harfte bir boşluk ekle (okunabilirlik için)
        val formattedContent = sortedLetters.chunked(5).joinToString(" ")

        val authorLetters = generateRandomLetters(10)
        val sortedAuthorLetters = sortLettersAlphabetically(authorLetters)
        val formattedAuthor = sortedAuthorLetters.chunked(5).joinToString(" ")

        return RandomInformation(
            content = formattedContent,
            author = formattedAuthor
        )
    }
}