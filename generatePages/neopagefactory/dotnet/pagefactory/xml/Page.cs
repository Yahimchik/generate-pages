using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Serialization;
using uk.org.hs2.genericutils;
using OpenQA.Selenium;
using OpenQA.Selenium.Interactions;
using OpenQA.Selenium.Support.UI;
using System.Collections.ObjectModel;
using System.Collections;
using System.Windows.Forms;
using pagefactory.handlers;
using logging;
using pagefactory.factories;

namespace pagefactory.xml
{
    [XmlRoot("Page")]
    public class Page : SeleniumElementHandler
    {
        /// <summary>
        /// Pages that this page inherits
        /// </summary>
        [XmlElement("InheritsPages")] public InheritsPages InheritsPages;

        /// <summary>
        /// Same as InheritsPages but only used by JSON Serializer
        /// </summary>
        public string[] Inherits;

        /// <summary>
        /// Elements in page
        /// </summary>
        [XmlElement("Element")] public Element[] Element;

        /// <summary>
        /// Name of page
        /// </summary>
        [XmlAttribute("Name")] public string Name;

        /// <summary>
        /// The type of page (currently not used)
        /// </summary>
        [XmlAttribute("Type")] public string Type;

        /// <summary>
        /// Based on the name of this class, returns the name of the
        /// page as would be defined in the page JSON file.
        /// </summary>
        /// <returns></returns>
        public static string GetPageNameFromClassName()
        {
            StackTrace st = new StackTrace();
            StackFrame sf = st.GetFrame(1);

            string className =
                st.GetFrame(1).GetMethod().ReflectedType.ToString();

            className =
                className.Split(new char[] {'.'})
                    [className.Split(new char[] {'.'}).Length - 1];

            Match m = null;

            if ((m = Regex.Match(className, "^Test(.*)$")).Success)
            {
                className = m.Groups[1].Value + "WfPage";
            }

            return className;
        }

        /// <summary>
        /// Should only be called if we expect the security warning page
        /// to appear before the ACTUAL page we want to navigate to appears
        /// </summary>
        public void SkipSecurityWarning()
        {
            PointLatestWindowHandle();

            try
            {
                BypassSecurityWarningPage();
            }
            finally
            {
                PointToOriginalWindowHandle();
            }
        }

        /// <summary>
        /// Sets the K2 based dropdown element to the value in 'text'
        /// </summary>
        /// <param name="elementName"></param>
        /// <param name="text"></param>
        public void SetK2DropdownText(string elementName, string text)
        {
            Element e = PrepareElement(GetElementByName(elementName));

            try
            {
                SetK2Dropdown(e.XPath, text);
            }
            finally
            {
                PointToOriginalWindowHandle();
            }
        }

        /// <summary>
        /// Gets a JSON Page file based Element (object) based on the supplied name.
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        protected Element GetElementByName(string name)
        {
            if (Element == null)
            {
                throw new Exception("[ERR] Element array is null");
            }

            Element e =
                Element.Where(item => item.Name.Equals(name)).ToArray().Length > 0
                    ? Element.Where(item => item.Name.Equals(name)).ToArray()[0]
                    : null;

            if (e == null)
            {
                throw new Exception("[ERR] Element '"+name+"' is not defined in pages file");
            }

            return e;
        }

        /// <summary>
        /// Returns a list of data rows based on the element name
        /// </summary>
        /// <param name="elementName"></param>
        /// <returns></returns>
        public List<string> GetTextList(string elementName)
        {
            Element e = PrepareElement(GetElementByName(elementName));

            List<string> value = null;

            try
            {
                value = GetElementTextListUsingXPath(e.XPath);

                Log.Debug("[INFO] Received " + e.Name + ". Value is '" + value + "'");
            }
            catch (Exception ex)
            {
                Log.ErrAndFail("[INFO] Failed to received element " + e.Name + ". Exception is '" + ex.Message + "'");
            }
            finally
            {
                PointToOriginalWindowHandle();
            }

            return value;
        }

        /// <summary>
        /// Returns text based on element name
        /// </summary>
        /// <param name="elementName"></param>
        /// <returns></returns>
        public string GetText(string elementName)
        {
            return GetText(elementName, null);
        }

        /// <summary>
        /// Returns text based on element name. substitues ${var} values
        /// (within XPath, ID or Name) with the substitutionValues hash table
        /// BEFORE applying the XPath, ID or Name to Selenium
        /// </summary>
        /// <param name="elementName"></param>
        /// <param name="substitutionValues"></param>
        /// <returns></returns>
        public string GetText(string elementName, Hashtable substitutionValues)
        {
            Element e = PrepareElement(GetElementByName(elementName));

            e.ApplySubstitutions(substitutionValues);

            string value = null;

            By by = GetByType(e, substitutionValues);

            try
            {
                Log.Debug("[INFO] Getting text from element '" + e.Name + "' ...");

                value = GetElementValueUsingByType(by);

                Log.Debug("[INFO] Received " + e.Name + ". Value is '" + value + "'");
            }
            catch (Exception ex)
            {
                Log.ErrAndFail("[INFO] Failed to received element " + e.Name + ". Exception is '" + ex.Message + "'");
            }
            finally
            {
                PointToOriginalWindowHandle();
            }

            return value;
        }

        public void ClearText(string elementName)
        {
            ClearText(elementName,null);
        }

        public void ClearText(string elementName, Hashtable substitutionmap)
        {
            Element e = PrepareElement(GetElementByName(elementName));

            e.ApplySubstitutions(substitutionmap);

            try
            {
                By by = GetByType(e, substitutionmap);

                Log.Debug("[INFO] Clearing element '" + e.Name + "' text ...");

                ClearElementTextUsingByType(by);

                Log.Debug("[INFO] Cleared element '" + e.Name + "' text");
            }
            catch (Exception ex)
            {
                Log.ErrAndFail("[INFO] Failed to set element " + e.Name + ". Exception is '" + ex.Message + "'");
            }
            finally
            {
                PointToOriginalWindowHandle();
            }
        }

        /// <summary>
        /// Set text to element.
        /// </summary>
        /// <param name="elementName"></param>
        /// <param name="text"></param>
        public void SetText(string elementName, string text)
        {
            SetText(elementName, text, null);
        }

        /// <summary>
        /// Set text on page element.
        /// </summary>
        /// <param name="elementName"></param>
        /// <param name="text"></param>
        /// <param name="substitutionmap"></param>
        public void SetText(string elementName, string text, Hashtable substitutionmap)
        {
            Element e = PrepareElement(GetElementByName(elementName));

            e.ApplySubstitutions(substitutionmap);

            try
            {
                By by = GetByType(e, substitutionmap);

                Log.Debug("[INFO] Setting element '" + e.Name + "' text to '" + text + "'");

                SetElementTextUsingByType(by, text);

                Log.Debug("[INFO] Set element '" + e.Name + "'. Value is now '" + text + "'");
            }
            catch (Exception ex)
            {
                Log.ErrAndFail("[INFO] Failed to set element " + e.Name + ". Exception is '" + ex.Message + "'");
            }
            finally
            {
                PointToOriginalWindowHandle();
            }
        }

        /// <summary>
        /// Replace ${var} values in input with values specified in hash table.
        /// </summary>
        /// <param name="input"></param>
        /// <param name="variablemap"></param>
        /// <returns></returns>
        protected string SubstituteVariables(string input, Hashtable variablemap)
        {
            string output = input;

            if ( (variablemap != null) && (output!=null) )
            {
                foreach (DictionaryEntry pair in variablemap)
                {
                    if (pair.Value != null)
                    {
                        output = output.Replace("${" + pair.Key + "}", pair.Value.ToString());
                    }
                }
            }

            return output;
        }

        /// <summary>
        /// Gets the elements By type object, based on whether XPath, Name or Id
        /// are specified within the Page JSON.
        /// </summary>
        /// <param name="e"></param>
        /// <param name="substitutionmap"></param>
        /// <returns></returns>
        protected By GetByType(Element e, Hashtable substitutionmap)
        {
            By by = null;

            if (e.ElementId != null)
            {
                by = By.Id(SubstituteVariables(e.ElementId,substitutionmap));
            }
            else
            if(e.ElementName!=null)
            {
                by = By.Name(SubstituteVariables(e.ElementName, substitutionmap));
            }
            else
            if(e.XPath!=null)
            {
                by = By.XPath(SubstituteVariables(e.XPath, substitutionmap));
            }
            else
            {
                throw new Exception("[ERR] Neither ElementId, ElementName nor XPath set for Page.json element '" + e.Name + "'");
            }

            return by;
        }

        public void WaitForElement(string elementName)
        {
            WaitForElement(elementName, null);
        }

        /// <summary>
        /// Waits for elements to appear on page
        /// </summary>
        /// <param name="elementName"></param>
        /// <param name="substitutionmap"></param>
        public void WaitForElement(string elementName, Hashtable substitutionmap)
        {
            Element e = GetElementByName(elementName);

            try
            {
                Log.Debug("[INFO] Waiting for Element '" + elementName + "' to be rendered on page.");

                WaitForElementUsingByType(GetByType(e,substitutionmap));
                
                Log.Debug("[INFO] Element '"+elementName+"' found on page.");
            }
            catch (Exception ex)
            {
                Log.ErrAndFail("[INFO] Failed to set element " + e.Name + ". Exception is '" + ex.Message + "'");
            }
        }

        /// <summary>
        /// DoubleClick element name
        /// </summary>
        /// <param name="elementName"></param>
        public void DoubleClick(string elementName)
        {
            DoubleClick(elementName,null);
        }


        /// <summary>
        /// DoubleClick element applying ${var} substitutions to XPath or Name or Id
        /// </summary>
        /// <param name="elementName"></param>
        /// <param name="substitutionmap"></param>
        /// <returns></returns>
        public Page DoubleClick(string elementName, Hashtable substitutionmap)
        {
            Element e = PrepareElement(GetElementByName(elementName));

            Page popupPage = null;

            if ((e.InIFrame != null) && (e.InIFrame.Equals("true")))
            {
                SwitchToIFrame();
            }

            try
            {
                Log.Debug("[INFO] DoubleClicking element " + e.Name + "(" + e.XPath + ")");

                DoubleClickElementUsingByType(GetByType(e, substitutionmap));

                popupPage = e.GetPageRedirect();

                Log.Debug("[INFO] Double click element " + e.Name + " successful.");
            }
            catch (Exception ex)
            {
                Log.ErrAndFail(
                    "[INFO] Failed to double click element " + e.Name + ". Exception is '" + ex.Message + "'");
            }
            finally
            {
                PointToOriginalWindowHandle();
            }

            return popupPage;
        }

        public bool ElementEnabled(string elementName)
        {
            Element e = PrepareElement(GetElementByName(elementName));

            bool result = false;

            try
            {
                Log.Debug("[INFO] Clicking element " + e.Name + "(" + e.XPath + ")");

                result=ElementIsEnabled(GetByType(e, null));

                Log.Debug("[INFO] Successfully clicked element " + e.Name);
            }
            catch (Exception ex)
            {
                Log.ErrAndFail("[INFO] Failed to click element " + e.Name + ". Exception is '" + ex.Message + "'");
            }
            finally
            {
                PointToOriginalWindowHandle();
            }

            return result;
        }

        /// <summary>
        /// Click the specified element
        /// </summary>
        /// <param name="elementName"></param>
        /// <returns></returns>
        public Page Click(string elementName)
        {
            Element e = PrepareElement(GetElementByName(elementName));

            Page popupPage = null;

            try
            {
                Log.Debug("[INFO] Clicking element " + e.Name + "(" + e.XPath + ")");

                ClickElementUsingByType(GetByType(e,null));

                popupPage = e.GetPageRedirect();

                Log.Debug("[INFO] Successfully clicked element " + e.Name);
            }
            catch (Exception ex)
            {
                Log.ErrAndFail("[INFO] Failed to click element " + e.Name + ". Exception is '" + ex.Message + "'");
            }
            finally
            {
                PointToOriginalWindowHandle();
            }

            return popupPage;
        }

        /// <summary>
        /// Prepares element for Selenium Access, by switching to the latest window handle (i.e.
        /// switching to the LAST page fired up by Selenium) and entering an iframe
        /// on that page, if required.
        /// 
        /// (the latter is determined by the Elements InIFrame property).
        /// </summary>
        /// <param name="e"></param>
        /// <returns></returns>
        protected Element PrepareElement(Element e)
        {
            if (e == null)
            {
                throw new Exception("[ERR] (PrepareElement()) Element object is null");
            }

            PointLatestWindowHandle();

            if (e.ElementIsInIFrame())
            {
                SwitchToIFrame();
            }

            return e;
        }

        protected void SwitchToIFrame()
        {
            SwitchToIframePopup();
        }
    }
}
