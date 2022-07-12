using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace pagefactory.xml
{
    [XmlRoot("Pages")]
    public class Pages
    {
        [XmlElement("Page")]
        public Page[] Page;
    }
}
