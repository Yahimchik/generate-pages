using pagefactory.xml;
using System;
using System.Collections;
using System.Configuration;
using System.Drawing.Printing;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Xml.Serialization;
using pagefactory.json;
using uk.org.hs2.genericutils;

namespace pagefactory.factories
{
    public class PageFactory
    {
        private static Hashtable pages = new Hashtable();

        public static Pages GetStandardPages()
        {
            string pageFactoryLocation = AppSettings.Get("page.factory.resource");

            if (pageFactoryLocation == null)
            {
                throw new Exception("[ERR] page.factory.resource not found in App.config");
            }

            pages[pageFactoryLocation] = GetCachedPages(pageFactoryLocation);

            return (Pages)pages[pageFactoryLocation];
        }


        private static Pages GetPagesFromXmlFile(string resourceFile)
        {
            Pages p = null;

            string rootDir = GenericUtils.GetRootFolder();

            using (StreamReader r = new StreamReader(rootDir +@"\"+resourceFile))
            {
                p =
                    new XmlSerializer(typeof(Pages)).Deserialize(r) as Pages;
            }

            pages[resourceFile] = p;

            return p;
        }

        private static Pages GetPagesFromJsonFile(string resourceFile)
        {
            Pages pages = new Pages();

            string rootDir = GenericUtils.GetRootFolder();

            Page[] page =  PagesJson.GetPages(rootDir + @"\" + resourceFile);

            pages.Page = page;

            return pages;
        }

        private static Pages GetCachedPages(string pageFactoryLocation)
        {
            Pages p = null;

            if (pages[pageFactoryLocation] != null)
            {
                p=(Pages)pages[pageFactoryLocation];
            }
            else
            {
                if (pageFactoryLocation != null)
                {
                    if (pageFactoryLocation.Contains(".json"))
                    {
                        p = GetPagesFromJsonFile(pageFactoryLocation);
                    }
                    else
                    if (pageFactoryLocation.Contains(".xml"))
                    {
                        p = GetPagesFromXmlFile(pageFactoryLocation);
                    }
                    else
                    {
                        throw new Exception("[ERR] Unknown page file extension (needs to be either .xml or .json): '" + pageFactoryLocation + "'");
                    }
                }
                else
                {
                    throw new Exception("[ERR] Unknown page file extension (needs to be either .xml or .json): '"+pageFactoryLocation+"'");
                }
            }

            return p;
        }

        public static Page GetPage(string name)
        {
            string pageFactoryLocation = AppSettings.Get("page.factory.resource");

            if(pageFactoryLocation==null)
            {
                throw new Exception("[ERR] page.factory.resource not found in App.config");
            }

            Pages cachedPages = GetCachedPages(pageFactoryLocation);

            Page page = null;

            foreach (Page p in cachedPages.Page)
            {
                if ((p != null) && (p.Name != null) && (p.Name.Equals(name)))
                {
                    page = p; break;
                }
            }
            
            // *** look for pages that we need to also
            // *** take elements from for "this" page ...

            if(page!=null)
            {
                if (page.InheritsPages != null)
                {
                    if ((page.InheritsPages.Page != null) && (page.InheritsPages.Page.Length > 0))
                    {
                        foreach (string parentPageName in
                            page.InheritsPages.Page.Select(item => item.Name))
                        {
                            InheritPage(parentPageName, page);
                        }
                    }
                }
                else
                if (page.Inherits != null)
                {
                    foreach (string parentPageName in page.Inherits)
                    {
                        InheritPage(parentPageName, page);
                    }
                }
            }
            else
            {
                throw new Exception("Page '" + name + "' does not exist in "+ pageFactoryLocation);
            }

            return page;
        }

        private static Element[] InheritPage(string parentPageName, Page childPage)
        {
            Page parentPage = GetPage(parentPageName);

            if (parentPage == null)
            {
                throw new Exception("[ERR] Parent page does not exist");
            }

            childPage.Element =
                childPage.Element.ToList().Concat(parentPage.Element.ToList())
                    .ToArray();

            return childPage.Element;
        }
    }
}
