using OpenQA.Selenium.IE;
using OpenQA.Selenium.Remote;
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
    public class IeDriverSingleton : DriverWrapper
    {
        private string driverLocation = AppSettings.Get("drivers.IeDriverSingleton.driverLocation");

        private string executionFolderRoot = Path.GetDirectoryName(
         Assembly.GetAssembly(typeof(IeDriverSingleton)).CodeBase).Replace(@"file:\", "");

        private string driverFullPath = null;

        protected override void initialiseDriver()
        {
            if (CurrentDriver == null)
            {
                driverFullPath = executionFolderRoot + @"\" + driverLocation;

                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.IgnoreZoomLevel = true;
                ieOptions.EnableNativeEvents = true;
                ieOptions.EnsureCleanSession = true;
                ieOptions.RequireWindowFocus = true;
                ieOptions.IntroduceInstabilityByIgnoringProtectedModeSettings = true;

                CurrentDriver = new InternetExplorerDriver(driverFullPath, ieOptions);
            }
        }
    }
}
