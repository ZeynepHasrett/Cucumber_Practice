Feature: US1001 testotomasyonu shoes arama testi

  Scenario: Kullanici testotomasyonu sitesinde shoes bulabilmeli

    Given kullanici testotomasyonu ana sayfasina gider
    When arama kutusuna "shoes" yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir
