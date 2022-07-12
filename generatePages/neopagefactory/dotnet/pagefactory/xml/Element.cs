using pagefactory.factories;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace pagefactory.xml
{
    [XmlRoot("Element")]
    public class Element
    {
        private Hashtable substitution = null;

        [XmlAttribute("Name")]
        public string Name;

        [XmlElement("Redirect")]
        public List<string> Redirect;

        [XmlAttribute("XPath")]
        public string XPath;

        [XmlAttribute("ElementId")]
        public string ElementId;

        [XmlAttribute("ElementName")]
        public string ElementName;

        [XmlAttribute("InIFrame")]
        public string InIFrame;

        public Page GetPageRedirect()
        {
            Element e = this;

            Page redirectPage = null;

            if (e.Redirect != null)
            {
                if ((e.Redirect.Count % 2) != 0)
                {
                    throw new Exception("[ERR] Re-direct need mutiple of 2 items (re-direct for element name='" +
                                        Name +
                                        "' currently has " + e.Redirect.Count + " elements");
                }

                if (e.Redirect[1].Trim().ToUpper().Equals("MODAL"))
                {
                    string newPage = e.Redirect[0];

                    redirectPage = PageFactory.GetPage(newPage);
                }
                else
                {
                    throw new Exception("[ERR] Unknown Element Redirect type '" + e.Redirect[1] + "' in element '" +
                                        e.Name + "'");
                }
            }

            return redirectPage;
        }

        public void ApplySubstitutions(Hashtable substitutionValues)
        {
            substitution = substitutionValues;

            if (substitution != null)
            {
                if (XPath != null)
                {
                    foreach (DictionaryEntry de in substitution)
                    {
                        XPath = XPath.Replace(de.Key.ToString(), de.Value.ToString());
                    }
                }
            }
        }

 

        public bool ElementIsInIFrame()
        {
            return ((InIFrame != null) && (InIFrame.ToLower().Equals("true")));
        }
    }
}
