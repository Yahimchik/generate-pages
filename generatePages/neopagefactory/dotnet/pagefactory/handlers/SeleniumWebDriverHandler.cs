using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.ObjectModel;
using System.Threading;
using logging;
using uk.org.hs2.genericutils;
using environments;
using environments.env;
using pagefactory.drivers;

namespace pagefactory.handlers
{
    /// <summary>
    /// Handles all operations at the WebDriver level, such as getting a new instance of
    /// webdriver depending on browserType, navigating to pages and setting up webdriver options.
    /// </summary>
    public abstract class SeleniumWebDriverHandler
    {
        protected static string browserType = AppSettings.Get("browserType");

        protected IAlert alert = null;

        protected static DriverWrapper ds = null;

        protected string url = null;

        protected string headerTextXPathName = null;

        public string Url { get { return url; } set { url = value; } }

        private static string mhandle = null;

        public static string MainWindowHandle
        {
            get
            {
                ReadOnlyCollection<string> handles =
                    ds.CurrentDriver.WindowHandles;

                if (handles.Count > 0)
                {
                    mhandle = handles[0];
                }

                return mhandle;
            }
        }

        protected void AssertIsTrue(bool istrue, string message)
        {
            try
            {
                Assert.IsTrue(istrue, message);
            }
            catch (Exception e)
            {
                Log.Err(e.Message);

                throw e;
            }
        }

        protected void AssertFail(string message)
        {
            Log.Err(message);

            Assert.Fail(message);
        }

        protected void AssertFail(string message, string message2)
        {
            Log.Err(message+message2);

            Assert.Fail(message,message2);
        }

        protected void AssertAreEqual(object expected, object actual)
        {
            try
            {
                Assert.AreEqual(expected, actual);
            }
            catch (Exception e)
            {
                Log.Err(e.Message);

                throw e;
            }
        }

        protected void AssertAreEqual(object expected, object actual, string message)
        {
            try
            {
                Assert.AreEqual(expected, actual, message);
            }
            catch (Exception e)
            {
                Log.Err(e.Message);

                throw e;
            }
        }

        protected void AssertIsNotNull(object expected, string message)
        {
            try
            {
                Assert.IsNotNull(expected, message);
            }
            catch (Exception e)
            {
                Log.Err(e.Message);

                throw e;
            }
        }

        protected void SetUrlProperty(string bddidentifier)
        {
            Env env =
                Env.GetTypeUsingEnvironmentSettings(typeof(Env),
                EnvironmentFileEnum.env) as Env;

            foreach (Url u in env.Url)
            {
                if (u.BddIdentifier.ToUpper().Trim().Equals(bddidentifier.ToUpper().Trim()))
                {
                    url = u.Value; break;
                }
            }

            if (url == null)
            {
                throw new Exception("[ERR] Url not found for Work List page");
            }
        }

        protected DriverWrapper GetDriverWrapper()
        {
            DriverWrapper dw = null;

            if (dw == null)
            {
                if ((browserType == null) || (browserType.Equals("ie")))
                {
                    dw = new IeDriverSingleton();
                }
                else
                if ((browserType == null) || (browserType.Equals("chrome")))
                {
                    dw = new ChromeDriverSingleton();
                }
                else
                {
                    throw new Exception("Unknown browser '" + browserType + "'");
                }
            }

            return dw;
        }

        protected void StartWebDriver()
        {
            if (ds == null)
            {
                ds = GetDriverWrapper();
            }
        }

        public void CloseBrowser()
        {
            if ((ds != null) && (ds.CurrentDriver != null))
            {
                ds.CurrentDriver.Quit();
                ds.CurrentDriver = null;
                ds = null;
            }
        }

        /// <summary>
        /// Get the current window handle ...
        /// </summary>
        /// <returns></returns>
        protected string GetCurrentWindowHandle()
        {
            return ds.CurrentDriver.CurrentWindowHandle;
        }

        /// <summary>
        /// Get the handle to the last subwindow of the browser
        /// </summary>
        /// <returns></returns>
        public string GetSubWindow()
        {
            string currentHandle =
                ds.CurrentDriver.CurrentWindowHandle;

            string subWindowHandler = null;

            ReadOnlyCollection<string> handles =
                ds.CurrentDriver.WindowHandles;

            foreach (string handle in handles)
            {
                if (!handle.Equals(currentHandle))
                {
                    subWindowHandler = handle;
                }
            }

            return subWindowHandler;
        }

        /// <summary>
        /// Switch to a window within the browser
        /// </summary>
        /// <param name="windowName"></param>
        protected void SwitchWindow(string windowName)
        {
            if (windowName != null)
            {
                ds.CurrentDriver.SwitchTo().Window(windowName);

                string currentHandle = ds.CurrentDriver.CurrentWindowHandle;
            }
        }

        public virtual void Go()
        {
            this.Go(null, null);
        }

        protected static string currentUsername = null;
        protected static string currentPassword = null;

        protected static string currentUrl = null;

        public static string CurrentUrl
        {
            get { return currentUrl; }
        }

        public static string CurrentUsername
        {
            get { return currentUsername; }
        }
        public static string CurrentPassword
        {
            get { return currentPassword; }
        }

        public bool PageIsAlreadyOpen
        {
            get
            {
                return
                    (username != null) &&
                    Url.Equals(CurrentUrl) &&
                    username.Equals(currentUsername);
            }
        }

        /// <summary>
        /// Points to the latest window handle.
        /// </summary>
        /// <returns></returns>
        protected string PointLatestWindowHandle()
        {
            string title = null;

            string windowhandle = GetWindowsHandle(MainWindowHandle);

            if ((windowhandle != null) && (windowhandle.Length > 0))
            {
                Exception exception = null;

                int tries = 0;
                int maxTries = 1000;

                for (tries = 0; tries < maxTries; tries++)
                {
                    try
                    {
                        IWebDriver driver = ds.CurrentDriver.SwitchTo().Window(windowhandle);

                        title = driver.Title;

                        exception = null;

                        break;
                    }
                    catch (Exception e)
                    {
                        exception = e;

                        Thread.Sleep(5);
                    }
                }

                if ((tries == maxTries) && (exception != null))
                {
                    throw exception;
                }
            }
            else
            {
                throw new Exception("Failed to locate separate window handle");
            }

            return title;
        }

        protected void PointToOriginalWindowHandle()
        {
            if ((MainWindowHandle != null) && (MainWindowHandle.Length > 0))
            {
                Exception exception = null;

                int tries = 0;
                int maxTries = 1000;

                for (tries = 0; tries < maxTries; tries++)
                {
                    try
                    {
                        ds.CurrentDriver.SwitchTo().Window(MainWindowHandle);

                        exception = null;

                        break;
                    }
                    catch (Exception e)
                    {
                        exception = e;

                        Thread.Sleep(5);
                    }
                }

                if ((tries == maxTries) && (exception != null))
                {
                    throw exception;
                }
            }
            else
            {
                ReadOnlyCollection<string> handles =
                    ds.CurrentDriver.WindowHandles;

                if( (handles!=null) && (handles.Count==1) )
                {
                    ds.CurrentDriver.SwitchTo().Window(handles[0]);
                }
            }
        }

        public string GetWindowsHandle(string mainWindowHandle)
        {
            string returnedHandle = null;

            for (int i = 0; i < 5; i++)
            {
                ReadOnlyCollection<string> handles =
                            ds.CurrentDriver.WindowHandles;

                foreach (string handle in handles)
                {
                    if (handle != mainWindowHandle)
                    {
                        returnedHandle = handle;

                        break;
                    }
                }

                if(returnedHandle!=null)
                {
                    break;
                }

                Thread.Sleep(1000);
            }

            return returnedHandle;
        }

        public virtual bool Go(string username, string password)
        {
            this.username = username;
            this.password = password;

            if (url == null)
            {
                return false;
            }

            // *** iitialise / re-initialise webdriver object .. 
            StartWebDriver();

            ds.CurrentDriver.Navigate().GoToUrl(url);

            // *** if credentials are given then
            // *** we expect a windows authentication popup/alert ...

            if ((username != null) && (password != null))
            {
                // *** if the login authentication page hit
                // *** then login using username/password details ...

                // *** By-pass security warning page if necessary ...
                BypassSecurityWarningPage();

                if (GetAlertFromLoginAuthenticationPage() != null)
                {
                    DoLogin(username, password);
                }
                else
                {
                    // *** we expected a login pop-up, so
                    // *** throw an exception that reflects this ...

                    throw new Exception(
                        "[ERR] Expected Windows Login Authentication pop-up at this stage but no alert found");
                }
                
                IOptions options = ds.CurrentDriver.Manage();
                options.Window.Maximize();
            }

            currentUrl = url;
            currentUsername = username;
            currentPassword = password;

            return true;
        }

        public void DoLogin(string username, string password)
        {
            // *** if the login authentication page hit
            // *** then login using username/password details ...

            IAlert alert = null;

            if (((alert = GetAlertFromLoginAuthenticationPage()) != null))
            {
                alert.SetAuthenticationCredentials(username, password);
                alert.Accept();
            }
        }

        private IAlert GetAlertFromLoginAuthenticationPage()
        {
            TimeSpan ts = new TimeSpan(0, 0, 2);

            DateTime startDt = DateTime.Now;

            WebDriverWait wait = new WebDriverWait(ds.CurrentDriver, ts);

            try
            {
                wait.Until(ExpectedConditions.AlertIsPresent());

                return ds.CurrentDriver.SwitchTo().Alert();
            }
            catch (Exception e)
            {
                // *** need to check "AlterException" here ...
                return null;
            }
        }

        public virtual bool BypassSecurityWarningPage()
        {
            bool ret = false;

            // *** if we expect a security warning page then
            // *** click on the 'ignore warnng' link ...

            if ((Env.GetEnv().GetProperty("HasSecurityWarningPage") != null) &&
                bool.Parse(Env.GetEnv().GetProperty("HasSecurityWarningPage")))
            {
                int maxtries = 2;

                By overrideLink = By.Id("overridelink");

                for (int i = 0; i < maxtries; i++)
                {
                    try
                    {
                        var wait = new WebDriverWait(
                            ds.CurrentDriver,
                            TimeSpan.FromSeconds(int.Parse(
                            AppSettings.Get("PageElement.wait"))));

                        wait.Until(ExpectedConditions.ElementExists(overrideLink));

                        IWebElement overridelink = ds.CurrentDriver.FindElement(overrideLink);

                        overridelink.SendKeys(Keys.Enter);

                        Log.Debug("Clicked on security link");

                        break;

                        ret = true;
                    }
                    catch (Exception e)
                    {
                        // *** do nothing since link does not exist ...
                        Log.Warn("Expected Security link but security link not found.");
                        Log.Warn("Retrying security link (iteration=" + i + " max iterations=" + maxtries + ")");
                    }
                }
            }
            
            return ret;
        }

        protected string username = null;
        protected string password = null;

        protected IWebElement getIFrameByClassName(string className)
        {
            ReadOnlyCollection<IWebElement> list = ds.CurrentDriver.FindElements(By.CssSelector("iframe"));

            if (list.Count == 0)
            {
                Exception pee = new Exception(
                    "[ERROR] Failed to find ANY iframe elements on current page");
            }

            IWebElement webElement = null;

            foreach (IWebElement ele in list)
            {
                string c = ele.GetAttribute("class");

                if ((c != null) && c.Equals(className))
                {
                    webElement = ele;
                    break;
                }
            }

            return webElement;
        }

        protected virtual void SwitchToIframePopup()
        {
            PointLatestWindowHandle();

            IWebElement frame = getIFrameByClassName("runtime-popup");

            if (frame == null) {
                throw new Exception("Failed to locate iframe using class name 'runtime-popup'");
            }

            ds.CurrentDriver.SwitchTo().Frame(frame);
        }
    }
}
