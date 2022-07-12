using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using uk.org.hs2.genericutils;

namespace pagefactory.drivers
{
    public class ChromeDriverSingleton : DriverWrapper
    {
        private string driverLocation = AppSettings.Get("drivers.ChromeDriverSingleton.driverLocation");

        private string executionFolderRoot = Path.GetDirectoryName(
         Assembly.GetAssembly(typeof(ChromeDriverSingleton)).CodeBase).Replace(@"file:\","");

        private string driverFullPath = null;

        protected override void initialiseDriver()
        {
            if (CurrentDriver == null)
            {
                driverFullPath = executionFolderRoot + @"\" + driverLocation;

                CurrentDriver = new ChromeDriver(driverFullPath);
            }
        }
    }
}
