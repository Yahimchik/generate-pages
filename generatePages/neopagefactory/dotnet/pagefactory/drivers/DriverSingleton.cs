using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pagefactory.drivers
{
    public abstract class DriverWrapper
    {
        public IWebDriver CurrentDriver
        {
            get; set;
        }

        public DriverWrapper()
        {
            initialiseDriver();
        }

        protected abstract void initialiseDriver();
    }
}
