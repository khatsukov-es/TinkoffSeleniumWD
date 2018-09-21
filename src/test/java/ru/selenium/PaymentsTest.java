package ru.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;


public class PaymentsTest extends BaseTest {
    @Test
    public void zhkuMoscowPaymentTest() throws InterruptedException {
        String providerName = "ЖКУ-Москва";
        String payerCode = "0";
        String period = "00";
        String cardNumber = "00";
        String sumofPayment = "*";



        MainPage main = getMainPage();
        LoginPage loginPage = main.loadPage().goToLoginPage();

        Thread.sleep(30000);

        //TODO  Нужно вбить вручную телефон и код из смс
//      loginPage.enterLogin("Some phone number");
//      main = loginPage.confirmLogin();

        main = getMainPage();
        PaymentsPage paymentsPage = main.goToPaymentsPage();
        ServiceProvidersPage serviceProvidersPage = paymentsPage.chooseServiceProviders();
        String region = serviceProvidersPage.getRegion();
        if (!region.contains("Москве")) {
            RegionsPage regionsPage = serviceProvidersPage.goToRegionsPage();
            serviceProvidersPage = regionsPage.pickRegion("Москва");
        }

        Thread.sleep(1500);
        Assert.assertEquals(providerName,serviceProvidersPage.getProviderNamebyNumber(1));

        ZkuMoscowPaymentPage zkuMoscowPaymentPage = serviceProvidersPage.clickToFirstProvider();
        zkuMoscowPaymentPage.payZHKUinMoscowClick();

        zkuMoscowPaymentPage.enterPayerCode(payerCode);
        zkuMoscowPaymentPage.enterPeriod(period);
        zkuMoscowPaymentPage.enterCardNumber(cardNumber);
        zkuMoscowPaymentPage.enterSumOfPayment(sumofPayment);
        zkuMoscowPaymentPage.clickPayButton();

        Assert.assertEquals("Поле неправильно заполнено", zkuMoscowPaymentPage.getCodeNotValidError());
        Assert.assertEquals("Поле заполнено некорректно", zkuMoscowPaymentPage.getPeriodNotValidError());
        Assert.assertEquals("Исправьте номер карты", zkuMoscowPaymentPage.getCardNumberNotValidError());
        Assert.assertEquals("Поле заполнено неверно", zkuMoscowPaymentPage.getSumOfPaymentIsNotValidError());

        paymentsPage = zkuMoscowPaymentPage.goToPaymentsPage();
        paymentsPage.searchProviderByName(providerName);
        String receivedName = paymentsPage.getProviderNameFromSearchedByNumber(1);
        Assert.assertEquals(providerName, receivedName);
        Thread.sleep(1500);
        paymentsPage.chooseSearchedProviderByNumber(1);
        Thread.sleep(2000);
        Assert.assertTrue("Загружена страница не с провайдером  " + providerName, getDriver().getTitle().contains(providerName));

        paymentsPage = zkuMoscowPaymentPage.goToPaymentsPage();
        serviceProvidersPage = paymentsPage.chooseServiceProviders();
        RegionsPage regionsPage = serviceProvidersPage.goToRegionsPage();
        regionsPage.pickRegion("Санкт-Петербург");
        regionsPage.back();
        serviceProvidersPage = ServiceProvidersPage.getInstance(getDriver());
        try {
            WebElement element = serviceProvidersPage.getProviderElementByName(providerName);
            Assert.fail("В списке поставщиков присутствует искомый");
        }  catch (NoSuchElementException e){

        }
    }


}
