package com.feyzagezererkaraca.benimmuhabbetkusum


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.Food
import com.feyzagezererkaraca.benimmuhabbetkusum.include.InformationsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.RandomInformation
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.RandomInformationGenerator
import com.feyzagezererkaraca.benimmuhabbetkusum.data.repository.FoodRepository
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class BudgieViewModel @Inject constructor( private val foodRepository: FoodRepository
) : ViewModel() {

    // Rastgele alıntı üreteci
    private val randomInformationGenerator = RandomInformationGenerator()

    // Mevcut API state'leriniz
    private val _informationResponse = MutableStateFlow<InformationsState<RandomInformation?>>(InformationsState.Loading)
    val informationResponse: StateFlow<InformationsState<RandomInformation?>> = _informationResponse.asStateFlow()

    private val _randomInformationResponse = MutableStateFlow<InformationsState<RandomInformation?>>(InformationsState.Loading)
    val randomInformationResponse: StateFlow<InformationsState<RandomInformation?>> = _randomInformationResponse.asStateFlow()

    // YENİ: Rastgele oluşturulan alıntılar için state'ler
    private val _generatedRandomInformation = MutableStateFlow<InformationsState<RandomInformation?>>(InformationsState.Loading)
    val generatedRandomInformation: StateFlow<InformationsState<RandomInformation?>> = _generatedRandomInformation.asStateFlow()

    private val _generatedInformationList = MutableStateFlow<InformationsState<List<RandomInformation>>>(InformationsState.Loading)
    val generatedQInformationList: StateFlow<InformationsState<List<RandomInformation>>> = _generatedInformationList.asStateFlow()

    // YENİ: Sıralı alıntılar için state'ler
    private val _generatedSortedInformation = MutableStateFlow<InformationsState<RandomInformation?>>(InformationsState.Loading)
    val generatedSortedInformation: StateFlow<InformationsState<RandomInformation?>> = _generatedSortedInformation.asStateFlow()

    private val _generatedSortedInformationList = MutableStateFlow<InformationsState<List<RandomInformation>>>(InformationsState.Loading)
    val generatedSortedInformationList: StateFlow<InformationsState<List<RandomInformation>>> = _generatedSortedInformationList.asStateFlow()

    val harmfulFoods = foodRepository.getHarmfulFoods()
    val beneficialFoods = foodRepository.getBeneficialFoods()


    init {
        fetchGeneratedRandomInformation()
        fetchGeneratedInformationList(20)
    }

    fun filterFoods(foods: List<Food>, query: String): List<Food> {
        if (query.isEmpty()) return foods
        return foods.filter { food ->
            food.name.contains(query, ignoreCase = true) ||
                    food.description.contains(query, ignoreCase = true)
        }
    }
    /**
     * Tek bir rastgele alıntı oluşturur
     */
    fun fetchGeneratedRandomInformation() {
        viewModelScope.launch {
            try {
                _generatedRandomInformation.value = InformationsState.Loading
                val information = randomInformationGenerator.generateSingleInformation()
                _generatedRandomInformation.value = InformationsState.Success(information)
            } catch (e: Exception) {
                _generatedRandomInformation.value = InformationsState.Error(e.message ?: "Hata oluştu")
            }
        }
    }

    /**
     * Rastgele alıntı listesi oluşturur
     */
    fun fetchGeneratedInformationList(count: Int = 20) {
        viewModelScope.launch {
            try {
                _generatedInformationList.value = InformationsState.Loading
                val informations = randomInformationGenerator.generateMultipleInformations(count)
                _generatedInformationList.value = InformationsState.Success(informations)
            } catch (e: Exception) {
                _generatedInformationList.value = InformationsState.Error(e.message ?: "Hata oluştu")
            }
        }
    }
    /**
     * Alfabetik sıralı tek bir alıntı oluşturur
     */
    fun fetchGeneratedSortedInformation() {
        viewModelScope.launch {
            try {
                _generatedSortedInformation.value = InformationsState.Loading
                val information = randomInformationGenerator.generateSortedInformation()
                _generatedSortedInformation.value = InformationsState.Success(information)
            } catch (e: Exception) {
                _generatedSortedInformation.value = InformationsState.Error(e.message ?: "Hata oluştu")
            }
        }
    }

    /**
     * Alfabetik sıralı alıntı listesi oluşturur
     */
    fun fetchGeneratedSortedInformationList(count: Int = 20) {
        viewModelScope.launch {
            try {
                _generatedSortedInformationList.value = InformationsState.Loading
                val informations = randomInformationGenerator.generateSortedInformations(count)
                _generatedSortedInformationList.value = InformationsState.Success(informations)
            } catch (e: Exception) {
                _generatedSortedInformationList.value = InformationsState.Error(e.message ?: "Hata oluştu")
            }
        }
    }

    /**
     * Sadece sıralı harflerden oluşan alıntı
     */
    fun fetchSortedLettersInformation(letterCount: Int = 50) {
        viewModelScope.launch {
            try {
                _generatedSortedInformation.value = InformationsState.Loading
                val informations = randomInformationGenerator.generateSortedLettersInformation(letterCount)
                _generatedSortedInformation.value = InformationsState.Success(informations)
            } catch (e: Exception) {
                _generatedSortedInformation.value = InformationsState.Error(e.message ?: "Hata oluştu")
            }
        }
    }

    /**
     * Yenile butonu için - yeni rastgele alıntı oluşturur
     */
    fun refreshGeneratedInformation() {
        fetchGeneratedRandomInformation()
    }

    /**
     * Yenile butonu için - yeni sıralı alıntı oluşturur
     */
    fun refreshSortedInformation() {
        fetchGeneratedSortedInformation()
    }
}