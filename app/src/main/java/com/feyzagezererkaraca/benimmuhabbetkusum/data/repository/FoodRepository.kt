package com.feyzagezererkaraca.benimmuhabbetkusum.data.repository

import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.Food
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepository @Inject constructor(){
    fun getBeneficialFoods(): List<Food> = listOf(
            Food("Elma", "C vitamini, lif açısından zengin", "🍎"),
            Food("Armut", "Sindirim sistemine iyi gelir", "🍐"),
            Food("Üzüm", "Antioksidan içerir", "🍇"),
            Food("Muz", "Potasyum kaynağı", "🍌"),
            Food("Portakal", "C vitamini deposu", "🍊"),
            Food("Kiraz", "Antioksidan, lezzetli", "🍒"),
            Food("Çilek", "C vitamini, folik asit", "🍓"),
            Food("Kavun", "Su oranı yüksek, serinletici", "🍈"),
            Food("Karpuz", "Hidrasyon sağlar", "🍉"),
            Food("Şeftali", "A ve C vitamini", "🍑"),
            Food("Havuç", "A vitamini, göz sağlığı", "🥕"),
            Food("Brokoli", "Vitamin ve mineral deposu", "🥦"),
            Food("Salatalık", "Su oranı yüksek", "🥒"),
            Food("Kabak", "Lif ve vitamin içerir", "🎃"),
            Food("Ispanak", "Demir kaynağı", "🥬"),
            Food("Marul", "Sindirime yardımcı", "🥗"),
            Food("Maydanoz", "C vitamini içerir", "🌿"),
            Food("Roka", "Kalsiyum ve demir", "🌿"),
            Food("Ceviz", "Omega-3, beyin gelişimi", "🌰"),
            Food("Badem", "Protein ve E vitamini", "🥜"),
            Food("Fındık", "Sağlıklı yağlar içerir", "🌰"),
            Food("Ayçiçeği Tohumu", "E vitamini, mineral", "🌻"),
            Food("Darı", "Karbonhidrat kaynağı", "🌾"),
            Food("Yulaf", "Lif ve B vitaminleri", "🌾"),
            Food("Arpa", "Lif kaynağı", "🌾"),
            Food("Buğday", "Enerji verici", "🌾"),
            Food("Kenevir Tohumu", "Protein içerir", "🌿"),
            Food("Nar", "Antioksidan deposu", "🍎"),
            Food("Erik", "Sindirim sistemine iyi", "🫐"),
            Food(
                "Muz",
                "B1, B2 vit., C vit., E vit. A vit. potasyum, kalsiyum, fosfor, demir, sodyum, iyot",
                "🍌"
            ),
            Food(
                "Elma",
                "Karaciğer ve sindirim sistemini sağlıklı tutar, antioksidan, A vit., zengin lif",
                "🍎"
            ),
            Food("Kivi", "C vit., E vit., Potasyum, protein", "🥝"),
            Food("Kavun", "A vit., beta-karoten, C vit. Kalsiyum, potasyum, fosfor, niyasin", "🍈"),
            Food("Karpuz", "A vit., C vit., potasyum, fosfor, tiamin", "🍉"),
            Food("Çilek", "A vit., B vit., C vit., Kalsiyum, demir, fosfor, Potasyum", "🍓"),
            Food("Kiraz", "Antioksidan içerir, A vit. C vit. Magnezyum, Kalsiyum", "🍒"),
            Food("Vişne", "A vit.", "🍒"),
            Food("Armut", "A vit., B1, B2 vit. C vit., Potasyum", "🍐"),
            Food("Ayva", "A vit. C vit. Mineral tuzları", "🍎"),
            Food(
                "Mango",
                "A vit., niyasin, C vit. Potasyum, papağanlar için önemli bir meyvedir",
                "🥭"
            ),
            Food("Havuç", "A vit., folik asit, demir, sodyum, potasyum, fosfor", "🥕"),
            Food("Domates", "C vit., E vit.,potasyum, sodyum, fosfor", "🍅"),
            Food("Turp", "B vit, C vit.,kükürt, iyot", "🥕"),
            Food(
                "Ispanak",
                "A vit., C vit., K vit., kalsiyum, fosfor. Papağanlar için önemli bir besindir",
                "🥬"
            ),
            Food("Semizotu", "Fosfor, potasyum, lif", "🌿"),
            Food(
                "Dereotu",
                "Kalsiyum, E vit. C vit. tiroid bezini normalleştirir. Papağanlar için önemli bir besindir",
                "🌿"
            ),
            Food("Pancar", "A vit. B vit. C vit. P vit. kalsiyum", "🥕"),
            Food("Biber", "C vit. P vit. K vit.", "🫑"),
            Food(
                "Taze/Kuru Fasulye",
                "Kalsiyum, fosfor, E vit, B1,B2,B3 vit.,protein, K vit., /ancak pişmiş verişlir",
                "🫘"
            ),
            Food("Barbunya", "demir, magnezyum, potasyum, lif/ancak pişmiş verilir", "🫘"),
            Food("Bezelye", "lif, protein, sodyum, vitaminler, /ancak pişmiş verilir", "🫛"),
            Food("Soya fasulyesi", "ancak pişmiş verilir", "🫘"),
            Food("Kabak", "B1 vit. C vit. protein,lif, K vit.", "🎃"),
            Food(
                "Balkabağı",
                "Betakaroten, demir, potasyum, sodyum, fosfor, kalsiyum, magnezyum, lif",
                "🎃"
            ),
            Food("Nane", "kalsiyum, A vit. protein, demir", "🌿"),
            Food("Tere", "C vit., fahalatıcı, hazmı kolaylaştırıcı", "🌿"),
            Food("Roka", "K vit., karaciğere iyi gelir", "🥬"),
            Food("Kırmızı Havuç", "betakaroten, antioksidan", "🥕"),
            Food("Karnıbahar", "A vit, B vit.,E vit., protein, fosfor, demir, potasyum", "🥦"),
            Food("Reyhan", "hazmı kolaylaştırır", "🌿"),
            Food(
                "Maydanoz",
                "A vitamini, kalsiyum, potasyum, kükürt, demir /küçük papağanlara sadece sapı verilebilir. Büyük ve orta boy papağanlar yaprak kısmını da yiyebilir",
                "🌿"
            ),
            Food("Enginar", "Kalsiyum, A vit. Potasyum", "🥬"),
            Food("Yerelması", "A vit. C vit. Kalsiyum, demir, fosfat", "🥔"),
            Food(
                "Patates",
                "Protein, kalsiyum, B vitaminleri /ancak pişmiş verilir ÇİĞ VERİLMEZ",
                "🥔"
            ),
            Food(
                "Mısır",
                "B1 vit., B3 vit. C vit. protein Ölçülü verilmelidir. Konserve mısır, besin değeri düştüğünden ve tuz/şeker içerebilidiğinden tercih edilmemelidir",
                "🌽"
            ),
            Food("Pırasa", "C vit. Potasyum, sodyum, kalsiyum, fosfor", "🥬"),
            Food(
                "Salatalık",
                "A vit., Potasyum, kalsiyum, folik asit, küçük papağanlara ölçülü verilmelidir",
                "🥒"
            ),
            Food("Kırmızı lahana", "B vit. C vit. E vit. potasyum, kalsiyum, kükürt, demir", "🥬"),
            Food("Bamya", "A vit., B1, B2 vit., magnezyum, demir", "🫛"),
            Food("Taze Kekik", "bakteri, virüs, mikrop öldürücü", "🌿"),
            Food("Kereviz", "Protein, demir, sodyum, folik asit, demir", "🥬"),
            Food("Brüksel Lahanası", "Kalsiyum, demir, betakaroten, E vit.", "🥬"),
            Food(
                "Karahindiba/Radika",
                "A vit. B vit. C vit. D vit. papağanlar için önemli bir besindir, çiğ verilmelidir",
                "🥬"
            ),
            Food("Ebegümeci", "A vit. C vit. E vit. demir. kalsiyum", "🌿"),
            Food("Lahana", "C vit., E vit. K vit.", "🥬"),
            Food(
                "Marul",
                "A vit., C vit. Kalsiyum. Ölçülü verilmelidir, fazlası ishale yol açar",
                "🥗"
            ),
            Food("Bakla", "B1, B2, B6 vit. K vit. Protein, potasyum", "🫘"),
            Food("Pazı", "A vit. K vit. C vit. E vit. demir kalsiyum, magnezyum", "🥬"),
            Food(
                "Şeker kamışı",
                "Çok sık olmamak kaydıyla papağanlara ödül olarak verilebilir",
                "🌾"
            ),

            Food("Yenidünya", "A vit., potasyum, Demir, fosfor, kalsiyum", "🟠"),
            Food("Mandalina", "C vit. Beta-karoten, B1, B2, B3 vit., Magnezyum, Potasyum", "🍊"),
            Food("Portakal", "Yüksek C vit. İçerir, kalsiyum, potasyum", "🍊"),
            Food(
                "Ananas",
                "C vit. B1 Vit, Manganez, papağanlar için önemli bir meyvedir. Elmayla birlikte verilmesi ekstra yarar sağlar",
                "🍍"
            ),
            Food("Şeftali", "A vit., Riboflavin, potasyum", "🍑"),
            Food(
                "Kayısı",
                "A vit, B vit., C vit., Kalsiyum, demir, kükürt, bakır, krom, manganez",
                "🧡"
            ),
            Food("Limon", "Antioksidan, C vit.", "🍋"),
            Food(
                "Üzüm",
                "Böbreklere iyi gelir, C vit., tiamin, potasyum, B6 vit., antioksidan",
                "🍇"
            ),
            Food("Dağ çileği (Kocayemiş)", "C vit.", "🍓"),
            Food("Yabanmersini", "C vit., E vit., Manganez, Antioksidan", "🫐"),
            Food("Böğürtlen", "Manganez, C vit. K vit.", "🫐"),
            Food("Dut", "B1 vit. B2 vit. C vit. Kalsiyum, Demir", "🫐"),
            Food("Ahududu", "C vit., A vit.", "🍓"),
            Food("İncir", "Kalsiyum, Demir, Potasyum", "🫐"),
            Food("Hindistan Cevizi", "Demir, Fosfor, çinko, Protein", "🥥"),
            Food("Papaya", "Sindirimi kolaylaştırıcı papain içerir, C vit.", "🥭"),
            Food("Erik", "C vit. Potasyum, antioksidan", "🫐"),
            Food("Greyfurt", "C vit.", "🍊"),
            Food("Nar", "Böbreklere iyi gelir, C vit., B vit., Potasyum", "🍎"),
            Food(
                "Hurma",
                "A vit., B1,B2, B3, B6 vit.,Folik asit, Kalsiyum, Protein, Potasyum, Fosfor, demir",
                "🍂"
            ),
            Food("Nektarin", "A vit.,Niyasin", "🍑"),
            Food("Guava", "A vit., B vit.,C vit. Kalsiyum", "🍈"),
            Food("Çarkıfelek Meyvası", "C vit., A vit., Demir, Kalsiyum", "🟣"),
            Food("Kızılcık", "Böbreklere iyi gelir, C vit. Manganez, Antioksidan", "🔴"),
            Food(
                "Kuşburnu",
                "C vit., B1, B2 vit., E vit, K vit. P vit. karoten,/ çekirdekleri de verilebilir",
                "🔴"
            ),
            Food("Brokoli", "A vit., E vit.,B1, B2 vit., C vit., sodyum, potasyum, protein", "🥦"),
            Food("Ceviz", "A vit. Omega 3/6, protein, kalsiyum, fosfor, Çiğ olarak daha faydalıdır. Kuru da verilebilir. Papağanların zeka gelişimini destekler", "🌰"),
            Food("Badem", "Kalsiyum, A vit. B vit. C vit. E vit. demir, magnezyum, potasyum, fosfor, çinko. Papağanlar için önemli bir besindir", "🥜"),
            Food("Fındık", "E vit. Protein, Tuzsuz ve çiğ olarak verilmelidir", "🌰"),
            Food("Şam Fıstığı", "Protein, B1 vit., fosfor, E vit. Tuzsuz ve çiğ olarak verilmelidir", "🥜"),
            Food("Çam Fıstığı", "Protein, B1, B2 vit. C vit., Omega 3/6", "🌰"),
            Food("Kaju", "D vit., selenyum, bakır, magnezyum, Tuzsuz ve çiğ olarak verilmelidir", "🥜"),
            Food("Kabak Çekirdeği", "K vit., magnezyum, manganez /çiğ, Tuzsuz ve çiğ olarak verilmelidir", "🌰"),
            Food("Kavun Çekirdeği", "A vit. C vit. E vit. B vit. kalsiyum", "🌰"),
            Food("Karpuz Çekirdeği", "B vit, C vit. beta karoten", "🌰"),
            Food("Limon Çekirdeği", "İnsanlara yararlı olmasa da, papağanınıza limon çekirdeklerini vermenizde bir mahsur yoktur. Ağrı kesici etkisi vardır", "🌰"),
            Food("Portakal Çekirdeği", "Ayrıca greyfurt ve mandalina çekirdeklerini de verebilirsiniz", "🌰"),
            Food("Nar Çekirdeği", "C vit., B vit. demir, fosfor", "🌰"),
            Food("Üzüm Çekirdeği", "kuvvetli bir antioksidan", "🌰"),
            Food("Böğürtlen Çekirdeği", "Böğürtlen, dut, yabanmersini gibi meyvelerin çekirdekleri gayet faydalıdır", "🌰"),
            Food("İncir Çekirdeği", "İncir çekirdeği de faydalıdır", "🌰"),
            Food("Aspir Tohumu", "vücuttaki gereksiz yağları erittiği için papağanalrda dengeleyici bir besindir. Renva düşürür. Çimlendirilerek taze verilirse daha faydalıdır", "🌾"),
            Food("Keten Tohumu", "B12 vit. Omega3/6. Papağanların B12 vit. alabilecekleri tek besindir", "🌾"),
            Food("Susam", "A vit. Kalsiyum, potasyum, fosfor. çiğ verilmelidir", "🌾"),
            Food("Kenevir Tohumu", "protein, albumin, omega 3/6, yağ oranı yüksektir, ölçülü verilmelidir", "🌿"),
            Food("Buğday/Karabuğday", "B2, B6 vit., E vit., niyasin, folik asit. Buğday yemeyen papağanlara buğday ununundan çeşitli mamalar yapılabilir. Çimlendirilerek taze verilirse daha faydalıdır", "🌾"),
            Food("Yulaf", "B vit. kalsiyum, magnezyum, fosfor. Papağanlara tüm tahıllardan daha faydalıdır. Yulaf unu mama yapımında kullanılabilir. Çimlendirilerek taze verilirse daha faydalıdır", "🌾"),
            Food("Arpa", "protein, B1, B3,B6 vit. Arpa unu mama yapımında da kullanılabilir. Çimlendirilerek taze verilirse daha faydalıdır", "🌾"),
            Food("Pirinç/esmer Pirinç", "E vit., B1 vit., potasyum, kalsiyum, demir. Esmer pirinç daha faydalıdır. Mama yapımında pirinç unu iyi bir temel malzemedir", "🌾"),
            Food("Nohut/leblebi", "SADECE PİŞMİŞ OLARAK VERİLİR. Leblebi halinde verilirken tuzsuz olmasına dikkat edilmelidir", "🫘"),
            Food("Mercimek", "Protein, nişasta içerir/pişmiş olarak verilir", "🫘"),
            Food("Kestane", "potasyum, kalsiyum. Kalorisi yüksek olduğu için çok sık vermemek gerekir", "🌰"),
            Food("Ay Çekirdeği", "E vit. Kalsiyum. Yağ oranı yüksektir ve AZ MİKTARDA VERİLMESİ GEREKİR. Ana besin kaynağı olamaz. Tuzsuz ve çiğ olarak verilmelidir. Çimlendirilerek taze verilirse daha faydalıdır", "🌻"),
            Food("Yer Fıstığı", "Protein. Yağ oranı çok yüksektir. ANCAK HAFTADA BİR, tuzsuz olarak verilmelidir. KABUKLU VERİLMEMELİDİR. Kabuğu iç mantar rahatsızlıklarına yol açabilir", "🥜"),
        Food("Zencefil", "Mideyi rahatlatır, toz halinde mamayla verilebilir", "🫚"),
        Food("Tarçın", "İç mantar sorunları için kullanılabilir", "🌿"),
        Food("Makarna", "Yağsız pişmiş olarak verilebilir", "🍝"),
        Food("Ruşeym", "Faydalıdır", "🌾"),
        Food("Tahin", "Katkısız az miktarda verilebilir, kalsiyum için", "\uD80C\uDDE2"),
        Food("Patlamış Mısır", "Tuzsuz ve yağsız olması şartıyla az miktarda verilebilir", "🍿"),
        Food("Papatya", "Rahatlatır", "🌼"),
        Food("Devedikeni Tohumu ve Çiçeği", "Karaciğere faydalıdır", "🌻"),
        Food("Gül", "Yaprakları verilebilir", "🌹"),
        Food("Karanfil", "Taze çiçeği verilebilir", "🌺"),
        Food("Hanımeli", "Çiçeği verilebilir", "🌸")
        )

    fun getHarmfulFoods(): List<Food> = listOf(
        Food("Avokado", "Persin içerir, toksiktir", "🥑"),
        Food("Avokado", "Persin içerir, toksiktir", "🥑"),
        Food("Çikolata", "Teobromin zehirlenmesi", "🍫"),
        Food("Şeker", "Körlüğü neden olabilir", "🍬"),
        Food("Tuz", "Böbrek hasarı", "🧂"),
        Food("Alkol", "Karaciğer yetmezliği", "🍺"),
        Food("Kafein", "Kahve, kola, soda vb. yüksek toksindir", "☕"),
        Food("Soğan", "Kanda toksin", "🧅"),
        Food("Sarımsak", "Anemi", "🧄"),
        Food("Mantar", "Sindirim sorunları", "🍄"),
        Food("Domates Yaprağı ve Sapı", "Solanin, toksindir", "🍅"),
        Food("Elma Çekirdeği", "Toksindir", "🍎"),
        Food("Kiraz Çekirdeği", "Toksindir", "🍒"),
        Food("Erik Çekirdeği", "Toksindir", "🫐"),
        Food("Kayısı Çekirdeği", "Toksindir", "🧡"),
        Food("Şeftali Çekirdeği", "Toksindir", "🍑"),
        Food("Yenidünya Çekirdeği", "Toksindir", "🟠"),
        Food("Süt", "Tereyağ gibi süt içeren hiçbir gıda hazmedilemez", "🥛"),
        Food("Tütün", "Toksindir", "🚬"),
        Food("Çiğ Patates", "Pişmiş verilebilir", "🥔"),
        Food("Çay", "Damarlara zararlıdır", "🍵"),
        Food("Patlıcan", "Toksindir", "🍆"),
        Food("Kuşkonmaz", "Toksindir", "🌿"),
        Food("Trabzon Hurması", "Zararı tartışmalıdır, riskli", "🟠"),
        Food(
            "Meşrubatlar",
            "Market ürünleri olan gazoz, ayran, şalgam ve meyve suyu gibi hazır içecekler zararlıdır",
            "🥤"
        ),
        Food("Abur Cubur", "Cips, bisküvi, kek, şeker vs. zararlıdır", "🍿"),
        Food("Yer Fıstığının Kabuğu", "Kendisi faydalı ama kabuğu zararlıdır", "🥜")

    )
}