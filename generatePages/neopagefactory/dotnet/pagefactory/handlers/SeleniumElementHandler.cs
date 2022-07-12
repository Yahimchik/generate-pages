using OpenQA.Selenium;
using OpenQA.Selenium.Interactions;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Text;
using System.Threading;
using logging;
using pagefactory.xml;
using uk.org.hs2.genericutils;
using System.Linq;

namespace pagefactory.handlers
{
    /// <summary>
    /// SeleniumElementHandler handles all Selenium ELEMENT interactions, such as getting text,
    /// clicking, setting text, and handling dropdowns.
    /// </summary>
    public abstract class SeleniumElementHandler : SeleniumWebDriverHandler
    {
        public SeleniumElementHandler()
        {}

        public SeleniumElementHandler(string browserType)
        {}

        protected void WaitForElementUsingByType(By by)
        {
            PointLatestWindowHandle();

            IWebElement webElement = GetDisplayedWebElement(by);

            PointToOriginalWindowHandle();
        }

        protected void SetElementTextUsingByType(By by, string value)
        {
            IWebElement webElement = GetDisplayedWebElement(by);

            new Actions(ds.CurrentDriver).MoveToElement(webElement).Perform();

            webElement.SendKeys(value);
        }

        protected void ClearElementTextUsingByType(By by)
        {
            IWebElement webElement = GetDisplayedWebElement(by);

            new Actions(ds.CurrentDriver).MoveToElement(webElement).Perform();

            webElement.Clear();
        }

        protected void DoubleClickElementUsingByType(By by)
        {
            IWebElement webElement = GetDisplayedWebElement(by);

            new Actions(ds.CurrentDriver)
                .MoveToElement(webElement).DoubleClick().Build().Perform();
        }

        protected List<string> GetElementTextListUsingXPath(string xpath)
        {
            List<string> textList = null;

            By elementBy = By.XPath(xpath);

            ReadOnlyCollection<IWebElement> webElements =
                ds.CurrentDriver.FindElements(elementBy);

            textList = webElements.Select(item => item.Text).ToList();

            return textList;
        }

        protected bool ElementIsEnabled(By by)
        {
            IWebElement webElement = ds.CurrentDriver.FindElement(by);

            return webElement.Enabled;
        }

        protected void ClickElementUsingByType(By by)
        {
            IWebElement webElement = GetDisplayedWebElement(by);

            new Actions(ds.CurrentDriver)
                .MoveToElement(webElement).Click().Build().Perform();
        }

        protected string GetElementValueUsingByType(By by)
        {
            string value = null;

            IWebElement ele = GetDisplayedWebElement(by);

            if (ele.TagName.Equals("input"))
            {
                value = ele.GetAttribute("value");
            }
            else
            {
                value = ele.Text;
            }

            Log.Debug("Element text is: " + value);

            return value;
        }

        /// <summary>
        /// NPS has elements WITH THE SAME NAME but only one is displayed.
        /// This method was written to get the displayed element.
        /// </summary>
        /// <param name="by"></param>
        /// <returns></returns>
        protected IWebElement GetDisplayedWebElement(By by)
        {
            ReadOnlyCollection<IWebElement> elist = ds.CurrentDriver.FindElements(
                by);

            IWebElement e = null;

            foreach (IWebElement element in elist)
            {
                if (element.Displayed)
                {
                    e = element;
                    break;
                }
            }

            return e;
        }

        protected void SetK2Dropdown(string xpath, string valueToSet)
        {
            ClickMainDropdownElement(xpath);

            SelectDropdownElementItem(valueToSet);
        }

        protected IWebElement ClickMainDropdownElement(string xpath)
        {
            var dropdownElementItemWait =
                new WebDriverWait(ds.CurrentDriver,
                    TimeSpan.FromSeconds(int.Parse(AppSettings.Get("dropdown.wait"))));

            // *** wait for dropdown box to exist ...
            Log.Debug("Waiting for dropdown element (xpath=" + xpath + ")");

            dropdownElementItemWait.Until(ExpectedConditions.ElementExists(By.XPath(xpath)));
            
            Log.Debug("Found main dropdown element  (xpath=" + xpath + ")");

            Log.Debug("Accessing dropdown element   (xpath=" + xpath + ")");

            IWebElement dropdown = GetDisplayedWebElement(By.XPath(xpath));

            Log.Debug("Clicking dropdown element (findelement) :" + xpath);

            new Actions(ds.CurrentDriver).MoveToElement(dropdown).Click().Perform();

            return dropdown;
        }

        protected IWebElement SelectDropdownElementItem(string value)
        {
            var dropdownElementItemWait =
                new WebDriverWait(ds.CurrentDriver,
                    TimeSpan.FromSeconds(int.Parse(AppSettings.Get("dropdown.wait"))));

            string xpath = "//li[contains(@title,'" + value + "')]";

            By by = By.XPath(xpath);

            var elementItemWait = new WebDriverWait(ds.CurrentDriver, TimeSpan.FromMilliseconds(3000));

            Log.Debug("Waiting for dropdown element item exists:" + xpath);

            elementItemWait.Until(ExpectedConditions.ElementExists(by));

            Log.Debug("Dropdown element item exists:" + xpath);

            elementItemWait.Until(ExpectedConditions.ElementIsVisible(by));

            Log.Debug("Dropdown element item is visible:" + xpath);

            IWebElement dropdownElementValue = GetDisplayedWebElement(by);

            Log.Debug("SELECTing dropdown element item :" + xpath);

            new Actions(ds.CurrentDriver).MoveToElement(dropdownElementValue).Click().Perform();

            Log.Debug("SELECTed dropdown element item:" + xpath);

            return dropdownElementValue;
        }

        public void SetElementText(string appSettingsName, string elementValue)
        {
            GetDisplayedWebElement(By.XPath(AppSettings.Get(appSettingsName))).SendKeys(elementValue);
        }
    }
}
