Feature: US1001 testotomasyonu login testi

  Scenario: TC01 Kullanici testotomasyonu sitesine gecerli email ve sifre ile giris yapabilmeli

    Given kullanici testotomasyonu ana sayfasina gider
    When account butonuna tiklar
    And gecerli email ve gecerli sifre girer
    And sign in butonuna tiklar
    Then basarili bir sekilde giris yapildigini test eder
    And logout butonuna basarak cikis yapar
    And sayfayi kapatir


    Scenario: TC02 Kullanici testotomasyonu sitesine gecersiz email ve sifre ile giris yapamamali

      Given kullanici testotomasyonu ana sayfasina gider
      When account butonuna tiklar
      And gecersiz email ve gecersiz sifre girer
      And sign in butonuna tiklar
      Then giris yapilamadigini test eder
      And sayfayi kapatir
