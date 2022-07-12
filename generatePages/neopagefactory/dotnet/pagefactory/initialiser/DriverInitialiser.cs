using OpenQA.Selenium;

namespace pagefactory.initialiser
{
    public abstract class DriverInitialiser
    {
        public IWebDriver WebDriver
        {
            get; set;
        }

        public DriverInitialiser()
        {
            initialiseDriver();
        }

        protected abstract void initialiseDriver();
    }
}
